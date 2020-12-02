package com.treasury.demo.demo.controller;
import java.util.List;

import javax.validation.Valid;

import com.treasury.demo.demo.model.Person;
import com.treasury.demo.demo.model.PersonDao;
import com.treasury.demo.demo.model.PersonDto;
import com.treasury.demo.demo.model.PersonDtoXML;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class DemoController {
    @Autowired
    PersonDao personDao;


    @GetMapping(value = "/findAll",produces = "application/xml")
    public List<PersonDto> findAll()
    {
        
        //System.out.println(personDao.findAll().get(0).toString());
       // System.out.println(personDao.findAll().isEmpty())
       log.debug("DEBUG Find All");
       log.info("Info Find All");
       log.warn("Warn Find ALl");
       log.trace("Trace Find All");
       log.error("Error Find All");

       
       return personDao.findAll().isEmpty() == true ? null : personDao.findAll();
    }
//INGET PERBEDAAN REQUESTBODY SAMA REQUEST PARAM
    @PostMapping(value = "/insertPerson")
    public Person insertPerson(@Valid @RequestBody PersonDtoXML personDtoXML)
    {

        System.out.println(personDtoXML.getDate());
        Person person=personDao.insertPerson(personDtoXML.getFirstName(), personDtoXML.getLastName(), personDtoXML.getAge());
        
        return person;
    }
    @GetMapping(value = "/findById",produces="application/xml")
    public PersonDto findById(@RequestParam int id)
    {
        return personDao.findById(id);
    }

    @GetMapping("/findByIdXML")
    public PersonDtoXML findByIdXml(@RequestParam int id)
    {
        return null;
    }


}
