package br.upf.ads_felipe_padilha_gerenciador_catalogo.controller;

import br.upf.ads_felipe_padilha_gerenciador_catalogo.facade.AbstractFacade;
import br.upf.ads_felipe_padilha_gerenciador_catalogo.facade.MarcaFacade;
import br.upf.ads_felipe_padilha_gerenciador_catalogo.model.Marca;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.util.List;

@Named
@SessionScoped
public class MarcaController extends AbstractCrudController<Marca> {

    @EJB
    private MarcaFacade ejbFacade;
    private Marca marca;

    @PostConstruct
    public void init() {
        prepareCreate();
    }

    public void prepareCreate() {
        marca = new Marca();
        marca.setAtivo(true);
    }

    public void adicionar() {
        if (persist(PersistAction.CREATE, "Marca cadastrada.", marca)) {
            prepareCreate();
        }
    }

    public void editar() {
        persist(PersistAction.UPDATE, "Marca atualizada.", getSelected());
    }

    public void excluir() {
        persist(PersistAction.DELETE, "Marca excluída.", getSelected());
    }

    public List<Marca> getMarcaList() {
        return getItems();
    }

    public List<Marca> getAtivas() {
        return ejbFacade.findAtivas();
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    @Override
    protected AbstractFacade<Marca> getFacade() {
        return ejbFacade;
    }

    @Override
    protected List<Marca> listar() {
        return ejbFacade.findAllOrderByNome();
    }
}
