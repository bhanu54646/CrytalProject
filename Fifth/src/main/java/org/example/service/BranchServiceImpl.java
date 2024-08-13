package org.example.service;

import org.example.model.PayBankParkingEntity;
import org.example.repository.PayBankParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    PayBankParkingRepository payBankParkingRepository;


    @Override
    public List<String> getBranchName(String branch) {

        List<String> str=payBankParkingRepository.getallbranches(branch);
      return  str;

    }
}
