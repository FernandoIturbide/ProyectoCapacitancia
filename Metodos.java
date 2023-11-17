import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

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
    public static String generarImagenYString(double[] valores) {
        // Crear un BufferedImage
        int anchoImagen = 200;
        int altoImagen = 100;
        BufferedImage imagen = new BufferedImage(anchoImagen, altoImagen, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = imagen.getGraphics();
    
        // Dibujar en la imagen (puedes personalizar esto según tus necesidades)
        graphics.setColor(Color.WHITE);
        graphics.fillRect(35, 12, anchoImagen, altoImagen);
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("Arial", Font.PLAIN, 20));
    
        // Construir el String con los valores
        StringBuilder resultado = new StringBuilder();
    
        // Dibujar los valores en la imagen y construir el String al mismo tiempo
        int y = 30;
        for (int i = 0; i < valores.length; i++) {
            if (valores[i] != 0.0 && !Double.isNaN(valores[i])) {
                resultado.append("    C").append(i + 1).append(": ").append(valores[i]).append("   ");
                

                // Dibujar el valor en la imagen
                graphics.drawString(String.valueOf(valores[i]), 20, y);
                y += 30;
            }
            
            
        }
        resultado.append("\n");
        for (int i = 0; i < valores.length; i++){
            if (valores[i] != 0.0 && !Double.isNaN(valores[i])) {
                if (i==0) {
                    resultado.append("|------|  ").append("|-------");
                }else{
                    if (valores[i]>999) {
                        resultado.append("-----");
                        resultado.append("-----|  ").append("|-------");
                    }
                    if (valores[i]>99) {
                        resultado.append("---");
                        resultado.append("-----|  ").append("|-------");
                        
                    }else if(valores[i]>9){
                        resultado.append("--------|  ").append("|-------");
                    }
                    else if (i>0) {
                        if (valores[i]<=9 && valores[i-1]<=9) {
                            resultado.append("------");
                            resultado.append("---|  ").append("|---");

                        }else if (valores[i]<=9 && valores[i-1]>9) {
                            resultado.append("-----|  ").append("|---");

                    }else if (valores[i]>9) {
                        resultado.append("---|  ").append("|---");
                    }
                    

                    }
                }
                
                
                    
                
            }
        }
        resultado.append("----|");
        resultado.append("\n");
        resultado.append("|");
    
        // Guardar la imagen en un archivo (opcional)
        try {
            ImageIO.write(imagen, "png", new File("imagen_generada.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        // Retornar el String con los valores y la representación de la imagen
        return resultado.toString();
    }
    
    
}
