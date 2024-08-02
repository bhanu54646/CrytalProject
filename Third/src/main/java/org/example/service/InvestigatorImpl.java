package org.example.service;

import org.example.Model.Approver;
import org.example.Model.CaseDetailEntity;
import org.example.Model.Investigators;
import org.example.dao.AssignToApproverRequest;
import org.example.dao.AssignToInvestigatorRequest;

import org.example.repository.ApproverRepository;
import org.example.repository.ClaimRepository;
import org.example.repository.InvestigatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.context.support.GroovyWebApplicationContext;

import java.util.HashMap;
import java.util.Map;

@Service
public class InvestigatorImpl implements InvestigatorService {
    @Autowired
    InvestigatorRepository investigatorRepository;
    @Autowired
    ClaimRepository claimRepository;

    @Autowired
    ApproverRepository approverRepository;



    @Override
    public Map<String, Object> acceptinvestigation(Investigators request) {

        Map<String, Object> map = new HashMap<>();
        System.out.println("requestBody" + " " + request);
        Investigators in = investigatorRepository.findinvestigatorbyId(request.getInvestigatorId());
        System.out.println("investigator fetched from db" + " " + in);
        CaseDetailEntity en = claimRepository.getclaimsDetail(request.getCaseID());
        try {
            if (in != null) {
                if (en != null) {
                    in.setCaseID(request.getCaseID());
                    investigatorRepository.save(in);
                    map.put("statusMessage", "case is assigned to investigator");
                    map.put("statusCode", "200");
                    map.put("Detail", request.getCaseID() + " " + request.getInvestigatorId());
                    return map;
                } else {
                    map.put("statusMessage", "case id doestNotexist");
                    map.put("statusCode", "404");
                    map.put("Details", request.getCaseID());
                    return map;
                }
            } else {
                if (en != null) {
                    request.getCaseID();
                    investigatorRepository.save(request);
                    map.put("statusMessagge", "new investigator added");
                    map.put("investigator", request);
                    return map;
                } else {
                    map.put("statusMessage", "caseDetail not found");
                    return map;
                }

            }
        } catch (Exception e) {
            map.put("statusMessage", e.getMessage());
            return map;
        }
    }

    @Override
    public Map<String, Object> assingCasetoapprover(AssignToApproverRequest request) {
        Map<String, Object> map = new HashMap<>();
        System.out.println(request);
        Approver ap = new Approver();
        System.out.println(ap);

        Investigators investigator = investigatorRepository.findinvestigatorbyId(request.getInvesId());
        if (investigator != null) {
            ap.setInvestigatorName(investigator.getInvestigatorName());
            if (investigator.getCaseID() == request.getCaseId()) {
                ap.setCaseID(request.getCaseId());
                approverRepository.save(ap);
                map.put("status code", "200");
                map.put("statusMessage", "case is assigned to approver");
                map.put("details", ap);
                return map;
            } else {

                //a.Common("NOT FOUND");
                map.put("statusMessage", "case details not found");
                map.put("statuscode","200");
               map.put("","");
                return map;
            }
        } else {

            map.put("statusMessage", "no investigator details found");
            return map;

        }

    }
}


