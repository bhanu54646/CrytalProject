package org.example.repository;

import org.example.model.PayBankParkingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayBankParkingRepository extends JpaRepository<PayBankParkingEntity,Long> {
}
