package com.redis.om.omtest.domain;


import com.redis.om.spring.annotations.Indexed;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Document {

    //@Indexed
    private String documentId;

    //@Indexed
    private String companyId;

    //@Indexed
    private String name;

    private String userEmail;
}
