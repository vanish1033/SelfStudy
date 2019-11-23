package com.bjpowernode.domain;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "user")
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