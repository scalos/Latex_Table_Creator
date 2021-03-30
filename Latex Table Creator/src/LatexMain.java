import javax.swing.SwingUtilities;

public class LatexMain {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
		     @Override
		     public void run() {
		 		LatexScreen mainScreen = new LatexScreen("Latex Table Creator");
		 		mainScreen.makeMain();
		 		mainScreen.show();
		     }
		 });		
		
	}
}
