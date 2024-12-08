import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Expedicion {
    private int ID;
    private String nombreExpedicion;
    private LocalDate fecha;
    private List<Expedicionario> listaExpedicionarios;
    private Montaña montaña;

    public Expedicion(int ID, String nombreExpedicion, LocalDate fecha, Montaña montaña) {
        if (nombreExpedicion == null || nombreExpedicion.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la expedición no puede ser null o vacío.");
        }
        if (fecha == null) {
            throw new IllegalArgumentException("La fecha no puede ser null.");
        }
        if (montaña == null) {
            throw new IllegalArgumentException("La montaña no puede ser null.");
        }

        this.ID = ID;
        this.nombreExpedicion = nombreExpedicion.trim();
        this.fecha = fecha;
        this.montaña = montaña;
        this.listaExpedicionarios = new ArrayList<>();
    }

    // Getters y Setters

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombreExpedicion() {
        return nombreExpedicion;
    }

    public void setNombreExpedicion(String nombreExpedicion) {
        if (nombreExpedicion == null || nombreExpedicion.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la expedición no puede ser null o vacío.");
        }
        this.nombreExpedicion = nombreExpedicion.trim();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        if (fecha == null) {
            throw new IllegalArgumentException("La fecha no puede ser null.");
        }
        this.fecha = fecha;
    }

    public Montaña getMontaña() {
        return montaña;
    }

    public void setMontaña(Montaña montaña) {
        if (montaña == null) {
            throw new IllegalArgumentException("La montaña no puede ser null.");
        }
        this.montaña = montaña;
    }

    public List<Expedicionario> getExpedicionarios() {
        return Collections.unmodifiableList(listaExpedicionarios);
    }

    public void setExpedicionarios(List<Expedicionario> expedicionarios) {
        if (expedicionarios == null) {
            throw new IllegalArgumentException("La lista de expedicionarios no puede ser null.");
        }
        for (Expedicionario e : expedicionarios) {
            if (e == null) {
                throw new IllegalArgumentException("La lista de expedicionarios no puede contener elementos null.");
            }
        }
        this.listaExpedicionarios = new ArrayList<>(expedicionarios);
    }

    public void addExpedicionario(Expedicionario expedicionario) {
        if (expedicionario == null) {
            throw new IllegalArgumentException("El expedicionario no puede ser null.");
        }
        this.listaExpedicionarios.add(expedicionario);
    }

    public boolean removeExpedicionario(Expedicionario expedicionario) {
        if (expedicionario == null) {
            return false;
        }
        return this.listaExpedicionarios.remove(expedicionario);
    }

    public int getNumeroDeExpedicionarios() {
        return this.listaExpedicionarios.size();
    }

    @Override
    public String toString() {
        return "Expedicion{" +
                "ID=" + ID +
                ", nombreExpedicion='" + nombreExpedicion + '\'' +
                ", fecha=" + fecha +
                ", montaña=" + montaña +
                ", listaExpedicionarios=" + listaExpedicionarios +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Expedicion that = (Expedicion) o;

        if (ID != that.ID)
            return false;
        if (!nombreExpedicion.equals(that.nombreExpedicion))
            return false;
        if (!fecha.equals(that.fecha))
            return false;
        if (!montaña.equals(that.montaña))
            return false;
        return listaExpedicionarios.equals(that.listaExpedicionarios);
    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + nombreExpedicion.hashCode();
        result = 31 * result + fecha.hashCode();
        result = 31 * result + listaExpedicionarios.hashCode();
        result = 31 * result + montaña.hashCode();
        return result;
    }
}
