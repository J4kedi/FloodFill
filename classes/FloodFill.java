package classes;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FloodFill {
    private File file;
    private BufferedImage image;
    private Fila<Integer> filaPixeis;
    private int imageHeight;
    private int imageWidth;
    private int prevCell;
    private int nextCell;


    public FloodFill (String imagePath) throws IOException {
        this.file = new File(imagePath);
        this.image = ImageIO.read(file);
        this.imageHeight = image.getHeight();
        this.imageWidth = image.getWidth();
        this.filaPixeis = new Fila<>(imageWidth * imageHeight);
        this.prevCell = 0;
        this.nextCell = 0;
    }

    public void fillImage (int x, int y, Color cor) {
        Color corPixel = getCorPixel(x, y);

        percorrerTodos(corPixel, x, y);

        for (int i = 0; i < filaPixeis.getTop(); i += 2) {
            int xFila = filaPixeis.rm();
            int yFila = filaPixeis.rm();
            image.setRGB(xFila, yFila, cor.getRGB());
        }

        mostrarImagem();
    }

    private Color getCorPixel(int x, int y) {
        if (x >= 0 && x < imageWidth && y >= 0 && y < imageHeight)
            return new Color(image.getRGB(x, y));
        
        throw new IllegalArgumentException("Pixel fora da imagem");
    }

    private void percorrerTodos(Color cor, int x, int y) {
        if (x < 1 || x >= imageWidth || y < 1 || y >= imageHeight)
            return;
    
        if (!getCorPixel(x, y).equals(cor))
            return;

        filaPixeis.add(x);
        filaPixeis.add(y);
        
        

        if (y + 1 < imageHeight && (y + 1) != nextCell && x + 1 != prevCell) {
            nextCell = y;
            percorrerTodos(cor, x, y + 1);
        }
        if (x + 1 < imageWidth && (x + 1) != prevCell && y + 1 != nextCell) {
            prevCell = x;
            percorrerTodos(cor, x + 1, y);
        }
        if (y - 1 > 0 && (y - 1) != nextCell && x - 1 != prevCell) {
            nextCell = y;
            percorrerTodos(cor, x, y - 1);
        }
        if (x - 1 > 0 && (x - 1) != prevCell && y - 1 != nextCell) {
            prevCell = x;
            percorrerTodos(cor, x - 1, y);
        }
    }

    private void mostrarImagem() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Imagem Pintada");

        ImageIcon imageIcon = new ImageIcon(image);
        JLabel jLabel = new JLabel(imageIcon);

        frame.getContentPane().add(jLabel);
        frame.pack();
        frame.setVisible(true);
    }
}   