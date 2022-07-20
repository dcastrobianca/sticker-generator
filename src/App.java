import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        String nasaAPIKey ="1it4ENqGhhA1yuwNgJWJvgaOC8BnHNML6I5thq66";
        String url = "https://imdb-api.com/en/API/Top250Movies/k_05s9gqz7";
        URI uri = URI.create(url);
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
        HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
        String body = response.body();

        List<Map<String, String>> movieList = new jsonParse().parse(body);
        StickerGenerator sticker = new StickerGenerator();
        for(Map<String, String> movie : movieList){
            //System.out.println(movie.get("image"));
            System.out.println(movie.get("title"));
            sticker.generateSticker(movie.get("image"), movie.get("title").replace(":","-")); 
        }
    
        
    }
}
