package org.example.service;


import org.example.dao.ClaimInvestigationRequest;
import org.example.dao.ClaimInvestigationResponse;
import org.example.dao.DiscountResponse;
import org.example.dao.MedicalClaimRequest;
import org.example.model.Order;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.Map;

public interface Discount {

    public DiscountResponse getdiscount(Order request) throws IOException;
    public ClaimInvestigationResponse executeInvestigationRule(ClaimInvestigationRequest request);
    public Map<String,Object> executeMedicalRules(MedicalClaimRequest request) throws Exception;
}
