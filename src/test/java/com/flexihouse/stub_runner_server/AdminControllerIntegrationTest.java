package com.flexihouse.stub_runner_server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.MOCK;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = MOCK,
        properties = "stubrunner.idsToServiceIds.users=users-api-v1")
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class AdminControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAdminUserTest() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/admin/5a26af97857aba000719ea2e"))
                .andExpect(status().isOk());
    }
}
