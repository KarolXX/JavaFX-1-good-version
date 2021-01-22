import javafx.application.Application;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Controls extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Font font = Font.font("Arial", FontWeight.BOLD, 16 );
        Color color = Color.web("996655");

        //label
        Label label = new Label("first Label");
        label.setLayoutX(50);
        label.setLayoutY(150);
        label.setFont(font);
        label.setTextFill(color);

        //ImageView
        Image image = new Image("icon.png");
        ImageView imageView = new ImageView(image);
        imageView.setLayoutX(5);
        imageView.setLayoutY(150);
        imageView.setFitHeight(30);
        imageView.setFitWidth(30);
        imageView.setPreserveRatio(true);
        //label.setGraphic(imageView);
        //Label labelWithImage = new Label("label with image", imageView);


        //TextField
        TextField textField = new TextField();
        //textField.setText("text");
        textField.setPromptText("enter email");
        textField.setPrefColumnCount(20); //it's like width


        //PasswordField
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter password");
        passwordField.setPrefColumnCount(20);
        passwordField.setLayoutY(40);


        //Checkbox
        CheckBox checkBox = new CheckBox("I have set password");
        checkBox.setLayoutX(10);
        checkBox.setLayoutY(80);


        BooleanBinding bb = new BooleanBinding() { //Binding button with textField
            {
                super.bind(textField.textProperty());
            }

            @Override
            protected boolean computeValue() {
                return (textField.getText().isEmpty() && !textField.getText().contains("@"));
            }
        };

        //Button
        Button button = new Button("first button");
        button.setLayoutX(255);
        button.setTextFill(Color.PURPLE);
        //button.setGraphic(imageView);
        button.disableProperty().bind(bb); //Binding button with textField
        //button.setDisable(true); //then I can't click button
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                button.setText("Another text");
                button.setTextFill(Color.RED);

            }
        });

        //RadioButton
        RadioButton radioButton1 = new RadioButton("First option");
        radioButton1.setLayoutX(5);
        radioButton1.setLayoutY(120);

        RadioButton radioButton2 = new RadioButton("Second option");
        radioButton2.setLayoutX(5);
        radioButton2.setLayoutY(150);

        ToggleGroup toggleGroup = new ToggleGroup();
        radioButton1.setToggleGroup(toggleGroup);
        radioButton2.setToggleGroup(toggleGroup);

        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            RadioButton selected = (RadioButton) newValue;
            System.out.println(selected);
        });

        //ChoiceBox

        /////////////////////////
        Group group = new Group();
        //group.getChildren().add(label);
        group.getChildren().add(imageView);
        //group.getChildren().add(labelWithImage);
        group.getChildren().add(textField);
        group.getChildren().add(button);
        group.getChildren().add(passwordField);
        group.getChildren().add(checkBox);
        group.getChildren().add(radioButton1);
        group.getChildren().add(radioButton2);

        Scene scene = new Scene(group, 400, 300);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Controls app");
        primaryStage.show();

    }
}
