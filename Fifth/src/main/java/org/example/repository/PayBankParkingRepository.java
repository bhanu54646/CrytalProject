package org.example.repository;

import org.example.model.PayBankParkingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PayBankParkingRepository extends JpaRepository<PayBankParkingEntity,Long> {

    @Query("select p from PayBankParkingEntity p where p.application_no =?1")
    PayBankParkingEntity  getDataByApplicationNo(String applicationNo);

    @Query("select p.branch_name from PayBankParkingEntity p where p.branch_name like :branch%")
    List<String> getallbranches(@Param("branch") String branch);



}