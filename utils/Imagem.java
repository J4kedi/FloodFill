package utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Imagem {
    private File file;
    private BufferedImage image;

    public Imagem (String imagePath) throws IOException {
        this.file = new File(imagePath);
        this.image = ImageIO.read(file);
    }

    public void mostrarImagem() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Imagem");

        ImageIcon imageIcon = new ImageIcon(image);
        JLabel jLabel = new JLabel(imageIcon);

        frame.getContentPane().add(jLabel);
        frame.pack();
        frame.setVisible(true);
    }   

    public BufferedImage getImage() {
        return image;
    }
}
