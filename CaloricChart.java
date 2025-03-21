<<<<<<< HEAD
package uiv3;
=======
package uiv6;
>>>>>>> first commit

public class CaloricChart {
    private double carbs;
    private double protein;
    private double fats;

    public CaloricChart(double carbs, double protein, double fats) {
        this.carbs = carbs;
        this.protein = protein;
        this.fats = fats;
    }
    
    

    public double getCarbs() { 
    	return carbs; 
    }
    
    public void setCarbs(double carbs) { 
    	this.carbs = carbs;
    }
    
    public double getProtein() { 
    	return protein; 
    }
    
    public void setProtein(double protein) { 
    	this.protein = protein; 
    }
    
    public double getFats() {
    	return fats; 
    }
    
    public void setFats(double fats) { 
    	this.fats = fats; 
    }
    
    
}