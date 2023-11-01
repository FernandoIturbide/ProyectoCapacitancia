import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
public class Desarrollo extends JFrame implements ActionListener, ChangeListener{
    private JLabel label1,label3;
    private JRadioButton radio1,radio2,radio3,radio4;
    private JButton boton1,volver;
    
    public Desarrollo (){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setTitle("Elección de calculo");
        setIconImage(new ImageIcon(getClass().getResource("images/ivono.png")).getImage());

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

        volver = new JButton("Volver");
        volver.setBounds(480,280,100,30);
        volver.addActionListener(this);
        add(volver);
    
    }
    public void stateChanged(ChangeEvent e) {
        
    }
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==boton1) {
            int decision = JOptionPane.showConfirmDialog(null, "¿Desea continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);

            if (decision == JOptionPane.YES_OPTION) {
                if (radio1.isSelected()==true && radio3.isSelected()==true) {
                boton1.setForeground(new Color(255,0,0));
                }
                else if (radio1.isSelected()==true && radio4.isSelected()==true) {
                    boton1.setForeground(new Color(0,255,0));
                }
                else if (radio2.isSelected()==true && radio3.isSelected()==true) {
                    boton1.setForeground(new Color(0,0,255));
                }
                else if (radio2.isSelected()==true && radio4.isSelected()==true) {
                    boton1.setForeground(new Color(0,0,0));
                }
            } else {
                
            }
        }
        if (e.getSource()==volver) {
            Terminos terminos = new Terminos();
            terminos.setBounds(0,0,600,360);
            terminos.setVisible(true);
            terminos.setResizable(false);
            terminos.setLocationRelativeTo(null);
        }
    }
    public static void main(String[] args) {
        Desarrollo desarrollo = new Desarrollo();
        desarrollo.setBounds(0,0,600,360);
        desarrollo.setVisible(true);
        desarrollo.setResizable(false);
        desarrollo.setLocationRelativeTo(null);
    }
}