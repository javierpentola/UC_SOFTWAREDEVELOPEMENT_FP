public class ExpedienteAlpinistas {
    private int ID;
    private String nombre;
    private String apellidos;

    public ExpedienteAlpinistas(int ID, String nombre, String apellidos) {
        this.ID = ID;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public void setCimaAlcanzada(Montaña montaña) {
        // Lógica para marcar que se alcanzó una cima
    }
}