package br.upf.ads_felipe_padilha_gerenciador_catalogo.controller;

import br.upf.ads_felipe_padilha_gerenciador_catalogo.facade.AbstractFacade;
import br.upf.ads_felipe_padilha_gerenciador_catalogo.facade.ConstrucaoFacade;
import br.upf.ads_felipe_padilha_gerenciador_catalogo.model.Construcao;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.util.List;

@Named
@SessionScoped
public class ConstrucaoController extends AbstractCrudController<Construcao> {

    @EJB
    private ConstrucaoFacade ejbFacade;
    private Construcao construcao;

    @PostConstruct
    public void init() {
        prepareCreate();
    }

    public void prepareCreate() {
        construcao = new Construcao();
        construcao.setAtivo(true);
    }

    public void adicionar() {
        if (persist(PersistAction.CREATE, "Construção cadastrada.", construcao)) {
            prepareCreate();
        }
    }

    public void editar() {
        persist(PersistAction.UPDATE, "Construção atualizada.", getSelected());
    }

    public void excluir() {
        persist(PersistAction.DELETE, "Construção excluída.", getSelected());
    }

    public List<Construcao> getConstrucaoList() {
        return getItems();
    }

    public List<Construcao> getAtivas() {
        return ejbFacade.findAtivas();
    }

    public Construcao getConstrucao() {
        return construcao;
    }

    public void setConstrucao(Construcao construcao) {
        this.construcao = construcao;
    }

    @Override
    protected AbstractFacade<Construcao> getFacade() {
        return ejbFacade;
    }

    @Override
    protected List<Construcao> listar() {
        return ejbFacade.findAllOrderByNome();
    }
}
