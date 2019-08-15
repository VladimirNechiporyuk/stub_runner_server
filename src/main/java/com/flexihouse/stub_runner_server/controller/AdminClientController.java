package com.flexihouse.stub_runner_server.controller;

import com.flexihouse.stub_runner_server.tools.GenericUserDetails;
import com.flexihouse.stub_runner_server.sevice.AdminClientService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/admin", produces = APPLICATION_JSON_VALUE)
public class AdminClientController {

    private AdminClientService adminClientService;

    @Autowired
    public AdminClientController(AdminClientService adminClientService) {
        this.adminClientService = adminClientService;
    }

    @GetMapping("/{userId}")
    public GenericUserDetails getStabs(@PathVariable ObjectId userId) {
        return adminClientService.getGenericUserDetails(userId);
    }
}