package backend;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
	
	private static UserRepository instance = new UserRepository();

	public static UserRepository getInstance() {
		return instance;
	}
	
	private Map<String, User> users = new HashMap<>();
	
	public void add(User u) {
		users.put(u.getUsername(), u);
	}
	
	private UserRepository() {
		add(new User("admin","admin","admin","admin"));
		add(new User("user1","pw","Luca","Verdi"));
	}
	
	public User getUser(String username) {
		return users.get(username);
	}

	public User getUser(String username, String password) {
		User u = getUser(username);
		return (u!=null && u.getPassword().equals(password)) ? u : null;
	}

}
