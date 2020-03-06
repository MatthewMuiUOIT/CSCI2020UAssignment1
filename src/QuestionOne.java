import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class QuestionOne extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        int cardOne = (int) (Math.random()*54 + 1);
        int cardTwo = (int) (Math.random()*54 + 1);
        int cardThree = (int) (Math.random()*54 + 1);

        ImageView imageViewOne = new ImageView(new Image("Cards/" + cardOne + ".png"));
        ImageView imageViewTwo = new ImageView(new Image("Cards/" + cardTwo + ".png"));
        ImageView imageViewThree = new ImageView(new Image("Cards/" + cardThree + ".png"));

        imageViewTwo.setX(75);
        imageViewThree.setX(150);

        Group root = new Group (imageViewOne, imageViewTwo, imageViewThree);
        Scene scene = new Scene(root, 220, 95);
        primaryStage.setTitle("Question 1");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
