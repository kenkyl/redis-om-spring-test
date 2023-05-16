package com.redis.om.omtest.repository;

import com.redis.om.omtest.domain.Company;
import com.redis.om.omtest.domain.Employee;
import com.redis.om.spring.annotations.Query;
import com.redis.om.spring.repository.RedisDocumentRepository;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface EmployeeRepository extends RedisDocumentRepository<Employee, String> {
//    Iterable<Employee> findByEmployeName(@Param("name") String name);
}
