public class Medico extends Expedicionario {
    public Medico(int ID, String nombre, String apellidos, int edad) {
        super(ID, nombre, apellidos, edad);
    }

    @Override
    public String toString() {
        return "Médico - " + super.toString();
    }
}
