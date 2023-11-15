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
    Dictionary medida;
    int tipo;

    ArrayList<Integer> med;

    public Modelos() {
        medida=new Hashtable();
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
        medida=new Hashtable();
        medida.put("\u00B5",0.000001);
        medida.put("m",0.001);
        medida.put("c",0.01);
        medida.put("d",0.1);
        medida.put("da",10);
        medida.put("h",100);
        medida.put("k",1000);
        medida.put("M",1000000);
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
        String str=info.get(index);
        double multiplicador=1;
        return multiplicador;
    }

}
