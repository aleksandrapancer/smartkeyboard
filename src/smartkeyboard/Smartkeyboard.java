package smartkeyboard;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
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
    
    final VBox root = new VBox(5);
    root.setPadding(new Insets(10));
    Scene scene = new Scene(root);  
      
   
    final TextArea textArea = new TextArea();
    final Button defaultButton = new Button("Domyślny układ QWERTY");
    defaultButton.setDefaultButton(true);
    defaultButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        System.out.println("Domyślny układ klawiatury QWERTY");
        root.getChildren().remove(2);         
        VirtualKeyboard vkb = new VirtualKeyboard(1);
        vkb.view().setStyle("-fx-border-color: darkblue; -fx-border-radius: 5;");

        root.getChildren().add(vkb.view()); 
      }
    });
    
    final Button customButton = new Button("Spersonalizowana układ klawiatury");
    customButton.setCancelButton(true);
    customButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        System.out.println("Spersonalizowany układ klawiatury");
        
        root.getChildren().remove(2);         
        VirtualKeyboard vkb = new VirtualKeyboard(2);
        vkb.view().setStyle("-fx-border-color: darkblue; -fx-border-radius: 5;");

        root.getChildren().add(vkb.view()); 
      }
    });
    
    final CheckBox editModeCheckBox = new CheckBox("EDIT MODE ACTIVE");
    
    final HBox buttons = new HBox(5);
    buttons.getChildren().addAll(defaultButton, customButton, editModeCheckBox);
    buttons.setAlignment(Pos.CENTER);
   
    VirtualKeyboard vkb = new VirtualKeyboard(1);
    vkb.view().setStyle("-fx-border-color: darkblue; -fx-border-radius: 5;");

    root.getChildren().addAll(textArea, buttons, vkb.view());

    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

}