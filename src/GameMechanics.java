import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GameMechanics {

	private static String currentPlayer = "X";
	private static int score1 = 0, score2 = 0;
	private static boolean isModeP2P = false;
	private static boolean isBotLastWinner = false;
	private static boolean wasLastMoveByBot = false;

	private static BotMechanics currentBotDifficulty = BotMechanics.EASY;

	public static void selectCordinate(JFrame gameBoardFrame, JButton button, JButton[][] board, int row, int column,
			JLabel user1Label, JLabel user2Label, JLabel waitingBotDecisionJLabel) {

		if (!button.getText().equals("") || checkWinner(board)) {
			return;
		}

		if (isModeP2P) {
			button.setText(currentPlayer);
			if (checkWinner(board)) {
				if (currentPlayer.equals("X")) {
					++score1;
					user1Label.setText("User (X): " + score1);
				} else {
					++score2;
					user2Label.setText("User (O): " + score2);
				}
				String winnerString = currentPlayer + " won!";
				JOptionPane.showMessageDialog(gameBoardFrame, winnerString, "Game", JOptionPane.PLAIN_MESSAGE);
				clearBoard(board, user1Label, user2Label, waitingBotDecisionJLabel);
			} else if (checkBoardIsFull(board)) {
				JOptionPane.showMessageDialog(gameBoardFrame, "Tie game!", "Game", JOptionPane.PLAIN_MESSAGE);
				clearBoard(board, user1Label, user2Label, waitingBotDecisionJLabel);
			} else {
				switchPlayer();
			}
		} else {

			waitingBotDecisionJLabel.setText("");

			if (currentPlayer.equals("X")) {
				button.setText("X");

				if (checkWinner(board)) {
					score1++;
					user1Label.setText("User: " + score1);
					JOptionPane.showMessageDialog(gameBoardFrame, "X won!");
					clearBoard(board, user1Label, user2Label, waitingBotDecisionJLabel);
					return;
				}

				if (checkBoardIsFull(board)) {
					JOptionPane.showMessageDialog(gameBoardFrame, "Tie game!");
					clearBoard(board, user1Label, user2Label, waitingBotDecisionJLabel);
					return;
				}

				switchPlayer();

				if (currentPlayer.equals("O")) {

					waitingBotDecisionJLabel.setText("The AI's selection is awaited.");

					javax.swing.Timer timer = new javax.swing.Timer(700, e -> {
						currentBotDifficulty.makeMove(board, user1Label, user2Label);
						if (checkWinner(board)) {
							score2++;
							user2Label.setText("Bot: " + score2);
							isBotLastWinner = true;
							JOptionPane.showMessageDialog(gameBoardFrame, "O won!");
							clearBoard(board, user1Label, user2Label, waitingBotDecisionJLabel);

						} else if (checkBoardIsFull(board)) {
							wasLastMoveByBot = true;
							JOptionPane.showMessageDialog(gameBoardFrame, "Tie game!");
							clearBoard(board, user1Label, user2Label, waitingBotDecisionJLabel);

						} else {
							switchPlayer();
						}

						waitingBotDecisionJLabel.setText("The AI made its selection.");
					});

					timer.setRepeats(false);
					timer.start();
				}

			}
		}
	}

	public static void clearBoard(JButton[][] board, JLabel user1Label, JLabel user2Label,
			JLabel waitingBotDecisionJLabel) {
		waitingBotDecisionJLabel.setText("");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j].setText("");
			}
		}

		if (!isModeP2P && (wasLastMoveByBot || isBotLastWinner)) {
			wasLastMoveByBot = false;
			isBotLastWinner = false;

			currentPlayer = "O";

			javax.swing.Timer timer = new javax.swing.Timer(700, e -> {
				currentBotDifficulty.makeMove(board, user1Label, user2Label);
				switchPlayer();
			});

			timer.setRepeats(false);
			timer.start();
		} else {
			currentPlayer = "X";
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

	public static void restartGame(JButton[][] board, JLabel user1Label, JLabel user2Label,
			JLabel waitingBotDecisionJLabel) {
		clearBoard(board, user1Label, user2Label, waitingBotDecisionJLabel);
		score1 = 0;
		score2 = 0;
		currentPlayer = "X";
		setScoreBoard(isModeP2P, user1Label, user2Label);
	}

	public static void changeMode(boolean decision, JButton[][] board, JLabel user1Label, JLabel user2Label,
			JLabel waitingBotDecisionJLabel) {
		if (decision != isModeP2P) {
			isModeP2P = decision;
			restartGame(board, user1Label, user2Label, waitingBotDecisionJLabel);
		}
	}

	public static void changeDifficulty(String difficulty) {
	    switch (difficulty) {
	        case "Easy":
	            currentBotDifficulty = BotMechanics.EASY;
	            break;
	        case "Medium":
	            currentBotDifficulty = BotMechanics.MEDIUM;
	            break;
	        case "Hard":
	        default:
	            currentBotDifficulty = BotMechanics.HARD;
	            break;
	    }
	}

	public static void setScoreBoard(Boolean decision, JLabel user1Label, JLabel user2Label) {
		if (decision) {
			user1Label.setText("User (X): ");
			user2Label.setText("User (O): ");
		} else {
			user1Label.setText("User: ");
			user2Label.setText("Bot: ");
		}
	}

	public static void switchPlayer() {
		if (currentPlayer.equals("X")) {
			currentPlayer = "O";
		} else {
			currentPlayer = "X";
		}
	}
}