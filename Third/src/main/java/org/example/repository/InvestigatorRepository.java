package org.example.repository;

import org.example.Model.Investigators;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestigatorRepository extends JpaRepository<Investigators,Integer> {
    @Query("select p from  Investigators p where p.investigatorId=?1")
    public Investigators findinvestigatorbyId(int id);

    @Query("select p from Investigators p where p.caseID=?1")
    public  Investigators getInvestigatorByCaseiD(int caseID);

    @Query("select p from Investigators p where p.approverName=?1")
    public List<Investigators> getInvestigators(String approverName);
}