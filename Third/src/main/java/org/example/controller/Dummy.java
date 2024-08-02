package org.example.controller;


import com.mysql.cj.util.DnsSrv;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/Third")
public class Dummy {


    @GetMapping("/check")
    public Map<String,String> check()
    {
       Map<String,String> map=new HashMap<>();
       map.put("statuscode","200");
       return map;
    }
}
