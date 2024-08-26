package org.example.service;

import org.example.Model.Investigators;
import org.example.dao.AssignToApproverRequest;
import org.example.dao.AssignToInvestigatorRequest;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestBody;

import java.io.StringReader;
import java.util.Map;


public interface InvestigatorService {

    public Map<String,Object> acceptinvestigation(Investigators request);
    public Map<String,Object> assingCasetoapprover(AssignToApproverRequest request);
    public String getInvestDetails(int caseId);
    }
