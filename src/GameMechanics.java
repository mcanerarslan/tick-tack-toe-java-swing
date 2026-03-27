import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GameMechanics {

	private static String currentPlayer = "X";
	private static int score1 = 0, score2 = 0;

	public static void selectCordinate(JFrame gameBoardFrame, JButton button, JButton[][] board, int row, int column,
			JLabel user1Label, JLabel user2Label) {

		if (!button.getText().equals("") || checkWinner(board)) {
			return;
		}

		button.setText(currentPlayer);

		if (checkWinner(board)) {
			if (currentPlayer == "X") {
				++score1;
				user1Label.setText("User 1: " + score1);
			} else {
				++score2;
				user2Label.setText("User 1: " + score2);
			}
			String winnerString = currentPlayer + " won!";
			JOptionPane.showMessageDialog(gameBoardFrame, winnerString, "Game", JOptionPane.INFORMATION_MESSAGE);
			clearBoard(board, user1Label, user2Label);
		} else if (checkBoardIsFull(board)) {
			JOptionPane.showMessageDialog(gameBoardFrame, "Tie game!", "Game", JOptionPane.INFORMATION_MESSAGE);
			clearBoard(board, user1Label, user2Label);
		} else {
			switchPlayer();
		}
	}

	public static boolean checkWinner(JButton[][] board) {
		// ROWS
		for (int i = 0; i < 3; i++) {
			if (!board[i][0].getText().equals("") && board[i][0].getText().equals(board[i][1].getText())
					&& board[i][1].getText().equals(board[i][2].getText())) {
				return true;
			}
		}

		// COLS
		for (int i = 0; i < 3; i++) {
			if (!board[0][i].getText().equals("") && board[0][i].getText().equals(board[1][i].getText())
					&& board[1][i].getText().equals(board[2][i].getText())) {
				return true;
			}
		}

		// LCROSS
		if (!board[0][0].getText().equals("") && board[0][0].getText().equals(board[1][1].getText())
				&& board[1][1].getText().equals(board[2][2].getText())) {
			return true;
		}

		// RCROSS
		if (!board[0][2].getText().equals("") && board[0][2].getText().equals(board[1][1].getText())
				&& board[1][1].getText().equals(board[2][0].getText())) {
			return true;
		}
		return false;
	}
	
	public static boolean checkBoardIsFull(JButton[][] board) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j].getText().equals("")) {
					return false;
				}
			}
		}

		return true;
	}
	
	public static void clearBoard(JButton[][] board,JLabel user1Label, JLabel user2Label) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {		
				board[i][j].setText("");
			}
		}
	}

	public static void restartGame(JButton[][] board,JLabel user1Label, JLabel user2Label) {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {		
				board[i][j].setText("");
			}
		}
		clearBoard(board, user1Label, user2Label);
		user1Label.setText("User 1: ");
		user2Label.setText("User 2: ");

	}

	public static void switchPlayer() {
		if (currentPlayer.equals("X")) {
			currentPlayer = "O";
		} else {
			currentPlayer = "X";
		}
	}
}