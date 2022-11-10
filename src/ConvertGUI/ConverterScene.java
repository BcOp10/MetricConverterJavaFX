package ConvertGUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ConverterScene extends Application {
    //Declaring fields and buttons
    private TextField metricUnit = new TextField();
    private static TextField milesUnit = new TextField();
    private static TextField kilogramsUnit = new TextField();
    private static TextField poundsUnit = new TextField();
    private static TextField cm = new TextField();
    private static TextField inches = new TextField();
    private static TextField mLUnit = new TextField();
    private static TextField litersUnit = new TextField();
    private Button btnConvert1 = new Button("Convert");
    private Button btnConvert2 = new Button("Convert");
    private Button btnConvert3 = new Button("Convert");
    private Button btnConvert4 = new Button("Convert");

    @Override //Override the start method for in Application class
    public void start(Stage primaryStage){
        GridPane gridPane = new GridPane();
        gridPane.setHgap(3);
        gridPane.setHgap(3);

        //Km to mi
        gridPane.add(new Label("Kilometers:"), 0, 0);
        gridPane.add(metricUnit, 1, 0);
        gridPane.add(new Label("Miles:"), 0, 1);
        gridPane.add(milesUnit, 1, 1);
        gridPane.add(btnConvert1, 1, 2);

        //kg to lbs
        gridPane.add(new Label("Kilograms:"), 0, 3);
        gridPane.add(kilogramsUnit, 1, 3);
        gridPane.add(new Label("Pounds:"), 0, 4);
        gridPane.add(poundsUnit, 1, 4);
        gridPane.add(btnConvert2, 1, 5);
        
        //cm to in
        gridPane.add(new Label("Centimeter:"), 0, 6);
        gridPane.add(cm, 1, 6);
        gridPane.add(new Label("Inches:"), 0, 7);
        gridPane.add(inches, 1, 7);
        gridPane.add(btnConvert3, 1, 8);

        //kph to mph
        gridPane.add(new Label("Milliliter:"), 0, 9);
        gridPane.add(mLUnit, 1, 9);
        gridPane.add(new Label("Liter:"), 0, 10);
        gridPane.add(litersUnit, 1, 10);
        gridPane.add(btnConvert4, 1, 11);

        // Set properties for UI
        gridPane.setAlignment(Pos.CENTER);
        milesUnit.setEditable(false);
        poundsUnit.setEditable(false);
        inches.setEditable(false);
        litersUnit.setEditable(false);
        GridPane.setHalignment(btnConvert1 , HPos.RIGHT);
        GridPane.setHalignment(btnConvert2 , HPos.RIGHT);
        GridPane.setHalignment(btnConvert3 , HPos.RIGHT);
        GridPane.setHalignment(btnConvert4 , HPos.RIGHT);

        //Setting an event
        btnConvert1.setOnAction(new ConvertButton());
        btnConvert2.setOnAction(new ConvertButton());
        btnConvert3.setOnAction(new ConvertButton());
        btnConvert4.setOnAction(new ConvertButton());
        
        // Creates the scene
        Scene scene = new Scene(gridPane, 500, 450);
        primaryStage.setTitle("Metric Converter"); // Set title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        
    }

    //class to handle the events
    class ConvertButton implements EventHandler<javafx.event.ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            //finding out which button is clicked
            if (event.getSource().equals(btnConvert1)) {
                //kilometers to miles
                Double kiloMeters = Double.parseDouble(metricUnit.getText());
                Double miles = kiloMeters * 0.621371;
                milesUnit.setText(String.format("%,.2f miles", miles));
            } else if (event.getSource().equals(btnConvert2)){
                //kilograms to pounds
                Double kilograms = Double.parseDouble(kilogramsUnit.getText());
                Double pounds = kilograms * 2.205;
                poundsUnit.setText(String.format("%,.2f pounds", pounds));
            } else if (event.getSource().equals(btnConvert3)){
                //kilograms to pounds
                Double centimeters = Double.parseDouble(cm.getText());
                Double inch = centimeters * 0.393701;
                inches.setText(String.format("%,.2f inches", inch));
            } else {
                //kph to mph
                Double mL = Double.parseDouble(mLUnit.getText());
                Double liters = mL * 0.001;
                litersUnit.setText(String.format("%,.3f L", liters));
            }
        }
    }
public static void main(String[] args){
    launch(args);
    }
}