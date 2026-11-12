package br.upf.ads_felipe_padilha_gerenciador_catalogo.facade;

import br.upf.ads_felipe_padilha_gerenciador_catalogo.model.Prancha;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PranchaFacade extends AbstractFacade<Prancha> {

    @PersistenceContext(unitName = "catalogoPU")
    private EntityManager em;

    public PranchaFacade() {
        super(Prancha.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Prancha> findAllOrderByNome() {
        return em.createQuery("SELECT p FROM Prancha p ORDER BY p.nome", Prancha.class).getResultList();
    }

    public List<Prancha> findAtivas() {
        return em.createQuery("SELECT p FROM Prancha p WHERE p.ativo = true ORDER BY p.nome", Prancha.class).getResultList();
    }
}
