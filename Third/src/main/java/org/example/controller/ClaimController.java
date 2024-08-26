package org.example.controller;

import org.example.dao.ClaimRequest;
import org.example.service.ClaimService;
import org.example.service.ClaimServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/claims")
public class ClaimController {
    @Autowired
    ClaimServiceImpl claimService;


    @PostMapping("/createinsuranceClaim")
    public String createClaim(@RequestBody ClaimRequest request) {
        System.out.println(request);
        claimService.createClaim(request);
        return "sa";

    }

    @PostMapping("get/case/details/v1")
    public String getCaseDetails(@RequestBody int caseID) {
        return claimService.getCaseDetails(caseID);

    }


}
