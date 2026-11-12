package br.upf.ads_felipe_padilha_gerenciador_catalogo.facade;

import br.upf.ads_felipe_padilha_gerenciador_catalogo.model.Usuario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "catalogoPU")
    private EntityManager em;

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Usuario> findAllOrderByNome() {
        return em.createQuery("SELECT u FROM Usuario u ORDER BY u.nome", Usuario.class).getResultList();
    }

    public Usuario findByEmailSenha(String email, String senha) {
        List<Usuario> lista = em.createQuery(
                        "SELECT u FROM Usuario u WHERE lower(u.email) = :email AND u.senha = :senha",
                        Usuario.class)
                .setParameter("email", email == null ? "" : email.trim().toLowerCase())
                .setParameter("senha", senha)
                .setMaxResults(1)
                .getResultList();
        return lista.isEmpty() ? null : lista.get(0);
    }
}
