package org.spring.casadocodigo.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.metadata.BeanDescriptor;

import org.spring.casadocodigo.models.Produto;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ProdutoValidation implements Validator {
	
	public boolean supports(Class<?> clazz) {
        return Produto.class.isAssignableFrom(clazz);
    }
	
	public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "titulo", "field.required");
        ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");

        Produto produto = (Produto) target;

        if(produto.getPaginas() <= 0) {
            errors.rejectValue("paginas", "field.required");
        }
    }

	
}
