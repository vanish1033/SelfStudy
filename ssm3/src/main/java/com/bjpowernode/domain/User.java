package com.bjpowernode.domain;

import lombok.Data;

@Data
public class User {
    /**
    * id
    */
    private Integer id;

    /**
    * name
    */
    private String name;

    /**
    * gender
    */
    private String gender;

    /**
    * age
    */
    private Integer age;
}