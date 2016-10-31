package rhinozelfantPackageObjektorientiert;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;


public class RhinozelfantImage {
	
	private BufferedImage image;
	
	public RhinozelfantImage() {
		// TODO Auto-generated constructor stub				
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage inputImage) {
		this.image = inputImage;
		
	}
	
	public void processImage(){
		int [][][] imageRGB; 
        ColorModel model;
        WritableRaster rasterNeu;
             	
		model = image.getColorModel();             
        WritableRaster raster = image.getRaster();
        rasterNeu = image.getRaster();            
        imageRGB = new int [image.getWidth()][image.getHeight()][3]; 
        imageRGB = fillArray(raster, imageRGB, model);            
        rasterNeu = scanArray(raster,imageRGB, model,rasterNeu ); 
	}
	
	
	private static int[][][] fillArray(WritableRaster raster, int[][][] imageRGB, ColorModel model){
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
	
	

	private static WritableRaster scanArray (WritableRaster raster, int [][][] imageRGB, ColorModel model,WritableRaster rasterNeu)
	{
		int i;
		int j;
		
		for(j = 0; j< raster.getHeight()-1; j+=2)
        {
        	for(i =0; i < raster.getWidth()-1; i++){        		
        		//Pixel rechts daneben gleich ?
        		if	(	
        				(
	        				(
        						(imageRGB[i][j][0] == imageRGB[i+1][j][0])
        						&&
        						(imageRGB[i][j][1] == imageRGB[i+1][j][1])
        						&&
        						(imageRGB[i][j][2] == imageRGB[i+1][j][2])  //rechts
	        				)
	        				||
	        				(
        						(imageRGB[i][j][0] == imageRGB[i][j+1][0])
		        				&&
		        				(imageRGB[i][j][1] == imageRGB[i][j+1][1])
		        				&&
		        				(imageRGB[i][j][2] == imageRGB[i][j+1][2])
	        				)//unten
	        				||
	        				(
		        				(imageRGB[i][j][0] == imageRGB[i+1][j+1][0])
		        				&&
		        				(imageRGB[i][j][1] == imageRGB[i+1][j+1][1])
		        				&&
		        				(imageRGB[i][j][2] == imageRGB[i+1][j+1][2])//diagonal rechts unten
	        				)
        				)
        				
        				
        			)
        				
        		{     			
        			einfaerben(new Color(255, 255, 255),
	        					rasterNeu,
	        					model,
	        					i,
	        					j);

	        		
        		}else{
        			einfaerben(new Color(imageRGB[i][j][0], imageRGB[i][j][1], imageRGB[i][j][2]), 
        						rasterNeu,
        						model,
        						i,
        						j);
        		
        		}            		
            }        	 
        }
		
		return rasterNeu;
	}
	
	private static void einfaerben(Color ColorObj, WritableRaster rasterObj, ColorModel cm, int x, int y){
		Object DataNeu;
		DataNeu = cm.getDataElements(ColorObj.getRGB(), null);   
		rasterObj.setDataElements(x, y, DataNeu);//der aktuelle Pixel im neuen Raster wird weiï¿½ gefï¿½rbt
	}

}
