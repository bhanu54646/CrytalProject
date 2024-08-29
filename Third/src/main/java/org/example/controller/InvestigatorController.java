package org.example.controller;

import org.example.Model.Investigators;
import org.example.dao.AssignToApproverRequest;
import org.example.dao.AssignToInvestigatorRequest;
import org.example.service.InvestigatorImpl;
import org.example.service.InvestigatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/investigator")
public class InvestigatorController {

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
    public String getInvestDetails(@RequestBody int caseID)
    {
        System.out.println(caseID+"--------------->");
     return investigatorService.getInvestDetails(caseID);

    }

}
