package rhinozelfantPackageObjektorientiert;


import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RhinozelfantImageClientTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File dateiBildRhinozelfant = new File("C:\\Users\\marzian\\Downloads\\rhinozelfant1.bmp");
		
		RhinozelfantImageClient asdf = new RhinozelfantImageClient(dateiBildRhinozelfant);
		asdf.doIt();
		
		ShowPicture BildNormal = new ShowPicture(ImageIO.read(dateiBildRhinozelfant));
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
				
		asdf.setLocation(600, 0);
		asdf.setSize(2000, 1000);
		panel.add(asdf);
		BildNormal.setLocation(0, 0);
		BildNormal.setSize(2000, 1000);
		panel.add(BildNormal);
		
		JFrame fenster = new JFrame();
		fenster.add(panel);
		
		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenster.setLocationRelativeTo(null);
		fenster.setSize(1000, 500);
		fenster.setExtendedState(JFrame.MAXIMIZED_BOTH);
		fenster.setVisible(true);
	}
	
}
