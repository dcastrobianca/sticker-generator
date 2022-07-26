import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class httpClient {
    public String retrieveAPIData(String url){
        try{
            URI uri = URI.create(url);
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
            HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
            String body = response.body();
            return body;
        }catch (IOException | InterruptedException e ){
            throw new RuntimeException(e);
        }    
    }

}
