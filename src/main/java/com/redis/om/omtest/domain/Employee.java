package com.redis.om.omtest.domain;

import com.redis.om.spring.annotations.Document;
import com.redis.om.spring.annotations.Searchable;
import com.redis.om.spring.annotations.Indexed;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Document("Employee")
public class Employee {

    @Id
    private String employeeEmail;

    @Searchable
    private String employeeName;

    // list of company id to role mappings
    @Indexed
    private List<CompanyRole> companyRoles;

    // list of company ids
    @Indexed
    private List<String> companies;

    // list of documents by employee (with company id mapping)
    @Indexed
    private List<com.redis.om.omtest.domain.Document> companyDocuments;

}
