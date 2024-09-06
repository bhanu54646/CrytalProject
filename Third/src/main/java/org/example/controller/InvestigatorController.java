package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.Model.Investigators;
import org.example.dao.AssignToApproverRequest;
import org.example.dao.AssignToInvestigatorRequest;
import org.example.dao.InvestiGatorResponse;
import org.example.dao.InvestigatorRequest;
import org.example.service.InvestigatorImpl;
import org.example.service.InvestigatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/investigator")
public class InvestigatorController {

    private static final Logger log = LoggerFactory.getLogger(InvestigatorController.class);
    @Autowired
    InvestigatorImpl investigatorService;

    @PostMapping("/assign/to/investigator")
    public Map<String, Object> acceptinvestigation(@RequestBody Investigators request) {

        System.out.println(request);
        return investigatorService.acceptinvestigation(request);
    }

    @PostMapping("/assign/toApprover")
    public Map<String, Object> assingCasetoapprover(@RequestBody AssignToApproverRequest request) {
        System.out.println(request);
        return investigatorService.assingCasetoapprover(request);
    }


    @PostMapping("/get/CaseDetails/from/Investigator")
    public String getInvestDetails(@RequestBody int caseID) {
        System.out.println(caseID + "--------------->");
        return investigatorService.getInvestDetails(caseID);

    }

    @PostMapping("/get/investigatordetails")
    public ResponseEntity<InvestiGatorResponse> getdetails(@RequestBody InvestigatorRequest request) {
        log.info("Request for get-invetigatorApi" + " " + request);
        InvestiGatorResponse res = new InvestiGatorResponse();
        res = investigatorService.getdetails(request);

        log.info("response is >>>>>>>>" + res);

        if (!res.getStatusCode().equals("200")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(res);
        }
    }


}
