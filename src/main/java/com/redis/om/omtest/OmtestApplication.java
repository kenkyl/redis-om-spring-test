package com.redis.om.omtest;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.redis.om.omtest.domain.CompanyRole;
import com.redis.om.omtest.domain.Document;
import com.redis.om.omtest.domain.Employee;
import com.redis.om.omtest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.geo.Point;

import com.redis.om.omtest.domain.Company;
import com.redis.om.omtest.repository.CompanyRepository;
import com.redis.om.spring.annotations.EnableRedisDocumentRepositories;


@SpringBootApplication
@EnableRedisDocumentRepositories(basePackages = "com.redis.om.omtest.*")
public class OmtestApplication {

	@Autowired
	CompanyRepository companyRepo;

	@Autowired
	EmployeeRepository employeeRepo;

	@Bean
	CommandLineRunner loadTestData() {
		return args -> {
			companyRepo.deleteAll();
			employeeRepo.deleteAll();

			Employee kyle = Employee.of("kyle@redis.com", "Kyle Kennedy");
			Employee brian = Employee.of("brian@redis.com", "Brian Sam");
			Employee john = Employee.of("john@msoft.com", "John Doe");

			Set<String> redisEmployees = Set.of(kyle.getEmployeeEmail(), brian.getEmployeeEmail());
			Set<String> msoftEmployees = Set.of(kyle.getEmployeeEmail(), john.getEmployeeEmail());

			Company redis = Company.of(UUID.randomUUID().toString(), "Redis");
			Company microsoft = Company.of(UUID.randomUUID().toString(),"Microsoft");
			redis.setEmployees(redisEmployees);
			microsoft.setEmployees(msoftEmployees);

			CompanyRole kyleRedisRole = new CompanyRole(UUID.fromString(redis.getCompanyId()), List.of("admin"));
			CompanyRole kyleMsoftRole = new CompanyRole(UUID.fromString(microsoft.getCompanyId()), List.of("view", "edit"));
			CompanyRole brianRedisRole = new CompanyRole(UUID.fromString(redis.getCompanyId()), List.of("view", "edit", "delete"));
			CompanyRole johnMsoftRole = new CompanyRole(UUID.fromString(microsoft.getCompanyId()), List.of("view"));

			Document redisDoc = new Document(UUID.randomUUID().toString(), redis.getCompanyId(), "Redis Doc", kyle.getEmployeeEmail());
			Document msoftDoc = new Document(UUID.randomUUID().toString(), microsoft.getCompanyId(), "Msoft Doc", john.getEmployeeEmail());

			kyle.setCompanies(List.of(redis.getCompanyId(), microsoft.getCompanyId()));
			kyle.setCompanyRoles(List.of(kyleRedisRole, kyleMsoftRole));
			kyle.setCompanyDocuments(List.of(redisDoc, msoftDoc));

			brian.setCompanies(List.of(redis.getCompanyId()));
			brian.setCompanyRoles(List.of(brianRedisRole));
			brian.setCompanyDocuments(List.of(redisDoc));

			john.setCompanies(List.of(microsoft.getCompanyId()));
			john.setCompanyRoles(List.of(johnMsoftRole));
			john.setCompanyDocuments(List.of(msoftDoc));

			companyRepo.save(redis);
			companyRepo.save(microsoft);
			employeeRepo.save(kyle);
			employeeRepo.save(brian);
			employeeRepo.save(john);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(OmtestApplication.class, args);
	}

}
