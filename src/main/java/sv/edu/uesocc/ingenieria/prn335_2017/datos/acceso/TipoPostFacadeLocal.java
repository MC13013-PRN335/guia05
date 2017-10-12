package sv.edu.uesocc.ingenieria.prn335_2017.datos.acceso;

import java.util.List;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.definiciones.TipoPost;

@Local
public interface TipoPostFacadeLocal {

    void create(TipoPost tipoPost);

    void edit(TipoPost tipoPost);

    void remove(TipoPost tipoPost);

    TipoPost find(Object id);

    List<TipoPost> findAll();

    List<TipoPost> findRange(int[] range);

    int count();
    
    List<TipoPost> obtenerUtilizados();
}
