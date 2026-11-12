package br.upf.ads_felipe_padilha_gerenciador_catalogo.filter;

import br.upf.ads_felipe_padilha_gerenciador_catalogo.enumeration.Perfil;
import br.upf.ads_felipe_padilha_gerenciador_catalogo.model.Usuario;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class FiltroAdministrativo implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        Object valor = session == null ? null : session.getAttribute("usuarioLogado");
        if (!(valor instanceof Usuario usuario)) {
            resp.sendRedirect(req.getContextPath() + "/login.xhtml");
            return;
        }
        String uri = req.getRequestURI();
        if (uri.contains("/admin/usuario") && usuario.getPerfil() != Perfil.ADMIN) {
            resp.sendRedirect(req.getContextPath() + "/admin/painel.xhtml");
            return;
        }
        chain.doFilter(request, response);
    }
}
