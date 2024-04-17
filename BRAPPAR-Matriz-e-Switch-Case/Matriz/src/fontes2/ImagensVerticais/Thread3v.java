package fontes2.ImagensVerticais;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Thread3v extends Thread{
    private int larguraInicial;
    private int larguraFinal;
    private int alturaInicial;
    private int alturaFinal;
    BufferedImage imagem;
    
    public Thread3v(BufferedImage imagem){
        
        this.imagem = imagem;
        
        int altura = this.imagem.getHeight();
        int largura = this.imagem.getWidth();

        this.larguraInicial = largura / 3;
        this.larguraFinal = largura / 2;
        this.alturaInicial = 0;
        this.alturaFinal = altura;
    }
    
    
    public Thread3v(int[][] matriz1, int[][] matriz2, int[][] resultado, int i) {
        //TODO Auto-generated constructor stub
    }


    public void run(){
        for (int x = larguraInicial; x<this.larguraFinal; x++){
            for (int y = this.alturaInicial; y<this.alturaFinal; y++){
                Color pixel = new Color(this.imagem.getRGB(x, y));
                
                int corPixel = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
                
                this.imagem.setRGB(x, y, new Color(corPixel, corPixel, corPixel).getRGB());
               // System.out.println("passando T1");
            }
        }
        
        try {
            ImageIO.write(this.imagem, "JPG", new File("imgGrayscaleVertical.jpg"));
            System.out.println("Escrevendo T3");
        } catch (IOException ex) {
            Logger.getLogger(Thread3v.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
}

