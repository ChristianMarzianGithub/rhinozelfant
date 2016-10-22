package rhinozelfantPackageObjektorientiert;

import java.awt.BorderLayout; 
import java.awt.Color; 
import java.awt.image.BufferedImage; 
import java.awt.image.ColorModel; 
import java.awt.image.WritableRaster; 
import java.io.File; 
import java.io.IOException; 

import javax.imageio.ImageIO; 
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JPanel; 
import javax.swing.border.LineBorder; 

public class ManipulateImage extends JFrame { 

    private static final long serialVersionUID = 1L; 

    JPanel panel; 

    JLabel label; 

    ImageIcon icon; 

    BufferedImage image; 

    public ManipulateImage() { 

        //processImage(); 
        makeImage(); 
         
        icon = new ImageIcon(image); 
        label = new JLabel(icon); 
        label.setBorder(new LineBorder(Color.WHITE)); 

        panel = new JPanel(); 
        panel.setLayout(new BorderLayout()); 
        panel.setBackground(Color.DARK_GRAY); 
        panel.add(label, BorderLayout.CENTER); 

        getContentPane().add(panel); 
        setSize(image.getWidth() + 100, image.getHeight() + 100); 
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setVisible(true); 
    } 
     
    private void processImage(String filePath){ 
        File file = new File(filePath); 
        try { 
            this.image = ImageIO.read(file); 
        } catch (IOException ex) { 
            ex.printStackTrace(); 
        } 
         
        ColorModel model = image.getColorModel(); 
         
        WritableRaster raster = image.getRaster(); 
        for(int i=0; i<image.getWidth(); i++){ 
            for(int j=0; j<image.getHeight(); j++){ 
                 
                Object dataAlt = raster.getDataElements(i, j, null); 
                int argbAlt = model.getRGB(dataAlt); 
                 
                Color c = new Color(argbAlt, true); 
                 
                int limit = 150, wert = 50; 
                 
                int r = (c.getRed() + limit) < 256 ? c.getRed() + wert : 255; 
                int g = (c.getGreen() + limit) < 256 ? c.getGreen() + wert : 255; 
                int b = (c.getBlue() + limit) < 256 ? c.getBlue() + wert : 255; 
                 
                Color cNeu = new Color(r, g, b); 
                 
                int argbNeu = cNeu.getRGB(); 
                 
                Object dataNeu = model.getDataElements(argbNeu, null); 
                 
                raster.setDataElements(i, j, dataNeu); 
            } 
        } 
    } 
     
    private void makeImage(){ 
        int width = 200, height = 200; 
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB); 
        WritableRaster raster = image.getRaster(); 
        ColorModel model = image.getColorModel(); 
         
        //�u�eres Viereck 
        Color c1 = Color.RED; 
        int argb1 = c1.getRGB(); 
        Object data1 = model.getDataElements(argb1, null); 
        
        //inneres Viereck
        Color c2 = Color.YELLOW; 
        int argb2 = c2.getRGB(); 
        Object data2 = model.getDataElements(argb2, null); 
        
        
        for (int i = 0; i < width; i++) { 
            for (int j = 0; j < height; j++) { 
                raster.setDataElements(i, j, data1); //mit data1 �bergebe ich in diesem Fall nur die Farbe
                if(i>50 && i<150 && j>50 && j<150){ 
                    raster.setDataElements(i, j, data2); 
                } 
            } 
        } 
        
        

        
        
        
        
    } 

    public static void main(String args[]) { 
       ManipulateImage abc =  new ManipulateImage();
       JFileChooser x = new JFileChooser();
       x.showOpenDialog(x);
      
       abc.processImage(x.getSelectedFile().getAbsolutePath());
       
       abc.makeImage();
       
       
       
    } 
} 
