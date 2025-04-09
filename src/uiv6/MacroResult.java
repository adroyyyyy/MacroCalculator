package uiv6;

public class MacroResult {

	private double calories, protein, carbs, fat, bmr, bmi;

	// Parameterized Constructor

	public MacroResult(double calories, double protein, double carbs, double fat, double bmr, double bmi) {
		this.calories = calories;
		this.protein = protein;
		this.carbs = carbs;
		this.fat = fat;
		this.bmr = bmr;
		this.bmi = bmi;
	}

	// Setters
	public void setCalories(double calories) {
		this.calories = calories;
	}

	public void setProtein(double protein) {
		this.protein = protein;
	}

	public void setCarbs(double carbs) {
		this.carbs = carbs;
	}

	public void setFat(double fat) {
		this.fat = fat;
	}

	public void setBmr(double bmr) {
		this.bmr = bmr;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	// Getters

	public double getCalories() {
		return calories;
	}

	public double getProtein() {
		return protein;
	}

	public double getCarbs() {
		return carbs;
	}

	public double getFat() {
		return fat;
	}

	public double getBmr() {
		return bmr;
	}

	public double getBmi() {
		return bmi;
	}

}