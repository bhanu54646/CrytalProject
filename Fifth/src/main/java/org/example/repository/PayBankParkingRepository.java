package org.example.repository;

import org.example.model.PayBankParkingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PayBankParkingRepository extends JpaRepository<PayBankParkingEntity,Long> {

    @Query("select p from PayBankParkingEntity p where p.application_no =?1")
    PayBankParkingEntity  getDataByApplicationNo(String applicationNo);


}