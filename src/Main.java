import java.awt.Color;
import java.io.IOException;

import floodFillFila.FloodFill;
import floodFillPilha.FloodFillPilha;
import utils.Imagem;

public class Main {
    public static void main(String[] args) {
        Color vermelho = new Color(255, 0, 0);

        try {
            Imagem imagemFila = new Imagem("imagem.png");
            Imagem imagemPilha = new Imagem("imagem.png");
            FloodFill floodFillFila = new FloodFill(imagemFila);
            FloodFillPilha floodFillPilha = new FloodFillPilha(imagemPilha);
            
            floodFillFila.fillImage(120, 70, vermelho);
            imagemFila.mostrarImagem();

            floodFillPilha.fillImage(120, 40, vermelho);
            imagemPilha.mostrarImagem();
        } catch (IOException e) {
            System.err.println("Erro ao carregar a imagem: " + e.getMessage());
        }
    }
}
