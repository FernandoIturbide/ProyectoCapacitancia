import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class Modelos implements ComboBoxModel {
    ArrayList<String> info;
    String selected;
    ArrayList<Double> medida;
    int tipo;

    ArrayList<Integer> med;

    public Modelos() {
        medida=new ArrayList();
        info = new ArrayList<>();
    }

    public Modelos(ArrayList<String>info) {
        this.info = info;
    }

    public Modelos(int tipo){
        info = new ArrayList<>();
        if (tipo==1){
            info.add("\u00B5F");
            info.add("mF");
            info.add("cF");
            info.add("dF");
            info.add("F");
            info.add("daF");
            info.add("hF");
            info.add("KF");
            info.add("MF");
        } else if (tipo==2) {
            info.add("\u00B5\u2126");
            info.add("m\u2126");
            info.add("c\u2126");
            info.add("d\u2126");
            info.add("\u2126");
            info.add("da\u2126");
            info.add("h\u2126");
            info.add("K\u2126");
            info.add("M\u2126");
        }
        medida=new ArrayList<>();
        medida.add(0.000001);
        medida.add(0.001);
        medida.add(0.01);
        medida.add(0.1);
        medida.add(1.0);
        medida.add(10.0);
        medida.add(10.0);
        medida.add(1000.0);
        medida.add(1000000.0);
    }

    @Override
    public void setSelectedItem(Object o) {
        this.selected = (String) o;
    }

    @Override
    public Object getSelectedItem() {
        return selected;
    }

    @Override
    public int getSize() {
        return info.size();
    }

    @Override
    public Object getElementAt(int index) {
        return info.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }

    public double darMultiplicador(int index){
        double multiplicador= medida.get(index);
        return multiplicador;
    }

}
