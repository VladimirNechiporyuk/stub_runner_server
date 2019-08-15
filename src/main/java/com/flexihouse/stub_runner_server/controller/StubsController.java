package com.flexihouse.stub_runner_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.contract.stubrunner.StubFinder;
import org.springframework.cloud.contract.stubrunner.StubRunning;
import org.springframework.cloud.contract.stubrunner.server.HttpStubsController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stubs")
public class StubsController {

    private StubRunning stubRunning;
    private HttpStubsController httpStubsController;

    @Autowired
    public StubsController(StubRunning stubRunning) {
        this.stubRunning = stubRunning;
        this.httpStubsController = new HttpStubsController(stubRunning);
    }

    @GetMapping("/s")
    public String getStubs() {
        String response = httpStubsController.stubs().toString();
        System.out.println(response);
        return response;
    }
}
