package org.example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.example.dao.ClaimInvestigationRequest;
import org.example.dao.ClaimInvestigationResponse;
import org.example.dao.DiscountResponse;
import org.example.model.Order;
import org.example.model.RequestLogging;
import org.example.repository.RequestLoggingRepo;
import org.example.service.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MegaOfferController {

    @Autowired
    Discount discount;
    @Autowired
    RequestLoggingRepo requestLoggingRepo;

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Gson gson = new Gson(); // Gson instance

    @PostMapping("/getdiscountpercent")
    public DiscountResponse getdiscount(@RequestBody Order request) throws IOException {
        return discount.getdiscount(request);
    }

    @PostMapping("/execute/investigation/rule/v1")
    public ClaimInvestigationResponse executeInvestigationRule(@RequestBody ClaimInvestigationRequest request) throws JsonProcessingException {
        RequestLogging requestlog = new RequestLogging();
        ClaimInvestigationResponse response = discount.executeInvestigationRule(request);
        requestlog.setApiType("Investigation-Rules-Api");
        requestlog.setRequestMethod("POST");
        requestlog.setModuleName("BRE");
        // Convert request object to JSON string using Gson
        String requestBodyJson = gson.toJson(request);
        requestlog.setRequestBody(requestBodyJson);
        //  String requestBodyJson = objectMapper.writeValueAsString(request);
        requestlog.setRequestBody(requestBodyJson);
        requestlog.setRequestEndpoint("EndPoint :/execute/investigation/rule/v1");
        String responseBodyJson = gson.toJson(response);
        // String responseBodyJson = objectMapper.writeValueAsString(response);
        requestlog.setResponseBody(responseBodyJson);
        requestLoggingRepo.save(requestlog);
        return response;
    }
}