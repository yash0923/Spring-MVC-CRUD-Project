package com.hendisantika.springmvcdemo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created in Eclipse IDE.
 * Project : SpringMVCDemo-master
 * User: yash
 * Date: 18/01/2020
 */

@Data
public class Employee implements Serializable {
    private static final long serialVersionUID = -1280037900360314186L;

    
	private Integer id;
    private String name;
    private Integer age;
    private String dept;
    
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
}
