package br.upf.ads_felipe_padilha_gerenciador_catalogo.controller;

import br.upf.ads_felipe_padilha_gerenciador_catalogo.facade.AbstractFacade;
import br.upf.ads_felipe_padilha_gerenciador_catalogo.facade.PranchaFacade;
import br.upf.ads_felipe_padilha_gerenciador_catalogo.model.Prancha;
import br.upf.ads_felipe_padilha_gerenciador_catalogo.util.ArmazenamentoImagem;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.IOException;
import java.util.List;
import org.primefaces.event.FileUploadEvent;

@Named
@SessionScoped
public class PranchaController extends AbstractCrudController<Prancha> {

    @EJB
    private PranchaFacade ejbFacade;
    private Prancha prancha;

    @PostConstruct
    public void init() {
        prepareCreate();
    }

    public void prepareCreate() {
        prancha = new Prancha();
        prancha.setAtivo(true);
    }

    public void uploadNova(FileUploadEvent event) {
        gravar(event, prancha);
    }

    public void uploadEdicao(FileUploadEvent event) {
        gravar(event, getSelected());
    }

    private void gravar(FileUploadEvent event, Prancha destino) {
        if (destino == null) {
            addErrorMessage("Abra o cadastro antes de enviar a imagem.");
            return;
        }
        try {
            destino.setImagem(ArmazenamentoImagem.salvar(event.getFile()));
            addSuccessMessage("Imagem enviada.");
        } catch (IOException ex) {
            addErrorMessage("Não foi possível salvar a imagem.");
        }
    }

    public void adicionar() {
        if (persist(PersistAction.CREATE, "Prancha cadastrada.", prancha)) {
            prepareCreate();
        }
    }

    public void editar() {
        persist(PersistAction.UPDATE, "Prancha atualizada.", getSelected());
    }

    public void excluir() {
        persist(PersistAction.DELETE, "Prancha excluída.", getSelected());
    }

    public List<Prancha> getPranchaList() {
        return getItems();
    }

    public Prancha getPrancha() {
        return prancha;
    }

    public void setPrancha(Prancha prancha) {
        this.prancha = prancha;
    }

    @Override
    protected AbstractFacade<Prancha> getFacade() {
        return ejbFacade;
    }

    @Override
    protected List<Prancha> listar() {
        return ejbFacade.findAllOrderByNome();
    }
}
