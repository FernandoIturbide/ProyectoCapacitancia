import javax.swing.*;
import javax.swing.event.*;
import java.text.DecimalFormat;     
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Desarrollo extends JFrame implements ActionListener, ChangeListener{
    private JLabel label1,label3,instruccion,resultado,serie1, serie2,paralelo1, paralelo2;
    private JRadioButton radio1,radio2,radio3,radio4;
    private JButton boton1,volver,agregar,eliminar, modificar;
    private int  contador=0,contador2=0,contador3=0, tipo=0;
    private JMenuBar mb;
    private JMenu menuOpciones,menuAcercaDe,menuColorFondo;
    private JMenuItem miRojo,miNegro,miMorado,Original,miElCreador,miSalir,miNuevo;
    private JScrollPane jspan;
    private JTextArea txtArea;
    private JTextField textField,resultad,prueba;
    private Modelos modeloCombo;
    private JComboBox combo;
    double[] dispositivos = new double[contador2+1];
    double[] lista=new double[contador2+1];
    int[] valores=new int[contador2+1];
    ButtonGroup buttonGroup = new ButtonGroup();
    ButtonGroup buttonGroup2 = new ButtonGroup();
    static Metodos metodos = new Metodos();

    public Desarrollo (){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setTitle("Elección de calculo");

        mb = new JMenuBar();
        mb.setBackground(new Color(0,35,53));
        setJMenuBar(mb);

        menuOpciones = new JMenu("Opciones");
        menuOpciones.setBackground(new Color(0,0,0));
        menuOpciones.setFont(new Font("Andale Mono", 1, 14));
        menuOpciones.setForeground(new Color(255, 255, 255));
        mb.add(menuOpciones);

        menuAcercaDe = new JMenu("Acerca de");
        menuAcercaDe.setBackground(new Color(0,0,0));
        menuAcercaDe.setFont(new Font("Andale Mono", 1, 14));
        menuAcercaDe.setForeground(new Color(255, 255, 255));
        mb.add(menuAcercaDe);

        menuColorFondo = new JMenu("Color de fondo");
        menuColorFondo.setFont(new Font("Andale Mono", 1, 14));
        menuColorFondo.setForeground(new Color(0,0,0));
        menuOpciones.add(menuColorFondo);

        Original=new JMenuItem("Defecto");
        Original.setFont(new Font ("Andale Mono",1,14));
        Original.setForeground(new Color(0,0,0));
        menuColorFondo.add(Original);
        Original.addActionListener(this);

        miRojo = new JMenuItem("Rojo");
        miRojo.setFont(new Font("Andale Mono", 1, 14));
        miRojo.setForeground(new Color(0,0,0));
        menuColorFondo.add(miRojo);
        miRojo.addActionListener(this);

        miNegro = new JMenuItem("Negro");
        miNegro.setFont(new Font("Andale Mono", 1, 14));
        miNegro.setForeground(new Color(0,0,0));
        menuColorFondo.add(miNegro);
        miNegro.addActionListener(this);

        miMorado = new JMenuItem("Morado");
        miMorado.setFont(new Font("Andale Mono", 1, 14));
        miMorado.setForeground(new Color(0,0,0));
        menuColorFondo.add(miMorado);
        miMorado.addActionListener(this);

        miNuevo = new JMenuItem("Nuevo");
        miNuevo.setFont(new Font("Andale Mono", 1, 14));
        miNuevo.setForeground(new Color(0,0,0));
        menuOpciones.add(miNuevo);
        miNuevo.addActionListener(this);

        miElCreador = new JMenuItem("El creador");
        miElCreador.setFont(new Font("Andale Mono", 1, 14));
        miElCreador.setForeground(new Color(0,0,0));
        menuAcercaDe.add(miElCreador);
        miElCreador.addActionListener(this);

        miSalir = new JMenuItem("Salir");
        miSalir.setFont(new Font("Andale Mono", 1, 14));
        miSalir.setForeground(new Color(0,0,0));
        menuOpciones.add(miSalir);
        miSalir.addActionListener(this);
        

        txtArea=new JTextArea();
        txtArea.setEditable(false);
        jspan= new JScrollPane(txtArea);
        jspan.setBounds(5,160,570,50);
        jspan.setVisible(false);
        add(jspan);

        instruccion=new JLabel("Valor:");
        instruccion.setBounds(20,220,150,30);
        instruccion.setFont(new Font("Andale Mono", 1, 15));
        instruccion.setForeground(new Color(0,0,0));
        instruccion.setVisible(false);
        add(instruccion);

        label1 = new JLabel("Seleccione el calculo que desea realizar");
        label1.setBounds(90,15,420,30);
        label1.setFont(new Font("Andale Mono", 1, 21));
        label1.setForeground(new Color(0, 0, 0));
        add(label1);

        radio1 = new JRadioButton("Capacitancia equivalente");
        radio1.setBounds(30,55,220,30);
        radio1.setFont(new Font("Andale Mono", 1, 14));
        radio1.addChangeListener(this);
        add(radio1);

        radio2 = new JRadioButton("Resistencia equivalente");
        radio2.setBounds(350,55,220,30);
        radio2.setFont(new Font("Andale Mono", 1, 14));
        radio2.addChangeListener(this);
        add(radio2);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radio1);
        buttonGroup.add(radio2);
        
        label3 = new JLabel("¿En serie o en paralelo?");
        label3.setBounds(160,120,280,30);
        label3.setFont(new Font("Andale Mono", 1, 21));
        label3.setForeground(new Color(0, 0, 0));
        add(label3);

        radio3 = new JRadioButton("Serie");
        radio3.setBounds(30,160,220,30);
        radio3.setFont(new Font("Andale Mono", 1, 14));
        radio3.addChangeListener(this);
        add(radio3);

        radio4 = new JRadioButton("Paralelo");
        radio4.setBounds(350,160,220,30);
        radio4.setFont(new Font("Andale Mono", 1, 14));
        radio4.addChangeListener(this);
        add(radio4);
        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(radio3);
        buttonGroup2.add(radio4);
    
        boton1 = new JButton("Continuar");
        boton1.setBounds(10,280,100,30);
        boton1.addActionListener(this);
        add(boton1);

        String rutaImagenOriginal = "R.jpg";
        serie1=new JLabel();
        redimensionarYEstablecerImagen(serie1, rutaImagenOriginal, 400, 150);
        serie1.setBounds(100,5,400,150);
        serie1.setVisible(false);
        add(serie1);

        String rutaImagenOriginal2 = "Parall.png";
        paralelo1=new JLabel();
        redimensionarYEstablecerImagen(paralelo1, rutaImagenOriginal2, 400, 150);
        paralelo1.setBounds(100,5,400,150);
        paralelo1.setVisible(false);
        add(paralelo1);

        String rutaImagenOriginal3 = "R1.jpg";
        serie2=new JLabel();
        redimensionarYEstablecerImagen(serie2, rutaImagenOriginal3, 400, 150);
        serie2.setBounds(100,5,400,150);
        serie2.setVisible(false);
        add(serie2);

        String rutaImagenOriginal4 = "P1.png";
        paralelo2=new JLabel();
        redimensionarYEstablecerImagen(paralelo2, rutaImagenOriginal4, 400, 150);
        paralelo2.setBounds(100,5,400,150);
        paralelo2.setVisible(false);
        add(paralelo2);

        resultado=new JLabel("Equivalencia");
        resultado.setBounds(50,280,250,30);
        resultado.setFont(new Font("Andale Mono", 1, 15));
        resultado.setVisible(false);
        add(resultado);

        resultad=new JTextField();
        resultad.setEditable(false);
        resultad.setBounds(250,280,180,30);
        resultad.setFont(new Font("Andale Mono", 1, 17));
        resultad.setVisible(false);
        add(resultad);

        modeloCombo=new Modelos();
        combo=new JComboBox(modeloCombo);
        combo.setBounds(330,220,50,30);
        combo.addActionListener(this);
        combo.setVisible(false);
        add(combo);

        agregar = new JButton("Agregar");
        agregar.setBounds(387,220,85,30);
        agregar.addActionListener(this);
        agregar.setVisible(false);
        add(agregar);

        eliminar = new JButton("Eliminar");
        eliminar.setBounds(487,220,85,30);
        eliminar.addActionListener(this);
        eliminar.setVisible(false);
        add(eliminar);

        modificar = new JButton("Modificar");
        modificar.setBounds(465,280,100,30);
        modificar.addActionListener(this);
        modificar.setVisible(false);
        add(modificar);

        textField=new JTextField();
        textField.setBounds(170,220,150,30);
        textField.setVisible(false);
        add(textField);
        
        textField=new JTextField();
        textField.setBounds(170,220,150,30);
        textField.setVisible(false);
        add(textField);

        volver = new JButton("\u2770");
        volver.setBounds(5,5,40,30);
        volver.addActionListener(this);
        volver.setVisible(false);
        add(volver);
    
    }
    public void stateChanged(ChangeEvent e) {

    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == miRojo){
            getContentPane().setBackground(new Color(255,0,0));
            colorNuevo();
        }
        if (e.getSource() == miNegro){
            getContentPane().setBackground(new Color(0,0,0));
            colorNuevo();
        }
        if (e.getSource() == miMorado){
            getContentPane().setBackground(new Color(51,0,51));
            colorNuevo();
        }
        if (e.getSource() == Original){
            getContentPane().setBackground(new Color(238,238,238));
            colorOriginal();
        }
        if (e.getSource() == miElCreador){
            JOptionPane.showMessageDialog(null, "Desarrollado por Innovate Solutions Technology \n                       www.IST.com.mx");
        }

        if (e.getSource() == miSalir){
            Inicio interfaz11 = new Inicio();
            interfaz11.setBounds(0,0,640,500);
            interfaz11.setVisible(true);
            interfaz11.setResizable(false);
            interfaz11.setLocationRelativeTo(null);
            this.setVisible(false);
        }
        if (e.getSource() == miNuevo) {
            contador2 = 0;
            dispositivos = new double[contador2 + 1];
            txtArea.setText("");
            resultad.setText("");
        }

        if (e.getSource()==boton1) {
            int decision = JOptionPane.showConfirmDialog(null, "¿Desea continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);

            if (decision == JOptionPane.YES_OPTION) {
                if (radio1.isSelected()==true && radio3.isSelected()==true) {
                    instruccion.setText("Valor del Capacitor:");
                    resultado.setText("Capacitancia equivalente:");
                    eliminar();
                    contador3=1;
                    combo.setModel(modeloCombo=new Modelos(1));
                    combo.setSelectedIndex(4);
                    tipo=1;
                    serie1.setVisible(true);
                }
                else if (radio1.isSelected()==true && radio4.isSelected()==true) {
                    instruccion.setText("Valor del Capacitor:");
                    resultado.setText("Capacitancia equivalente:");
                    eliminar();
                    contador3=0;
                    combo.setModel(modeloCombo=new Modelos(1));
                    combo.setSelectedIndex(4);
                    tipo=1;
                    paralelo1.setVisible(true);
                }
                else if (radio2.isSelected()==true && radio3.isSelected()==true) {
                    instruccion.setText("Valor del Resistor:");
                    resultado.setText("Resistencia equivalente:");
                    eliminar();
                    contador3=2;
                    serie2.setVisible(true);
                    combo.setModel(modeloCombo=new Modelos(2));
                    combo.setSelectedIndex(4);
                    tipo=2;
                    boton1.setForeground(new Color(0,0,255));
                }
                else if (radio2.isSelected()==true && radio4.isSelected()==true) {
                    instruccion.setText("Valor del Resistor:");
                    resultado.setText("Resistencia equivalente:");
                    eliminar();
                    contador3=3;
                    paralelo2.setVisible(true);
                    combo.setModel(modeloCombo=new Modelos(2));
                    combo.setSelectedIndex(4);
                    tipo=2;
                    boton1.setForeground(new Color(0,0,0));
                }
                else{
                    JOptionPane.showMessageDialog(null,"Por favor, marque las opciones","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }


        if (e.getSource() == agregar) {
            try {

                double valorDipositivo = Double.parseDouble(textField.getText());
                double value=metodos.multiplicar(Double.parseDouble(textField.getText()), modeloCombo.darMultiplicador(combo.getSelectedIndex()));
                int valor=combo.getSelectedIndex();


                // Asegúrate de que haya suficiente espacio en el arreglo
                if (contador2 < dispositivos.length ) {
                    dispositivos[contador2] = valorDipositivo;
                    lista[contador2]=value;
                    valores[contador2]=valor;
                    contador2++;
                } else {
                    // Si el arreglo está lleno, redimensiona el arreglo para agregar más elementos
                    dispositivos = Arrays.copyOf(dispositivos, dispositivos.length * 2);
                    dispositivos[contador2] = valorDipositivo;
                    lista = Arrays.copyOf(lista, lista.length * 2);
                    lista[contador2]= value;
                    valores = Arrays.copyOf(valores, valores.length * 2);
                    valores[contador2] = valor;
                    contador2++;
                }

                // Imprime solo los dispositivos válidos en el JTextArea
                txtArea.setText(metodos.impresion(Arrays.copyOf(dispositivos,contador2),tipo,Arrays.copyOf(valores,contador2)));
            } catch (NumberFormatException ex) {
                String nombre=null;
                if (tipo==1){
                    nombre="capacitor";
                } else if (tipo==2) {
                    nombre="resistor";
                }
                JOptionPane.showMessageDialog(null, "Ingrese un valor válido para el "+nombre, "Error", JOptionPane.ERROR_MESSAGE);
            }
            textField.setText("");
            contador++;
            insertar();
        }

        if (e.getSource()==eliminar){
            if (contador==1) {
                txtArea.setText("");
                resultad.setText("");

                contador2 = 0;
                dispositivos = new double[contador2 + 1];
                lista = new double[contador2 + 1];
                valores=new int[contador2+1];
            }
            if (contador==0){
                JOptionPane.showMessageDialog(null, "Ya no se puede eliminar", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (contador>1) {
                if (contador2 > 0) {
                    contador2--;  // Reducir el contador para indicar que se eliminará un elemento

                    // Crear un nuevo array con un tamaño menor y copiar los valores originales
                    double[] nuevoArray = Arrays.copyOf(dispositivos, contador2);

                    // Asignar el nuevo array al array de dispositivos
                    dispositivos = nuevoArray;

                    // Actualizar la representación en el JTextArea
                    txtArea.setText(metodos.impresion(dispositivos,tipo,valores));
                    insertar();
                }
                if (contador2==0) {
                    contador2--;  // Reducir el contador para indicar que se eliminará un elemento

                    // Crear un nuevo array con un tamaño menor y copiar los valores originales
                    double[] nuevoArray = null;

                    // Asignar el nuevo array al array de dispositivos
                    dispositivos = nuevoArray;

                    txtArea.setText("");
                    resultad.setText("");
                }
                contador--;
            }
        }

        if (e.getSource()==modificar){
            modificarValor();
        }

        if (e.getSource()==volver) {
            restablecer();
            quitarSeleccion();
        }
    }
    public static void main(String[] args) {
        Desarrollo desarrollo =new Desarrollo();
        desarrollo.setBounds(0,0,600,400);
        desarrollo.setVisible(true);
        desarrollo.setResizable(false);
        desarrollo.setLocationRelativeTo(null);
    }
    public void eliminar(){
        label1.setVisible(false);
        label3.setVisible(false);
        radio1.setVisible(false);
        radio2.setVisible(false);
        radio3.setVisible(false);
        radio4.setVisible(false);
        boton1.setVisible(false);
        jspan.setVisible(true);
        combo.setVisible(true);
        agregar.setVisible(true);
        modificar.setVisible(true);
        eliminar.setVisible(true);
        textField.setVisible(true);
        instruccion.setVisible(true);
        resultado.setVisible(true);
        resultad.setVisible(true);
        volver.setVisible(true);
        contador=0;
    }
    public void restablecer(){
        label1.setVisible(true);
        label3.setVisible(true);
        radio1.setVisible(true);
        radio2.setVisible(true);
        radio3.setVisible(true);
        radio4.setVisible(true);
        boton1.setVisible(true);
        instruccion.setVisible(false);
        jspan.setVisible(false);
        agregar.setVisible(false);
        eliminar.setVisible(false);
        modificar.setVisible(false);
        combo.setVisible(false);
        textField.setVisible(false);
        resultado.setVisible(false);
        resultad.setVisible(false);
        txtArea.setText("");
        resultad.setText("");
        volver.setVisible(false);

        contador2 = 0;
        dispositivos = new double[contador2 + 1];
        lista = new double[contador2 + 1];
        valores=new int[contador2+1];

        serie1.setVisible(false);
        serie2.setVisible(false);
        paralelo1.setVisible(false);
        paralelo2.setVisible(false);
        menuOpciones.remove(miNuevo);

        contador=0;
    }

    public void insertar(){
        double[] temp = Arrays.copyOf(lista, contador2);
        DecimalFormat df = new DecimalFormat("#.##############");
        switch (contador3){
            case 0:
                resultad.setText(metodos.conversion(Double.parseDouble(df.format(metodos.capaEnParalelo(temp))),metodos.evaluar(valores))+"F");
                break;
            case 1:
                resultad.setText(metodos.conversion(Double.parseDouble(df.format(metodos.capaEnSerie(temp))),metodos.evaluar(valores))+"F");
                break;
            case 2:
                resultad.setText(metodos.conversion(Double.parseDouble(df.format(metodos.resisEnSerie(temp))),metodos.evaluar(valores))+"\u2126");
                break;
            case 3:
                resultad.setText(metodos.conversion(Double.parseDouble(df.format(metodos.resisEnParalelo(temp))),metodos.evaluar(valores))+"\u2126");
                break;
            default:
                System.out.println("No se puede realizar esa acción");
        }
    }
    public void redimensionarYEstablecerImagen(JLabel label, String rutaOriginal, int ancho, int alto) {
        try {
            // Leer la imagen original
            BufferedImage imagenOriginal = ImageIO.read(new File(rutaOriginal));

            // Redimensionar la imagen manteniendo la proporción
            Image imagenRedimensionada = imagenOriginal.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);

            // Crear un ImageIcon con la imagen redimensionada
            ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);

            // Establecer el ImageIcon en el JLabel
            label.setIcon(iconoRedimensionado);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void modificarValor() {
        if (contador2 > 0) {
            String[] opciones = new String[contador2];
            for (int i = 0; i < contador2; i++) {
                opciones[i] = String.format("C%d = %.2f %s", i + 1, dispositivos[i],modeloCombo.getElementAt(valores[i]));
            }

            JComboBox<String> comboBoxModificar = new JComboBox<>(opciones);
            JComboBox opcion=new JComboBox(modeloCombo=new Modelos(tipo));
            JTextField nuevoValorTextField = new JTextField();

            JPanel panelModificar = new JPanel();
            panelModificar.setLayout(new GridLayout(3, 2));
            panelModificar.add(new JLabel("Seleccione un valor:"));
            panelModificar.add(comboBoxModificar);
            panelModificar.add(new JLabel("Nuevo valor:"));
            panelModificar.add(nuevoValorTextField);
            panelModificar.add(opcion);
            opcion.setSelectedIndex(4);

            int resultado = JOptionPane.showConfirmDialog(
                    null,
                    panelModificar,
                    "Modificar Valor",
                    JOptionPane.OK_CANCEL_OPTION
            );

            if (resultado == JOptionPane.OK_OPTION) {
                try {

                    int indiceSeleccionado = comboBoxModificar.getSelectedIndex();
                    double nuevoValor = Double.parseDouble(nuevoValorTextField.getText());
                    double nuevo=metodos.multiplicar(Double.parseDouble(nuevoValorTextField.getText()),modeloCombo.darMultiplicador(opcion.getSelectedIndex()));
                    int newValue=opcion.getSelectedIndex();

                    if (indiceSeleccionado >= 0 && indiceSeleccionado < contador2) {
                        dispositivos[indiceSeleccionado] = nuevoValor;
                        lista[indiceSeleccionado]=nuevo;
                        valores[indiceSeleccionado]=newValue;

                        txtArea.setText(metodos.impresion(Arrays.copyOf(dispositivos,contador2),tipo,Arrays.copyOf(valores,contador2)));

                        insertar();
                    } else {
                        JOptionPane.showMessageDialog(null, "Seleccione un valor válido", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un valor válido para la modificación", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay valores para modificar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void quitarSeleccion(){
        buttonGroup2.clearSelection();
        buttonGroup.clearSelection();
    }
    public void colorNuevo(){
        label1.setForeground(new Color(0, 255, 0));
        radio1.setBackground(new Color(0, 255, 0));
        radio2.setBackground(new Color(0, 255, 0));
        radio3.setBackground(new Color(0, 255, 0));
        radio4.setBackground(new Color(0, 255, 0));
        boton1.setBackground(new Color(0, 255, 255));
        label3.setForeground(new Color(0, 255, 0));
        resultado.setForeground(new Color(0, 255, 0));
        instruccion.setForeground(new Color(0, 255, 0));
    }
    public void colorOriginal(){
        label1.setForeground(new Color(0, 0, 0));
        radio1.setBackground(new Color(238,238,238));
        radio2.setBackground(new Color(238,238,238));
        radio3.setBackground(new Color(238,238,238));
        radio4.setBackground(new Color(238,238,238));
        boton1.setBackground(new Color(238,238,238));
        label3.setForeground(new Color(0, 0, 0));
        resultado.setForeground(new Color(0, 0, 0));
        instruccion.setForeground(new Color(0, 0, 0));

    }
}
