package org.example.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dao.ClaimRequest;

public interface ClaimService {

    public String createClaim(ClaimRequest request);
    public String getCaseDetails(int caseID) throws JsonProcessingException;
}
