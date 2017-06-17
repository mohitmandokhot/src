import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;

/**
 * 
 */

/**
 * Program simulates a music player that plays tracks from a user selected data file. 
 * @author mandokhot.1
 * 
 * Faces two issues. 
 * The getNextTrack method of SimpleMusicTrack class does not work correctly for multi-song input
 * The Scanner FileIn needs to be modified to avoid reading the input file for the same lines of input
 * again. 
 *
 */
public class musicPlayer {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print("Enter filename: ");
		Scanner keyIn = new Scanner(System.in);
		
		String fname = keyIn.nextLine();
		
		try{
			
			File songFile = new File(fname);
			
			Scanner fileIn = new Scanner(songFile);
			
			//Default initialization of PlayList as a SimplePlayList. 
			PlayList mySongs = new SimplePlayList();
			
			// Ask user for their choice of playlist
			System.out.print("Do you want to add songs from file as a [S]tack or a [Q]ueue or default (P)?: ");
			String userOption = keyIn.nextLine();
			
			if(userOption.equalsIgnoreCase("Q")){
				// Create a new PlayList object as a Queue
				mySongs = new PlayListQueue();
			}
			else if (userOption.equalsIgnoreCase("S")){
				// Create a new PlayList object as a Queue
				mySongs = new PlayListStack();
			}
			else{
				//Do nothing continue with simpleplaylist type of object
			}
			
			// Read songs from fileIn and store each item as a song. 
			// Read song from file and assign to song object
			// The song object is refreshed inside of the loop. This allows the correct pointing of data and adding to the right variables. 
			while(fileIn.hasNextLine()){
				SimpleMusicTrack song = new SimpleMusicTrack();
				song.getNextTrack(fileIn);
				mySongs.addTrack(song);
			}
			
			
			// Initialize display objects
			SimpleMusicTrack currentSong = new SimpleMusicTrack();
			SimpleMusicTrack nextSong = (SimpleMusicTrack) mySongs.peekAtNextTrack();
			
			Scanner askChoice = new Scanner(System.in);
			String choice = "";
			
			//Print display and ask user for appropriate choices. 
			//Display new tracks or add tracks as appropriate
			while(!(mySongs.isEmpty()) && !choice.equalsIgnoreCase("Q")){
				
				System.out.println("Current song: " + currentSong.toString());
				System.out.println("Next song: " + nextSong.toString());
				
				System.out.println("[P]lay next track");
				System.out.println("[A]dd a new track");
				System.out.println("[Q]uit");
				System.out.print("> ");
				
				choice = askChoice.nextLine();
				
				//If user chooses to play
				
				if(choice.equalsIgnoreCase("P")){
					currentSong = (SimpleMusicTrack) mySongs.getNextTrack();
					nextSong = (SimpleMusicTrack) mySongs.peekAtNextTrack();
				}
				
				//If user chooses to add new song
				if(choice.equalsIgnoreCase("A")){
					System.out.println("Add a new song");
					SimpleMusicTrack newSong = new SimpleMusicTrack();
					
					Scanner keyInNewSong = new Scanner(System.in);
					
					System.out.print("New Track: ");
					newSong.setName(keyInNewSong.nextLine());
					System.out.print("Artist: ");
					newSong.setArtist(keyInNewSong.nextLine());
					System.out.print("Album: ");
					newSong.setAlbum(keyInNewSong.nextLine());
					
					System.out.print("Are you sure you want to add this track [y/n]? ");
					String ans = keyInNewSong.nextLine();
					
					if(ans.equalsIgnoreCase("y")){
						mySongs.addTrack(newSong);
					}
					
					else{
						choice = "P";
						System.out.println("");
					}
					
				}
			}
			
			//If user chooses to QUIT
			
			if(choice.equalsIgnoreCase("Q")){
				int i = 1;
				
				System.out.println();
				System.out.println("Tracks remaining in play list");
				System.out.println("----------------------------------------------------");
				
				if(mySongs.isEmpty()){
					System.out.println("No Songs Remaining");
				}
				
				while(!mySongs.isEmpty()){
					SimpleMusicTrack remSong = (SimpleMusicTrack) mySongs.getNextTrack();
					System.out.println(i + " - " + remSong.toString());
					i++;
				}

			}
			
			
			
			
		}
		catch(IOException e){
			System.out.println("File not found");
		}
	}

}
