package com.redis.om.omtest.repositories;

import com.redis.om.omtest.domain.Company;
import com.redis.om.spring.annotations.Query;
import com.redis.om.spring.repository.RedisDocumentRepository;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface CompanyRepository extends RedisDocumentRepository<Company, String> {

    Iterable<Company> findByTags(@Param("tags") Set<String> tags);

    // find by tag field, using JRediSearch "native" annotation
    @Query("@tags:{$tags}")
    Iterable<Company> findByTags2(@Param("tags") Set<String> tags);
}