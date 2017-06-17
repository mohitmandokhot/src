import java.util.Scanner;

public class SimpleMusicTrack implements PlayListTrack {
	
	private String trackName;
	private String artistName;
	private String albumName;
	
	public SimpleMusicTrack(){
		this.trackName = "";
		this.artistName = "";
		this.albumName = "";
	}
	
	// Implemented methods from PlayListTrack Interface
	public String getName(){
		return this.trackName;
	}
	
	public void setName(String name){
		this.trackName = name;
	}
	
	public String getArtist(){
		return this.artistName;
	}
	
	public void setArtist(String artist){
		this.artistName = artist;
	}
	
	public String getAlbum(){
		return this.albumName;
	}
	
	public void setAlbum(String album){
		this.albumName = album;
	}
	
	public void refreshTrack(){
		this.trackName = "";
		this.artistName = "";
		this.albumName = "";
	}
	
	public boolean getNextTrack(Scanner infile){
		// Attempts to read a playlist track entry from a Scanner object
		// Sets the values in the object to the values given in
		// the file
		// If it successfully loads the track, return true
		// otherwise, return false
		
		boolean trackLoaded = false;
		int line = 1;

			while(line <= 3){
				if(line == 1){
					String read = infile.nextLine();
//					System.out.println(read);
					setName(read);
				}
				if(line == 2){
					setArtist(infile.nextLine());
				}
				if(line == 3){
					setAlbum(infile.nextLine());
					break;
				}
				line++;
			}
			if(line == 3){
				trackLoaded = true;
			}
			else{
				trackLoaded = false;
			}
		
		return trackLoaded;
	}
	
	@Override
	public boolean equals(Object obj){
		boolean isEqual = false;
		
		if(obj instanceof SimpleMusicTrack){
			
			SimpleMusicTrack checkTrack = (SimpleMusicTrack) obj;
			
			boolean trackCheck = this.trackName.equals(checkTrack.getName());
			boolean artistCheck = this.artistName.equals(checkTrack.getArtist());
			boolean albumCheck = this.albumName.equals(checkTrack.getAlbum());
			
			if(trackCheck && artistCheck && albumCheck){
				isEqual = true;
			}
		}
		return isEqual;
	}
	
	@Override
	public String toString(){
		String output = "";	
		output = "'" + this.artistName + "/ " + this.trackName + "'";
		if(output.equals("'/ '")){
			output = "No Song Playing";
		}
		return output;
	}

}
