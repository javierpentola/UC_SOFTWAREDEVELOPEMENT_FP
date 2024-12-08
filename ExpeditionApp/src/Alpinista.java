public class Alpinista extends Expedicionario {
    public Alpinista(int ID, String nombre, String apellidos, int edad) {
        super(ID, nombre, apellidos, edad);
    }

    @Override
    public String toString() {
        return "Alpinista - " + super.toString();
    }
}
