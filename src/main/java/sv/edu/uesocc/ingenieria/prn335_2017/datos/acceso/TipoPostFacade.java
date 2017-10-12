package sv.edu.uesocc.ingenieria.prn335_2017.datos.acceso;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.definiciones.TipoPost;

@Stateless
public class TipoPostFacade extends AbstractFacade<TipoPost> implements TipoPostFacadeLocal {

    @PersistenceContext(unitName = "guia5")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoPostFacade() {
        super(TipoPost.class);
    }

    @Override
    public List<TipoPost> obtenerUtilizados() {
        TypedQuery<TipoPost> query = em.createNamedQuery("TipoPost.findUsados", TipoPost.class);
        return query.getResultList();
    }
    
}
