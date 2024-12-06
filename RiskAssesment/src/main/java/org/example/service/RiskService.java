package org.example.service;

import org.example.dao.RiskCalculateRequest;
import org.example.dao.RiskResponse;

public interface RiskService {
    public RiskResponse calculateRisk(RiskCalculateRequest request);
}
