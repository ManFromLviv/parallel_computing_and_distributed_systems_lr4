package com.example.admin_service.service;

import com.example.admin_service.model.Administrator;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class AdminService {
    private final RestTemplate restTemplate;
    private final Map<Integer, Administrator> administrators = new HashMap<>();
    private int adminIdCounter = 1;
    private static final String USER_SERVICE_URL = "http://localhost:8081/accounts";

    public AdminService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Administrator createAdmin(String name) {
        Administrator admin = new Administrator(adminIdCounter++, name);
        administrators.put(admin.getId(), admin);
        return admin;
    }

    public String blockAccount(int accountId) {
        String url = USER_SERVICE_URL + "/block/" + accountId;
        return restTemplate.postForObject(url, null, String.class);
    }

    public String unblockAccount(int accountId) {
        String url = USER_SERVICE_URL + "/unblock/" + accountId;
        return restTemplate.postForObject(url, null, String.class);
    }

    public Administrator getAdmin(int id) {
        return administrators.get(id);
    }
}
