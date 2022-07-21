import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.InputStream;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;

public class StickerGenerator {
    public void generateSticker(InputStream inputStream, String name) throws Exception{
    
       BufferedImage originalImage = ImageIO.read(inputStream);

       int originalWidth = originalImage.getWidth();
       int originalHeight = originalImage.getHeight();
       int newHeight = (int) (originalHeight + (originalHeight*0.3));

       BufferedImage newImage= new BufferedImage(originalWidth, newHeight, BufferedImage.TRANSLUCENT);
       Graphics2D graphics = (Graphics2D) newImage.getGraphics();
       graphics.drawImage(originalImage, 0,0, null);
       
       Font font = new Font(Font.SANS_SERIF, Font.BOLD, 24);
       graphics.setFont(font);
       graphics.setColor(Color.MAGENTA);
       graphics.drawString("TOPZERA", 0, (int)(newHeight-newHeight*0.05));
       ImageIO.write(newImage, "png", new File("img/"+name+".png"));
    }
}
