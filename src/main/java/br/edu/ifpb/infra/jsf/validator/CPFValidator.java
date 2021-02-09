package br.edu.ifpb.infra.jsf.validator;

import br.edu.ifpb.domain.CPF;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.Arrays;

@FacesValidator("cpf.validator")
public class CPFValidator implements Validator {
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        CPF cpf = (CPF) value;
        if (cpf.valido()) return;

        throw new ValidatorException(
                new FacesMessage("CPF inválido")
        );

//        throw new ValidatorException(
//                Arrays.asList(
//                        new FacesMessage("CPF inválido"),
//                        new FacesMessage("nome incompleto")
//                )
//        );
    }
}
