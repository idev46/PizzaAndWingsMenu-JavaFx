package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PizzaAndWingsMenu extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        final int SPACING = 10;
        final int PADDING = 10;
        VBox vBox = new VBox(SPACING);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(PADDING, PADDING, PADDING, PADDING));

        //NO OF PIZZAS
        HBox hBox = new HBox(SPACING);
        hBox.setAlignment(Pos.CENTER_LEFT);

        Label label = new Label("Number of Pizzas:");
        TextField noOfPizzaField = new TextField("0");

        hBox.getChildren().add(label);
        hBox.getChildren().add(noOfPizzaField);

        //EXTRA CHEESE
        HBox hBox1 = new HBox(SPACING);
        hBox1.setAlignment(Pos.CENTER_LEFT);

        Label label1 = new Label("Extra Cheese:");
        TextField cheeseField = new TextField("No");

        hBox1.getChildren().add(label1);
        hBox1.getChildren().add(cheeseField);

        //EXTRA TOMATO
        HBox hBox2 = new HBox(SPACING);
        hBox1.setAlignment(Pos.CENTER_LEFT);

        Label label2 = new Label("extra tomato:");
        TextField tomatoField = new TextField("No");

        hBox2.getChildren().add(label2);
        hBox2.getChildren().add(tomatoField);

        //NO OF WINGS
        HBox hBox3 = new HBox(SPACING);
        hBox3.setAlignment(Pos.CENTER_LEFT);

        Label label3 = new Label("Number of Wings:");
        TextField noOfWingsField = new TextField("0");

        hBox3.getChildren().add(label3);
        hBox3.getChildren().add(noOfWingsField);

        //PRETAX TOTAL
        HBox hBox4 = new HBox(SPACING);
        hBox4.setAlignment(Pos.CENTER_LEFT);

        Label label4 = new Label("Pretax Total:");
        Label preTaxLabel = new Label();

        hBox4.getChildren().add(label4);
        hBox4.getChildren().add(preTaxLabel);

        //TAXES
        HBox hBox5 = new HBox(SPACING);
        hBox5.setAlignment(Pos.CENTER_LEFT);

        Label label5 = new Label("Taxes:");
        Label taxesLabel = new Label();

        hBox5.getChildren().add(label5);
        hBox5.getChildren().add(taxesLabel);

        //TOTAL WITH TAXES
        HBox hBox6 = new HBox(SPACING);
        hBox6.setAlignment(Pos.CENTER_LEFT);

        Label label6 = new Label("Total with taxes:");
        Label totalLabel = new Label();

        hBox6.getChildren().add(label6);
        hBox6.getChildren().add(totalLabel);

        //CALCULATION BUTTON
        HBox hBox7 = new HBox(SPACING);
        hBox7.setAlignment(Pos.CENTER);

        Button calcButton = new Button("Calculate Cost");

        //calcButton.setOnAction(event -> handleClickMe(event,"kk"));

        calcButton.setOnAction(event -> {
            double pizzaCost = 10.99;
            double extraCheeseCost = 0.0;
            double extraTomatoCost = 0.0;
            double wingsOrderCost = 3.75;

            try {
                pizzaCost = Integer.parseInt(noOfPizzaField.getText().toString()) * pizzaCost;
                if (cheeseField.getText().toLowerCase().equals("yes"))
                    extraCheeseCost = 1.90;

                if (tomatoField.getText().toLowerCase().equals("yes"))
                    extraTomatoCost = 1.50;

                wingsOrderCost = Integer.parseInt(noOfWingsField.getText().toString()) * wingsOrderCost;

                double preTax = pizzaCost + extraCheeseCost + extraTomatoCost + wingsOrderCost;
                preTaxLabel.setText(String.format("%.02f", preTax));

                double taxes = preTax - (preTax * 0.9);
                taxesLabel.setText(String.format("%.02f", taxes));

                double total = preTax + taxes;
                totalLabel.setText(String.format("%.02f", total));

            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        hBox7.getChildren().add(calcButton);

        Group root = new Group();
        vBox.getChildren().add(hBox);
        vBox.getChildren().add(hBox1);
        vBox.getChildren().add(hBox2);
        vBox.getChildren().add(hBox3);
        vBox.getChildren().add(hBox4);
        vBox.getChildren().add(hBox5);
        vBox.getChildren().add(hBox6);
        vBox.getChildren().add(hBox7);
        root.getChildren().add(vBox);

        primaryStage.setTitle("Pizza and Wings Menu");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


}
