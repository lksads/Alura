import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    private static HttpClient newHttpClient;

    public static void main(String[] args) throws Exception {
        //conexão HTTP
        String url = "https://imdb-api.com/en/API/Top250Movies/k_6ovkj9j9";
        URI endereco = URI.create(url);
        var client= HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);

        var parse = new JsonParser();
        List<Map<String, String>>listaDeFilmes = parse.parse(body);
        
        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println("Titulo: " + filme.get("title"));
            System.out.println("Imagem: " + filme.get("image"));
            System.out.println("Nota: " + filme.get("imDbRating"));
            
        }
        


    }
}
