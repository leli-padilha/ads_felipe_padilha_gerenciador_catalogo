package br.upf.ads_felipe_padilha_gerenciador_catalogo.converter;

import br.upf.ads_felipe_padilha_gerenciador_catalogo.facade.MarcaFacade;
import br.upf.ads_felipe_padilha_gerenciador_catalogo.model.Marca;
import jakarta.ejb.EJB;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(value = "marcaConverter", managed = true)
public class MarcaConverter implements Converter<Marca> {

    @EJB
    private MarcaFacade facade;

    @Override
    public Marca getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isBlank()) {
            return null;
        }
        return facade.find(Integer.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Marca value) {
        if (value == null || value.getId() == null) {
            return "";
        }
        return value.getId().toString();
    }
}
