
import javax.swing.*;
import java.awt.*;
import java.text.*;
import java.util.*;

public class Game2048 {
	private static int board[][] = new int[4][4];
	JTable table = new JTable();
	Random rd = new Random();
	
	void start() {
		this.random();
		this.random();
		this.random();
	}
	
	void random() {
		int x, y;
		do {
			x = rd.nextInt(4);
			y = rd.nextInt(4);
		} while (checkZero(x, y) == false);
		int value = rd.nextInt(2);
		if (value == 0) {
			board[x][y] = 2;
		} else board[x][y] = 4;
	}
	
	boolean checkZero(int x, int y) {
		if (board[x][y] == 0)
				return true;
		else return false;
	}
	
	public void print() {
		for (int i=0; i<4; i++) {
			for (int j=0; j<4; j++) {
				System.out.print(board[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Game2048 game = new Game2048();
		game.start();
		game.print();
	}
}
