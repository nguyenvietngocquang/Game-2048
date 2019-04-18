
import java.awt.Desktop;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
 
public class Control implements Initializable {
	
	protected Main main;
	private Game game;
	
	protected void setMain(Main main) {
		this.main = main;
	}
	
	public Game getGame() {
		return game;
	}

	@FXML
	private Label scorelb = new Label(), bestlb = new Label();
	
	@FXML
	private Label label00, label01, label02, label03,
				label10, label11, label12, label13,
				label20, label21, label22, label23,
				label30, label31, label32, label33;
	
	public void newGame() {
		Game game = new Game();
		this.game = game;
		display();
	}
	
	public void exit() {
		System.exit(0);
	}
	
	public void left() {
		game.moveLeft();
		display();
		checkMove();
	}
	
	public void right() {
		game.moveRight();
		display();
		checkMove();
	}
	
	public void up() {
		game.moveUp();
		display();
		checkMove();
	}
	
	public void down() {
		game.moveDown();
		display();
		checkMove();
	}
	
	public void undo() {
		if (game != null) {
			if (game.checkMove() == 0) {
				for (int i=0; i<4; i++)
					for (int j=0; j<4; j++) {
						game.board[i][j] = game.undo[i][j];
					}
				game.score = game.undoScore;
				Game.bestScore = Game.undoBest;
				display();
			}
		}
	}
	
	private void checkMove() {
		if (game.checkMove() == 1) {
			JOptionPane.showMessageDialog(null, "Score: " + game.score,
					"Game Over", JOptionPane.WARNING_MESSAGE);
			int option = JOptionPane.showConfirmDialog(null, 
					"Do you want to play new game?", "", JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
				newGame();
			}
		}
	}
	
	protected void goFacebook() {
		goLink("https://facebook.com/nguyenvietngoc.quang");
	}
	
	protected void goGitHub() {
		goLink("https://github.com/nguyenvietngocquang");
	}
	
	static void goLink(String link) {
		try {
			Desktop.getDesktop().browse(new URI(link));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	void about() {
		try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/About.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setTitle("About");
            stage.getIcons().add(new Image("/2048.png"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
	}
	
	@FXML
	private void display() {
		scorelb.setText("SCORE\n" + game.score);
		bestlb.setText("BEST\n" + Game.bestScore);
		set(label00, 0, 0);
		set(label01, 0, 1);
		set(label02, 0, 2);
		set(label03, 0, 3);
		set(label10, 1, 0);
		set(label11, 1, 1);
		set(label12, 1, 2);
		set(label13, 1, 3);
		set(label20, 2, 0);
		set(label21, 2, 1);
		set(label22, 2, 2);
		set(label23, 2, 3);
		set(label30, 3, 0);
		set(label31, 3, 1);
		set(label32, 3, 2);
		set(label33, 3, 3);
	}
	
	private void set(Label label, int i, int j) {
		int value = game.board[i][j];
		label.setText(string(value));
		switch(value) {
		case 0: {
			label.setBackground(new Background(new BackgroundFill(Color.web("#A9A9A9"), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
			break;
		}
		case 2: {
			label.setTextFill(Color.web("#000000"));
			label.setBackground(new Background(new BackgroundFill(Color.web("#F5DEB3"), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
			break;
		}
		case 4: {
			label.setTextFill(Color.web("#000000"));
			label.setBackground(new Background(new BackgroundFill(Color.web("#FFB6C1"), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
			break;
		}
		case 8: {
			label.setTextFill(Color.web("#FFFFFF"));
			label.setBackground(new Background(new BackgroundFill(Color.web("#FF8C00"), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
			break;
		}
		case 16: {
			label.setTextFill(Color.web("#FFFFFF"));
			label.setBackground(new Background(new BackgroundFill(Color.web("#F4A460"), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
			break;
		}
		case 32: {
			label.setTextFill(Color.web("#FFFFFF"));
			label.setBackground(new Background(new BackgroundFill(Color.web("#F08080"), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
			break;
		}
		case 64: {
			label.setTextFill(Color.web("#FFFFFF"));
			label.setBackground(new Background(new BackgroundFill(Color.web("#CD5C5C"), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
			break;
		}
		case 128: {
			label.setTextFill(Color.web("#FFFFFF"));
			label.setBackground(new Background(new BackgroundFill(Color.web("#FF7F50"), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
			break;
		}
		case 256: {
			label.setTextFill(Color.web("#FFFFFF"));
			label.setBackground(new Background(new BackgroundFill(Color.web("#FF4500"), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
			break;
		}
		case 512: {
			label.setTextFill(Color.web("#000000"));
			label.setBackground(new Background(new BackgroundFill(Color.web("#FFFF00"), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
			break;
		}
		case 1024: {
			label.setTextFill(Color.web("#000000"));
			label.setBackground(new Background(new BackgroundFill(Color.web("#FFD700"), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
			break;
		}
		case 2048: {
			label.setTextFill(Color.web("#FFFFFF"));
			label.setBackground(new Background(new BackgroundFill(Color.web("#DAA520"), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
			break;
		}
		case 4096: {
			label.setTextFill(Color.web("#FFFFFF"));
			label.setBackground(new Background(new BackgroundFill(Color.web("#FF0000"), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
			break;
		}
		case 8192: {
			label.setTextFill(Color.web("#FFFFFF"));
			label.setBackground(new Background(new BackgroundFill(Color.web("#FF0000"), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
			break;
		}
		case 16384: {
			label.setTextFill(Color.web("#FFFFFF"));
			label.setBackground(new Background(new BackgroundFill(Color.web("#FF0000"), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
			break;
		}
		case 32768: {
			label.setTextFill(Color.web("#FFFFFF"));
			label.setBackground(new Background(new BackgroundFill(Color.web("#FF0000"), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
			break;
		}
		case 65536: {
			label.setTextFill(Color.web("#FFFFFF"));
			label.setBackground(new Background(new BackgroundFill(Color.web("#FF0000"), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
			break;
		}
		}
	}
	
	private String string(int value) {
		if (value != 0)
			return Integer.toString(value);
		else
			return "";
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}