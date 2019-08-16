package com.flexihouse.stub_runner_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.contract.stubrunner.server.StubRunnerBoot;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController

@RequestMapping("/stubs")
@ContextConfiguration(classes = StubRunnerBoot.class)
public class StubsController {

    private RestTemplate restTemplate;

    @Autowired
    public StubsController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/s")
    public String getStubs() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8555/api/admin/5a26af97857aba000719ea2e", String.class);
        return response.getBody();
    }
}
