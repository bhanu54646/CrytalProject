package org.example.config;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DynamicRule {

    private final KieServices kieServices;

    public DynamicRule() {
        this.kieServices = KieServices.Factory.get();
    }

    public String readClaimDrl(String ruleName) {
        // Load DRL from resources folder
        String drlFilePath = "rules/" + ruleName + ".drl";
        try {
            return new String(kieServices.getResources().newClassPathResource(drlFilePath).getInputStream().readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException("Failed to read DRL file: " + drlFilePath, e);
        }
    }

    public <T> T executeRules(String drl, T request) throws Exception {
        KieServices kieServices = KieServices.Factory.get();
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();

        // Write DRL content with a source path
        kieFileSystem.write(ResourceFactory.newByteArrayResource(drl.getBytes()).setSourcePath("dynamic-rules.drl"));

        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem).buildAll();
        KieContainer kieContainer = kieServices.newKieContainer(kieBuilder.getKieModule().getReleaseId());

        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(request);
        kieSession.fireAllRules();
        T response = request;
        kieSession.dispose();
        return response;
    }
}
