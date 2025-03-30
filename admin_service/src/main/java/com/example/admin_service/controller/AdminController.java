package com.example.admin_service.controller;

import com.example.admin_service.model.Administrator;
import com.example.admin_service.service.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/create")
    public Administrator createAdmin(@RequestBody Map<String, String> request) {
        String name = request.get("name");
        return adminService.createAdmin(name);
    }

    @PostMapping("/{adminId}/block/{accountId}")
    public String blockAccount(@PathVariable int accountId, @PathVariable int adminId) {
        Administrator administrator = adminService.getAdmin(adminId);
        if (administrator != null){
            return "Admin with id " + adminId + " made: " + adminService.blockAccount(accountId);
        }
        return "Admin with id " + adminId + " not found";
    }

    @PostMapping("/{adminId}/unblock/{accountId}")
    public String unblockAccount(@PathVariable int accountId, @PathVariable int adminId) {
        Administrator administrator = adminService.getAdmin(adminId);
        if (administrator != null){
            return "Admin with id " + adminId + " made: " + adminService.unblockAccount(accountId);
        }
        return "Admin with id " + adminId + " not found";
    }
}
