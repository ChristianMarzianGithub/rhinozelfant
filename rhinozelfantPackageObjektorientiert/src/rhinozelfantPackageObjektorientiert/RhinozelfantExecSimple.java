package rhinozelfantPackageObjektorientiert;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

public class RhinozelfantExecSimple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(null);
		File dateiBildRhinozelfant = new File(fc.getSelectedFile().getAbsolutePath());
		
		RhinozelfantImage img = new RhinozelfantImage();
		
		try {
			img.setImage(ImageIO.read(dateiBildRhinozelfant));
			img.processImage();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		File outputFile = new File(fc.getCurrentDirectory() + "/asdf.jpg");
        try {
			ImageIO.write(img.getImage(), "jpg", outputFile);
			System.out.println("Datei gespeichert  asdf unter \n" + fc.getCurrentDirectory() + "\\asdf.jpg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
