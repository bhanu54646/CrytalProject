package org.example.controller;

import org.example.model.Order;
import org.example.service.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MegaOfferController {

    @Autowired
    Discount discount;

    @PostMapping("/getdiscountpercent")
    public Order getdiscount(@RequestBody Order request) throws IOException {
        return discount.getdiscount(request);
    }

}