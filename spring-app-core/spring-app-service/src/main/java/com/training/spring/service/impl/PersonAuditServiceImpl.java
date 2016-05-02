package com.training.spring.service.impl;

import com.training.spring.model.PersonAudit;
import com.training.spring.dto.PersonAuditDto;
import com.training.spring.dto.PersonDto;
import com.training.spring.model.Status;
import com.training.spring.dao.PersonAuditDao;
import com.training.spring.service.PersonAuditService;
import java.util.Date;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.beanutils.BeanUtils;
import java.util.List;
import java.util.ArrayList;

@Service
public class PersonAuditServiceImpl implements PersonAuditService {

	@Autowired
	private PersonAuditDao personAuditDao;

	@Override
	public PersonAudit savePersonAudit(PersonDto person, Status status){
		return personAuditDao.savePersonAudit(toAudit(person,status));
	}

	public PersonAudit toAudit(PersonDto person, Status status){
		PersonAudit personAudit = new PersonAudit();
		personAudit.setPersonId(person.getId());
		personAudit.setStatus(status);
		// personAudit.setCurrentDate(new Date());
		return personAudit;
	}

	public PersonAuditDto toDto(PersonAudit personAudit){
		PersonAuditDto personAuditDto = new PersonAuditDto();
		try{
			BeanUtils.copyProperties(personAuditDto,personAudit);	
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return personAuditDto;
	}

	public List<PersonAuditDto> toDtos(List<PersonAudit> personAudits){
		List<PersonAuditDto> personAuditDtos = new ArrayList<>();
		for (PersonAudit personAudit : personAudits){
			personAuditDtos.add(toDto(personAudit));
		}
		return personAuditDtos;
	}

	public List<PersonAuditDto> list(){
		return toDtos(personAuditDao.list());
	}

}