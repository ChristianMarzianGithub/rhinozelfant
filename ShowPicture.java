package rhinozelfantPackageObjektorientiert;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class ShowPicture extends JPanel {
	
	BufferedImage img;
	
	public ShowPicture(BufferedImage bild) {
		// TODO Auto-generated constructor stub
		this.img = bild;
				
	}
	
	public void paintComponent(Graphics g){		
		g.drawImage(img,0,0,null);
	}
	
	
	
	
	
	
	
	
	
	
	public BufferedImage getImg(){
		return img;
	}
}
