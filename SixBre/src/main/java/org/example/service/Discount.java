package org.example.service;


import org.example.model.Order;

import java.io.IOException;

public interface Discount {

    public Order getdiscount(Order request) throws IOException;
}
