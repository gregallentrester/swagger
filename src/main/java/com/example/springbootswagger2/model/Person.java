package com.example.springbootswagger2.model;

import io.swagger.annotations.ApiModelProperty;

public class Person {

	public Person(String fname, String lname) {
		firstname = fname;
		lastname = lname;
	}

	@ApiModelProperty(notes = "firstname", name="firstname", required=true, value="test firstname")
	private String firstname;

	@ApiModelProperty(notes = "lastname", name="lastname", required=true, value="test lastname")
	private String lastname;

	public String getFirstname() { return firstname; }
	public String getLastname() { return lastname; }

	@Override
	public String toString() {
		return "Person [first=" + firstname + ", last=" + lastname + "]";
	}
}
