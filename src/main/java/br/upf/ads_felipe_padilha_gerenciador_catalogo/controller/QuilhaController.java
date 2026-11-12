package br.upf.ads_felipe_padilha_gerenciador_catalogo.controller;

import br.upf.ads_felipe_padilha_gerenciador_catalogo.facade.AbstractFacade;
import br.upf.ads_felipe_padilha_gerenciador_catalogo.facade.QuilhaFacade;
import br.upf.ads_felipe_padilha_gerenciador_catalogo.model.Quilha;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.util.List;

@Named
@SessionScoped
public class QuilhaController extends AbstractCrudController<Quilha> {

    @EJB
    private QuilhaFacade ejbFacade;
    private Quilha quilha;

    @PostConstruct
    public void init() {
        prepareCreate();
    }

    public void prepareCreate() {
        quilha = new Quilha();
        quilha.setAtivo(true);
    }

    public void adicionar() {
        if (persist(PersistAction.CREATE, "Quilha cadastrada.", quilha)) {
            prepareCreate();
        }
    }

    public void editar() {
        persist(PersistAction.UPDATE, "Quilha atualizada.", getSelected());
    }

    public void excluir() {
        persist(PersistAction.DELETE, "Quilha excluída.", getSelected());
    }

    public List<Quilha> getQuilhaList() {
        return getItems();
    }

    public List<Quilha> getAtivas() {
        return ejbFacade.findAtivas();
    }

    public Quilha getQuilha() {
        return quilha;
    }

    public void setQuilha(Quilha quilha) {
        this.quilha = quilha;
    }

    @Override
    protected AbstractFacade<Quilha> getFacade() {
        return ejbFacade;
    }

    @Override
    protected List<Quilha> listar() {
        return ejbFacade.findAllOrderByNome();
    }
}
