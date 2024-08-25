package org.example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.example.dao.ClaimInvestigationRequest;
import org.example.dao.ClaimInvestigationResponse;
import org.example.dao.DiscountResponse;
import org.example.dao.MedicalClaimRequest;
import org.example.model.Order;
import org.example.model.RequestLogging;
import org.example.repository.RequestLoggingRepo;
import org.example.service.Discount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@Log4j2
@RestController
@RequestMapping("/bre/v1")
public class MegaOfferController {

    private static final Logger log = LoggerFactory.getLogger(MegaOfferController.class);
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
        log.info("Request Body for investigatinApi" + request);
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

    @PostMapping("/rules/medical")
    public Map<String, Object> medicalRules(@RequestBody MedicalClaimRequest request) throws Exception {

        log.info("requestbody" + "----->" + request);

        return discount.executeMedicalRules(request);
    }

}