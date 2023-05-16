package com.redis.om.omtest.domain;

import com.redis.om.spring.annotations.Indexed;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
public class CompanyRole {

    //@Indexed
    private UUID companyId;
    private List<String> roles;

}
