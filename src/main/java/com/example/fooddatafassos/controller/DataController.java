package com.example.fooddatafassos.controller;

import com.example.fooddatafassos.service.DataProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    @Autowired
    private DataProcess dataProcess;

    @GetMapping(value = "/health")
    public String healthCheck(){
        return "Up and working";
    }

    @GetMapping(value = "/dishData")
    public boolean scrapData(){
        return dataProcess.callFassosApi();
    }

    @GetMapping(value = "/restaurantData")
    public boolean restaurantData() {
        return dataProcess.callGetStoreApi();
    }
}
