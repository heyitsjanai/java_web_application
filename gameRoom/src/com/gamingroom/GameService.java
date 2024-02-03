package module2.src.com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/**
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;
	
	private static long nextTeamId = 1;
	
	private static long nextPlayerId = 1;

	//singleton object
	private static GameService newGame = null;
	
	/**
	 * Private constructor which will
	 * prevent more than one instance of a GameService object
	 */
	private GameService() {
		
	}
	/**
	 * Checks if an existing GameService instance
	 * already exists. If it does, returns that instance.
	 * If not, creates a new instance
	 */
	public static GameService getInstance() {
		if(newGame == null) {
			newGame = new GameService();
		}
		return newGame;
	}
	
	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {
		//local instance
		Game game = getGame(name);
		//checks for existing game name. If found, returns existing instance
		// if not found, makes a new instance & adds to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		} 
		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		//iterator to look for existing game with same id
		// if found, simply assign that instance to the local variable
		for (int i = 0; i < getGameCount(); i++) {
			if (games.get(i).getId() == id) {
				game = games.get(i);
			}
		}

		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		// iterator to look for existing game with same name
		// if found, simply assign that instance to the local variable
		for (int i = 0; i < getGameCount(); i++) {
			if (games.get(i).getName() == name) {
				game = games.get(i);
			}
		}

		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
	
	/*
	 * returns id of next team in Team list
	 * adds 1 to next value to iterate through list
	 */
	public long getNextTeamId() {
		
		return nextTeamId++;
	}
	
	/*
	 * returns id of next Player in Players list
	 * adds 1 to next value to iterate through list
	 */
	public long getNextPlayerId() {
		
		return nextPlayerId++;
	}
}
	
	
