package com.redis.om.omtest.controller;

import com.redis.om.omtest.domain.Company;
import com.redis.om.omtest.repository.CompanyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/companies")
public class CompanyControllerV1 {
    @Autowired
    CompanyRepository companyRepo;

    @GetMapping("all")
    Iterable<Company> all() {
        return companyRepo.findAll();
    }

    @GetMapping("employeeEmail")
    Iterable<Company> byEmployeeEmail(@RequestParam("employeeEmail") String employeeEmail) {
        return companyRepo.findByEmployeeEmail(employeeEmail);
    }

//    @GetMapping("tags")
//    Iterable<Company> byTags(@RequestParam("tags") Set<String> tags) {
//        return companyRepo.findByTags(tags);
//    }
//
//    @GetMapping("tags2")
//    Iterable<Company> byTags2(@RequestParam("tags") Set<String> tags) {
//        return companyRepo.findByTags2(tags);
//    }
}