import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Main {
    public static void main(String[] args) {
        try {
            // Carregar a imagem a partir de um arquivo
            File file = new File("../imagem.png");
            BufferedImage image = ImageIO.read(file);

            // Obter a cor do pixel na posição (x, y)
            int x = 50; // coordenada x
            int y = 50; // coordenada y

            // Verificar se a coordenada está dentro dos limites da imagem
            if (x >= 0 && x < image.getWidth() && y >= 0 && y < image.getHeight()) {
                int rgb = image.getRGB(x, y);

                // Extrair os componentes de cor
                Color color = new Color(rgb);

                // Obter valores individuais de cor
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();

                System.out.println("Cor do pixel na posição (" + x + ", " + y + "):");
                System.out.println("Red: " + red);
                System.out.println("Green: " + green);
                System.out.println("Blue: " + blue);
            } else {
                System.out.println("As coordenadas estão fora dos limites da imagem.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar a imagem: " + e.getMessage());
        }
    }
}
