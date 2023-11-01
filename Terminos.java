import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
public class Terminos extends JFrame implements ActionListener, ChangeListener{
    private JLabel label1, label2;
    private JCheckBox check1;
    private JButton boton1, boton2;
    private JScrollPane scrollPane;
    private JTextArea textArea;
    public Terminos (){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setTitle("Licencia de uso");
        setIconImage(new ImageIcon(getClass().getResource("images/ivono.png")).getImage());

        label1 = new JLabel("TERMINOS Y CONDICIONES");
        label1.setBounds(200,5,250,30);
        label1.setFont(new Font("Andale Mono", 1, 14));
        label1.setForeground(new Color(0, 0, 0));
        add(label1);
    
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Andale Mono", 0, 9));   
        textArea.setText("\n\n          TERMINOS Y CONDICIONES" +
                    "\n\n            A.  PROHIBIDA SU VENTA O DISTRIBUCION SIN AUTORIZACION DE LA EMPRESA WAPYJ." +
                    "\n            B.  PROHIBIDA LA ALTERACION DEL CODIGO FUENTE O DISEÑO DE LAS INTERFACES GRAFICAS." +
                    "\n            C.  LA EMPRESA WAPYJ NO SE HACE RESPONSABLE DEL MAL USO DE ESTE SOFTWARE." +
                    "\n\n          LOS ACUERDOS LEGALES EXPUESTOS ACONTINUACION RIGEN EL USO QUE USTED HAGA DE ESTE SOFTWARE" +
                    "\n          (LA EMPRESA WAPYJ Y EL AUTOR FERNANDO), NO SE RESPONSABILIZAN DEL USO QUE USTED" + 
                    "\n          HAGA CON ESTE SOFTWARE Y SUS SERVICIOS. PARA ACEPTAR ESTOS TERMINOS HAGA CLIC EN (ACEPTO)" +
                    "\n          SI USTED NO ACEPTA ESTOS TERMINOS, HAGA CLIC EN (NO ACEPTO) Y NO UTILICE ESTE SOFTWARE." + 
                    "\n\n          PARA MAYOR INFORMACION SOBRE NUESTROS PRODUCTOS O SERVICIOS, POR FAVOR VISITE" + 
                    "\n          http://www.wapyj.com/");

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
    
        ImageIcon imagen = new ImageIcon("images/Logo3.png");
        label2 = new JLabel(imagen);  
        label2.setBounds(315,135,300,300);
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
            desarrollo.setBounds(0,0,600,360);
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
}