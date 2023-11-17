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
    private JLabel label1,label3,instruccion,resultado,serie,paralelo;
    private JRadioButton radio1,radio2,radio3,radio4;
    private JButton boton1,volver,boton2,agregar;
    private int  contador=0,contador2=0,contador3=0;
    private JMenuBar mb;
    private JMenu menuOpciones,menuAcercaDe,menuColorFondo;
    private JMenuItem miRojo,miNegro,miMorado,Original,miElCreador,miSalir,miNuevo;
    private JScrollPane jspan;
    private JTextArea txtArea;
    private JTextField textField,resultad;
    double[] capacitores = new double[contador2+1];
    static Metodos metodos = new Metodos();
    public Desarrollo (){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setTitle("Elección de calculo");
        setIconImage(new ImageIcon(getClass().getResource("images/ivono.png")).getImage());

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
        jspan.setBounds(5,5,570,150);
        jspan.setVisible(false);
        add(jspan);

        instruccion=new JLabel("Valor Capacitor:");
        instruccion.setBounds(20,220,150,30);
        instruccion.setFont(new Font("Andale Mono", 1, 17));
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

        boton2 = new JButton("Continuar");
        boton2.setBounds(10,280,100,30);
        boton2.addActionListener(this);
        boton2.setVisible(false);
        add(boton2);

        String rutaImagenOriginal = "images/R.jpg";
        serie=new JLabel();
        redimensionarYEstablecerImagen(serie, rutaImagenOriginal, 400, 150);
        serie.setBounds(100,5,400,150);
        serie.setVisible(false);
        add(serie);

        String rutaImagenOriginal2 = "images/Parall.png";
        paralelo=new JLabel();
        redimensionarYEstablecerImagen(paralelo, rutaImagenOriginal2, 400, 150);
        paralelo.setBounds(100,5,400,150);
        paralelo.setVisible(false);
        add(paralelo);

        resultado = new JLabel("Capacitancia equivalente: ");
        resultado.setBounds(80,280,250,30);
        resultado.setFont(new Font("Andale Mono", 1, 17));
        resultado.setVisible(false);
        add(resultado);

        resultad=new JTextField();
        resultad.setEditable(false);
        resultad.setBounds(290,280,130,30);
        resultad.setFont(new Font("Andale Mono", 1, 17));
        resultad.setVisible(false);
        add(resultad);

        agregar = new JButton("Agregar");
        agregar.setBounds(330,220,100,30);
        agregar.addActionListener(this);
        agregar.setVisible(false);
        add(agregar);
        
        textField=new JTextField();
        textField.setBounds(170,220,150,30);
        textField.setVisible(false);
        add(textField);

        volver = new JButton("Volver");
        volver.setBounds(450,280,100,30);
        volver.addActionListener(this);
        add(volver);
    
    }
    public void stateChanged(ChangeEvent e) {
        
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == miRojo){
            getContentPane().setBackground(new Color(255,0,0));
        }
        if (e.getSource() == miNegro){
            getContentPane().setBackground(new Color(0,0,0));
        }
    	if (e.getSource() == miMorado){
            getContentPane().setBackground(new Color(51,0,51));
        }
        if (e.getSource() == Original){
            getContentPane().setBackground(new Color(238,238,238));
        }
        if (e.getSource() == miElCreador){
            JOptionPane.showMessageDialog(null, "Desarrollado por WAPYJ \n        www.wapyj.com");
        }

        if (e.getSource()==boton1) {
            int decision = JOptionPane.showConfirmDialog(null, "¿Desea continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);

            if (decision == JOptionPane.YES_OPTION) {
                if (radio1.isSelected()==true && radio3.isSelected()==true) {
                    
                    eliminar();
                    contador3=1;
                    
                }
                else if (radio1.isSelected()==true && radio4.isSelected()==true) {
                    eliminar();
                    contador3=0;
                    paralelo.setVisible(true);
                }
                else if (radio2.isSelected()==true && radio3.isSelected()==true) {
                    boton1.setForeground(new Color(0,0,255));
                }
                else if (radio2.isSelected()==true && radio4.isSelected()==true) {
                    boton1.setForeground(new Color(0,0,0));
                }
                else{
                    JOptionPane.showMessageDialog(null,"Por favor, marque las opciones","Error",JOptionPane.ERROR_MESSAGE);
                }
            } else {
                
            }
        }
        if (e.getSource() == agregar) {
            try {
                double valorCapacitor = Double.parseDouble(textField.getText());
        
                // Asegúrate de que haya suficiente espacio en el arreglo
                if (contador2 < capacitores.length) {
                    capacitores[contador2] = valorCapacitor;
                    contador2++;
                } else {
                    // Si el arreglo está lleno, redimensiona el arreglo para agregar más elementos
                    capacitores = Arrays.copyOf(capacitores, capacitores.length * 2);
                    capacitores[contador2] = valorCapacitor;
                    contador2++;
                }
        
            
                txtArea.setText(metodos.generarImagenYString(capacitores));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor válido para el capacitor", "Error", JOptionPane.ERROR_MESSAGE);
            }
            textField.setText("");
            contador++;
            insertar();
        }
        
        if (e.getSource()==volver) {
            if (contador==0) {
                Terminos terminos = new Terminos();
                terminos.setBounds(0,0,600,360);
                terminos.setVisible(true);
                terminos.setResizable(false);
                terminos.setLocationRelativeTo(null);
                this.setVisible(false);
            }if (contador==1) {
                reestablecer();
            }
            if (contador>1) {
                if (contador2 > 0) {
                    contador2--;  // Reducir el contador para indicar que se eliminará un elemento
        
                    // Crear un nuevo array con un tamaño menor y copiar los valores originales
                    double[] nuevoArray = Arrays.copyOf(capacitores, contador2);
        
                    // Asignar el nuevo array al array de capacitores
                    capacitores = nuevoArray;
        
                    // Actualizar la representación en el JTextArea
                    txtArea.setText(metodos.impresionSerie(capacitores));
                    insertar();
                    
                }
                contador--;
            }
            
        }
        if (e.getSource()==boton2) {
            
            
        }
    }
    public static void main(String[] args) {
        Desarrollo desarrollo = new Desarrollo();
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
        agregar.setVisible(true);
        textField.setVisible(true);
        instruccion.setVisible(true);
        resultado.setVisible(true);
        resultad.setVisible(true);
        contador=0;
    }
    public void reestablecer(){
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
        textField.setVisible(false);
        resultado.setVisible(false);
        resultad.setVisible(false);
        txtArea.setText("");
        resultad.setText("");
        contador2 = 0;
        capacitores = new double[contador2 + 1];

        serie.setVisible(false);
        paralelo.setVisible(false);

        contador=0;
    }
    public void insertar(){
        double[] temp = Arrays.copyOf(capacitores, contador2);
            DecimalFormat df = new DecimalFormat("#.######");
            if (contador3==1) {
                resultad.setText(String.valueOf(df.format(metodos.capaEnSerie(temp))));
            }if (contador3==0) {
                resultad.setText(String.valueOf(metodos.capaEnParalelo(temp)));
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
}
