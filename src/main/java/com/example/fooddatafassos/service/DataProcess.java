package com.example.fooddatafassos.service;

import com.example.fooddatafassos.dto.*;
import com.example.fooddatafassos.entity.*;
import com.example.fooddatafassos.repository.DishDataRepository;
import com.example.fooddatafassos.repository.RestaurantDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataProcess {

    @Autowired
    private RestaurantDataRepository restaurantDataRepository;

    @Autowired
    private DishDataRepository dishDataRepository;

    //sid 58 for bangalore location
    private final String fassos_url = "https://www.faasos.com/v1/api/get_all_products?sid=58";

    //to get sid 58 based on longitude latitude
    private final String get_Store_Id = "https://www.faasos.com/v1/api/getstore?&lat=12.974002&lng=77.613458&address=Bengaluru%20Karnataka&place_id=2UQY8X&place_name=Bengaluru&no_session=false";


    private FassosResponse fassosResponse;

    public Boolean callGetStoreApi() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<FassosGetStoreApiResponse> responseEntity = restTemplate.getForEntity(get_Store_Id,FassosGetStoreApiResponse.class);
        if(responseEntity.getBody() != null){
            return getApidataUtil(responseEntity.getBody());
        }
        return false;
    }


    public Boolean callFassosApi() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<FassosResponse> response = restTemplate.getForEntity(fassos_url, FassosResponse.class);
        if(response.getStatusCode().is2xxSuccessful()){
           if(response.getBody() != null){
               return getDistDataUtil(response.getBody());
           }
           return false;
        }
        return false;
    }

    private boolean getApidataUtil(FassosGetStoreApiResponse fassosGetStoreApiResponse){
        return restaurantDataUtil(fassosGetStoreApiResponse.getData());
    }

    private boolean getDistDataUtil(FassosResponse fassosResponse){
        return dishDataUtil(fassosResponse);
    }

    private boolean dishDataUtil(FassosResponse fassosResponse){
        List<DishData> dishData = fassosResponseToDishDataMapper(fassosResponse);
        if(dishData.size() != 0){
            return saveDishData(dishData);
        }
        return false;
    }

    // write mapper response to entity
    private List<DishData> fassosResponseToDishDataMapper(FassosResponse fassosResponse){
        String restaurantId = fassosResponse.getData().getStore_id();
        List<DishData> dishDatas = new ArrayList<>();
        for(FassosCollection fassosCollection : fassosResponse.getData().getCollections()){
            for(Product product: fassosCollection.getProducts()){
                dishDatas.add(DishData.builder()
                        .id("fassos_" + restaurantId + "_" + fassosCollection.getCollection_id() + "_" + product.getProduct_id())
                        .name(product.getProduct_name())
                        .category(fassosCollection.getCollection_name())
                        .partner_id("Fassos")
                        .isVeg(product.getIs_veg() == 1)
                        .isNonveg(product.getIs_veg()!=1)
                        .price(product.getDisplay_price())
                        .smallDescription(product.getSmall_description())
                        .bigDescription(product.getBig_description())
                        .image_link(product.getImage_es())
                        .isPopular(product.getBought_count()>=100)
                        .isRecommended((product.getBought_count() >100) && (product.getRating()>=4.0))
                        .bestSeller((product.getBought_count() >1000) && (product.getRating()>=4.0))
                        .tags(product.getTags())
                        .restaurantId(restaurantId)
                        .rating(product.getRating())
                        .variant(product.getIs_customizable().toString())
                        .build());
            }
        }
        return dishDatas;
    }

    private boolean saveDishData(List<DishData> dishDatas){
        if(dishDatas != null){
            List<DishData> dishData1 = dishDataRepository.saveAll(dishDatas);
            if( dishData1.size() != 0){
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean saveRestaurantData(RestaurantData restaurantData){
        RestaurantData restaurantData1 = restaurantDataRepository.save(restaurantData);
        if(restaurantData1.getRestaurantId() != null){
            return true;
        }
        return false;
    }

    private boolean restaurantDataUtil(FassosData fassosData){
        RestaurantData restaurantData = fassosGetStoreResponseToRestaurantDataMapper(fassosData);
        if(restaurantData != null){
            return saveRestaurantData(restaurantData);
        }
        return false;
    }

    private RestaurantData fassosGetStoreResponseToRestaurantDataMapper(FassosData fassosData){
        List<String> productIds = getAllProductIds();
        RestaurantData restaurantData = RestaurantData.builder()
                .restaurantId(fassosData.getStore_id().toString())
                .restaurantName(fassosData.getStore())
                .city(fassosData.getPlace_name())
                .deliveryPartner("Fassos")
                .location(LocationDetails.builder()
                        .lat(fassosData.getLatitude().toString())
                        .log(fassosData.getLongitude().toString())
                        .address(AddressData.builder()
                                .city(fassosData.getCity_name())
                                .landmark(fassosData.getLandmark())
                                .locality(fassosData.getLocality_name())
                                .societyName(fassosData.getSociety_name())
                                .street(fassosData.getStreet())
                                .build())
                        .build())
                .timing(TimeDetails.builder()
                        .startTime(fassosData.getOnTime())
                        .closeTime(fassosData.getOffTime())
                        .build())
                .restaurantMenu(productIds)
                .build();
        return restaurantData;
    }

    private List<String> getAllProductIds(){
        List<DishData> dishDatas = dishDataRepository.findAll();
        List<String> productId = new ArrayList<>();
        if(dishDatas.size() != 0) {
            for (DishData dishData : dishDatas) {
                productId.add(dishData.getId());
            }
        }
        return productId;
    }
}
