import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    
    public static void main(String[] args) throws Exception {
        //conexão HTTP
        //String url = "https://api.mocki.io/v2/549a5d8b";
        //ExtratorDeConteudoDoIMDB extrator = new ExtratorDeConteudoDoIMDB();
        
        //String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD";
        ///ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();

        String url = "http://localhost:8080/linguagens";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();
        
        var http = new ClienteHttp();
        String json = http.buscaDados(url);
        
        

        //manipulando dados        var geradora = new GeradoraDeFigurinhas();
        
        List<Conteudo> conteudos = extrator.extraiConteudos(json);
        
        
        var geradora = new GeradoraDeFigurinhas();
        
        for (int i = 0; i < 3; i++){
            
            Conteudo conteudo = conteudos.get(i);
            
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";
            
            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();
            
        }
        
        

    }
}
