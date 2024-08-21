package org.example.controller;

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

    @PostMapping("/getdiscountpercent")
    public DiscountResponse getdiscount(@RequestBody Order request) throws IOException {
        return discount.getdiscount(request);
    }

    @PostMapping("/execute/investigation/rule/v1")
    public ClaimInvestigationResponse executeInvestigationRule(@RequestBody ClaimInvestigationRequest request) {
        RequestLogging requestlog = new RequestLogging();
        ClaimInvestigationResponse response = discount.executeInvestigationRule(request);
        requestlog.setApiType("Investigation-Rules-Api");
        requestlog.setRequestMethod("POST");
        requestlog.setModuleName("BRE");
        requestlog.setRequestBody("ClaimAmount"+"="+request.getClaimAmount() + " "+"CauseOfDeath"+"="+ request.getCauseOfDeath());
        requestlog.setRequestEndpoint("EndPoint :/execute/investigation/rule/v1");
        requestlog.setResponseBody("InvestigationRequired" + "="+response.getInvestigationRequired() +" "+ "statusMessage"+ "="+ "" + response.getStatusMessage());
        requestLoggingRepo.save(requestlog);
        return response;
    }
}