package org.example.controller;


import lombok.extern.slf4j.Slf4j;
import org.example.dao.RiskCalculateRequest;
import org.example.dao.RiskResponse;
import org.example.service.RiskServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/risk")
public class RiskController {
   @Autowired
    RiskServiceImpl  riskService;

    private static final Logger log = LoggerFactory.getLogger(RiskController.class);

    @PostMapping("/get/rating")
    public RiskResponse calculateRisk(@RequestBody RiskCalculateRequest request)
    {
        log.info("###################----->>>>inside riskController");
        log.info("###################----->>>>request  for getRiskratingis"+request);

        return riskService.calculateRisk(request);

    }
}

