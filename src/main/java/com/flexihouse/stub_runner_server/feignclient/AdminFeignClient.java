package com.flexihouse.stub_runner_server.feignclient;

import com.flexihouse.stub_runner_server.tools.GenericUserDetails;
import org.bson.types.ObjectId;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "users-api-v1")
public interface AdminFeignClient {

    @GetMapping("/api/admin/{userId}")
    GenericUserDetails getById(@PathVariable ObjectId userId);
}
