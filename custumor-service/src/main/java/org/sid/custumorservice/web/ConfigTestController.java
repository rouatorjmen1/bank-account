package org.sid.custumorservice.web;

import org.sid.custumorservice.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;



@RestController
@RefreshScope
public class ConfigTestController {
    @Value("${global.params.p1}")
    private int p1;
    @Value("${global.params.p2}")

    private int p2;
    @Value("${customer.params.x}")
    private int x;
    @Value("${customer.params.y}")
    private int y;
    //1ere solution de config; la deuxieme dans le package config

    @GetMapping("/testConfig")
    public Map<String, Integer> configTest(){
        return Map.of("p1", p1, "p2", p2, "x", x, "y", y);
    }

    //2 sol attaché la deuxieme dans le package config

    @Autowired
    private GlobalConfig globalConfig;
    @GetMapping("/GlobalConfig")
public GlobalConfig globalConfig(){
    return  globalConfig;
}

}
