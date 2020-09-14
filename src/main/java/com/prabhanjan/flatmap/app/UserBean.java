package com.prabhanjan.flatmap.app;

import java.util.List;

public class UserBean {

	private String name;
	private Integer age;
	private List<Integer> phoneNumber;

	@Override
	public String toString() {
		return "UserBean [name=" + name + ", age=" + age + ", phoneNumber=" + phoneNumber + "]";
	}

	public UserBean(String name, Integer age, List<Integer> phoneNumber) {
		super();
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
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

	public List<Integer> getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(List<Integer> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
