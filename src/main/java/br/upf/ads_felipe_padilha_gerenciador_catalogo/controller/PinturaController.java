package br.upf.ads_felipe_padilha_gerenciador_catalogo.controller;

import br.upf.ads_felipe_padilha_gerenciador_catalogo.facade.AbstractFacade;
import br.upf.ads_felipe_padilha_gerenciador_catalogo.facade.PinturaFacade;
import br.upf.ads_felipe_padilha_gerenciador_catalogo.model.Pintura;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.util.List;

@Named
@SessionScoped
public class PinturaController extends AbstractCrudController<Pintura> {

    @EJB
    private PinturaFacade ejbFacade;
    private Pintura pintura;

    @PostConstruct
    public void init() {
        prepareCreate();
    }

    public void prepareCreate() {
        pintura = new Pintura();
        pintura.setAtivo(true);
    }

    public void adicionar() {
        if (persist(PersistAction.CREATE, "Pintura cadastrada.", pintura)) {
            prepareCreate();
        }
    }

    public void editar() {
        persist(PersistAction.UPDATE, "Pintura atualizada.", getSelected());
    }

    public void excluir() {
        persist(PersistAction.DELETE, "Pintura excluída.", getSelected());
    }

    public List<Pintura> getPinturaList() {
        return getItems();
    }

    public List<Pintura> getAtivas() {
        return ejbFacade.findAtivas();
    }

    public Pintura getPintura() {
        return pintura;
    }

    public void setPintura(Pintura pintura) {
        this.pintura = pintura;
    }

    @Override
    protected AbstractFacade<Pintura> getFacade() {
        return ejbFacade;
    }

    @Override
    protected List<Pintura> listar() {
        return ejbFacade.findAllOrderByNome();
    }
}
