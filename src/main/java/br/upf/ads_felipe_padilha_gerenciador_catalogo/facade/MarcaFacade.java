package br.upf.ads_felipe_padilha_gerenciador_catalogo.facade;

import br.upf.ads_felipe_padilha_gerenciador_catalogo.model.Marca;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class MarcaFacade extends AbstractFacade<Marca> {

    @PersistenceContext(unitName = "catalogoPU")
    private EntityManager em;

    public MarcaFacade() {
        super(Marca.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Marca> findAllOrderByNome() {
        return em.createQuery("SELECT m FROM Marca m ORDER BY m.nome", Marca.class).getResultList();
    }

    public List<Marca> findAtivas() {
        return em.createQuery("SELECT m FROM Marca m WHERE m.ativo = true ORDER BY m.nome", Marca.class).getResultList();
    }
}
