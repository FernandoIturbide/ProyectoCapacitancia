import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Inicio extends JFrame implements ActionListener{
    private JLabel pro,label1, label2, label3, label4,label5,label6,label7, img,img2;
    private JButton boton1;
    public static String text="";
        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String timeActual = formatoFecha.format(fechaActual);
    public Inicio(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Bienvenido");
        getContentPane().setBackground(new Color(255,255,255));
        setIconImage(new ImageIcon("images/logoF.jpg").getImage());

        String rutaImagen = "images/logoF.jpg";
        label1 = new JLabel();
        redimensionarYEstablecerImagen(label1, rutaImagen, 127, 127);
        label1.setBounds(10,20,130,130);
        add(label1);

        label2 = new JLabel(timeActual);
        label2.setBounds(450,320,300,30);
        label2.setFont(new Font("Andale Mono", 3, 18));
        label2.setForeground(new Color(255,255,255));
        add(label2);

        label3 = new JLabel("Socios: ");
        label3.setBounds(35,262,200,30);
        label3.setFont(new Font("Andale Mono", 1, 20));
        label3.setForeground(new Color(255,255,255));
        add(label3);

        label4 = new JLabel("-Iturbide Amador Fernando");
        label4.setBounds(50,312,300,30);
        label4.setFont(new Font("Andale Mono", 1, 14));
        label4.setForeground(new Color(255,255,255));
        add(label4);

        label7 = new JLabel("-Arrieta Flores Miguel Angel");
        label7.setBounds(50,292,300,30);
        label7.setFont(new Font("Andale Mono", 1, 14));
        label7.setForeground(new Color(255,255,255));
        add(label7);

        label5=new JLabel("Calculadora de capacitancia");
        label5.setBounds(155,80,340,30);
        label5.setFont(new Font("Andale Mono", 3, 24));
        label5.setForeground(new Color(255,255,255));
        add(label5);

        label6=new JLabel("y resistencia equivalente");
        label6.setBounds(175,110,300,30);
        label6.setFont(new Font("Andale Mono", 3, 24));
        label6.setForeground(new Color(255, 255, 255));
        add(label6);

        boton1=new JButton("Continuar");
        boton1.setBounds(260, 370, 120, 40);
        boton1.addActionListener(this);
        add(boton1);

        String rutaFes="images/AragonF.jpg";
        label1 = new JLabel();
        redimensionarYEstablecerImagen(label1,rutaFes,115,115);
        label1.setBounds(495,20,140,140);
        add(label1);

        String rutaFondo="images/nuevo3.jpg";
        img = new JLabel();
        redimensionarYEstablecerImagen(img,rutaFondo,640,500);
        img.setBounds(0,0,640,500);
        add(img);

        ImageIcon imagen=new ImageIcon("images/nuevo3.jpg");
        img2 = new JLabel(imagen);
        img2.setBounds(0,0,640,500);
        add(img2);

      }
    
    
       public void actionPerformed(ActionEvent e){
        if(e.getSource() == boton1){
            Terminos interfaz = new Terminos();
            interfaz.setBounds(0,0,600,360);
            interfaz.setVisible(true);
            interfaz.setResizable(false);
            interfaz.setLocationRelativeTo(null);
            this.setVisible(false);
           }else{
            
           }
         }
       public static void main(String args[]){
        Inicio interfaz11 = new Inicio();
        interfaz11.setBounds(0,0,640,500);
        interfaz11.setVisible(true);
        interfaz11.setResizable(false);
        interfaz11.setLocationRelativeTo(null);
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
