package com.training.spring.service;

import com.training.spring.model.Status;
import com.training.spring.model.PersonAudit;
import com.training.spring.dto.PersonAuditDto;
import com.training.spring.dto.PersonDto;
import java.util.List;

public interface PersonAuditService {
	public PersonAudit savePersonAudit(PersonDto person, Status status);

	public List<PersonAuditDto> list();
}