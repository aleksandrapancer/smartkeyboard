package smartkeyboard;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Smartkeyboard extends Application {

  @Override
  public void start(Stage primaryStage) {

    final TextArea textArea = new TextArea();
    final Button okButton = new Button("OK");
    okButton.setDefaultButton(true);
    okButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        System.out.println("OK Button Pressed!");
      }
    });
    
    final Button cancelButton = new Button("Cancel");
    cancelButton.setCancelButton(true);
    cancelButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        System.out.println("Canceled!");
      }
    });
    
    final CheckBox editModeCheckBox = new CheckBox("EDIT MODE ACTIVE");
    
    final HBox buttons = new HBox(5);
    buttons.getChildren().addAll(okButton, cancelButton, editModeCheckBox);
    buttons.setAlignment(Pos.CENTER);

    final VBox root = new VBox(5);
    root.setPadding(new Insets(10));
    Scene scene = new Scene(root);
    
    VirtualKeyboard vkb = new VirtualKeyboard();
    vkb.view().setStyle("-fx-border-color: darkblue; -fx-border-radius: 5;");
    
    root.getChildren().addAll(textArea, buttons, vkb.view());

    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

}