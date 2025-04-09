package uiv6;


public class MacroCalculator {
	// This method calculates bmr, bmi, calories and macros for data inserted by
	// user
	public MacroResult calculate(User user, String formula, String dietType, String goal) {

		double bmr;

		if ("Harris-Benedict".equals(formula)) { // Harris-Benedict formula

			if ("Male".equals(user.getGender())) { // for male
				bmr = 88.362 + (13.397 * user.getWeight()) + (4.799 * user.getHeight()) - (5.677 * user.getAge());
			}

			else { // for female
				bmr = 447.593 + (9.247 * user.getWeight()) + (3.098 * user.getHeight()) - (4.330 * user.getAge());
			}

		} else { // Default set to Mifflin-St Jeor formula
			// formula for both male and female
			bmr = (10 * user.getWeight()) + (6.25 * user.getHeight()) - (5 * user.getAge());

			// Add 5 for men, subtract 161 for women
			bmr += "Male".equals(user.getGender()) ? 5 : -161;
		}

		// adjusting bmr based on how active the user is
		double activityMultiplier = switch (user.getActivityLevel()) {
		case "Normal" -> 1.2; // low activity
		case "Moderate" -> 1.55; // medium activity
		case "Active" -> 1.725; // high activity
		default -> 1.2; // default to low if unknown
		};

		double calories = bmr * activityMultiplier;

		// for adjusting calories based on users goal
		calories = switch (goal) {
		case "Weight Loss" -> calories * 0.8; // 80% of calories to lose weight
		case "Muscle Gain" -> calories * 1.1; // 110% of calories to gain muscle
		case "Maintenance" -> calories; // calories the same to maintain
		default -> calories; // default to maintain

		};

		// calculating bmi (weight in kg / height converted to meters squared)
		double bmi = user.getWeight() / Math.pow(user.getHeight() / 100, 2);

		// setting percentages for protein, fat, and carbs based on diet type
		double proteinPercentage, fatPercentage, carbPercentage;
		switch (dietType) {
		case "Keto": // high fat and low carb diet
			proteinPercentage = 0.25; // 25% protein
			fatPercentage = 0.70; // 70% fat
			carbPercentage = 0.05; // 5% carbs
			break;

		case "Low Fat": // low fat and higher carbs
			proteinPercentage = 0.35; // 35% protein
			fatPercentage = 0.15; // 15% fat
			carbPercentage = 0.50; // 50% carbs
			break;

		case "Standard":
		default: // balanced diet
			proteinPercentage = 0.30; // 30% protein
			fatPercentage = 0.30; // 30% fat
			carbPercentage = 0.40; // 40% carbs
			break;
		}

		// calculates grams of protein, fat, and carbs
		double protein = (calories * proteinPercentage) / 4; // protein 4 cal per gram
		double fat = (calories * fatPercentage) / 9; // fat 9 cal per gram
		double carbs = (calories * carbPercentage) / 4; // carbs 4 cal per gram

		// returns all results in a MacroResult object

		return new MacroResult(calories, protein, carbs, fat, bmr, bmi);
	}
}