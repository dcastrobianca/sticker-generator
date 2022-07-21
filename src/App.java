import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        //String nasaAPIKey ="1it4ENqGhhA1yuwNgJWJvgaOC8BnHNML6I5thq66";
        String urlImDB = "https://imdb-api.com/en/API/Top250Movies/k_05s9gqz7";
        String urlNasa = "https://api.nasa.gov/planetary/apod?api_key=1it4ENqGhhA1yuwNgJWJvgaOC8BnHNML6I5thq66&start_date=2022-03-23&end_date=2022-03-25";
        
        httpClient client = new httpClient();
        String json = client.retrieveAPIData(urlNasa);

        ContentExtractor contentExtrator = new NasaContentExtractor();
        List<Content> contents = contentExtrator.extraContents(json);

        StickerGenerator sticker = new StickerGenerator();
        for(Content content : contents){
            //System.out.println(movie.get("image"));
            System.out.println(content.getTitle());
            InputStream inputStream = new URL(content.getUrlImage()).openStream();
            sticker.generateSticker(inputStream, content.getTitle()); 
        }
    
        
    }
}
