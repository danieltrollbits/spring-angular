package com.training.spring.service;

import com.training.spring.dto.PersonDto;
import com.training.spring.dto.RoleDto;
import com.training.spring.dto.ContactDto;
import java.util.List;

public interface PersonService {

	public List<PersonDto> getAllPersons();

	public PersonDto getPersonById(int id);

	public PersonDto savePerson(PersonDto personDto);

	public PersonDto updatePerson(PersonDto personDto);

	public PersonDto deletePerson(int id);

	public List<PersonDto> searchPerson(String lastName, String firstName, String middleName, String role);

	public List<RoleDto> getRoles();

	public ContactDto addContact(String contactType, String contactValue);

}