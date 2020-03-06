import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class QuestionTwo extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setVgap(5);
        pane.setHgap(5);

        Label amountL = new Label("Investment Amount");
        TextField amount = new TextField();
        Label yearsL = new Label( "Years");
        TextField years = new TextField();
        Label inRateL = new Label("Annual Interest Rate");
        TextField inRate = new TextField();
        Label futureAmountL = new Label("Future Amount");
        TextField futureAmount = new TextField();

        Button calculate = new Button("Calculate");
        calculate.setOnAction(e->
        {
            int amountInt = Integer.parseInt(amount.getText());
            int yearsInt = Integer.parseInt(years.getText());
            double inRateDouble = Double.parseDouble(inRate.getText());
            inRateDouble = inRateDouble/100;

            double futureValue = amountInt * Math.pow(1 + inRateDouble/12, yearsInt*12);
            futureValue = (double)Math.round(futureValue * 100)/100;
            futureAmount.setText(String.valueOf(futureValue));
        });

        pane.add(amountL, 0, 0);
        pane.add(amount,1, 0);
        pane.add(yearsL, 0, 1);
        pane.add(years, 1, 1);
        pane.add(inRateL, 0, 2);
        pane.add(inRate, 1, 2);
        pane.add(futureAmountL, 0, 3);
        pane.add(futureAmount, 1, 3);
        pane.add(calculate, 1,4);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Question Two");
        primaryStage.show();




    }
}
