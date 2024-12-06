package org.example.service;


import lombok.extern.slf4j.Slf4j;
import org.example.dao.RiskCalculateRequest;
import org.example.dao.RiskResponse;
import org.example.model.RiskProfile;
import org.example.repository.RiskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RiskServiceImpl implements RiskService {

    @Autowired
    RiskRepository riskRepository;

    private static final Logger log = LoggerFactory.getLogger(RiskServiceImpl.class);

    @Override
    public RiskResponse calculateRisk(RiskCalculateRequest request) {

        String risklevel = getrisk(request);
        String recoomand = getrecommandation(risklevel);
        RiskResponse res = new RiskResponse();
        res.setRisk(risklevel);
        res.setRecommandation(recoomand);
        res.setPolicyNo(request.getPolicyNo());
        res.setHolderName(request.getPolicyHoldername());
        log.info("response is------------->>>>>>>>>>>" + res);
        RiskProfile re=new RiskProfile();
        System.out.println(re);
        re.setRisk(res.getRisk());
        re.setHolderName(res.getHolderName());
        re.setRecommandation(res.getRecommandation());
        re.setPolicyNo(res.getPolicyNo());
        riskRepository.save(re);
        return res;
    }

    public String getrisk(RiskCalculateRequest request) {
        if (request.getAge() >= 60 && request.isSmoker()) {
            return "high";
        } else if (request.getAge() <= 40) {
            return "medium";
        } else {

            return "low";
        }

    }

    public String getrecommandation(String risklevel) {

        switch (risklevel) {
            case "high":
                return "one";
            case "low":
                return "two";
            default:
                return "threee";
        }
    }

}
