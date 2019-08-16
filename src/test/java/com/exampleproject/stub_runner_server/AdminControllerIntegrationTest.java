package com.exampleproject.stub_runner_server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.contract.stubrunner.StubFinder;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode.LOCAL;

@RunWith(SpringRunner.class)
@AutoConfigureStubRunner(
        stubsMode = LOCAL,
        ids = {"com.example:exampleapp:${producer.version:+}:stubs:8555"})
public class AdminControllerIntegrationTest {

    @Autowired
    private StubFinder stubFinder;

    @Test
    public void getAdminUserTest() {
        System.out.println("\n\n>>>>>>>>My stubs via stub finder:\n\n" + stubFinder.getContracts().toString());
    }
}
