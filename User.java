<<<<<<< HEAD
package uiv3;
=======
package uiv6;
>>>>>>> first commit

public class User {
    private int id;
    private String email;
    private String password;
    private String name;
    private String gender;
    private String activityLevel;
    private int age;
    private double weight;
    private double height;
    private String fitnessGoal; // Added for PrevCalcWindow

    public User(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
    
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public User(double height, double weight, int age, String gender, String activityLevel) {
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.gender = gender;
        this.activityLevel = activityLevel;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getActivityLevel() {
        return activityLevel;
    }
    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public String getFitnessGoal() {
        return fitnessGoal;
    }
    public void setFitnessGoal(String fitnessGoal) {
        this.fitnessGoal = fitnessGoal;
    }
    
<<<<<<< HEAD
    /*
    // Save user data and fitness goal to a Properties file
    public void saveProfile(String fitnessGoal) {
        Properties props = new Properties();
        props.setProperty("height", String.valueOf(height));
        props.setProperty("weight", String.valueOf(weight));
        props.setProperty("age", String.valueOf(age));
        props.setProperty("gender", gender);
        props.setProperty("activityLevel", activityLevel);
        props.setProperty("fitnessGoal", fitnessGoal);

        try (FileOutputStream fos = new FileOutputStream("user_profile.properties")) {
            props.store(fos, "User Profile Data");
        } catch (IOException e) {
            System.err.println("Error saving profile: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Load user data from a Properties file
    public static User loadProfile() {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("user_profile.properties")) {
            props.load(fis);
            double height = Double.parseDouble(props.getProperty("height", "0"));
            double weight = Double.parseDouble(props.getProperty("weight", "0"));
            int age = Integer.parseInt(props.getProperty("age", "0"));
            String gender = props.getProperty("gender", "");
            String activityLevel = props.getProperty("activityLevel", "");
            return new User(height, weight, age, gender, activityLevel);
        } catch (IOException e) {
            System.err.println("Error loading profile: " + e.getMessage());
            return null; // Return null if loading fails
        }
    }

    // Load fitness goal from the Properties file
    public static String loadFitnessGoal() {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("user_profile.properties")) {
            props.load(fis);
            return props.getProperty("fitnessGoal", "");
        } catch (IOException e) {
            System.err.println("Error loading fitness goal: " + e.getMessage());
            return "";
        }
    }
    */
=======
    

>>>>>>> first commit
}