package org.example.service;


import org.example.dao.DiscountResponse;
import org.example.model.Order;

import java.io.IOException;

public interface Discount {

    public DiscountResponse getdiscount(Order request) throws IOException;
}
