package uiv6;

public class UserProfile {
	private int userId;
	private int profileId;

	private double bmi;
	private double bmr;
	private int dailyCalories;
	private int dailyCarbs;
	private int dailyProtein;
	private int dailyFats;

	// parameterized constructors

	public UserProfile(int userId, double bmi, double bmr, int dailyCalories, int dailyCarbs, int dailyProtein,
			int dailyFats) {
		this.userId = userId;
		this.bmi = bmi;
		this.bmr = bmr;
		this.dailyCalories = dailyCalories;
		this.dailyCarbs = dailyCarbs;
		this.dailyProtein = dailyProtein;
		this.dailyFats = dailyFats;
	}

	// getters and setters

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	public double getBmr() {
		return bmr;
	}

	public void setBmr(double bmr) {
		this.bmr = bmr;
	}

	public int getDailyCalories() {
		return dailyCalories;
	}

	public void setDailyCalories(int dailyCalories) {
		this.dailyCalories = dailyCalories;
	}

	public int getDailyCarbs() {
		return dailyCarbs;
	}

	public void setDailyCarbs(int dailyCarbs) {
		this.dailyCarbs = dailyCarbs;
	}

	public int getDailyProtein() {
		return dailyProtein;
	}

	public void setDailyProtein(int dailyProtein) {
		this.dailyProtein = dailyProtein;
	}

	public int getDailyFats() {
		return dailyFats;
	}

	public void setDailyFats(int dailyFats) {
		this.dailyFats = dailyFats;
	}

}
