package uiv6;

import java.util.List;

public interface InfUserCRUD {
	public User authenticator(String email, String password);

	public User newUser(String name, String email, String password);

	public void saveProfile(UserProfile profile);

	public List<UserProfile> viewProfile(int userId);

	public void updateUser(User user);
}


