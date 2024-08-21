package org.example.service;

import org.example.config.DynamicRule;
import org.example.dao.ClaimInvestigationRequest;
import org.example.dao.ClaimInvestigationResponse;
import org.example.dao.DiscountResponse;
import org.example.model.Order;
import org.example.model.RequestLogging;
import org.example.repository.RequestLoggingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DiscountImpl implements Discount {
    @Autowired
    DynamicRule dynamicRule;


    @Override
    public DiscountResponse getdiscount(Order request) throws IOException {
        String updatedDrl = null;
        updatedDrl = dynamicRule.readClaimDrl("offer");
        Order response = new Order();

        DiscountResponse dis = new DiscountResponse();
        try {
            response = dynamicRule.executeRules(updatedDrl, request);
            response.getDiscount();
            dis.setDiscount(response.getDiscount());
            dis.setStatusMessage("Offer rules executed successfully");
            return dis;
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ClaimInvestigationResponse executeInvestigationRule(ClaimInvestigationRequest request) {
        String updatedDrl = null;
        updatedDrl = dynamicRule.readClaimDrl("claimInvestigation");
        ClaimInvestigationRequest response = new ClaimInvestigationRequest();
        ClaimInvestigationResponse res = new ClaimInvestigationResponse();
        try {
            response = dynamicRule.executeRules(updatedDrl, request);
            res.setStatusMessage("Claim investigationRules Executed Successfully");
            res.setInvestigationRequired(response.getInvestigationRequired());

            return res;
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
