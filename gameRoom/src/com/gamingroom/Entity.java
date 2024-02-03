package module2.src.com.gamingroom;

/*
 * Parent class to hold inherited attributes
 * 
 * @author Janai Cano
 * Revised 9/17/22
 */
public class Entity {
	
	//inherited attributes
	protected long id;
	protected String name;
	
	//default constructor
	protected Entity() {
		
	}
	
	//constructor with id and name parameters
	public Entity(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	//return id method
	public long getId() {
		return id;
	}
	
	//return name method
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Entity [id = " + id + ", name = " + name + "]";
	}

}
