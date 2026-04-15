import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;

public class BotMechanics {

	private static Random random = new Random();

	public static void startBasicBot(JButton[][] board, JLabel user1Label, JLabel user2Label) {

		if (board[1][1].getText().equals("")) {
			board[1][1].setText("O");
		} else {
			ArrayList<JButton> randomPickArrayList = new ArrayList<>();
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (board[i][j].getText().equals("")) {
						randomPickArrayList.add(board[i][j]);
					}

				}
			}

			if (!randomPickArrayList.isEmpty()) {
				JButton chosen = randomPickArrayList.get(random.nextInt(randomPickArrayList.size()));
				chosen.setText("O");
			}
		}

	}

	public static void startMediumBot(JButton[][] board, JLabel user1Label, JLabel user2Label) {

		if (board[1][1].getText().equals("")) {
			board[1][1].setText("O");
		} else if (board[0][0].getText().equals("") || board[0][2].getText().equals("")
				|| board[2][0].getText().equals("") || board[2][2].getText().equals("")) {
			ArrayList<JButton> cornersArrayList = new ArrayList<>();
			if (board[0][0].getText().equals(""))
				cornersArrayList.add(board[0][0]);
			if (board[0][2].getText().equals(""))
				cornersArrayList.add(board[0][2]);
			if (board[2][0].getText().equals(""))
				cornersArrayList.add(board[2][0]);
			if (board[2][2].getText().equals(""))
				cornersArrayList.add(board[2][2]);

			if (!cornersArrayList.isEmpty()) {
				JButton chosen = cornersArrayList.get(random.nextInt(cornersArrayList.size()));
				chosen.setText("O");
			}

		} else {
			ArrayList<JButton> middleOfTheLineArrayList = new ArrayList<>();
			if (board[0][1].getText().equals(""))
				middleOfTheLineArrayList.add(board[0][1]);
			if (board[1][0].getText().equals(""))
				middleOfTheLineArrayList.add(board[1][0]);
			if (board[1][2].getText().equals(""))
				middleOfTheLineArrayList.add(board[1][2]);
			if (board[2][1].getText().equals(""))
				middleOfTheLineArrayList.add(board[2][1]);

			if (!middleOfTheLineArrayList.isEmpty()) {
				JButton chosen = middleOfTheLineArrayList.get(random.nextInt(middleOfTheLineArrayList.size()));
				chosen.setText("O");
			}
		}

	}

	public static void startHardBot(JButton[][] board, JLabel user1Label, JLabel user2Label) {

		if (winNextMove(board,"O")) {

		} else if (winNextMove(board, "X")) {

		} else {
			startMediumBot(board, user1Label, user2Label);
		}

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
