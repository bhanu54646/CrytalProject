package org.example.service;

import org.example.Model.CaseDetailEntity;
import org.example.dao.ClaimRequest;
import org.example.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
    public String getCaseDetails(int caseID) {
        String response = restTemplate.postForObject(investigatorUri,caseID,String.class);
        return response;
    }
}
