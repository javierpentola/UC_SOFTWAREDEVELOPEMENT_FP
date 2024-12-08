public abstract class Expedicionario {
    private int ID;
    private String nombre;
    private String apellidos;
    private int edad;

    public Expedicionario(int ID, String nombre, String apellidos, int edad) {
        this.ID = ID;
        this.nombre = nombre.trim();
        this.apellidos = apellidos.trim();
        this.edad = edad;
    }

    // Getters y Setters

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.trim();
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos.trim();
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad <= 0) {
            throw new IllegalArgumentException("La edad debe ser un valor positivo.");
        }
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "ID: " + ID + ", Nombre: " + nombre + " " + apellidos + ", Edad: " + edad;
    }
}
