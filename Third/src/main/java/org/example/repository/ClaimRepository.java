package org.example.repository;

import org.example.Model.CaseDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends JpaRepository<CaseDetailEntity, Integer> {
    @Query("select  c from CaseDetailEntity c where c.caseID=?1")
    public CaseDetailEntity getclaimsDetail(int id);


}
