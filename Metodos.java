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
    public String impresionSerie(double[] capacitores){
        StringBuilder impresion = new StringBuilder();
        impresion.append("Capacitores en serie: [");
        for (int i = 0; i < capacitores.length; i++) {
            impresion.append("c"+(i+1)+" = ");
            impresion.append(capacitores[i]);
            if (i < capacitores.length - 1) {
                impresion.append(" , ");
            }
        }
        impresion.append("]");
        return impresion.toString();
    }            
}
