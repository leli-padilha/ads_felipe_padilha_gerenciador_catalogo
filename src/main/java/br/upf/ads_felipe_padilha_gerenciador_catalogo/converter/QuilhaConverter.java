package br.upf.ads_felipe_padilha_gerenciador_catalogo.converter;

import br.upf.ads_felipe_padilha_gerenciador_catalogo.facade.QuilhaFacade;
import br.upf.ads_felipe_padilha_gerenciador_catalogo.model.Quilha;
import jakarta.ejb.EJB;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(value = "quilhaConverter", managed = true)
public class QuilhaConverter implements Converter<Quilha> {

    @EJB
    private QuilhaFacade facade;

    @Override
    public Quilha getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isBlank()) {
            return null;
        }
        return facade.find(Integer.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Quilha value) {
        if (value == null || value.getId() == null) {
            return "";
        }
        return value.getId().toString();
    }
}
