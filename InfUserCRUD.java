<<<<<<< HEAD
package uiv3;

import java.util.List;
import uiv4_AI.UserProfile;

public interface InfUserCRUD {
	
	public User authenticator(String email, String password);
	
	public User newUser(String  name, String email, String password);
	
	public void saveProfile(UserProfile profile);
	
	public List<UserProfile> viewProfile(int userId);

	void saveProfile(uiv3.UserProfile profile);
	

	/*
	 * public boolean insert(User user);
	public User search(String email);
	public User search1(String password);
	public boolean update(User user);
	public boolean delete(User user);
	 */
}
=======
package uiv6;

import java.util.List;

public interface InfUserCRUD {
    public User authenticator(String email, String password);
    public User newUser(String name, String email, String password);
    public void saveProfile(UserProfile profile); 
    public List<UserProfile> viewProfile(int userId);
}
>>>>>>> first commit
