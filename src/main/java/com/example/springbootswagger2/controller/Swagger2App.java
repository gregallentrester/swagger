package com.example.springbootswagger2.controller;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

import com.example.springbootswagger2.model.Person;
import io.swagger.annotations.*;


@Api(value = "Swagger2DemoRestController", description = "REST APIs related to Person")
@RestController
public class Swagger2DemoRestController {

	List<Person> persons = new ArrayList();

	{
		persons.add(new Person("Vanessa", "Williams"));
		persons.add(new Person("Martha", "Dixon"));
		persons.add(new Person("Greg", "Allen"));
  }

	@ApiOperation(value = "List Persons ", response = Iterable.class, tags = "getPersons")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Suceess"),
			@ApiResponse(code = 401, message = "Not Authorized!"),
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found") })
	@RequestMapping(value = "/getPersons")
	public List<Person> getPersons() {
		return persons;
	}

	@ApiOperation(value = "Get one person ", response = Person.class, tags = "getPerson")
	@RequestMapping(value = "/getPerson/{firstname}")
	public Person getPerson(@PathVariable(value = "firstname") String firstname) {

		return
		  persons.stream().filter(
			  x -> x.getFirstname().equalsIgnoreCase(firstname)).
				       collect(Collectors.toList()).get(0);
	}

	@ApiOperation(value = "Get person By lastname ", response = Person.class, tags = "getPersonByLastname")
	@RequestMapping(value = "/getPersonByLastname/{lastname}")
	public List<Person> getPersonByLastname(@PathVariable(value = "lastname") String lastname) {

		System.out.println("Searching Person by lastname : " + lastname);

		List<Person> personsByLastname =
		persons.stream().filter(
			x -> x.getLastname().equalsIgnoreCase(lastname)).
				       collect(Collectors.toList());

		System.out.println(personsByLastname);

		return personsByLastname;
	}
}
