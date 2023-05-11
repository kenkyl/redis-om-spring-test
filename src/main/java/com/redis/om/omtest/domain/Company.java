package com.redis.om.omtest.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;

import com.redis.om.spring.annotations.Document;
import com.redis.om.spring.annotations.Searchable;
import com.redis.om.spring.annotations.Indexed;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Document("Company")
public class Company {
    @Id
    private String companyId;

    @NonNull
    @Searchable
    private String name;

    @Indexed
    private Set<String> employees;

}
