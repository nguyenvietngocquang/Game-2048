
import java.util.*;

public class Game {
	int score = 0;
	int undoScore = 0;
	static int bestScore = 0;
	static int undoBest = 0;
	int board[][] = new int[4][4];
	int undo[][] = new int[4][4];
	Random rd = new Random();

	Game() {
		this.start();
	}
	
	//Start game with 3 boxes
	void start() {
		score = 0;
		random();
		random();
		random();
	}
	
	//Random empty box with value 2 or 4
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
	
	//Check this box is empty 
	boolean checkZero(int x, int y) {
		if (board[x][y] == 0)
				return true;
		else return false;
	}
	
	//Check can move
	int checkMove() {
		if ((checkLeft()==false) && (checkRight()==false)
				&& (checkUp()==false) && (checkDown()==false)) {
			return 1;
		} else return 0;
	}
	
	//Move left
	void moveLeft() {
		if (checkLeft() == true) {
			for (int i=0; i<4; i++)
				for (int j=0; j<4; j++) {
					undo[i][j] = board[i][j];
				}
			undoScore = score;
			undoBest = bestScore;
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
			if (combineLeft() == true) {
				for (int i=0; i<4; i++) {
					int k = 0;
					for (int j=0; j<4; j++) {
						if (board[i][j] != 0) {
							if (j<3) {
								if (board[i][j] == board[i][j+1]) {
									board[i][k] = 2*board[i][j];
									score += board[i][k];
									if (score > bestScore) {
										bestScore = score;
									}
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
			}
			random();
		}
	}
	//Check can move left
	boolean checkLeft() {
		if (combineLeft() == true) {
			return true;
		}
		for (int i=0; i<4; i++) {
			for (int j=0; j<3; j++) {
				if (board[i][j]==0) {
					for (int k=j+1; k<4; k++) {
						if (board[i][k]!=0)
							return true;
					}
				}
			}
		}
		return false;
	}
	//Check can combine left
	boolean combineLeft() {
		for (int i=0; i<4; i++) {
			for (int j=0; j<3; j++) {
				if ((board[i][j]!=0) && (board[i][j] == board[i][j+1])) {
					return true;
				}
			}
		}
		return false;
	}
	
	//Move right
	void moveRight() {
		if (checkRight()==true) {
			for (int i=0; i<4; i++)
				for (int j=0; j<4; j++) {
					undo[i][j] = board[i][j];
				}
			undoScore = score;
			undoBest = bestScore;
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
			if (combineRight()==true) {
				for (int i=0; i<4; i++) {
					int k = 3;
					for (int j=3; j>=0; j--) {
						if (board[i][j] != 0) {
							if (j>0) {
								if (board[i][j] == board[i][j-1]) {
									board[i][k] = 2*board[i][j];
									score += board[i][k];
									if (score > bestScore) {
										bestScore = score;
									}
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
			}
			random();
		}
	}
	//Check can move right
	boolean checkRight() {
		if (combineRight() == true) {
			return true;
		}
		for (int i=0; i<4; i++) {
			for (int j=3; j>0; j--) {
				if (board[i][j]==0) {
					for (int k=j-1; k>=0; k--) {
						if (board[i][k]!=0)
							return true;
					}
				}
			}
		}
		return false;
	}
	//Check can combine right
	boolean combineRight() {
		for (int i=0; i<4; i++) {
			for (int j=3; j>0; j--) {
				if ((board[i][j]!=0) && (board[i][j] == board[i][j-1])) {
					return true;
				}
			}
		}
		return false;
	}
	
	//Move up
	void moveUp() {
		if (checkUp() == true) {
			for (int i=0; i<4; i++)
				for (int j=0; j<4; j++) {
					undo[i][j] = board[i][j];
				}
			undoScore = score;
			undoBest = bestScore;
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
			if (combineUp() == true) {
				for (int j=0; j<4; j++) {
					int k = 0;
					for (int i=0; i<4; i++) {
						if (board[i][j] != 0) {
							if (i<3) {
								if (board[i][j] == board[i+1][j]) {
									board[k][j] = 2*board[i][j];
									score += board[k][j];
									if (score > bestScore) {
										bestScore = score;
									}
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
			}
			random();
		}
	}
	//Check can move up
	boolean checkUp() {
		if (combineUp() == true) {
			return true;
		}
		for (int j=0; j<4; j++) {
			for (int i=0; i<3; i++) {
				if (board[i][j]==0) {
					for (int k=i+1; k<4; k++) {
						if (board[k][j]!=0)
							return true;
					}
				}
			}
		}
		return false;
	}
	//Check can combine up
	boolean combineUp() {
		for (int j=0; j<4; j++) {
			for (int i=0; i<3; i++) {
				if ((board[i][j]!=0) && (board[i][j] == board[i+1][j])) {
					return true;
				}
			}
		}
		return false;
	}
	
	//Move down
	void moveDown() {
		if (checkDown() == true) {
			for (int i=0; i<4; i++)
				for (int j=0; j<4; j++) {
					undo[i][j] = board[i][j];
				}
			undoScore = score;
			undoBest = bestScore;
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
			if (combineDown() == true) {
				for (int j=0; j<4; j++) {
					int k = 3;
					for (int i=3; i>=0; i--) {
						if (board[i][j] != 0) {
							if (i>0) {
								if (board[i][j] == board[i-1][j]) {
									board[k][j] = 2*board[i][j];
									score += board[k][j];
									if (score > bestScore) {
										bestScore = score;
									}
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
			}
			random();
		}
	}
	//Check can move down
	boolean checkDown() {
		if (combineDown() == true) {
			return true;
		}
		for (int j=0; j<4; j++) {
			for (int i=3; i>0; i--) {
				if (board[i][j]==0) {
					for (int k=i-1; k>=0; k--) {
						if (board[k][j]!=0)
							return true;
					}
				}
			}
		}
		return false;
	}
	//Check can combine down
	boolean combineDown() {
		for (int j=0; j<4; j++) {
			for (int i=3; i>0; i--) {
				if ((board[i][j]!=0) && (board[i][j] == board[i-1][j])) {
					return true;
				}
			}
		}
		return false;
	}
}