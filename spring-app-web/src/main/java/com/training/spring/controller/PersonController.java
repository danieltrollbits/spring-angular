package com.training.spring.controller;

import java.util.List;
import java.util.ArrayList;

import com.training.spring.service.PersonService;
import com.training.spring.service.PersonAuditService;
import com.training.spring.service.UserService;
import com.training.spring.dto.PersonDto;
import com.training.spring.dto.RoleDto;
import com.training.spring.dto.ContactDto;
import com.training.spring.dto.PersonAuditDto;
import com.training.spring.editor.DateEditor;
import com.training.spring.editor.GenderEditor;
import com.training.spring.model.Gender;
import com.training.spring.dto.UserDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.WebDataBinder;
import java.util.Date;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import java.lang.RuntimeException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

@Controller
public class PersonController {
	
	@Autowired
	private PersonService personService;

	@Autowired
	private PersonAuditService personAuditService;

	@Autowired
	private UserService userService;

	@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new DateEditor());
        binder.registerCustomEditor(Gender.class, new GenderEditor());
    }

    @RequestMapping(value = "/login", method = {RequestMethod.GET,RequestMethod.POST})
    public String login(){
    	return "login";
    }

    @RequestMapping(value = "/login_as_admin", method = {RequestMethod.GET,RequestMethod.POST})
    public String login(@RequestParam String username, @RequestParam String password){
    	UserDto userDto = userService.getUsernameAndPassword(username, password);
    	if(userDto.getUserRoleDto().contains("ADMIN")){
    		return "redirect:/login?admin";
    	}
    	else{
    		return "login";
    	}
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login?logout";
	}

	@RequestMapping(value = "/denied", method = RequestMethod.GET)
	public String denied() {
	    return "denied";
	}

	@RequestMapping(value = "/create_account", method = RequestMethod.POST)
	public String createAccount(UserDto userDto){
		userService.save(userDto);
		return "redirect:/login?saved";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView list(){
		List<PersonDto> personDtos = personService.getAllPersons();
		ModelAndView model = new ModelAndView("index");
		model.addObject("persons",personDtos);
		model.addObject("roles",personService.getRoles());
		return model;
	}

	@RequestMapping(value="view/{personId}", method = RequestMethod.GET)
	public ModelAndView view(@PathVariable int[] personId){
		PersonDto personDto = new PersonDto();
		if(personId != null && personId.length == 1){
			personDto = personService.getPersonById(personId[0]);
			ModelAndView model = new ModelAndView("view");
			model.addObject("personDto",personDto);
			model.addObject("roles",personService.getRoles());
    		return model;
		}
		else{
			return new ModelAndView("redirect:/?message=Please select one person");
		}
	}	


	@RequestMapping(value="/add", method = RequestMethod.GET)
	public ModelAndView add(){
		ModelAndView model = new ModelAndView("person");
		PersonDto personDto = new PersonDto();
		model.addObject("roles",personService.getRoles());
		model.addObject("personDto",personDto);
		return model;
	}

	@RequestMapping(value="/update", method = RequestMethod.GET)
	public ModelAndView update(@RequestParam(value="personId",required=false) int[] personId){
		PersonDto personDto = new PersonDto();
		if (personId != null && personId.length == 1){
			personDto = personService.getPersonById(personId[0]);
			ModelAndView model = new ModelAndView("person");
			model.addObject("personDto",personDto);
			model.addObject("roles",personService.getRoles());
    		return model;
    	}
    	else{
    		return new ModelAndView("redirect:/?message=Please select one person");
    	}
	}

	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public ModelAndView delete(@RequestParam(value="personId",required=false) int[] personId){
		if(personId != null){	
			for(int id : personId){
				personService.deletePerson(id);
			}
			return new ModelAndView("redirect:/?message=Person/s deleted");
		}else{
			return new ModelAndView("redirect:/?message=Please select person/s to delete");
		}
	}

	@RequestMapping(value="/search", method = RequestMethod.GET)
	public ModelAndView search(@RequestParam(value="firstName",required=false) String firstName,
		@RequestParam(value="middleName",required=false) String middleName,
		@RequestParam(value="lastName",required=false) String lastName,
		@RequestParam(value="roles",required=false) String roles){
		ModelAndView model = new ModelAndView("index");
		List<PersonDto> personDtos = null;
		if (lastName.isEmpty() && firstName.isEmpty() && middleName.isEmpty() && roles.isEmpty()){
			personDtos = personService.getAllPersons();
		}
		else{
			personDtos = personService.searchPerson(lastName,firstName,
			middleName,roles);
		}
		model.addObject("persons",personDtos);
		model.addObject("roles",personService.getRoles());
		return model;
	}

	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView search(@Valid PersonDto personDto, BindingResult result){
		List<ContactDto> contactDtos = new ArrayList<>();
		for (ContactDto c : personDto.getContactDtos()){
			if (c.getType() != null && c.getValue() != ""){
				contactDtos.add(c);
			}
		}
		personDto.setContactDtos(contactDtos);
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("person");
			model.addObject("roles",personService.getRoles());
			return model;
		}
		else{
			if(personDto.getId() != 0){
				personService.updatePerson(personDto);	
			}
			else{
				personService.savePerson(personDto);
			}
			return new ModelAndView("redirect:/?message=Person saved");
		}
	}

	@RequestMapping(value="/audit", method=RequestMethod.GET)
	public ModelAndView audit(){
		List<PersonAuditDto> personAuditDtos = personAuditService.list();
		ModelAndView model = new ModelAndView("person_audit");
		model.addObject("personAudits",personAuditDtos);
		return model;
	}


}
