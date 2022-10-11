package via.friendBook;

import java.util.ArrayList;

public class friendViewModel {

	
	private ArrayList<Friend> Friends = new ArrayList<>();
	
	public ArrayList<Friend> getFriends() {
		return Friends;
	}
	
	public void setFriends (ArrayList<Friend> friends) {
		Friends = friends;
	}
	
	public void addFriends (Friend friend) {
		Friends.add(friend);
	}
	
	public void removeFriends(Friend friend) {
		Friends.remove(friend);
	}
	
	public int countFriends() {
		return Friends.size();
	}
}
