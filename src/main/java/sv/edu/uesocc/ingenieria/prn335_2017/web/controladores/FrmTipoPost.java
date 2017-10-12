package sv.edu.uesocc.ingenieria.prn335_2017.web.controladores;
//john//
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.acceso.TipoPostFacadeLocal;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.definiciones.TipoPost;

@Named(value = "frmTipoPost")
@RequestScoped
public class FrmTipoPost {

    private TipoPost nuevoTipoPost;
    private boolean soloUsados;

    @EJB
    private TipoPostFacadeLocal facadeLocal;

    public FrmTipoPost() {
    }

    @PostConstruct
    private void init() {
        nuevoTipoPost = new TipoPost();
    }

    public List<TipoPost> getTipoPost() {
        if (soloUsados) {
            return facadeLocal.obtenerUtilizados();
        } else {
            return facadeLocal.findAll();
        }
    }

    public TipoPost getNuevoTipoPost() {
        return nuevoTipoPost;
    }

    public void setNuevoTipoPost(TipoPost nuevoTipoPost) {
        this.nuevoTipoPost = nuevoTipoPost;
    }

    public boolean isSoloUsados() {
        return soloUsados;
    }

    public void setSoloUsados(boolean soloUsados) {
        this.soloUsados = soloUsados;
    }

    public void limpiar() {
        nuevoTipoPost = new TipoPost();
    }

    public void guardar() {
        // Validacion
        boolean valido = true;
        if (nuevoTipoPost.getNombre().trim().isEmpty()) {
            valido = false;
        }
        if (nuevoTipoPost.getDescripcion().trim().isEmpty()) {
            valido = false;
        }

        // Si es valido
        if (valido) {
            facadeLocal.create(nuevoTipoPost);
            limpiar();
        }
    }

}
