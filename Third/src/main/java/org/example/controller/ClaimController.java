package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.dao.ClaimRequest;
import org.example.service.ClaimService;
import org.example.service.ClaimServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/claims")
public class ClaimController {
    private static final Logger log = LoggerFactory.getLogger(ClaimController.class);
    @Autowired
    ClaimServiceImpl claimService;


    @PostMapping("/createinsuranceClaim")
    public String createClaim(@RequestBody ClaimRequest request) {
        System.out.println(request);
        claimService.createClaim(request);
        return "sa";

    }

    @PostMapping("get/case/details/v1")
    public String getCaseDetails(@RequestBody int caseID) throws Exception {
        log.info("--------------->inside claims controller<-------------------------");
        return claimService.getCaseDetails(caseID);

    }


}
