import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GraphicApp extends Application {
    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) {
        //Controls
        Text text = new Text("jakis tekst");
        Button button = new Button("button");
        Text text2 = new Text("drugi tekst");

        //root
        //StackPane root = new StackPane();
        //HBox root = new HBox();  //Horizontal Box
        VBox root = new VBox();  //Vertical Box
        root.getChildren().add(text);
        root.getChildren().add(button);
        root.getChildren().add(text2);

        //scene
        Scene scene = new Scene(root);

        //stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}