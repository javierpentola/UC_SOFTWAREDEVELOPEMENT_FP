import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CatalogoMontañas {
    private List<Montaña> listaMontañas;

    public CatalogoMontañas() {
        this.listaMontañas = new ArrayList<>();
    }

    public void addMontaña(Montaña montaña) {
        if (montaña == null) {
            throw new IllegalArgumentException("La montaña no puede ser null.");
        }
        listaMontañas.add(montaña);
    }

    public boolean removeMontaña(Montaña montaña) {
        if (montaña == null) {
            return false;
        }
        return listaMontañas.remove(montaña);
    }

    public Montaña getMontaña(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser null o vacío.");
        }
        for (Montaña montaña : listaMontañas) {
            if (montaña.getNombre().equalsIgnoreCase(nombre.trim())) {
                return montaña;
            }
        }
        return null;
    }

    public List<Montaña> getTodasLasMontañas() {
        return Collections.unmodifiableList(listaMontañas);
    }

    public boolean estaVacio() {
        return listaMontañas.isEmpty();
    }

    public int getNumeroDeMontañas() {
        return listaMontañas.size();
    }
}
