import javax.swing.JButton;

public class GameMechanics {

	private static String currentPlayer = "X";

	public static void selectCordinate(JButton button, JButton[][] board, int row, int column) {

		if (button.getText().equals("")) {
			button.setText(currentPlayer);
		}

        if (checkWinner(board)) {
            System.out.println(currentPlayer + " kazandı!");
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
	
	public static void restartGame(JButton[] button) {
		button.
	}

	public static void switchPlayer() {
		if (currentPlayer.equals("X")) {
			currentPlayer = "O";
		} else {
			currentPlayer = "X";
		}
	}
}