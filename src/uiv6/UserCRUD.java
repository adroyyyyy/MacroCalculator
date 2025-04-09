package uiv6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserCRUD extends MyDatabase implements InfUserCRUD {

    @Override
    public User authenticator(String email, String password) {
        Connection conn = null;
        PreparedStatement pStat = null;
        ResultSet rs = null;
        String sqlQuery = "SELECT * FROM users WHERE email = ? AND uPassword = ?"; // SQL query to authenticate user

        try {
            conn = connect(); // Database connection
            if (conn == null) {
                System.out.println("Failed to connect to database");
                return null;
            }

            pStat = conn.prepareStatement(sqlQuery);
            pStat.setString(1, email); // Set email
            pStat.setString(2, password); // Set password
            rs = pStat.executeQuery(); // Execute the query

            if (rs.next()) { // Check if result exists
                User user = new User(rs.getInt("id"), rs.getString("email"), rs.getString("uPassword"));

                // Set up user details
                user.setName(rs.getString("uName"));
                user.setAge(rs.getInt("age"));
                user.setWeight(rs.getDouble("weight"));
                user.setHeight(rs.getDouble("height"));
                user.setGender(rs.getString("gender"));
                user.setActivityLevel(rs.getString("activity_level"));
                return user;
            }
        } catch (Exception ex) {
            System.out.println("Login Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (Exception ex) {
                }
            if (pStat != null)
                try {
                    pStat.close();
                } catch (Exception ex) {
                }
            close(conn);
        }
        return null;
    }

    @Override
    public User newUser(String name, String email, String password) {
        Connection conn = null;
        PreparedStatement pStat = null, checkStat = null;
        ResultSet rs = null, checkRs = null;
        User user = null;
        String checkQuery = "SELECT email FROM users WHERE email = ?"; // SQL query to check if email exists
        String insertQuery = "INSERT INTO users (uName, email, uPassword) VALUES (?, ?, ?)"; // SQL query to insert new user

        try {
            conn = connect();
            if (conn == null) {
                System.out.println("Failed to connect to database");
                return null;
            }

            // Check if email already exists
            checkStat = conn.prepareStatement(checkQuery);
            checkStat.setString(1, email);
            checkRs = checkStat.executeQuery();

            if (checkRs.next()) {
                System.out.println("Email '" + email + "' already exists in the database!");
                return null;
            } else {
                System.out.println("Email '" + email + "' not found, proceeding with insertion.");
            }

            pStat = conn.prepareStatement(insertQuery, new String[] { "id" });
            pStat.setString(1, name);
            pStat.setString(2, email);
            pStat.setString(3, password);
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
            }
        } catch (Exception ex) {
            System.out.println("Unexpected Registration Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            if (checkRs != null)
                try {
                    checkRs.close();
                } catch (Exception e) {
                }
            if (checkStat != null)
                try {
                    checkStat.close();
                } catch (Exception e) {
                }
            if (rs != null)
                try {
                    rs.close();
                } catch (Exception e) {
                }
            if (pStat != null)
                try {
                    pStat.close();
                } catch (Exception e) {
                }
            close(conn);
        }
        if (user == null) {
            System.out.println("Returning null - user creation failed for email: " + email);
        } else {
            System.out.println("Returning user - successfully created: " + user.getEmail());
        }
        return user;
    }

    @Override
    public void saveProfile(UserProfile profile) {
        Connection conn = null;
        PreparedStatement pStat = null;
        ResultSet rs = null;
        String sqlQuery = "INSERT INTO user_profile (userId, bmi, bmr, dailyCalories, dailyCarbs, dailyProtein, dailyFats) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?)"; // SQL query to save profile

        try {
            conn = connect();
            if (conn == null) {
                System.out.println("Failed to connect to database");
                return;
            }
            pStat = conn.prepareStatement(sqlQuery, new String[] { "profileId" });
            pStat.setInt(1, profile.getUserId());
            pStat.setDouble(2, profile.getBmi());
            pStat.setDouble(3, profile.getBmr());
            pStat.setInt(4, profile.getDailyCalories());
            pStat.setInt(5, profile.getDailyCarbs());
            pStat.setInt(6, profile.getDailyProtein());
            pStat.setInt(7, profile.getDailyFats());
            int rowsAffected = pStat.executeUpdate();
            System.out.println("Rows affected by profile insert: " + rowsAffected);

            rs = pStat.getGeneratedKeys();
            if (rs.next()) {
                profile.setProfileId(rs.getInt(1));
                System.out.println("Profile saved with ID: " + profile.getProfileId());
            }
        } catch (Exception ex) {
            System.out.println("Error saving user profile: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (Exception ex) {
                }
            if (pStat != null)
                try {
                    pStat.close();
                } catch (Exception ex) {
                }
            close(conn);
        }
    }

    @Override
    public List<UserProfile> viewProfile(int userId) {
        Connection conn = null;
        PreparedStatement pStat = null;
        ResultSet rs = null;
        List<UserProfile> profiles = new ArrayList<>();
        String sqlQuery = "SELECT * FROM user_profile WHERE userId = ? ORDER BY profileId DESC"; // SQL query to view profiles

        try {
            conn = connect();
            if (conn == null) {
                System.out.println("Failed to connect to database");
                return profiles; // Return empty list if connection fails
            }
            pStat = conn.prepareStatement(sqlQuery);
            pStat.setInt(1, userId);
            rs = pStat.executeQuery();

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
            ex.printStackTrace();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (Exception ex) {
                }
            if (pStat != null)
                try {
                    pStat.close();
                } catch (Exception ex) {
                }
            close(conn);
        }
        return profiles;
    }

    @Override
    public void updateUser(User user) {
        Connection conn = null;
        PreparedStatement pStat = null;
        String sqlQuery = "UPDATE users SET age = ?, weight = ?, height = ?, gender = ?, activity_level = ? WHERE id = ?"; // SQL query to update user

        try {
            conn = connect();
            if (conn == null) {
                System.out.println("Failed to connect to database");
                return;
            }

            pStat = conn.prepareStatement(sqlQuery);
            pStat.setInt(1, user.getAge());
            pStat.setDouble(2, user.getWeight());
            pStat.setDouble(3, user.getHeight());
            pStat.setString(4, user.getGender());
            pStat.setString(5, user.getActivityLevel());
            pStat.setInt(6, user.getId());

            int rowsAffected = pStat.executeUpdate();
            System.out.println("Rows affected by update: " + rowsAffected);

        } catch (Exception ex) {
            System.out.println("Error updating user: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            if (pStat != null) {
                try {
                    pStat.close();
                } catch (Exception ex) {
                }
            }
            close(conn);
        }
    }
}