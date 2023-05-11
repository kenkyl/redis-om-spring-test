package com.redis.om.omtest;

import java.util.List;
import java.util.Set;
import java.util.UUID;

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

			Employee kyle = Employee.of()
			Employee brian = Employee.of()
			Employee sri = Employee.of()

			Company redis = Company.of(UUID.randomUUID().toString(), "Redis", Set.of(kyle, brian));

			Company microsoft = Company.of("Microsoft", "https://microsoft.com", new Point(-122.124500, 47.640160), 182268, 1975);


			companyRepo.save(redis);
			companyRepo.save(microsoft);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(OmtestApplication.class, args);
	}

}
