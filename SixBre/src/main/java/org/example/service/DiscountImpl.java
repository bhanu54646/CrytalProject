package org.example.service;

import org.example.config.DynamicRule;
import org.example.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DiscountImpl implements Discount {
    @Autowired
    DynamicRule dynamicRule;

    @Override
    public Order getdiscount(Order request) throws IOException {
        String updatedDrl = null;
        updatedDrl = dynamicRule.readClaimDrl("offer");
        Order ruleResponse = null;
        try {
            ruleResponse = dynamicRule.executeSequentialRules(updatedDrl,request);
            return ruleResponse;
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
