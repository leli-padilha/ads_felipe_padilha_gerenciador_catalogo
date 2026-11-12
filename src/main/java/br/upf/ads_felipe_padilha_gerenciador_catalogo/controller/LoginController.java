package br.upf.ads_felipe_padilha_gerenciador_catalogo.controller;

import br.upf.ads_felipe_padilha_gerenciador_catalogo.enumeration.Perfil;
import br.upf.ads_felipe_padilha_gerenciador_catalogo.facade.UsuarioFacade;
import br.upf.ads_felipe_padilha_gerenciador_catalogo.model.Usuario;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class LoginController implements Serializable {

    @EJB
    private UsuarioFacade usuarioFacade;
    private Usuario usuario = new Usuario();
    private Usuario usuarioLogado;

    public String validarLogin() {
        Usuario encontrado = usuarioFacade.findByEmailSenha(usuario.getEmail(), usuario.getSenha());
        if (encontrado == null || !Boolean.TRUE.equals(encontrado.getAtivo())) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Acesso negado", "E-mail ou senha inválidos."));
            return null;
        }
        usuarioLogado = encontrado;
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioLogado", encontrado);
        usuario = new Usuario();
        return "/admin/painel.xhtml?faces-redirect=true";
    }

    public String logout() {
        usuarioLogado = null;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/login.xhtml?faces-redirect=true";
    }

    public boolean isLogado() {
        return usuarioLogado != null;
    }

    public boolean isAdmin() {
        return usuarioLogado != null && usuarioLogado.getPerfil() == Perfil.ADMIN;
    }

    public Usuario getUsuario() {
        if (usuario == null) {
            usuario = new Usuario();
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }
}
