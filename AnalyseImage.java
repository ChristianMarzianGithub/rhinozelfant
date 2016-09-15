package beispiel;


import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

public class AnalyseImage {

	static BufferedImage image;
	
	private static void doIt(){
		
		JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(null);
		
		File datei = new File(fc.getSelectedFile().getAbsolutePath());

		
		
		try { 
            image = ImageIO.read(datei); 
            
            
        } catch (IOException ex) { 
            ex.printStackTrace(); 
        } 
		
		ColorModel model = image.getColorModel(); 
        
        WritableRaster raster = image.getRaster();
        Object dataAlt = raster.getDataElements(0, 0, null); 
        int argbAlt =  model.getRGB(dataAlt);
		Color c = new Color(argbAlt, true); 
		System.out.println("R: " + c.getRed() );
		System.out.println("G: " + c.getGreen() );
		System.out.println("B: " + c.getBlue() );
		
		
		
		
		
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		doIt();


		
		
		
		
	}

}
