import java.util.Scanner;
import java.io.*;

public class TestMusicClass {

	public static void main(String[] args) {
		
		System.out.print("Enter a test filename: ");
		
		Scanner keyIn = new Scanner(System.in);
		File testFile = new File(keyIn.nextLine());
		
		try{
			Scanner fileInput = new Scanner(testFile);
			
			// Initialize a SimpleMusicTrack object
			SimpleMusicTrack myTrack = new SimpleMusicTrack();
			boolean correctRead = myTrack.getNextTrack(fileInput);
			if(!correctRead){
				System.out.println("File format not correct");
			}
			
			// Check if data has been fed.
			System.out.println(myTrack.toString());
			
			//Check other methods of the SimpleMusicTrack Class
			System.out.println(myTrack.getName());
			System.out.println(myTrack.getAlbum());
			System.out.println(myTrack.getArtist());
			
//			//Change Album name of the track
//			myTrack.setAlbum("I don't know");
//			
//			//Verify if change is made
//			System.out.println(myTrack.getName());
//			System.out.println(myTrack.getAlbum());
//			System.out.println(myTrack.getArtist());
			
		}
		catch(IOException e){
			System.out.println("FILE CANNOT BE FOUND");
		}
		
		

	}

}
