import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Nombre : Lorenzo Cumbal
// Fecha de compilación: 16/05/2025

// Clase principal que contiene el metodo main y la interfaz gráfica
public class FactorialApp extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L; // Agregado para evitar la advertencia de serialización
    private JTextField inputField;
    private JLabel resultLabel;
    private JButton calculateButton;
    private JPanel panel;

    // Constructor de la clase FactorialApp
    public FactorialApp() {
        // Configuracion de la ventana principal
        setTitle("Calculadora de Factorial");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150); // Tamaño de la ventana
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Creacion del panel principal
        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1)); // 3 filas, 1 columna

        // Creacion de la etiqueta y el campo de texto para la entrada del número
        JLabel inputLabel = new JLabel("Ingrese un número entero:");
        inputField = new JTextField(10); // 10 columnas de ancho

        // Creacion del botón para calcular el factorial
        calculateButton = new JButton("Calcular Factorial");
        calculateButton.addActionListener(this); // Asignar el ActionListener al botón

        // Creacion de la etiqueta para mostrar el resultado
        resultLabel = new JLabel("Resultado:");
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER); // Centrar el texto

        // Agregar los componentes al panel
        panel.add(inputLabel);
        panel.add(inputField);
        panel.add(calculateButton);
        panel.add(resultLabel); //Se agrega el label del resultado.

        // Agregar el panel a la ventana
        add(panel);

        setVisible(true); // Mostrar la ventana
    }

    // Metodo principal que inicia la aplicacion
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FactorialApp()); // Usar invokeLater para seguridad de hilos en Swing
    }

    // Metodo actionPerformed para manejar el evento del boton
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) { // Verificar si el evento proviene del botón calculateButton
            try {
                int number = Integer.parseInt(inputField.getText()); // Obtener el número del campo de texto
                if (number < 0) {
                    resultLabel.setText("El número debe ser no negativo.");
                } else {
                    FactorialCalculator calculator = new FactorialCalculator(); // Crear un objeto de la clase FactorialCalculator
                    long factorial = calculator.calculateFactorial(number); // Calcular el factorial
                    resultLabel.setText("El factorial de " + number + " es " + factorial + "."); // Mostrar el resultado
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Ingrese un entero válido."); // Manejar la excepcion si la entrada no es un numero entero
            }
        }
    }
}

// Clase secundaria que contiene el metodo para calcular el factorial
class FactorialCalculator {
    /**
     * Calcula el factorial de un número entero no negativo.
     *
     * @param n El número entero del cual se calculara el factorial.
     * @return El factorial de n.
     * @throws IllegalArgumentException Si n es negativo.
     */
    public long calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos.");
        }
        long factorial = 1;
        // Bucle for para calcular el factorial
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}

