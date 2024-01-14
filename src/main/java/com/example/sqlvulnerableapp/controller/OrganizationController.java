package com.example.sqlvulnerableapp.controller;

import com.example.sqlvulnerableapp.repo.UserEntity;
import com.example.sqlvulnerableapp.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/organization")
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    //unsafe queries

    @GetMapping("/{name}")
    public ResponseEntity<List<UserEntity>> getUsersByOrganization(@PathVariable String name) {
        return ResponseEntity.ok(organizationService.getUsersByNameUnsafe(name));
    }

    @GetMapping("/ai/{name}")
    public ResponseEntity<String> getEmailByOrganizationAI(@PathVariable String name) {
        return ResponseEntity.ok(organizationService.getEmailsByNameUnsafeAI(name));
    }

    @GetMapping("/engineering/{name}")
    public ResponseEntity<String> getEmailByOrganizationEngineering(@PathVariable String name) {
        return ResponseEntity.ok(organizationService.getEmailsByNameSafeEngineering(name));
    }
}
