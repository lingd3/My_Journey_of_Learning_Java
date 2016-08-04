import java.util.*;

public class Player {
	public int ID;
	public String name;
	public List<String> hasPoker;
	
	public Player() {
		this.ID = 0;
		this.name = "";
	}
	
	public Player(int id, String name) {
		this.ID = id;
		this.name = name;
		hasPoker = new ArrayList<String>();
	}

	public void addPoker(String p) {
		hasPoker.add(p);
	}
	
	
	
}
