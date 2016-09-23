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
		int j = 0;
        int i = 0;
        
        int RNeu = 0;
        int GNeu = 0;
        int BNeu = 0;
        
        int FarbRaum = 255;
        
        int ARGBNeu;
        Object DataNeu;
		
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
        WritableRaster rasterNeu = image.getRaster();
        
        Object dataAlt;
        
        for(j = 0; j< raster.getHeight(); j++){
        	for(i = 0; i < raster.getWidth(); i++){
        		
                dataAlt = raster.getDataElements(i, j, null); 
                int argbAlt =  model.getRGB(dataAlt);
        		Color c = new Color(argbAlt, true); 
        		System.out.println("Koordinaten: x=" + i + " y=" + j);
        		System.out.println("R: " + c.getRed() );
        		System.out.println("G: " + c.getGreen() );
        		System.out.println("B: " + c.getBlue() );
        		System.out.println("---------------------------------");
        		System.out.println(" ");
                		
        		RNeu = invertiere(c.getRed());
        		GNeu = invertiere(c.getGreen());
        		BNeu = invertiere(c.getBlue());
        		
        		Color cNeu = new Color(RNeu, GNeu, BNeu);        	
        		DataNeu = model.getDataElements(cNeu.getRGB(), null);
        		
        		rasterNeu.setDataElements(i, j, DataNeu);        		 
            }        	 
        }
       
        File outputFile = new File(fc.getCurrentDirectory() + "/asdf.jpg");
        try {
			ImageIO.write(image, "jpg", outputFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		doIt();
		
	}
	
	private static int invertiere(int rgbValue){
		return 255 - rgbValue;
	}

}
