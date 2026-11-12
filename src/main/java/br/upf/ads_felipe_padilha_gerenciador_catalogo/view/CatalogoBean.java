package br.upf.ads_felipe_padilha_gerenciador_catalogo.view;

import br.upf.ads_felipe_padilha_gerenciador_catalogo.facade.PranchaFacade;
import br.upf.ads_felipe_padilha_gerenciador_catalogo.model.Prancha;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class CatalogoBean implements Serializable {

    @EJB
    private PranchaFacade pranchaFacade;
    private List<Prancha> pranchas = new ArrayList<>();
    private Prancha selecionada;

    @PostConstruct
    public void iniciar() {
        pranchas = pranchaFacade.findAtivas();
    }

    public void selecionar(Integer id) {
        this.selecionada = pranchas.stream()
                .filter(prancha -> prancha.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Prancha> getPranchas() {
        return pranchas;
    }

    public Prancha getSelecionada() {
        return selecionada;
    }
}
