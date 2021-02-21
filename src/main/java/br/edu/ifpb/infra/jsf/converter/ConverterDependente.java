package br.edu.ifpb.infra.jsf.converter;

import br.edu.ifpb.domain.Dependente;
import br.edu.ifpb.domain.Pessoas;
import br.edu.ifpb.infra.persistence.memory.PessoasEmMemoria;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "converter.Dependente")
public class ConverterDependente implements Converter {

    private Pessoas service = new PessoasEmMemoria();

    @Override
    public Object getAsObject(
        FacesContext context,
        UIComponent component,
        String value) {
        if (value == null) {
            return null;
        }

        Dependente dep = this.service
            .localizarDependenteComId(value);
        return dep;
//return new Dependente(value,"");

    }

    @Override
    public String getAsString(
        FacesContext context,
        UIComponent component,
        Object value) {

        if (value == null) {
            return null;
        }
        Dependente dep = (Dependente) value;
        return dep.getUuid();
    }

}
