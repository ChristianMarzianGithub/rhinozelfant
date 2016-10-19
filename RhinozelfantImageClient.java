package rhinozelfantPackageObjektorientiert;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

public class RhinozelfantImageClient {

	public RhinozelfantImageClient (){
		
	}
	
	public void doIt(){		
		RhinozelfantImage image = new RhinozelfantImage();
		JFileChooser fc = new JFileChooser();
		if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
			image.setImage(openImage(fc));
			image.processImage();			
			saveImage(image.getImage(),fc);
		}else{
        	System.out.println("Datei-Auswahl wurde vom Benutzer abgebrochen.");
        } 
	}
	
	private static BufferedImage openImage(JFileChooser fc){
		BufferedImage  imageRes = null;	
		
		File datei = new File(fc.getSelectedFile().getAbsolutePath());
		try { 
			imageRes = ImageIO.read(datei);                 
        } catch (IOException ex) {            
        	ex.printStackTrace();            
        }   
		
		return imageRes;
	}
	
	private static void saveImage(BufferedImage imageWork ,JFileChooser fc){
		File outputFile = new File(fc.getCurrentDirectory() + "/asdf.jpg");
        try {
			ImageIO.write(imageWork, "jpg", outputFile);
			System.out.println("Datei gespeichert unter \n" + fc.getCurrentDirectory() + "\\asdf.jpg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
