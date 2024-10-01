package floodFillPilha;

import java.awt.Color;
import java.awt.image.BufferedImage;

import utils.Imagem;

public class FloodFillPilha {
    private BufferedImage image;
    private int imageHeight;
    private int imageWidth;

    public FloodFillPilha(Imagem imagem){
        this.image = imagem.getImage();
        this.imageHeight = image.getHeight();
        this.imageWidth = image.getWidth();
    }

    public void fillImage(int x, int y, Color novaCor) {
        Color corPixelInicial = getCorPixel(x, y);
        pintar(x, y, corPixelInicial, novaCor);
    }

    private Color getCorPixel(int x, int y) {
        if (x >= 0 && x < imageWidth && y >= 0 && y < imageHeight)
            return new Color(image.getRGB(x, y));

        throw new IllegalArgumentException("Pixel fora da imagem");
    }

    private void pintar(int x, int y, Color corInicial, Color novaCor) {
        Pilha<int[]> pilha = new Pilha<>(imageHeight * imageWidth);
        pilha.push(new int[]{x, y});

        image.setRGB(x, y, novaCor.getRGB());

        if (corInicial.equals(novaCor))
            return;

        while (!pilha.isEmpty()) {
            int[] pos = pilha.pop();

            if (pos == null)
                return;

            int px = pos[0];
            int py = pos[1];
            
            if (px - 1 >= 0 && getCorPixel(px - 1, py).equals(corInicial)) {
                image.setRGB(px - 1, py, novaCor.getRGB());
                pilha.push(new int[]{px - 1, py});
            }
            if (px + 1 < imageWidth && getCorPixel(px + 1, py).equals(corInicial)) {
                image.setRGB(px + 1, py, novaCor.getRGB());
                pilha.push(new int[]{px + 1, py});
            }
            if (py + 1 < imageHeight && getCorPixel(px, py + 1).equals(corInicial)) {
                image.setRGB(px, py + 1, novaCor.getRGB());
                pilha.push(new int[]{px, py + 1});
            }
            if (py - 1 >= 0 && getCorPixel(px, py - 1).equals(corInicial)) {
                image.setRGB(px, py - 1, novaCor.getRGB());
                pilha.push(new int[]{px, py - 1});
            }
        }
    }
}