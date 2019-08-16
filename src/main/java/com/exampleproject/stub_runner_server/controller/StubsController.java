package com.exampleproject.stub_runner_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.contract.stubrunner.StubFinder;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode.LOCAL;

@RestController
@RequestMapping("/stubs")
@AutoConfigureStubRunner(
        stubsMode = LOCAL,
        ids = {"com.example:exampleapp:${producer.version:+}:stubs:8555"})
public class StubsController {

    private StubFinder stubFinder;

    @Autowired
    public StubsController(StubFinder stubFinder) {
        this.stubFinder = stubFinder;
    }

    @GetMapping("/s")
    public String getStubs() {
        return stubFinder.getContracts().toString();
    }
}
