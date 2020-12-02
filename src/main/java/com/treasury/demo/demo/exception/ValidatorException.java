package com.treasury.demo.demo.exception;
import org.springframework.validation.BindingResult;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class ValidatorException extends Exception
{
    private static final long serialVersionUID = -5966626458547949897L;
    private BindingResult bindingResult;
}