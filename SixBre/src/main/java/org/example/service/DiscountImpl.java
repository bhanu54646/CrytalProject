package org.example.service;

import org.example.config.DynamicRule;
import org.example.dao.DiscountResponse;
import org.example.model.Order;
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
        DiscountResponse response =new DiscountResponse();
        try {
            response = dynamicRule.executeSequentialRules(updatedDrl,request);
            return response;
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
