package com.training.spring.dao;

import com.training.spring.model.PersonAudit;
import java.util.List;

public interface PersonAuditDao {

	PersonAudit savePersonAudit(PersonAudit personAudit);

	List<PersonAudit> list();

}