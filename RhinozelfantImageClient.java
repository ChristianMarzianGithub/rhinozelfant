package rhinozelfantPackageObjektorientiert;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class RhinozelfantImageClient extends JPanel {

	BufferedImage x;
	
	public RhinozelfantImageClient (){

		
	}
	
		
	public void doIt(){		
		RhinozelfantImage image = new RhinozelfantImage();
		JFileChooser fc = new JFileChooser();
		if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
			
			image.setImage(openImage(fc));	//wenn der Benutzer die Datei-Auswahl abbricht, sollte etwas passieren!
			image.processImage();			
			saveImage(image.getImage(),fc);	
			x = image.getImage();
		}else{
        	System.out.println("Datei-Auswahl wurde vom Benutzer abgebrochen.");
        } 		
	}
	
	public void paintComponent(Graphics g){
		
		g.drawImage(x,0,0,null);
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


