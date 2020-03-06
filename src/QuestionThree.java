import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class QuestionThree extends Application {

    Pane pane = new Pane();

    @Override
    public void start(Stage primaryStage)
    {
        Line[] line = new Line[3];
        Text[] text = new Text[3];

        Circle circle = new Circle(150, 150, 100);
        pane.getChildren().add(circle);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.BLACK);

        Circle[] circlePoints = new Circle[3];

        for (int i = 0; i < circlePoints.length; i++)
        {
            text[i] = new Text();
            circlePoints[i] = new Circle(0, 0, 5);
            randomSpot(circlePoints[i], circle);
            int index = i;

            circlePoints[i].setOnMouseDragged(e ->
            {
                double radiusValue = Math.atan2(e.getY() - circle.getCenterY(), e.getX() - circle.getCenterX());
                double x = circle.getCenterX() + circle.getRadius() * Math.cos(radiusValue);
                double y = circle.getCenterY() + circle.getRadius() * Math.sin(radiusValue);

                circlePoints[index].setCenterX(x);
                circlePoints[index].setCenterY(y);
                updateLine(line, circlePoints, text);
            });
        }

        for (int i = 0; i < line.length; i++)
        {
            int circleIndex;
            if (i + 1 >= circlePoints.length)
                circleIndex = 0;
            else
                circleIndex = i + 1;

            line[i] = new Line(
                    circlePoints[i].getCenterX(), circlePoints[i].getCenterY(),
                    circlePoints[circleIndex].getCenterX(), circlePoints[circleIndex].getCenterY());
        }

        updateLine(line, circlePoints, text);
        pane.getChildren().addAll(line);
        pane.getChildren().addAll(text);
        pane.getChildren().addAll(circlePoints);

        for (int i = 0; i < circlePoints.length; i++)
        {
            circlePoints[i].setFill(Color.RED);
            circlePoints[i].setStroke(Color.BLACK);
        }

        primaryStage.setScene(new Scene(pane, 300, 300));
        primaryStage.setTitle("Question 3");
        primaryStage.show();
    }

    private void updateLine(Line[] line, Circle[] circle, Text[] text)
    {
        for (int i = 0; i < line.length; i++)
        {
            int circleIndex;
            if (i + 1 >= circle.length)
                circleIndex = 0;
            else
                circleIndex = i + 1;

            line[i].setStartX(circle[i].getCenterX());
            line[i].setStartY(circle[i].getCenterY());
            line[i].setEndX(circle[circleIndex].getCenterX());
            line[i].setEndY(circle[circleIndex].getCenterY());
            text[i].setX(circle[i].getCenterX() + 5);
            text[i].setY(circle[i].getCenterY() - 5);
        }

        //Calculate distances of lines
        double x1 = line[0].getStartX();
        double y1 = line[0].getStartY();
        double x2 = line[0].getEndX();
        double y2 = line[0].getEndY();
        double a = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));

        x1 = line[1].getStartX();
        y1 = line[1].getStartY();
        x2 = line[1].getEndX();
        y2 = line[1].getEndY();
        double b = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));

        x1 = line[2].getStartX();
        y1 = line[2].getStartY();
        x2 = line[2].getEndX();
        y2 = line[2].getEndY();
        double c = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));

        //Calculate Angles
        int B = (int) Math.toDegrees(Math.acos((b * b - a * a - c * c) / (-2 * a * c)));
        text[0].setText(String.valueOf(B));
        int C = (int) Math.toDegrees(Math.acos((c * c - b * b - a * a) / (-2 * a * b)));
        text[1].setText(String.valueOf(C));
        int A = (int) Math.toDegrees(Math.acos((a * a - b * b - c * c) / (-2 * b * c)));
        text[2].setText(String.valueOf(A));
    }

    //Generate random spots for circles to start
    private void randomSpot(Circle circlePoint, Circle circle)
    {
        double angle = Math.random() * 360;
        double x = circle.getCenterX() + circle.getRadius() * Math.cos(Math.toRadians(angle));
        double y = circle.getCenterY() + circle.getRadius() * Math.sin(Math.toRadians(angle));
        circlePoint.setCenterX(x);
        circlePoint.setCenterY(y);
    }
}
