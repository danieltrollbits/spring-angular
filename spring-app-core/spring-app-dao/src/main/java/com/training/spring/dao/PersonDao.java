package com.training.spring.dao;

import com.training.spring.model.Person;
import com.training.spring.model.Role;
import java.util.List;

public interface PersonDao {

	List<Person> getAllPersons();

	Person getPersonById(int id);

	List<Person> searchPerson(String lastName, String firstName, String middleName, String role);

	Person savePerson(Person person);

	Person updatePerson(Person person);

	Person deletePerson(int id);

	Role getRoleByName(String name);

	List<Role> getRoles();

}