package rhinozelfantPackageObjektorientiert;


import javax.swing.JFrame;


public class RhinozelfantImageClientTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RhinozelfantImageClient asdf = new RhinozelfantImageClient();
		asdf.doIt();
		JFrame fenster = new JFrame();
		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenster.setLocationRelativeTo(null);
		
		fenster.add(asdf);
		fenster.setSize(1000, 500);
		fenster.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
			
		
		fenster.setVisible(true);
		

	}
	
}
