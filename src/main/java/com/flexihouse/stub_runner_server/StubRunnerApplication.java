package com.flexihouse.stub_runner_server;

import com.flexihouse.stub_runner_server.feignclient.AdminFeignClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.contract.stubrunner.server.EnableStubRunnerServer;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode.LOCAL;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(clients = AdminFeignClient.class)
@EnableWebMvc
@EnableStubRunnerServer
@AutoConfigureWireMock
@AutoConfigureStubRunner(
        stubsMode = LOCAL,
//        stubsMode = REMOTE,
//        repositoryRoot = "http://artifactory.gemicle.com/artifactory/flexihouse/com/clap/users/",
        repositoryRoot = "classpath:m2repo/repository/",
        ids = {"com.clap:users:${producer.version:+}:stubs:8555"})
public class StubRunnerApplication {
    public static void main(String[] args) {
        SpringApplication.run(StubRunnerApplication.class, args);
    }
}
