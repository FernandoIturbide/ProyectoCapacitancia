import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Inicio extends JFrame implements ActionListener{
    private JTextField textfield1;
    private JLabel label1, label2, label3, label4,label5,label6,label7;
    private JButton boton1;
    public static String text="";
        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String timeActual = formatoFecha.format(fechaActual);
    public Inicio(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Bienvenido");
        getContentPane().setBackground(new Color(0,35,53));
        setIconImage(new ImageIcon(getClass().getResource("images/ivono.png")).getImage());
        
        ImageIcon imagen = new ImageIcon("images/Fes.png");
        label1 = new JLabel(imagen);
        label1.setBounds(380,15,340,100);
        add(label1);
    
        label2 = new JLabel(timeActual);
        label2.setBounds(480,400,300,30);
        label2.setFont(new Font("Andale Mono", 3, 18));
        label2.setForeground(new Color(253,12,3));
        add(label2);
    
        label3 = new JLabel("Socios: ");
        label3.setBounds(30,212,200,30);
        label3.setFont(new Font("Andale Mono", 1, 20));
        label3.setForeground(new Color(255,255,255));
        add(label3);
    
        label4 = new JLabel("-Fernando Iturbide Amador");
        label4.setBounds(50,242,300,30);
        label4.setFont(new Font("Andale Mono", 1, 14));
        label4.setForeground(new Color(255,255,255));
        add(label4);

        label7 = new JLabel("-Arrieta Flores Miguel Angel");
        label7.setBounds(50,272,300,30);
        label7.setFont(new Font("Andale Mono", 1, 14));
        label7.setForeground(new Color(255,255,255));
        add(label7);

        label5=new JLabel("Calculadora de capacitancia");
        label5.setBounds(150,60,340,30);
        label5.setFont(new Font("Andale Mono", 3, 24));
        label5.setForeground(new Color(251,235,0));
        add(label5);

        label6=new JLabel("y resistencia equivalente");
        label6.setBounds(170,90,300,30);
        label6.setFont(new Font("Andale Mono", 3, 24));
        label6.setForeground(new Color(251,235,0));
        add(label6);

        boton1=new JButton("Continuar");
        boton1.setBounds(260, 360, 120, 40);
        boton1.addActionListener(this);
        add(boton1);
        
    
   
      }
    
    
       public void actionPerformed(ActionEvent e){
         if(e.getSource() == boton1){
           text=textfield1.getText().trim();
           if (text.equals("")) {
             JOptionPane.showMessageDialog(null, "Debes ingresar tu nombre");
           }else{
            
           }
         }
       }
    
       public static void main(String args[]){
        Inicio interfaz11 = new Inicio();
        interfaz11.setBounds(0,0,640,500);
        interfaz11.setVisible(true);
        interfaz11.setResizable(false);
        interfaz11.setLocationRelativeTo(null);
        
        
       }
}