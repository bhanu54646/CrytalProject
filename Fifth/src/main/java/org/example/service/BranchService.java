package org.example.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BranchService {

    public List<String> getBranchName(String Branch);
}
