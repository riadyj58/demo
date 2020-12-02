package com.treasury.demo.demo.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Scope("prototype")

@Entity 
@Table(name="person")
@Data
public class Person {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    int id;
    @Column(name="FIRST_NAME")
    String firstName;
    @Column(name="LAST_NAME")
    String lastName;
    @Column(name="AGE")
    int age;

    @Override
    public String toString() {
        return "Person [age=" + age + ", firstName=" + firstName + ", id=" + id + ", lastName=" + lastName + "]";
    }

    
}
