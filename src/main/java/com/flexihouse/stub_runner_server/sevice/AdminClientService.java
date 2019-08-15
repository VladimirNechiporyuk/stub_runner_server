package com.flexihouse.stub_runner_server.sevice;

import com.flexihouse.stub_runner_server.feignclient.AdminFeignClient;
import com.flexihouse.stub_runner_server.tools.GenericUserDetails;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminClientService {

    private AdminFeignClient adminFeignClient;

    @Autowired
    public AdminClientService(AdminFeignClient adminFeignClient) {
        this.adminFeignClient = adminFeignClient;
    }

    public GenericUserDetails getGenericUserDetails(ObjectId userId) {
        return adminFeignClient.getById(userId);
    }
}
