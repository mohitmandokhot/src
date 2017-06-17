import java.awt.EventQueue;

public class guiPlayer {
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		String readUser = "";
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					musicPlayerGUI window = new musicPlayerGUI();
					
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

}
