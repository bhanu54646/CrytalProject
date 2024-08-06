package org.example.service;

import org.example.model.PayBankParkingEntity;
import org.example.repository.PayBankParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Service
public class ParkingDataService {

    @Autowired
    PayBankParkingRepository payBankParkingRepository;

    public Map<String, Object> getParkingData(String applicationNo) {
        Map<String, Object> map = new HashMap<>();

        PayBankParkingEntity paybank = payBankParkingRepository.getDataByApplicationNo(applicationNo);

        if (paybank != null) {
            map.put("StatusMessage", "data fetched succesfully for" + " " + applicationNo);
            map.put("StatusCode", "200");
            map.put("response", paybank);
            return map;
        } else {
            map.put("StatusCode", "400");
            map.put("StatusMessage", "No data found");
            map.put("response", paybank);
            return map;
        }
    }


}


