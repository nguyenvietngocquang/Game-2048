
import javax.swing.*;
import java.awt.*;
import java.text.*;
import java.util.*;

public class Game2048 {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Game2048 game = new Game2048();
		game.start();
		print();
		int c=0;
		do {
			c = sc.nextInt();
			sc.nextLine();
			switch(c) {
			case 2: {
				moveDown();
				print();
				break;
			}
			case 4: {
				moveLeft();
				print();
				break;
			}
			case 6: {
				moveRight();
				print();
				break;
			}
			case 8: {
				moveUp();
				print();
				break;
			}
			}
		} while (c!=0);
	}
	
	static int board[][] = new int[4][4];
	JTable table = new JTable();
	static Random rd = new Random();
	
	void start() {
		random();
		random();
		random();
	}
	
	static void random() {
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
	
	static boolean checkZero(int x, int y) {
		if (board[x][y] == 0)
				return true;
		else return false;
	}
	
	static boolean checkMove() {
		return false;
	}
	
	public static void print() {
		for (int i=0; i<4; i++) {
			for (int j=0; j<4; j++) {
				System.out.print(board[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static void moveLeft() {
		boolean check;
		for (int i=0; i<4; i++) {
			int k = 0;
			for (int j=0; j<4; j++) {
				if (board[i][j] != 0) {
					board[i][k] = board[i][j];
					k++;
				}
			}
			for (int j=k; j<4; j++) {
				board[i][j] = 0;
			}
		}
		do {
			check = grossLeft();
		} while (check==false);
		checkMove();
		random();
	}
	
	static boolean grossLeft() {
		for (int i=0; i<4; i++) {
			int k = 0;
			for (int j=0; j<4; j++) {
				if (board[i][j] != 0) {
					if (j<3) {
						if (board[i][j] == board[i][j+1]) {
							board[i][k] = 2*board[i][j];
							k++;
							j++;
						} else {
							board[i][k] = board[i][j];
							k++;
						}
					} else {
						board[i][k] = board[i][j];
						k++;
					}
				}
			}
			for (int j=k; j<4; j++) {
				board[i][j] = 0;
			}
		}
		for (int i=0; i<4; i++) {
			for (int j=0; j<3; j++) {
				if ((board[i][j]!=0) && (board[i][j] == board[i][j+1])) {
					return false;
				}
			}
		}
		return true;
	}
	
	static void moveRight() {
		boolean check;
		for (int i=0; i<4; i++) {
			int k = 3;
			for (int j=3; j>=0; j--) {
				if (board[i][j] != 0) {
					board[i][k] = board[i][j];
					k--;
				}
			}
			for (int j=0; j<=k; j++) {
				board[i][j] = 0;
			}
		}
		do {
			check = grossRight();
		} while (check==false);
		checkMove();
		random();
	}
	
	static boolean grossRight() {
		for (int i=0; i<4; i++) {
			int k = 3;
			for (int j=3; j>=0; j--) {
				if (board[i][j] != 0) {
					if (j>0) {
						if (board[i][j] == board[i][j-1]) {
							board[i][k] = 2*board[i][j];
							k--;
							j--;
						} else {
							board[i][k] = board[i][j];
							k--;
						}
					} else {
						board[i][k] = board[i][j];
						k--;
					}
				}
			}
			for (int j=0; j<=k; j++) {
				board[i][j] = 0;
			}
		}
		for (int i=0; i<4; i++) {
			for (int j=3; j>0; j--) {
				if ((board[i][j]!=0) && (board[i][j] == board[i][j-1])) {
					return false;
				}
			}
		}
		return true;
	}
	
	static void moveUp() {
		boolean check;
		for (int j=0; j<4; j++) {
			int k = 0;
			for (int i=0; i<4; i++) {
				if (board[i][j] != 0) {
					board[k][j] = board[i][j];
					k++;
				}
			}
			for (int i=k; i<4; i++) {
				board[i][j] = 0;
			}
		}
		do {
			check = grossUp();
		} while (check==false);
		checkMove();
		random();
	}
	
	static boolean grossUp() {
		for (int j=0; j<4; j++) {
			int k = 0;
			for (int i=0; i<4; i++) {
				if (board[i][j] != 0) {
					if (i<3) {
						if (board[i][j] == board[i+1][j]) {
							board[k][j] = 2*board[i][j];
							k++;
							i++;
						} else {
							board[k][j] = board[i][j];
							k++;
						}
					} else {
						board[k][j] = board[i][j];
						k++;
					}
				}
			}
			for (int i=k; i<4; i++) {
				board[i][j] = 0;
			}
		}
		for (int j=0; j<4; j++) {
			for (int i=0; i<3; i++) {
				if ((board[i][j]!=0) && (board[i][j] == board[i+1][j])) {
					return false;
				}
			}
		}
		return true;
	}
	
	static void moveDown() {
		boolean check;
		for (int j=0; j<4; j++) {
			int k = 3;
			for (int i=3; i>=0; i--) {
				if (board[i][j] != 0) {
					board[k][j] = board[i][j];
					k--;
				}
			}
			for (int i=0; i<=k; i++) {
				board[i][j] = 0;
			}
		}
		do {
			check = grossDown();
		} while (check==false);
		checkMove();
		random();
	}
	
	static boolean grossDown() {
		for (int j=0; j<4; j++) {
			int k = 3;
			for (int i=3; i>=0; i--) {
				if (board[i][j] != 0) {
					if (i>0) {
						if (board[i][j] == board[i-1][j]) {
							board[k][j] = 2*board[i][j];
							k--;
							i--;
						} else {
							board[k][j] = board[i][j];
							k--;
						}
					} else {
						board[k][j] = board[i][j];
						k--;
					}
				}
			}
			for (int i=0; i<=k; i++) {
				board[i][j] = 0;
			}
		}
		for (int j=0; j<4; j++) {
			for (int i=3; i>0; i--) {
				if ((board[i][j]!=0) && (board[i][j] == board[i-1][j])) {
					return false;
				}
			}
		}
		return true;
	}
}
