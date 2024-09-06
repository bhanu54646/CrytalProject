package org.example.service;

import org.example.Model.Investigators;
import org.example.dao.AssignToApproverRequest;
import org.example.dao.AssignToInvestigatorRequest;
import org.example.dao.InvestiGatorResponse;
import org.example.dao.InvestigatorRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestBody;

import java.io.StringReader;
import java.util.List;
import java.util.Map;


public interface InvestigatorService {

    public Map<String,Object> acceptinvestigation(Investigators request);
    public Map<String,Object> assingCasetoapprover(AssignToApproverRequest request);
    public String getInvestDetails(int caseId);
    public InvestiGatorResponse getdetails(InvestigatorRequest request) ;
    }
;