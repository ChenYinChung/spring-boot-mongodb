package com.sb.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;

/**
 * @Auther: sammy
 * @Date: 2018/5/22 11:59
 * @Description:
 */
@Document(collection = "test")
public class User implements Serializable{

    private static final long serialVersionUID = -3681921164813044855L;

    @Id
    private String id;
    String name;
    String company;
    String school;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
