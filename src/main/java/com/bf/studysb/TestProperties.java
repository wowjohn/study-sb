package com.bf.studysb;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class TestProperties {

    @Value("${com.bf.studysb.name}")
    private String name;

    @Value("${com.bf.studysb.random-string}")
    private String randomString;
}