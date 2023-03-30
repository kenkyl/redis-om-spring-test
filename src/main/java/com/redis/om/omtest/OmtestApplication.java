package com.redis.om.omtest;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.geo.Point;

import com.redis.om.omtest.domain.Company;
import com.redis.om.omtest.repositories.CompanyRepository;
import com.redis.om.spring.annotations.EnableRedisDocumentRepositories;


@SpringBootApplication
@EnableRedisDocumentRepositories(basePackages = "com.redis.om.omtest.*")
public class OmtestApplication {

	@Autowired
	CompanyRepository companyRepo;

	@Bean
	CommandLineRunner loadTestData() {
		return args -> {
			companyRepo.deleteAll();

			Company redis = Company.of("Redis", "https://redis.com", new Point(-122.066540, 37.377690), 526, 2011);
			redis.setTags(Set.of("fast", "scalable", "reliable"));

			Company microsoft = Company.of("Microsoft", "https://microsoft.com", new Point(-122.124500, 47.640160), 182268, 1975);
			microsoft.setTags(Set.of("innovative", "reliable"));

			companyRepo.save(redis);
			companyRepo.save(microsoft);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(OmtestApplication.class, args);
	}

}
