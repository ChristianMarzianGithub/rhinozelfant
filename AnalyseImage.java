package rhizolefantPackage;


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
	
	static int [][][] imageRGB; 
	
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
        
        imageRGB = new int [image.getWidth()][image.getHeight()][3];
        
        
        //befülle array
        for(j = 0; j< raster.getHeight(); j++){
        	for(i = 0; i < raster.getWidth(); i++){
        		
                dataAlt = raster.getDataElements(i, j, null); 
                int argbAlt =  model.getRGB(dataAlt);
        		Color c = new Color(argbAlt, true);
        		
        		imageRGB[i][j][0] = c.getRed();
        		imageRGB[i][j][1] = c.getGreen();
        		imageRGB[i][j][2] = c.getBlue();
        			 
            }        	 
        }
       
        
        //durchsuche Array
        for(j = 0; j< raster.getHeight()-1; j++){
        	for(i = 0; i < raster.getWidth()-1; i++){        		
        		//Pixel rechts daneben gleich ?
        		if(	
        				(imageRGB[i][j][0] == imageRGB[i+1][j][0])
        				&&
        				(imageRGB[i][j][1] == imageRGB[i+1][j][1])
        				&&
        				(imageRGB[i][j][2] == imageRGB[i+1][j][2])        				
        		  )
        		{
        			Color cNeu = new Color(255, 255, 255);        	
            		DataNeu = model.getDataElements(cNeu.getRGB(), null);
            		
            		rasterNeu.setDataElements(i, j, DataNeu);
        		}else if(
        				(imageRGB[i][j][0] == imageRGB[i][j+1][0])
        				&&
        				(imageRGB[i][j][1] == imageRGB[i][j+1][1])
        				&&
        				(imageRGB[i][j][2] == imageRGB[i][j+1][2])    
        				
        				
        				){
        			
        			Color cNeu = new Color(255, 255, 255);        	
            		DataNeu = model.getDataElements(cNeu.getRGB(), null);
            		
            		rasterNeu.setDataElements(i, j, DataNeu);
        			
        			
        			
        		}else{
        			Color cNeu = new Color(imageRGB[i][j][0], imageRGB[i][j][1], imageRGB[i][j][2]);        	
            		DataNeu = model.getDataElements(cNeu.getRGB(), null);
            		
            		rasterNeu.setDataElements(i, j, DataNeu);    
        			
        		}
        		
            }        	 
        }
        
        
        
		
        
		
		
		//Pixel darunter gleich ?
		//Pixel schräg darunter gleich ?
		
        
        
        File outputFile = new File(fc.getCurrentDirectory() + "/asdf.jpg");
        try {
			ImageIO.write(image, "jpg", outputFile);
			System.out.println("Datei gespeichert unter \n" + fc.getCurrentDirectory() + "/asdf.jpg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
        
        
        		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		doIt();
		
	}
	
	private static void fillArray(){
		
	}
	
	 
	
	private static int invertiere(int rgbValue){
		return 255 - rgbValue;
	}

}
