package br.upf.ads_felipe_padilha_gerenciador_catalogo.facade;

import br.upf.ads_felipe_padilha_gerenciador_catalogo.model.Construcao;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ConstrucaoFacade extends AbstractFacade<Construcao> {

    @PersistenceContext(unitName = "catalogoPU")
    private EntityManager em;

    public ConstrucaoFacade() {
        super(Construcao.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Construcao> findAllOrderByNome() {
        return em.createQuery("SELECT c FROM Construcao c ORDER BY c.nome", Construcao.class).getResultList();
    }

    public List<Construcao> findAtivas() {
        return em.createQuery("SELECT c FROM Construcao c WHERE c.ativo = true ORDER BY c.nome", Construcao.class).getResultList();
    }
}
