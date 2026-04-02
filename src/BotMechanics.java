import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;

public class BotMechanics {
	
	public static void startBot(JButton[][] board, JLabel user1Label, JLabel user2Label) {
		
		Random random = new Random();
		
		if(board[1][1].getText().equals("")) {
			board[1][1].setText("O");
			System.out.println("AI - Bot ortaya oynadi");
		}else if(board[0][0].getText().equals("") || board[0][2].getText().equals("") || board[2][0].getText().equals("")|| board[2][2].getText().equals("")) {
			ArrayList<JButton> cornersArrayList = new ArrayList<>();
			if(board[0][0].getText().equals(""))cornersArrayList.add(board[0][0]);
			if(board[0][2].getText().equals(""))cornersArrayList.add(board[0][2]);
			if(board[2][0].getText().equals(""))cornersArrayList.add(board[2][0]);
			if(board[2][2].getText().equals(""))cornersArrayList.add(board[2][2]);
			
			if(!cornersArrayList.isEmpty()) {
				JButton chosen = cornersArrayList.get(random.nextInt(cornersArrayList.size()));
				chosen.setText("O");
			}
			System.out.println("AI - Koselere Oynadi");
		}else {
			ArrayList<JButton> middleOfTheLineArrayList = new ArrayList<>();
			if(board[0][1].getText().equals(""))middleOfTheLineArrayList.add(board[0][1]);
			if(board[1][0].getText().equals(""))middleOfTheLineArrayList.add(board[1][0]);
			if(board[1][2].getText().equals(""))middleOfTheLineArrayList.add(board[1][2]);
			if(board[2][1].getText().equals(""))middleOfTheLineArrayList.add(board[2][1]);
			
			if(!middleOfTheLineArrayList.isEmpty()) {
				JButton chosen = middleOfTheLineArrayList.get(random.nextInt(middleOfTheLineArrayList.size()));
				chosen.setText("O");
			}
			System.out.println("AI - Cizgilerin ortasina oynadi");
		}
		
	}

}
