
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	private AnchorPane root;
	
    @Override
    public void start(Stage primaryStage) {
        try {
            //Read file fxml and draw interface.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/GUI.fxml"));
            root = (AnchorPane) loader.load();
            primaryStage.setTitle("Game 2048");
            primaryStage.getIcons().add(new Image("/2048.png"));
            
            // Give the controller access to the main application
            Control control = loader.getController();
            control.setMain(this);
            
            KeyCombination newgame = new KeyCodeCombination(KeyCode.N, KeyCodeCombination.CONTROL_DOWN);
            KeyCombination undo = new KeyCodeCombination(KeyCode.Z, KeyCodeCombination.CONTROL_DOWN);
            KeyCombination exit = new KeyCodeCombination(KeyCode.X, KeyCodeCombination.CONTROL_DOWN);
            root.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                	if (exit.match(event)) control.exit();
                	if (newgame.match(event)) control.newGame();
                	if (control.getGame() != null) {
                		if (undo.match(event)) control.undo();
                		switch (event.getCode()) { 
                        case UP:    control.up(); break;
                        case DOWN:  control.down(); break;
                        case LEFT:  control.left(); break;
                        case RIGHT: control.right(); break;
                		}
                	}
                }
            });
            
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}