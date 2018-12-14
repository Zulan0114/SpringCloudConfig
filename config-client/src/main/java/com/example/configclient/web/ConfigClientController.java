package com.example.configclient.web;

import com.example.configclient.service.ConfigClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {

    @Autowired
    ConfigClientService configClientService;

    @Value("${foo}")
    String foo;

    @RequestMapping(value = "/hi")
    public String hi() {
        return foo;
    }

    @RequestMapping(value = "/url")
    public String serviceURL(@RequestParam("applicationName") String applicationName) {
        String url = configClientService.serviceUrl(applicationName);
        return url;
    }

}
