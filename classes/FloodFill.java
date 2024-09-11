package classes;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FloodFill {
    private File file;
    private BufferedImage image;
    private Fila<Integer> filaPixeis;
    
    public FloodFill (String imagePath) throws IOException{
        this.file = new File(imagePath);
        this.image = ImageIO.read(file);
    }

    public void pixelAlvo(int x, int y) {
        if (x >= 0 && x < image.getWidth() && y >= 0 && y < image.getHeight()) {
            int rgb = image.getRGB(x, y);
            Color color = new Color(rgb);
        } else {
            throw new IllegalArgumentException("Pixel inválido");
        }
    }

    public void percorrerTodos() {
        
    }
}
