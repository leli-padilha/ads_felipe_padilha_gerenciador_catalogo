package br.upf.ads_felipe_padilha_gerenciador_catalogo.controller;

import br.upf.ads_felipe_padilha_gerenciador_catalogo.enumeration.Perfil;
import br.upf.ads_felipe_padilha_gerenciador_catalogo.facade.AbstractFacade;
import br.upf.ads_felipe_padilha_gerenciador_catalogo.facade.UsuarioFacade;
import br.upf.ads_felipe_padilha_gerenciador_catalogo.model.Usuario;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.util.List;

@Named
@SessionScoped
public class UsuarioController extends AbstractCrudController<Usuario> {

    @EJB
    private UsuarioFacade ejbFacade;
    private Usuario usuario;

    @PostConstruct
    public void init() {
        prepareCreate();
    }

    public void prepareCreate() {
        usuario = new Usuario();
        usuario.setAtivo(true);
        usuario.setPerfil(Perfil.EDITOR);
    }

    public void adicionar() {
        if (persist(PersistAction.CREATE, "Usuário cadastrado.", usuario)) {
            prepareCreate();
        }
    }

    public void editar() {
        if (getSelected() != null && (getSelected().getSenha() == null || getSelected().getSenha().isBlank())) {
            Usuario atual = ejbFacade.find(getSelected().getId());
            getSelected().setSenha(atual.getSenha());
        }
        persist(PersistAction.UPDATE, "Usuário atualizado.", getSelected());
    }

    public void excluir() {
        persist(PersistAction.DELETE, "Usuário excluído.", getSelected());
    }

    public List<Usuario> getUsuarioList() {
        return getItems();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    protected AbstractFacade<Usuario> getFacade() {
        return ejbFacade;
    }

    @Override
    protected List<Usuario> listar() {
        return ejbFacade.findAllOrderByNome();
    }
}
