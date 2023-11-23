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

    public String impresion(double[] elementos, int opcion, int[] combo){
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

        String dispositivo=null;
        StringBuilder impresion = new StringBuilder();
        impresion.append(accion+" [");
        for (int i = 0; i < elementos.length; i++) {
            impresion.append(c+(i+1)+" = ");
            dispositivo=magnitud(elementos[i],opcion,combo[i]);
            impresion.append(dispositivo);
            if (i < elementos.length - 1) {
                impresion.append(" , ");
            }
        }
        impresion.append("]");
        return impresion.toString();
    }

    public String conversion(double valor, int evaluacion){
        String resultado=null;
        if (valor<1 && evaluacion==0){
            valor*=1000000;
            resultado=valor+"\u00B5";
        } else if (valor>1000){
            valor/=1000;
            resultado=valor+"k";
        }else {
            resultado= String.valueOf(valor);
        }
        return resultado;
    }

    public double multiplicar(double valor, double multiplicador){
        double conversion=valor*multiplicador;
        return conversion;
    }

    public int evaluar(int[] valores){
        int multiplicador=valores[0];
        for (int numero : valores) {
            if (numero< multiplicador){
                multiplicador=numero;
            }
        }
        return multiplicador;
    }

    public String magnitud(double valor, int tipo, int index){
        String value=null;
        String cantidad=null;
        int i=index;
        switch (i){
            case 0:
                cantidad=("\u00B5");
                break;
            case 1:
                cantidad=("m");
                break;
            case 2:
                cantidad=("c");
                break;
            case 3:
                cantidad=("d");
                break;
            case 4:
                cantidad=("");
                break;
            case 5:
                cantidad=("da");
                break;
            case 6:
                cantidad=("h");
                break;
            case 7:
                cantidad=("K");
                break;
            case 8:
                cantidad=("M");
                break;
            default:
                cantidad=null;
                break;
        }
        if (tipo==1){
            value=cantidad+"F";
        } else if (tipo==2) {
            value=cantidad+"\u2126";
        }
        value=valor+value;
        return value;
    }
}
