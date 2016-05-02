package com.training.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterReturning;
import com.training.spring.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import com.training.spring.service.PersonAuditService;
import com.training.spring.dto.PersonDto;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AuditPersonAspect {

	@Autowired
	private PersonAuditService personAuditService;

	@Pointcut("execution(* com.training.spring.service.PersonService.savePerson(..))")
	public void save(){};

	@Pointcut("execution(* com.training.spring.service.PersonService.updatePerson(..))")
	public void update(){};

	@Pointcut("execution(* com.training.spring.service.PersonService.deletePerson(..))")
	public void delete(){};

	 @AfterReturning(
	 	pointcut = "save() || update() || delete()",
      returning= "result")
   	public void logAfterReturning(JoinPoint joinPoint, Object result) {

		System.out.println("saving person log");
		System.out.println("Method returned value is : " + result);
		Status status = null;
		if(joinPoint.getSignature().getName().equals("savePerson")){
			status = Status.ADDED;
		}
		else if(joinPoint.getSignature().getName().equals("updatePerson")){
			status = Status.MODIFIED;
		}
		else{
			status = Status.DELETED;
		}
		personAuditService.savePersonAudit((PersonDto)result, status);
   }

}