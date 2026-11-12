package br.upf.ads_felipe_padilha_gerenciador_catalogo.facade;

import br.upf.ads_felipe_padilha_gerenciador_catalogo.model.Pintura;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PinturaFacade extends AbstractFacade<Pintura> {

    @PersistenceContext(unitName = "catalogoPU")
    private EntityManager em;

    public PinturaFacade() {
        super(Pintura.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Pintura> findAllOrderByNome() {
        return em.createQuery("SELECT p FROM Pintura p ORDER BY p.nome", Pintura.class).getResultList();
    }

    public List<Pintura> findAtivas() {
        return em.createQuery("SELECT p FROM Pintura p WHERE p.ativo = true ORDER BY p.nome", Pintura.class).getResultList();
    }
}
