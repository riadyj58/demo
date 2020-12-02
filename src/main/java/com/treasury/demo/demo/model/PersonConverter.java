package com.treasury.demo.demo.model;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PersonConverter {
    public PersonDto entityTDto(Person person)
    {
     ModelMapper mapper=new ModelMapper();
     PersonDto persondto=mapper.map(person, PersonDto.class);
     return persondto;
    }
    public List<PersonDto> entityTDto(List<Person> person)
    {
        return person.stream().map(x->entityTDto(x)).collect(Collectors.toList());
    }
}
