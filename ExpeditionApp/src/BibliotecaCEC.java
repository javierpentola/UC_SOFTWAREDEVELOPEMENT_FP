import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BibliotecaCEC {
    private List<Montaña> listaMontañas;
    private List<Expedicionario> listaExpedicionarios;
    private List<Expedicion> listaExpediciones;

    public BibliotecaCEC() {
        this.listaMontañas = new ArrayList<>();
        this.listaExpedicionarios = new ArrayList<>();
        this.listaExpediciones = new ArrayList<>();
    }

    // Métodos para Montañas
    public void añadirMontaña(Montaña montaña) {
        if (montaña == null) {
            throw new IllegalArgumentException("La montaña no puede ser null.");
        }
        this.listaMontañas.add(montaña);
    }

    public List<Montaña> getListaMontañas() {
        return Collections.unmodifiableList(listaMontañas);
    }

    // Métodos para Expedicionarios
    public void añadirExpedicionario(Expedicionario expedicionario) {
        if (expedicionario == null) {
            throw new IllegalArgumentException("El expedicionario no puede ser null.");
        }
        this.listaExpedicionarios.add(expedicionario);
    }

    public List<Expedicionario> getListaExpedicionarios() {
        return Collections.unmodifiableList(listaExpedicionarios);
    }

    // Métodos para Expediciones
    public void añadirExpedicion(Expedicion expedicion) {
        if (expedicion == null) {
            throw new IllegalArgumentException("La expedición no puede ser null.");
        }
        this.listaExpediciones.add(expedicion);
    }

    public List<Expedicion> getListaExpediciones() {
        return Collections.unmodifiableList(listaExpediciones);
    }

    // Métodos de Consulta
    public CatalogoMontañas consultarMontaña() {
        CatalogoMontañas catalogo = new CatalogoMontañas();
        for (Montaña m : listaMontañas) {
            catalogo.addMontaña(m);
        }
        return catalogo;
    }

    public List<Expedicion> consultarExpediciones() {
        return getListaExpediciones();
    }
}
