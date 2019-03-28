
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
	
public class Run extends JFrame implements KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Game2048 game = new Game2048();
	JLabel[][] label = new JLabel[4][4];
	Run() {
		setTitle("Game 2048");
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\GitHub\\Game-2048\\2048.png"));
		setBounds(100,100,400,400);
		setLayout(new GridLayout(4, 4));
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				label[i][j] = new JLabel("", JLabel.CENTER);
				label[i][j].setFont(new Font("Times New Roman", Font.BOLD, 30));
				add(label[i][j]);
				label[i][j].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
			}
		}
		addKeyListener(this);
		this.display();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public String string(int value) {
		if (value != 0)
			return Integer.toString(value);
		else
			return "";
	}
	
	public void display() {
		int i, j;
		for (i = 0; i < 4; i++) {
			for (j = 0; j < 4; j++) {
				int value = Game2048.board[i][j];
				label[i][j].setOpaque(true);
				label[i][j].setText(string(value));
				switch(value) {
				case 0: {
					label[i][j].setBackground(Color.decode("#A9A9A9"));
					break;
				}
				case 2: {
					label[i][j].setForeground(Color.decode("#000000"));
					label[i][j].setBackground(Color.decode("#F5F5F5"));
					break;
				}
				case 4: {
					label[i][j].setForeground(Color.decode("#000000"));
					label[i][j].setBackground(Color.decode("#F5DEB3"));
					break;
				}
				case 8: {
					label[i][j].setForeground(Color.decode("#FFFFFF"));
					label[i][j].setBackground(Color.decode("#FF8C00"));
					break;
				}
				case 16: {
					label[i][j].setForeground(Color.decode("#FFFFFF"));
					label[i][j].setBackground(Color.decode("#F4A460"));
					break;
				}
				case 32: {
					label[i][j].setForeground(Color.decode("#FFFFFF"));
					label[i][j].setBackground(Color.decode("#F08080"));
					break;
				}
				case 64: {
					label[i][j].setForeground(Color.decode("#FFFFFF"));
					label[i][j].setBackground(Color.decode("#CD5C5C"));
					break;
				}
				case 128: {
					label[i][j].setForeground(Color.decode("#FFFFFF"));
					label[i][j].setBackground(Color.decode("#FF7F50"));
					break;
				}
				case 256: {
					label[i][j].setForeground(Color.decode("#FFFFFF"));
					label[i][j].setBackground(Color.decode("#F0E68C"));
					break;
				}
				case 512: {
					label[i][j].setForeground(Color.decode("#FFFFFF"));
					label[i][j].setBackground(Color.decode("#FFFF00"));
					break;
				}
				case 1024: {
					label[i][j].setForeground(Color.decode("#FFFFFF"));
					label[i][j].setBackground(Color.decode("#FFD700"));
					break;
				}
				case 2048: {
					label[i][j].setForeground(Color.decode("#FFFFFF"));
					label[i][j].setBackground(Color.decode("#DAA520"));
					break;
				}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new Run();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_LEFT:
			game.moveLeft();
			this.display();
			break;
		case KeyEvent.VK_RIGHT:
			game.moveRight();
			this.display();
			break;
		case KeyEvent.VK_UP:
			game.moveUp();
			this.display();
			break;
		case KeyEvent.VK_DOWN:
			game.moveDown();
			this.display();
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}