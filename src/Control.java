
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
 
public class Control implements Initializable {
	
	private Game game;
	
	@FXML
	private Label scorelb, bestlb;
	
	@FXML
	private Label label00, label01, label02, label03,
				label10, label11, label12, label13,
				label20, label21, label22, label23,
				label30, label31, label32, label33;
	
	public void newGame() {
		Game game = new Game();
		this.game = game;
		this.display();
	}
	
	public void exit() {
		System.exit(0);
	}
	
	public void left() {
		this.game.moveLeft();
		this.display();
		this.checkMove();
	}
	
	public void right() {
		this.game.moveRight();
		this.display();
		this.checkMove();
	}
	
	public void up() {
		this.game.moveUp();
		this.display();
		this.checkMove();
	}
	
	public void down() {
		this.game.moveDown();
		this.display();
		this.checkMove();
	}
	
	public void undo() {
		if (this.game.checkMove() == 0) {
			for (int i=0; i<4; i++)
				for (int j=0; j<4; j++) {
					this.game.board[i][j] = this.game.undo[i][j];
				}
			this.game.score = this.game.undoScore;
			Game.bestScore = Game.undoBest;
			this.display();
		}
	}
	
	void checkMove() {
		if (this.game.checkMove() == 1) {
			JOptionPane.showMessageDialog(null, "Score: " + this.game.score,
					"Game Over", JOptionPane.WARNING_MESSAGE);
			int option = JOptionPane.showConfirmDialog(null, 
					"Do you want to play new game?", "", JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
				this.newGame();
			}
		}
	}
	
	public void about() {
		JOptionPane.showMessageDialog(null, "Game 2048\nNguyễn Viết Ngọc Quang\nApril 2019\n"
				+ "Facebook: https://facebook.com/nguyenvietngoc.quang\nGitHub: https://github.com/nguyenvietngocquang",
				"About", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void display() {
		scorelb.setText("SCORE\n" + this.game.score);
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
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO (don't really need to do anything here).
	}
	
	public void set(Label label, int i, int j) {
		int value = this.game.board[i][j];
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
			label.setBackground(new Background(new BackgroundFill(Color.web("#F0E68C"), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
			break;
		}
		case 512: {
			label.setTextFill(Color.web("#FFFFFF"));
			label.setBackground(new Background(new BackgroundFill(Color.web("#FFFF00"), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
			break;
		}
		case 1024: {
			label.setTextFill(Color.web("#FFFFFF"));
			label.setBackground(new Background(new BackgroundFill(Color.web("#FFD700"), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
			break;
		}
		case 2048: {
			label.setTextFill(Color.web("#FFFFFF"));
			label.setBackground(new Background(new BackgroundFill(Color.web("#DAA520"), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
			break;
		}
		}
	}
	
	public String string(int value) {
		if (value != 0)
			return Integer.toString(value);
		else
			return "";
	}
}