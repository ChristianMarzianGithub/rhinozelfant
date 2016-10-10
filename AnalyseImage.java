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
	static ColorModel model;
	static Object DataNeu;
	static WritableRaster rasterNeu;
	
	private static void doIt(){  
        JFileChooser fc = new JFileChooser();
        if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
        	File datei = new File(fc.getSelectedFile().getAbsolutePath());
    		try { 
                image = ImageIO.read(datei);                 
            } catch (IOException ex) {            
            	ex.printStackTrace();            
            }     		
    		
    		model = image.getColorModel();             
            WritableRaster raster = image.getRaster();
            rasterNeu = image.getRaster();            
            imageRGB = new int [image.getWidth()][image.getHeight()][3]; 
            
            //befülle array
            imageRGB = fillArray(raster);
            
            //durchsuche Array            
            rasterNeu = scanArray(raster);                        
            File outputFile = new File(fc.getCurrentDirectory() + "/asdf.jpg");
            try {
    			ImageIO.write(image, "jpg", outputFile);
    			System.out.println("Datei gespeichert unter \n" + fc.getCurrentDirectory() + "\\asdf.jpg");
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        }else{
        	System.out.println("Datei-Auswahl wurde vom Benutzer abgebrochen.");
        }        		
	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		doIt();
		
	}
	
	private static WritableRaster scanArray (WritableRaster raster){
		int i;
		int j;
		
		
		for(j = 0; j< raster.getHeight()-1; j++)
        {
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
		
		
		return rasterNeu;
	}
	
	
	private static int[][][] fillArray(WritableRaster raster){
		int j;
		int i;
		Object dataAlt;
		
		for(j = 0; j< raster.getHeight(); j++)
        {
        	for(i = 0; i < raster.getWidth(); i++)
        	{            		
                dataAlt = raster.getDataElements(i, j, null); 
                int argbAlt =  model.getRGB(dataAlt);
        		Color c = new Color(argbAlt, true);
        		
        		imageRGB[i][j][0] = c.getRed();
        		imageRGB[i][j][1] = c.getGreen();
        		imageRGB[i][j][2] = c.getBlue();            			 
            }        	 
        }		
		return imageRGB;
	}
	
	 
	
	private static int invertiere(int rgbValue){
		return 255 - rgbValue;
	}

}
