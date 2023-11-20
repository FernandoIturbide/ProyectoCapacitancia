public class Metodos{
    public double capaEnSerie(double[] capacitores){
        double valores[]=new double [capacitores.length];
        double capacitor_1=0.00;
        for (int i = 0; i < capacitores.length; i++) {
            valores[i]=(1/capacitores[i]);
        }
        for (int i = 0; i < valores.length; i++) {
            capacitor_1+=valores[i];
        }
        double a=(1/capacitor_1);
        return a;
    }
    public double capaEnParalelo(double[] capacitores){
        double capacitor_1=0.00;
        for (int i = 0; i < capacitores.length; i++) {
            capacitor_1+=capacitores[i];
        }
        return capacitor_1;
    }
    public double resisEnSerie(double[] resistores){
        double capacitor_1=0.00;
        for (int i = 0; i < resistores.length; i++) {
            capacitor_1+=resistores[i];
        }
        return capacitor_1;
    }
    public double resisEnParalelo(double[] resistores){
        double valores[]=new double [resistores.length];
        double capacitor_1=0.00;
        for (int i = 0; i < resistores.length; i++) {
            valores[i]=(1/ resistores[i]);
        }
        for (int i = 0; i < valores.length; i++) {
            capacitor_1+=valores[i];
        }
        double a=(1/capacitor_1);
        return a;
    }
    public String impresion(double[] elementos, int opcion){
        String accion=null;
        String medida=null;
        String c=null;
        if(opcion==1){
            accion="Capacitores";
            medida="F";
            c=String.valueOf(accion.charAt(0));
        } else if (opcion==2) {
            accion="Resistores";
            medida="\u2126";
            c=String.valueOf(accion.charAt(0));
        }


        StringBuilder impresion = new StringBuilder();
        impresion.append(accion+" [");
        for (int i = 0; i < elementos.length; i++) {
            impresion.append(c+(i+1)+" = ");
            impresion.append(elementos[i]+medida);
            if (i < elementos.length - 1) {
                impresion.append(" , ");
            }
        }
        impresion.append("]");
        return impresion.toString();
    }

    public Double conversion(double valor, double multiplicador){
        Double conversion=valor*multiplicador;
        return conversion;
    }
}