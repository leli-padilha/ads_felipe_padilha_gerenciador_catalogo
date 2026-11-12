package br.upf.ads_felipe_padilha_gerenciador_catalogo.converter;

import br.upf.ads_felipe_padilha_gerenciador_catalogo.facade.ConstrucaoFacade;
import br.upf.ads_felipe_padilha_gerenciador_catalogo.model.Construcao;
import jakarta.ejb.EJB;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(value = "construcaoConverter", managed = true)
public class ConstrucaoConverter implements Converter<Construcao> {

    @EJB
    private ConstrucaoFacade facade;

    @Override
    public Construcao getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isBlank()) {
            return null;
        }
        return facade.find(Integer.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Construcao value) {
        if (value == null || value.getId() == null) {
            return "";
        }
        return value.getId().toString();
    }
}
