import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;

public class Main {
    private BibliotecaCEC biblioteca;

    // Componentes de la GUI
    private JFrame frame;
    private JTabbedPane tabbedPane;

    // Componentes para Montañas
    private JTextField txtNombreMontaña;
    private JTextField txtAlturaMontaña;
    private JTextField txtPaisMontaña;
    private JTextField txtCoordenadasMontaña;
    private DefaultTableModel modeloTablaMontañas;
    private JTable tablaMontañas;

    // Componentes para Expedicionarios
    private JComboBox<String> cmbTipoExpedicionario;
    private JTextField txtIDExpedicionario;
    private JTextField txtNombreExpedicionario;
    private JTextField txtApellidosExpedicionario;
    private JTextField txtEdadExpedicionario;
    private DefaultTableModel modeloTablaExpedicionarios;
    private JTable tablaExpedicionarios;

    // Componentes para Expediciones
    private JTextField txtIDExpedicion;
    private JTextField txtNombreExpedicion;
    private JTextField txtFechaExpedicion;
    private JComboBox<String> cmbMontañaExpedicion;
    private DefaultTableModel modeloTablaExpediciones;
    private JTable tablaExpediciones;
    private JComboBox<String> cmbExpedicionariosExpedicion;

    public Main() {
        biblioteca = new BibliotecaCEC();
        initialize();
    }

    private void initialize() {
        // Configuración del JFrame
        frame = new JFrame("Gestión de Expediciones - BibliotecaCEC");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null); // Centrar la ventana

        // Crear el JTabbedPane
        tabbedPane = new JTabbedPane();

        // Añadir pestañas
        tabbedPane.addTab("Montañas", crearPanelMontañas());
        tabbedPane.addTab("Expedicionarios", crearPanelExpedicionarios());
        tabbedPane.addTab("Expediciones", crearPanelExpediciones());

        // Añadir el tabbedPane al frame
        frame.getContentPane().add(tabbedPane);

        frame.setVisible(true);
    }

    private JPanel crearPanelMontañas() {
        JPanel panel = new JPanel(new BorderLayout());

        // Formulario para añadir montañas
        JPanel formulario = new JPanel(new GridLayout(5, 2, 10, 10));
        formulario.setBorder(BorderFactory.createTitledBorder("Añadir Montaña"));

        formulario.add(new JLabel("Nombre:"));
        txtNombreMontaña = new JTextField();
        formulario.add(txtNombreMontaña);

        formulario.add(new JLabel("Altura (m):"));
        txtAlturaMontaña = new JTextField();
        formulario.add(txtAlturaMontaña);

        formulario.add(new JLabel("País:"));
        txtPaisMontaña = new JTextField();
        formulario.add(txtPaisMontaña);

        formulario.add(new JLabel("Coordenadas:"));
        txtCoordenadasMontaña = new JTextField();
        formulario.add(txtCoordenadasMontaña);

        JButton btnAñadirMontaña = new JButton("Añadir Montaña");
        btnAñadirMontaña.addActionListener(e -> añadirMontaña());
        formulario.add(btnAñadirMontaña);

        // Tabla para mostrar montañas
        modeloTablaMontañas = new DefaultTableModel(new Object[] { "Nombre", "Altura (m)", "País", "Coordenadas" }, 0);
        tablaMontañas = new JTable(modeloTablaMontañas);
        JScrollPane scrollMontañas = new JScrollPane(tablaMontañas);

        // Añadir componentes al panel
        panel.add(formulario, BorderLayout.NORTH);
        panel.add(scrollMontañas, BorderLayout.CENTER);

        return panel;
    }

    private JPanel crearPanelExpedicionarios() {
        JPanel panel = new JPanel(new BorderLayout());

        // Formulario para añadir expedicionarios
        JPanel formulario = new JPanel(new GridLayout(6, 2, 10, 10));
        formulario.setBorder(BorderFactory.createTitledBorder("Añadir Expedicionario"));

        formulario.add(new JLabel("Tipo:"));
        cmbTipoExpedicionario = new JComboBox<>(new String[] { "Alpinista", "Médico" });
        formulario.add(cmbTipoExpedicionario);

        formulario.add(new JLabel("ID:"));
        txtIDExpedicionario = new JTextField();
        formulario.add(txtIDExpedicionario);

        formulario.add(new JLabel("Nombre:"));
        txtNombreExpedicionario = new JTextField();
        formulario.add(txtNombreExpedicionario);

        formulario.add(new JLabel("Apellidos:"));
        txtApellidosExpedicionario = new JTextField();
        formulario.add(txtApellidosExpedicionario);

        formulario.add(new JLabel("Edad:"));
        txtEdadExpedicionario = new JTextField();
        formulario.add(txtEdadExpedicionario);

        JButton btnAñadirExpedicionario = new JButton("Añadir Expedicionario");
        btnAñadirExpedicionario.addActionListener(e -> añadirExpedicionario());
        formulario.add(btnAñadirExpedicionario);

        // Tabla para mostrar expedicionarios
        modeloTablaExpedicionarios = new DefaultTableModel(new Object[] { "ID", "Tipo", "Nombre", "Apellidos", "Edad" },
                0);
        tablaExpedicionarios = new JTable(modeloTablaExpedicionarios);
        JScrollPane scrollExpedicionarios = new JScrollPane(tablaExpedicionarios);

        // Añadir componentes al panel
        panel.add(formulario, BorderLayout.NORTH);
        panel.add(scrollExpedicionarios, BorderLayout.CENTER);

        return panel;
    }

    private JPanel crearPanelExpediciones() {
        JPanel panel = new JPanel(new BorderLayout());

        // Formulario para añadir expediciones
        JPanel formulario = new JPanel(new GridLayout(6, 2, 10, 10));
        formulario.setBorder(BorderFactory.createTitledBorder("Añadir Expedición"));

        formulario.add(new JLabel("ID:"));
        txtIDExpedicion = new JTextField();
        formulario.add(txtIDExpedicion);

        formulario.add(new JLabel("Nombre de Expedición:"));
        txtNombreExpedicion = new JTextField();
        formulario.add(txtNombreExpedicion);

        formulario.add(new JLabel("Fecha (YYYY-MM-DD):"));
        txtFechaExpedicion = new JTextField();
        formulario.add(txtFechaExpedicion);

        formulario.add(new JLabel("Montaña:"));
        cmbMontañaExpedicion = new JComboBox<>();
        actualizarComboMontañas();
        formulario.add(cmbMontañaExpedicion);

        formulario.add(new JLabel("Expedicionarios (ID separados por comas):"));
        cmbExpedicionariosExpedicion = new JComboBox<>();
        actualizarComboExpedicionarios();
        formulario.add(cmbExpedicionariosExpedicion);

        JButton btnAñadirExpedicion = new JButton("Añadir Expedición");
        btnAñadirExpedicion.addActionListener(e -> añadirExpedicion());
        formulario.add(btnAñadirExpedicion);

        // Tabla para mostrar expediciones
        modeloTablaExpediciones = new DefaultTableModel(
                new Object[] { "ID", "Nombre", "Fecha", "Montaña", "Expedicionarios" }, 0);
        tablaExpediciones = new JTable(modeloTablaExpediciones);
        JScrollPane scrollExpediciones = new JScrollPane(tablaExpediciones);

        // Añadir componentes al panel
        panel.add(formulario, BorderLayout.NORTH);
        panel.add(scrollExpediciones, BorderLayout.CENTER);

        return panel;
    }

    // Métodos para añadir elementos

    private void añadirMontaña() {
        String nombre = txtNombreMontaña.getText().trim();
        String alturaStr = txtAlturaMontaña.getText().trim();
        String pais = txtPaisMontaña.getText().trim();
        String coordenadas = txtCoordenadasMontaña.getText().trim();

        if (nombre.isEmpty() || alturaStr.isEmpty() || pais.isEmpty() || coordenadas.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Por favor, completa todos los campos.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        int altura;
        try {
            altura = Integer.parseInt(alturaStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "La altura debe ser un número entero.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Montaña montaña = new Montaña(nombre, altura, pais, coordenadas);
            biblioteca.añadirMontaña(montaña);
            modeloTablaMontañas.addRow(new Object[] { montaña.getNombre(), montaña.getAltura(), montaña.getPais(),
                    montaña.getCoordenadas() });
            actualizarComboMontañas();
            JOptionPane.showMessageDialog(frame, "Montaña añadida exitosamente.", "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
            limpiarCamposMontaña();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCamposMontaña() {
        txtNombreMontaña.setText("");
        txtAlturaMontaña.setText("");
        txtPaisMontaña.setText("");
        txtCoordenadasMontaña.setText("");
    }

    private void añadirExpedicionario() {
        String tipo = (String) cmbTipoExpedicionario.getSelectedItem();
        String idStr = txtIDExpedicionario.getText().trim();
        String nombre = txtNombreExpedicionario.getText().trim();
        String apellidos = txtApellidosExpedicionario.getText().trim();
        String edadStr = txtEdadExpedicionario.getText().trim();

        if (idStr.isEmpty() || nombre.isEmpty() || apellidos.isEmpty() || edadStr.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Por favor, completa todos los campos.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        int id, edad;
        try {
            id = Integer.parseInt(idStr);
            edad = Integer.parseInt(edadStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "El ID y la edad deben ser números enteros.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Expedicionario expedicionario;
            if (tipo.equals("Alpinista")) {
                expedicionario = new Alpinista(id, nombre, apellidos, edad);
            } else {
                expedicionario = new Medico(id, nombre, apellidos, edad);
            }
            biblioteca.añadirExpedicionario(expedicionario);
            modeloTablaExpedicionarios.addRow(new Object[] { expedicionario.getID(), tipo, expedicionario.getNombre(),
                    expedicionario.getApellidos(), expedicionario.getEdad() });
            actualizarComboExpedicionarios();
            JOptionPane.showMessageDialog(frame, "Expedicionario añadido exitosamente.", "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
            limpiarCamposExpedicionario();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCamposExpedicionario() {
        txtIDExpedicionario.setText("");
        txtNombreExpedicionario.setText("");
        txtApellidosExpedicionario.setText("");
        txtEdadExpedicionario.setText("");
    }

    private void añadirExpedicion() {
        String idStr = txtIDExpedicion.getText().trim();
        String nombre = txtNombreExpedicion.getText().trim();
        String fechaStr = txtFechaExpedicion.getText().trim();
        String montañaSeleccionada = (String) cmbMontañaExpedicion.getSelectedItem();
        String expedicionariosSeleccionados = (String) cmbExpedicionariosExpedicion.getSelectedItem();

        if (idStr.isEmpty() || nombre.isEmpty() || fechaStr.isEmpty() || montañaSeleccionada == null
                || expedicionariosSeleccionados == null) {
            JOptionPane.showMessageDialog(frame, "Por favor, completa todos los campos.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        int id;
        LocalDate fecha;
        try {
            id = Integer.parseInt(idStr);
            fecha = LocalDate.parse(fechaStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "El ID debe ser un número entero.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        } catch (java.time.format.DateTimeParseException e) {
            JOptionPane.showMessageDialog(frame, "La fecha debe tener el formato YYYY-MM-DD.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        Montaña montaña = biblioteca.consultarMontaña().getMontaña(montañaSeleccionada);
        if (montaña == null) {
            JOptionPane.showMessageDialog(frame, "La montaña seleccionada no existe.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        Expedicion expedicion = new Expedicion(id, nombre, fecha, montaña);

        // Obtener los expedicionarios seleccionados
        String[] idsExpedicionarios = expedicionariosSeleccionados.split(",");
        for (String idExp : idsExpedicionarios) {
            try {
                int idExpedicionario = Integer.parseInt(idExp.trim());
                Expedicionario expedicionario = buscarExpedicionarioPorID(idExpedicionario);
                if (expedicionario != null) {
                    expedicion.addExpedicionario(expedicionario);
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "Expedicionario con ID " + idExpedicionario + " no encontrado.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "El ID de expedicionario debe ser un número entero.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        try {
            biblioteca.añadirExpedicion(expedicion);
            String expedicionariosStr = expedicionariosSeleccionados;
            modeloTablaExpediciones.addRow(new Object[] { expedicion.getID(), expedicion.getNombreExpedicion(),
                    expedicion.getFecha(), montaña.getNombre(), expedicionariosStr });
            JOptionPane.showMessageDialog(frame, "Expedición añadida exitosamente.", "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
            limpiarCamposExpedicion();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Expedicionario buscarExpedicionarioPorID(int id) {
        for (Expedicionario e : biblioteca.getListaExpedicionarios()) {
            if (e.getID() == id) {
                return e;
            }
        }
        return null;
    }

    private void limpiarCamposExpedicion() {
        txtIDExpedicion.setText("");
        txtNombreExpedicion.setText("");
        txtFechaExpedicion.setText("");
        cmbMontañaExpedicion.setSelectedIndex(0);
        cmbExpedicionariosExpedicion.setSelectedIndex(0);
    }

    // Métodos para actualizar los combos
    private void actualizarComboMontañas() {
        cmbMontañaExpedicion.removeAllItems();
        for (Montaña m : biblioteca.getListaMontañas()) {
            cmbMontañaExpedicion.addItem(m.getNombre());
        }
    }

    private void actualizarComboExpedicionarios() {
        cmbExpedicionariosExpedicion.removeAllItems();
        StringBuilder sb = new StringBuilder();
        for (Expedicionario e : biblioteca.getListaExpedicionarios()) {
            sb.append(e.getID()).append(",");
        }
        if (sb.length() > 0) {
            // Eliminar la última coma
            sb.deleteCharAt(sb.length() - 1);
            cmbExpedicionariosExpedicion.addItem(sb.toString());
        }
    }

    public static void main(String[] args) {
        // Ejecutar la GUI en el hilo de eventos de Swing
        SwingUtilities.invokeLater(Main::new);
    }
}
