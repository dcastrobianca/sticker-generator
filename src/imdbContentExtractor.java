import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class imdbContentExtractor implements ContentExtractor{
    
    public List<Content> extraContents(String json){
        List<Map<String, String>> contentsMaps = new jsonParse().parse(json);

        List <Content> contents = new ArrayList<Content>();

        for(Map<String, String> map : contentsMaps){
            String title = map.get("title").replace(":","-");
            String urlImage = map.get("image");

            Content content = new Content(title, urlImage);

            contents.add(content);
        }

        return contents;
    }
}
