import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;

public enum BotMechanics {

	EASY {
		@Override
		public void makeMove(JButton[][] board, JLabel user1Label, JLabel user2Label) {
			startBasicBot(board, user2Label, user2Label);
		}
	},

	MEDIUM {
		@Override
		public void makeMove(JButton[][] board, JLabel user1Label, JLabel user2Label) {
			startMediumBot(board, user2Label, user2Label);
		}
	},

	HARD {
		@Override
		public void makeMove(JButton[][] board, JLabel user1Label, JLabel user2Label) {
			startHardBot(board, user2Label, user2Label);
		}
	};

	public abstract void makeMove(JButton[][] board, JLabel user1Label, JLabel user2Label);

	private static Random random = new Random();

	public static void startBasicBot(JButton[][] board, JLabel user1Label, JLabel user2Label) {

		if (createChance(60)) {
			if (winNextMove(board, "O")) {
				return;
			}
		}
		if (createChance(60)) {
			if (winNextMove(board, "X")) {
				return;
			}
		}

		ArrayList<JButton> emptyCells = getEmptyCells(board);
		if (!emptyCells.isEmpty()) {
			emptyCells.get(random.nextInt(emptyCells.size())).setText("O");
		}
	}

	public static void startMediumBot(JButton[][] board, JLabel user1Label, JLabel user2Label) {

		if (createChance(80)) {
			if (winNextMove(board, "O")) {
				return;
			}
		}
		if (createChance(100)) {
			if (winNextMove(board, "X")) {
				return;
			}
		}

		ArrayList<JButton> emptyCells = getEmptyCells(board);
		if (!emptyCells.isEmpty()) {
			emptyCells.get(random.nextInt(emptyCells.size())).setText("O");
		}

	}

	public static void startHardBot(JButton[][] board, JLabel user1Label, JLabel user2Label) {

		if (winNextMove(board, "O")) {
			return;
		}

		if (winNextMove(board, "X")) {
			return;
		}
		if (board[1][1].getText().isEmpty()) {
			board[1][1].setText("O");
			return;
		}
		int[][] corners = { { 0, 0 }, { 0, 2 }, { 2, 0 }, { 2, 2 } };
		ArrayList<JButton> availableCorners = new ArrayList<>();
		for (int[] corner : corners) {
			if (board[corner[0]][corner[1]].getText().isEmpty()) {
				availableCorners.add(board[corner[0]][corner[1]]);
			}
		}
		if (!availableCorners.isEmpty()) {
			availableCorners.get(random.nextInt(availableCorners.size())).setText("O");
			return;
		}
		ArrayList<JButton> emptyCells = getEmptyCells(board);
		if (!emptyCells.isEmpty()) {
			emptyCells.get(random.nextInt(emptyCells.size())).setText("O");
		}
	}

	private static ArrayList<JButton> getEmptyCells(JButton[][] board) {
		ArrayList<JButton> emptyCells = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j].getText().isEmpty()) {
					emptyCells.add(board[i][j]);
				}
			}
		}
		return emptyCells;
	}

	public static boolean winNextMove(JButton[][] board, String playerSymbol) {
		String[][] virtualBoard = new String[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				virtualBoard[i][j] = board[i][j].getText();
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (virtualBoard[i][j].equals("")) {

					virtualBoard[i][j] = playerSymbol;

					if (checkWinner(virtualBoard)) {
						board[i][j].setText("O");
						return true;
					} else {
						virtualBoard[i][j] = "";
					}
				}
			}
		}
		return false;
	}

	public static boolean createChance(int persentece) {

		if (random.nextInt(100) < persentece) {
			return true;
		}
		return false;
	}

	public static boolean checkWinner(String[][] virtualboard) {
		// ROWS
		for (int i = 0; i < 3; i++) {
			if (!virtualboard[i][0].equals("") && virtualboard[i][0].equals(virtualboard[i][1])
					&& virtualboard[i][1].equals(virtualboard[i][2])) {
				return true;
			}
		}

		// COlS
		for (int j = 0; j < 3; j++) {
			if (!virtualboard[0][j].equals("") && virtualboard[0][j].equals(virtualboard[1][j])
					&& virtualboard[1][j].equals(virtualboard[2][j])) {
				return true;
			}
		}

		// LCROSS
		if (!virtualboard[0][0].equals("") && virtualboard[0][0].equals(virtualboard[1][1])
				&& virtualboard[1][1].equals(virtualboard[2][2])) {
			return true;
		}

		// RCROSS
		if (!virtualboard[0][2].equals("") && virtualboard[0][2].equals(virtualboard[1][1])
				&& virtualboard[1][1].equals(virtualboard[2][0])) {
			return true;
		}

		return false;

	}

}
