package tpv_galileo;


import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gonfe
 */
public class Utilidades {
    /**
     * Carga la imagen de una url para tranformarla en un icono
     * @param Url Url de la imagen
     * @return Un ImageIcon con la imagen
     */
    static ImageIcon UrlIcon(String Url,int x, int y){
        ImageIcon icon = null;
        try {
                  URL url = new URL(Url);
                  BufferedImage img = ImageIO.read(url);
                  BufferedImage resized = resize(img, x, y);
                  icon = new ImageIcon(resized);
               } catch (MalformedURLException e) {
                  e.printStackTrace();
               } catch (IOException e) {
                  e.printStackTrace();
               } 
        return icon;
    }
    
    //https://memorynotfound.com/java-resize-image-fixed-width-height-example/
    private static BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }
}
