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
	String pfad;
	File datei;
	
	public RhinozelfantImageClient (File BildDatei){
		this.datei = BildDatei;
	}
	
		
	public void doIt() throws IOException{		
		RhinozelfantImage image = new RhinozelfantImage();
		JFileChooser fc = new JFileChooser();
		//if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){			
			image.setImage(ImageIO.read(datei) );	//wenn der Benutzer die Datei-Auswahl abbricht, sollte etwas passieren!
			image.processImage();			
			saveImage(image.getImage(),fc);	
			x = image.getImage();
			
//		}else{
//        	System.out.println("Datei-Auswahl wurde vom Benutzer abgebrochen.");
//        } 		
	}
	
	public void paintComponent(Graphics g){		
		int height = (int) (x.getHeight() * 0.5);
		int width = (int) (x.getWidth() * 0.5);
		g.drawImage(x, 0, 0, width, height, null);
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


