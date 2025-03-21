
package uiv6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CaloricChartView extends Application  {
	
    private CaloricChart caloricChart;
    private PieChart pieChart;
    private PieChart.Data carbsData;
    private PieChart.Data proteinData;
    private PieChart.Data fatsData;

    public CaloricChartView(CaloricChart caloricChart) {
        this.caloricChart = caloricChart;

    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 300, 300);

        pieChart = createPieChart();
        pieChart.setLayoutX(50);
        pieChart.setLayoutY(50);
        pieChart.setPrefSize(150, 150);

        pane.getChildren().add(pieChart);

        primaryStage.setTitle("Caloric Chart View");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public PieChart getPieChart() {
        pieChart.setPrefSize(150, 150); // Configure size when requested
        return pieChart; // Return the existing instance

    }

    public void updateChart(double carbs, double protein, double fats) {
        caloricChart.setCarbs(carbs);
        caloricChart.setProtein(protein);
        caloricChart.setFats(fats);

        carbsData.setPieValue(caloricChart.getCarbs());
        proteinData.setPieValue(caloricChart.getProtein());
        fatsData.setPieValue(caloricChart.getFats());
    }

    private PieChart createPieChart() {
        PieChart pieChart = new PieChart();
        pieChart.setLegendVisible(false);

        carbsData = new PieChart.Data("Carbs", caloricChart.getCarbs());
        proteinData = new PieChart.Data("Protein", caloricChart.getProtein());
        fatsData = new PieChart.Data("Fats", caloricChart.getFats());
        pieChart.getData().addAll(carbsData, proteinData, fatsData);

        carbsData.getNode().setStyle("-fx-pie-color: #ffd300;"); // yellow
        proteinData.getNode().setStyle("-fx-pie-color: #bd83fc;"); // purple

        fatsData.getNode().setStyle("-fx-pie-color: #ff4444;");	// red

        fatsData.getNode().setStyle("-fx-pie-color: #ff4444;"); // red

        
        pieChart.setLabelsVisible(false); // remove the labels

        return pieChart;
    }


    public static void main(String[] args) {
        launch(args);
    }
}

