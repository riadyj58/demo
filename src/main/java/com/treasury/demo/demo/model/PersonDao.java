package com.treasury.demo.demo.model;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonDao {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    PersonConverter personConverter;


    public Person insertPerson(String firstName,String lastName,int age)
    {
        Person person=new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setAge(age);
        return personRepository.save(person);        
    }

    public List<PersonDto> findAll()
    {
        return personConverter.entityTDto(personRepository.findAll());
    }

    public PersonDto findById(int id)
    {
        Optional<Person> person=personRepository.findById(id);
        
        return person.isEmpty()==true?null:personConverter.entityTDto(person.get());
    }
}



