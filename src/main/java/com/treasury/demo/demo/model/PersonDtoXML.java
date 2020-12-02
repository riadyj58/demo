package com.treasury.demo.demo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@JacksonXmlRootElement(localName = "p_dto_xml")
public class PersonDtoXML {
    @JacksonXmlProperty(localName = "fname")
    @NotBlank(message = "Cannot blank")
    private String firstName;
    @JacksonXmlProperty(localName = "lname")
    @NotNull(message = "Cannot null")
    private String lastName;
    @JacksonXmlProperty(localName = "age")
    private int age;
    @JsonFormat(pattern = "yyyyMMdd")
    private String date;
}
