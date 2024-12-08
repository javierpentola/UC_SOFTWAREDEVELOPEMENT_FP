public class Montaña {
    private String nombre;
    private int altura; // en metros
    private String pais;
    private String coordenadas;

    public Montaña(String nombre, int altura, String pais, String coordenadas) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la montaña no puede ser null o vacío.");
        }
        if (altura <= 0) {
            throw new IllegalArgumentException("La altura debe ser un valor positivo.");
        }
        this.nombre = nombre.trim();
        this.altura = altura;
        this.pais = pais.trim();
        this.coordenadas = coordenadas.trim();
    }

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la montaña no puede ser null o vacío.");
        }
        this.nombre = nombre.trim();
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        if (altura <= 0) {
            throw new IllegalArgumentException("La altura debe ser un valor positivo.");
        }
        this.altura = altura;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais.trim();
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas.trim();
    }

    @Override
    public String toString() {
        return nombre + " (" + altura + " m) - " + pais + " - " + coordenadas;
    }
}
