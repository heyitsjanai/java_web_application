package module2.src.com.gamingroom;


import java.util.ArrayList;
import java.util.List;


/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity{
	
	/**
	 * Hide the default constructor to prevent creating empty instances.
	 */
	private Game() {
	}
	
	//list of active teams
	private static List<Team> teams = new ArrayList<Team>();
	
	
	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
		this();
		this.id = id;
		this.name = name;
	}
	
	/*
	 * new Team constructor with name parameter
	 * iterates through Team list to make sure name
	 * is unique to list. If found, uses that instance.
	 * If not found, adds team to the Team list by name.
	 * 
	 * @returns team
	 */
	public Team addTeam(String name) {
		
		Team team = null;
		
		for(int i = 0; i < teams.size() - 1; i++) {
			
			if (teams.get(i).getName() == name) {
				team = teams.get(i);
			}
		}
		
		if (team == null) {
			
			GameService service = GameService.getInstance();
			
			team = new Team(service.getNextPlayerId(), name);
			teams.add(team);
		}
		
		return team;
	}
	
	
	@Override
	public String toString() {
		
		return "Game [id=" + id + ", name=" + name + "]";
	}

}
