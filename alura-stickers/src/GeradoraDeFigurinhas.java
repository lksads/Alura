import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    
    public void cria(InputStream inputStream, String nomeArquivo) throws Exception{

        //buscando a imagem
        //InputStream inputStream = new FileInputStream(new File("entrada/filme.jpg"));
        //InputStream inputStream = new URL("https://imdb-api.com/images/original/MV5BMWMwMGQzZTItY2JlNC00OWZiLWIyMDctNDk2ZDQ2YjRjMWQ0XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_Ratio0.7015_AL_.jpg").openStream();
        BufferedImage original = ImageIO.read(inputStream);

        int largura = original.getWidth();
        int altura = original.getHeight();
        int novaAltura = altura + 200;


        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
        
        //copiando a imagem original para a nova imagem
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(original, 0, 0, null);



        //configurando a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 200);
        graphics.setColor(Color.yellow);
        graphics.setFont(fonte);

        //Escrevendo na nova imagem
        graphics.drawString("LKSADS", 500, novaAltura-100);

        ImageIO.write(novaImagem, "png", new File(nomeArquivo));



    }

}
