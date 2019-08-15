package com.flexihouse.stub_runner_server;

import com.flexihouse.stub_runner_server.feignclient.AdminFeignClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.contract.stubrunner.server.EnableStubRunnerServer;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode.LOCAL;

@EnableDiscoveryClient
@EnableFeignClients(clients = AdminFeignClient.class)
@EnableWebMvc
@SpringBootApplication
@EnableStubRunnerServer
@AutoConfigureStubRunner(
        stubsMode = LOCAL,
//        stubsMode = REMOTE,
//        repositoryRoot = "http://artifactory.gemicle.com/artifactory/flexihouse/com/clap/users/",
        repositoryRoot = "stubs://C://Work/CLAP_Projects/flexihouse_server_users/users",
        ids = "com.clap:users:${producer.version:+}:stubs:8555",
        properties = "stubs.find-producer=true")
public class StubRunnerApplication {
    public static void main(String[] args) {
        SpringApplication.run(StubRunnerApplication.class, args);
    }
}
