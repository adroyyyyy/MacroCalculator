<<<<<<< HEAD
package uiv3;
=======
package uiv6;
>>>>>>> first commit

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserCRUD extends MyDatabase implements InfUserCRUD {

    @Override
    public User authenticator(String email, String password) {
<<<<<<< HEAD
        Connection conn = null;
        PreparedStatement pStat = null;
        ResultSet rs = null;
        String sqlQuery = "SELECT * FROM users WHERE email = ? AND password = ?";

        try {
            conn = connect();
=======
        Connection conn = null; 
        PreparedStatement pStat = null; // for query
        ResultSet rs = null;
        String sqlQuery = "SELECT * FROM users WHERE email = ? AND password = ?"; // sql query

        try {
            conn = connect(); // database connection 
>>>>>>> first commit
            if (conn == null) {
                System.out.println("Failed to connect to database");
                return null;
            }
            
            pStat = conn.prepareStatement(sqlQuery);
<<<<<<< HEAD
            pStat.setString(1, email);
            pStat.setString(2, password);
            rs = pStat.executeQuery();
            if (rs.next()) { // Changed from while to if since email/password should be unique
                User user = new User(rs.getInt("id"), rs.getString("email"), rs.getString("password"));
=======
            pStat.setString(1, email);	// set email 
            pStat.setString(2, password);	// set password
            rs = pStat.executeQuery(); // executes the query 
            
            if (rs.next()) { // checking if result exists 
                User user = new User(rs.getInt("id"), rs.getString("email"), rs.getString("password"));
                
                // setting up user name, age, weight, height, gender, activity level
>>>>>>> first commit
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                user.setWeight(rs.getDouble("weight"));
                user.setHeight(rs.getDouble("height"));
                user.setGender(rs.getString("gender"));
                user.setActivityLevel(rs.getString("activity_level"));
                return user;
            }
<<<<<<< HEAD
        } catch (Exception ex) {
            System.out.println("Login Error: " + ex.getMessage());
            ex.printStackTrace(); // Added for better debugging
        } finally {
            if (rs != null) try { rs.close(); } catch (Exception e) {}
            if (pStat != null) try { pStat.close(); } catch (Exception e) {}
            close(conn);
=======
        } 
        catch (Exception ex) {
            System.out.println("Login Error: " + ex.getMessage()); // error message 
            ex.printStackTrace(); // gets detailed error
            
        } 
        finally {
            if (rs != null) 
            	try { 
            		rs.close(); // result set close
            		
            	} 
            
            catch (Exception ex) {}
            if (pStat != null) 
            	try { 
            		pStat.close(); // pStat close 
            		
            	}
            
            catch (Exception ex) {}
            close(conn); // close db connection
>>>>>>> first commit
        }
        return null;
    }
    
    @Override
    public User newUser(String name, String email, String password) {
        Connection conn = null;
<<<<<<< HEAD
        PreparedStatement pStat = null, checkStat = null;
        ResultSet rs = null, checkRs = null;
        User user = null;
        String sqlQuery = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
=======
        PreparedStatement pStat = null,  checkStat = null; // for checking email 
        ResultSet rs = null, checkRs = null;
        User user = null;
        String sqlQuery = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)"; // insert SQL query 
>>>>>>> first commit

        try {
            conn = connect();
            if (conn == null) {
                System.out.println("Failed to connect to database");
                return null;
            }

<<<<<<< HEAD
            // Check if email already exists
            checkStat = conn.prepareStatement("SELECT email FROM users WHERE email = ?");
            checkStat.setString(1, email);
            checkRs = checkStat.executeQuery();
            
            if (checkRs.next()) {
                System.out.println("Email already exists!");
                return null; // Email already exists
=======
            // check if email already exists
            checkStat = conn.prepareStatement("SELECT email FROM users WHERE email = ?"); 
            checkStat.setString(1, email);
            checkRs = checkStat.executeQuery(); // executing the SQL query to check email in users table
            
            if (checkRs.next()) {
                System.out.println("Email '" + email + "' already exists in the database!");
                return null; // email already exists
                
            } else {
                System.out.println("Email '" + email + "' not found, proceeding with insertion.");
>>>>>>> first commit
            }

            pStat = conn.prepareStatement(sqlQuery, new String[]{"id"});
            pStat.setString(1, name); 
            pStat.setString(2, email);
            pStat.setString(3, password);
<<<<<<< HEAD
            pStat.executeUpdate();
            rs = pStat.getGeneratedKeys();
            if (rs.next()) {
                user = new User(rs.getInt("id"), email, password);
                user.setName(name);
=======
            int rowsAffected = pStat.executeUpdate();
            
            System.out.println("Rows affected by insert: " + rowsAffected);

            rs = pStat.getGeneratedKeys();
            if (rs.next()) {
                int generatedId = rs.getInt(1);
                System.out.println("New user created with ID: " + generatedId);
                user = new User(generatedId, email, password);
                user.setName(name);
            } else {
                System.out.println("No generated keys returned after insert!");
>>>>>>> first commit
            }
        } catch (Exception ex) {
            System.out.println("Unexpected Registration Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
<<<<<<< HEAD
            if (checkRs != null) try { checkRs.close(); } catch (Exception e) {}
            if (checkStat != null) try { checkStat.close(); } catch (Exception e) {}
            if (rs != null) try { rs.close(); } catch (Exception e) {}
            if (pStat != null) try { pStat.close(); } catch (Exception e) {}
            close(conn);
        }
        return user; // Moved outside try-catch to ensure return in all cases
=======
            if (checkRs != null) 
            	try { 
            		checkRs.close(); 
            		} 
            
            	catch (Exception e) {}
            if (checkStat != null) 
            	try { 
            		checkStat.close();
            		} 
            	catch (Exception e) {}
            if (rs != null) 
            	try { 
            		rs.close();
            	} 
            
            	catch (Exception e) {}
            
            if (pStat != null) 
            	try {
            		pStat.close(); 
            		}
            	catch (Exception e) {}
            close(conn); // closing connection 
        }
        if (user == null) {
            System.out.println("Returning null - user creation failed for email: " + email);
        } else {
            System.out.println("Returning user - successfully created: " + user.getEmail());
        }
        return user;
>>>>>>> first commit
    }

    @Override
    public void saveProfile(UserProfile profile) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = connect();
            if (conn == null) {
                System.out.println("Failed to connect to database");
                return;
            }
            stmt = conn.prepareStatement(
                "INSERT INTO user_profile (userId, bmi, bmr, dailyCalories, dailyCarbs, dailyProtein, dailyFats) VALUES (?, ?, ?, ?, ?, ?, ?)",
                new String[]{"profileId"}
            );
            stmt.setInt(1, profile.getUserId());
            stmt.setDouble(2, profile.getBmi());
            stmt.setDouble(3, profile.getBmr());
            stmt.setInt(4, profile.getDailyCalories());
            stmt.setInt(5, profile.getDailyCarbs());
            stmt.setInt(6, profile.getDailyProtein());
            stmt.setInt(7, profile.getDailyFats());
            stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
<<<<<<< HEAD
                profile.setProfileId(rs.getInt(1)); // Set the generated profileId
            }
        } catch (Exception ex) {
            System.out.println("Error saving user profile: " + ex.getMessage());
            ex.printStackTrace(); // Added for better debugging
        } finally {
            if (rs != null) try { rs.close(); } catch (Exception ex) {}
            if (stmt != null) try { stmt.close(); } catch (Exception ex) {}
=======
                profile.setProfileId(rs.getInt(1));
            }
        } catch (Exception ex) {
            System.out.println("Error saving user profile: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            if (rs != null) 
            	try { rs.close(); 
            	
            	} 
            	catch (Exception ex) {}
            
            if (stmt != null) 
            	try {
            		stmt.close();
            	}
            	catch (Exception ex) {}
            
>>>>>>> first commit
            close(conn);
        }
    }

    @Override
    public List viewProfile(int userId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
<<<<<<< HEAD
        List<UserProfile> profiles = new ArrayList<>();
=======
        List<UserProfile> profiles = new ArrayList<>(); // to store users profiles
>>>>>>> first commit
        try {
            conn = connect();
            if (conn == null) {
                System.out.println("Failed to connect to database");
<<<<<<< HEAD
                return profiles; // Return empty list if connection fails
=======
                return profiles; // return empty list if connection fails
>>>>>>> first commit
            }
            stmt = conn.prepareStatement("SELECT * FROM user_profile WHERE userId = ? ORDER BY profileId DESC");
            stmt.setInt(1, userId);
            rs = stmt.executeQuery();
            while (rs.next()) {
                UserProfile profile = new UserProfile(
                    rs.getInt("userId"),
                    rs.getDouble("bmi"),
                    rs.getDouble("bmr"),
                    rs.getInt("dailyCalories"),
                    rs.getInt("dailyCarbs"),
                    rs.getInt("dailyProtein"),
                    rs.getInt("dailyFats")
                );
                profile.setProfileId(rs.getInt("profileId"));
                profiles.add(profile);
            }
        } catch (Exception ex) {
            System.out.println("Error viewing user profile: " + ex.getMessage());
<<<<<<< HEAD
            ex.printStackTrace(); // Added for better debugging
        } finally {
            if (rs != null) try { rs.close(); } catch (Exception ex) {}
            if (stmt != null) try { stmt.close(); } catch (Exception ex) {}
            close(conn);
        }
        return profiles;
    }

	@Override
	public void saveProfile(uiv4_AI.UserProfile profile) {
		// TODO Auto-generated method stub
		
	}
=======
            ex.printStackTrace(); // gets detailed error message 
            
        } 
        
        return profiles;
    }

>>>>>>> first commit
}