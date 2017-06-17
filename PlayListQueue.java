import java.util.LinkedList;
import java.util.Queue;

/*
 * Implements the playlist as a Stack
 * This gives user an option to play the last song they added to the Playlist.
 * 
 */

public class PlayListQueue implements PlayList {
	
	private Queue<SimpleMusicTrack> myPlayList;
	
	public PlayListQueue(){
		this.myPlayList = new LinkedList<SimpleMusicTrack>();
	}
	
	public PlayListTrack getNextTrack(){
		PlayListTrack queuedTrack = this.myPlayList.remove();
		return queuedTrack;
	}
	
	public PlayListTrack peekAtNextTrack(){
		// Returns next entry to the caller, but leaves it in the list
		return this.myPlayList.peek();
	}
	
	public void addTrack(PlayListTrack track){
		// Adds this track to the playlist in the appropriate order
		SimpleMusicTrack newTrack = (SimpleMusicTrack) track;
		this.myPlayList.add(newTrack);
	}
	
	public boolean isEmpty(){
		// Returns true if the playlist is empty
		return this.myPlayList.isEmpty();
	}
	

}
