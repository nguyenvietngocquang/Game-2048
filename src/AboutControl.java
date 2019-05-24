
import java.awt.Desktop;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class AboutControl implements Initializable {

	@FXML
	private Rectangle Facebook, GitHub;
	
	@FXML
	protected void goFacebook() {
		goLink("https://facebook.com/nguyenvietngoc.quang");
	}
	
	@FXML
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
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Image facebook = new Image("/facebook.png");
		Image github = new Image("/github.png");
		Facebook.setFill(new ImagePattern(facebook));
		GitHub.setFill(new ImagePattern(github));
	}
}