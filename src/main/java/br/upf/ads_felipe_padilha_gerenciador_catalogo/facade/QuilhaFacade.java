package br.upf.ads_felipe_padilha_gerenciador_catalogo.facade;

import br.upf.ads_felipe_padilha_gerenciador_catalogo.model.Quilha;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class QuilhaFacade extends AbstractFacade<Quilha> {

    @PersistenceContext(unitName = "catalogoPU")
    private EntityManager em;

    public QuilhaFacade() {
        super(Quilha.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Quilha> findAllOrderByNome() {
        return em.createQuery("SELECT q FROM Quilha q ORDER BY q.nome", Quilha.class).getResultList();
    }

    public List<Quilha> findAtivas() {
        return em.createQuery("SELECT q FROM Quilha q WHERE q.ativo = true ORDER BY q.nome", Quilha.class).getResultList();
    }
}
