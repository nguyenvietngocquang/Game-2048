
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
 
public class Main extends Application {
	
    @Override
    public void start(Stage primaryStage) {
        try {
        	Control ctrl = new Control();
            //Read file fxml and draw interface.
            Parent root = FXMLLoader.load(getClass().getResource("/GUI.fxml"));
            primaryStage.setTitle("Game 2048");
            primaryStage.getIcons().add(new Image("/2048.png"));
            
            KeyCombination newgame = new KeyCodeCombination(KeyCode.N, KeyCodeCombination.CONTROL_ANY);
            KeyCombination exit = new KeyCodeCombination(KeyCode.X, KeyCodeCombination.CONTROL_ANY);
            
            root.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                	if (exit.match(event)) ctrl.exit();
                	if (newgame.match(event)) ctrl.newGame();
                    switch (event.getCode()) { 
                        case UP:    ctrl.up(); break;
                        case DOWN:  ctrl.down(); break;
                        case LEFT:  ctrl.left(); break;
                        case RIGHT: ctrl.right(); break;
                    }
                }
            });
            
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}