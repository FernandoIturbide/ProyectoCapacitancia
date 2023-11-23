import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Terminos extends JFrame implements ActionListener, ChangeListener{
    private JLabel label1, label2;
    private JCheckBox check1;
    private JButton boton1, boton2;
    private JScrollPane scrollPane;
    private JTextArea textArea;
    public Terminos (){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("images/logoF.jpg").getImage());
        
        setTitle("Licencia de uso");
        setIconImage(new ImageIcon("images/logoF.jpg").getImage());

        label1 = new JLabel("TERMINOS Y CONDICIONES");
        label1.setBounds(200,5,250,30);
        label1.setFont(new Font("Andale Mono", 1, 14));
        label1.setForeground(new Color(0, 0, 0));
        add(label1);
    
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Andale Mono", 0, 9));   
        textArea.setText("\n\n          TERMINOS Y CONDICIONES" +
                    "\n\n            A.  PROHIBIDA SU VENTA O DISTRIBUCION SIN AUTORIZACION DE LA EMPRESA IST." +
                    "\n            B.  PROHIBIDA LA ALTERACION DEL CODIGO FUENTE O DISEÑO DE LAS INTERFACES GRAFICAS." +
                    "\n            C.  LA EMPRESA IST NO SE HACE RESPONSABLE DEL MAL USO DE ESTE SOFTWARE." +
                    "\n\n          LOS ACUERDOS LEGALES EXPUESTOS ACONTINUACION RIGEN EL USO QUE USTED HAGA DE ESTE SOFTWARE" +
                    "\n          (LA EMPRESA IST Y LOS AUTORES FERNANDO Y MIGUEL), NO SE RESPONSABILIZAN DEL USO QUE USTED" + 
                    "\n          HAGA CON ESTE SOFTWARE Y SUS SERVICIOS. PARA ACEPTAR ESTOS TERMINOS HAGA CLIC EN (ACEPTO)" +
                    "\n          SI USTED NO ACEPTA ESTOS TERMINOS, HAGA CLIC EN (NO ACEPTO) Y NO UTILICE ESTE SOFTWARE." + 
                    "\n\n          PARA MAYOR INFORMACION SOBRE NUESTROS PRODUCTOS O SERVICIOS, POR FAVOR VISITE" + 
                    "\n          http://www.IST.com.mx/");

        scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10,40,565,200);
        add(scrollPane);   
    
        check1 = new JCheckBox("Yo acepto");
        check1.setBounds(10,245,300,30);
        check1.addChangeListener(this);
        add(check1);
    
        boton1 = new JButton("Continuar");
        boton1.setBounds(10,280,100,30);
        boton1.addActionListener(this);
        boton1.setEnabled(false);
        add(boton1);
    
        boton2 = new JButton("No Acepto");
        boton2.setBounds(120,280,100,30);
        boton2.addActionListener(this);
        boton2.setEnabled(true);
        add(boton2);
    
        String fondo="images/logoF.jpg";
        label2 = new JLabel();
        redimensionarYEstablecerImagen(label2,fondo,60,60);
        label2.setBounds(490,240,80,80);
        add(label2);
    }
    public void stateChanged(ChangeEvent e) {
        if (check1.isSelected()==true) {
            boton1.setEnabled(true);
            boton2.setEnabled(false);
        } else {
            boton1.setEnabled(false);
            boton2.setEnabled(true);
        }
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==boton1) {
            Desarrollo desarrollo = new Desarrollo();
            desarrollo.setBounds(0,0,600,400);
            desarrollo.setVisible(true);
            desarrollo.setResizable(false);
            desarrollo.setLocationRelativeTo(null);
            this.setVisible(false);
        }
        if (e.getSource()==boton2){
            Inicio interfaz11 = new Inicio();
            interfaz11.setBounds(0,0,640,500);
            interfaz11.setVisible(true);
            interfaz11.setResizable(false);
            interfaz11.setLocationRelativeTo(null);
        }
    }
    public static void main(String[] args) {
        Terminos interfaz = new Terminos();
        interfaz.setBounds(0,0,600,360);
        interfaz.setVisible(true);
        interfaz.setResizable(false);
        interfaz.setLocationRelativeTo(null);
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