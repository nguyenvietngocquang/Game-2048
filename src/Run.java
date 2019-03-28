
import javax.swing.*;
import java.awt.*;
import java.text.*;
import java.util.*;

public class Run {
	JFrame f;

	public static void main(String[] args) {
		JFrame f = new JFrame();
		Game2048 game = new Game2048();
		f.setTitle("Game 2048");
		f.setBounds(100, 100, 800, 500);		
		f.setVisible(true);
	}
	
	public Run() {
		
	}
}
