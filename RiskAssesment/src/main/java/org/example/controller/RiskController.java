package org.example.controller;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.example.dao.RiskCalculateRequest;
import org.example.dao.RiskResponse;
import org.example.model.RequestLogging;
import org.example.model.RiskProfile;
import org.example.repository.RequestLoggingRepo;
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
    @Autowired
    RequestLoggingRepo requestLoggingRepo;

    private final Gson gson = new Gson();

    private static final Logger log = LoggerFactory.getLogger(RiskController.class);

    @PostMapping("/get/rating")
    public RiskResponse calculateRisk(@RequestBody RiskCalculateRequest request)
    {
        log.info("###################----->>>>inside riskController");
        log.info("###################----->>>>request  for getRiskratingis"+request);
        RiskResponse res=riskService.calculateRisk(request);
        log.info("###################----->>>Response is"+res);
        String requestBodyJson = gson.toJson(request);
        String responseBodyJson=gson.toJson(res);
        RequestLogging r=new RequestLogging();
        if(res!=null)
        {
           r.setModuleName("Risk-MODULE");
           r.setApiType("/get/rating");
           r.setRequestMethod("POST");
           r.setRequestBody(requestBodyJson);
           r.setResponseBody(responseBodyJson);
           requestLoggingRepo.save(r);
        }
        return res;
    }
}

