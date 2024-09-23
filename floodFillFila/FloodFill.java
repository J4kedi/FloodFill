package floodFillFila;

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
    private int imageHeight;
    private int imageWidth;

    public FloodFill(String imagePath) throws IOException {
        this.file = new File(imagePath);
        this.image = ImageIO.read(file);
        this.imageHeight = image.getHeight();
        this.imageWidth = image.getWidth();
    }

    public void fillImage(int x, int y, Color novaCor) {
        Color corPixelInicial = getCorPixel(x, y);
        floodFill(x, y, corPixelInicial, novaCor);
        mostrarImagem();
    }

    private Color getCorPixel(int x, int y) {
        if (x >= 0 && x < imageWidth && y >= 0 && y < imageHeight)
            return new Color(image.getRGB(x, y));

        throw new IllegalArgumentException("Pixel fora da imagem");
    }

    private void floodFill(int x, int y, Color corInicial, Color novaCor) {
        Fila<int[]> fila = new Fila<>(imageHeight * imageWidth);
        fila.add(new int[]{x, y});

        image.setRGB(x, y, novaCor.getRGB());

        if (corInicial.equals(novaCor)) {
            return;
        }

        while (!fila.isEmpty()) {
            int[] pos = fila.poll();

            if (pos == null)
                return;

            int px = pos[0];
            int py = pos[1];
            
            if (px - 1 >= 0 && getCorPixel(px - 1, py).equals(corInicial)) {
                image.setRGB(px - 1, py, novaCor.getRGB());
                fila.add(new int[]{px - 1, py});
            }
            if (px + 1 < imageWidth && getCorPixel(px + 1, py).equals(corInicial)) {
                image.setRGB(px + 1, py, novaCor.getRGB());
                fila.add(new int[]{px + 1, py});
            }
            if (py + 1 < imageHeight && getCorPixel(px, py + 1).equals(corInicial)) {
                image.setRGB(px, py + 1, novaCor.getRGB());
                fila.add(new int[]{px, py + 1});
            }
            if (py - 1 >= 0 && getCorPixel(px, py - 1).equals(corInicial)) {
                image.setRGB(px, py - 1, novaCor.getRGB());
                fila.add(new int[]{px, py - 1});
            }
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
