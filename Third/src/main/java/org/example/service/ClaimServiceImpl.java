package org.example.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Model.CaseDetailEntity;
import org.example.constants.Constants;
import org.example.dao.ClaimRequest;
import org.example.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Base64;

@Service
public class ClaimServiceImpl implements ClaimService {

    @Autowired
    ClaimRepository claimRepository;
    @Autowired
    RestTemplate restTemplate;
    @Value("${investigator}")
    String investigatorUri;

    @Override
    public String createClaim(ClaimRequest request) {
        CaseDetailEntity c = new CaseDetailEntity();
        System.out.println(c);
        c.setCaseType(request.getClaimType());
        c.setPolicyNo(request.getPolicyNo());
        c.setClaimAmount(request.getClaimAmount());
        c.setClaimerofclaim(request.getClaimerofclaim());
        c.setCauseofDeath((request.getCauseofDeath()));
        c.setPlaceofDeath(request.getPlaceofDeath());
        c.setLifeAssured(request.getLifeAssured());
        c.setDateOfDeath(request.getDateOfDeath());
        c.setDateofInsurance(request.getDateofInsurance());
        claimRepository.save(c);
        System.out.println(c);
        return "added";
    }

    @Override
    public String getCaseDetails(int caseID) throws JsonProcessingException {

         HttpHeaders headers = new HttpHeaders();
         headers.setBasicAuth(Constants.username,Constants.password);
         headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
         ObjectMapper objectMapper = new ObjectMapper();
         String caseIDJson = objectMapper.writeValueAsString(caseID);
         HttpEntity<String> entity = new HttpEntity<>(caseIDJson, headers);
         ResponseEntity<String> responseEntity = restTemplate.exchange(
                investigatorUri,
                HttpMethod.POST,
                entity,
                String.class
        );

        return responseEntity.getBody();
    }
}
