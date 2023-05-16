package com.redis.om.omtest.controller;

import com.redis.om.omtest.domain.Company;
import com.redis.om.omtest.domain.Employee;
import com.redis.om.omtest.repository.CompanyRepository;
import com.redis.om.omtest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeControllerV1 {

    @Autowired
    EmployeeRepository employeeRepo;

    @GetMapping("all")
    Iterable<Employee> all() {
        return employeeRepo.findAll();
    }

//    @GetMapping("name")
//    Iterable<Employee> byName(@RequestParam("name") String name) {
//        return employeeRepo.findByEmployeName(name);
//    }
}
