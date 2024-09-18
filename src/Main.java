import java.awt.Color;
import java.io.IOException;
import classes.FloodFill;

public class Main {
    public static void main(String[] args) {
        Color vermelho = new Color(255, 0, 0);

        try {
            FloodFill floodFill = new FloodFill("imagem.png");

            floodFill.fillImage(359, 55, vermelho);
        } catch (IOException e) {
            System.err.println("Erro ao carregar a imagem: " + e.getMessage());
        }
    }
}
