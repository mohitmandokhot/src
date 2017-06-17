import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class graphicPlayer {

	/*
	 * @version 1.0
	 * Load data from file. Display loaded tracks as output
	 */



	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					musicPlayerGUI window = new musicPlayerGUI();
					window.setFrameView();
					


					//Load data from file when button is pressed. 

					window.getData.addMouseListener(new MouseAdapter() {

						String fname = "";
						
						PlayList mySongs;

						@Override
						public void mouseClicked(MouseEvent e) {
							
							
							
							//Default initialization of PlayList as a SimplePlayList.
							//User selects the correct kind of playList.
							if(window.basicRadioButton.isSelected()){
								mySongs = new SimplePlayList();
							}
							else if(window.stackRadioButton.isSelected()){
								mySongs = new PlayListStack();
							}
							else if(window.queueRadioButton.isSelected()){
								mySongs = new PlayListQueue();
							}
							

							
							window.loadDataProceed();
							fname = window.getUserText();

							try{
								File songFile = new File(fname);
								Scanner fileIn = new Scanner(songFile);

								// Read songs from fileIn and store each item as a song. 
								// Read song from file and assign to song object
								// The song object is refreshed inside of the loop. This allows the correct pointing of data and adding to the right variables. 
								while(fileIn.hasNextLine()){
									SimpleMusicTrack song = new SimpleMusicTrack();
									song.getNextTrack(fileIn);
									mySongs.addTrack(song);
								}
								
								window.setTextExternal("Data Read. HIT BUTTON TO DISPLAY");
								
								// Event Handler for PLAY BUTTON
								window.displayData.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										
										if(!mySongs.isEmpty()){
											// Initialize display objects
											SimpleMusicTrack currentSong = new SimpleMusicTrack();
											SimpleMusicTrack nextSong = (SimpleMusicTrack) mySongs.peekAtNextTrack();

											//Display in output window

											String output = "";

											currentSong = (SimpleMusicTrack) mySongs.getNextTrack();
											nextSong = (SimpleMusicTrack) mySongs.peekAtNextTrack();

											output = currentSong + "\n" + nextSong;

											window.setTextExternal(output);
										}
										else{
											window.btnEND.doClick();
										}

										
									}
								});
								
								// Event Handler for END BUTTON
								window.btnEND.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent arg0) {
										
										int i = 1;
										
										String lineA = "Tracks remaining in play list" + "\n";
										String lineB = "----------------------------------------------------" + "\n";
										String lineC = "";
										
										if(mySongs.isEmpty()){
											lineC = "No Songs Remaining";
										}
										
										while(!mySongs.isEmpty()){
											SimpleMusicTrack remSong = (SimpleMusicTrack) mySongs.getNextTrack();
											lineC = lineC + i + " - " + remSong.toString() + "\n";
											i++;
										}
										
										String output = lineA + lineB + lineC;
										
										window.setTextExternal(output);
										
									}
								});

							}
							catch(IOException el){
								System.out.println("Error");
							}
						}
					});
					


				}			

				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
