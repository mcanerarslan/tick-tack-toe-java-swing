import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {

	public static void main(String args[]) {

		JFrame gameBoardFrame = new JFrame("X O X - GAME");
		gameBoardFrame.setLayout(new BorderLayout());

		URL bgUrl = Main.class.getResource("/bg.png");
		System.out.println("bgUrl = " + bgUrl);

		if (bgUrl != null) {
			JLabel backgroundMenu = new JLabel(new ImageIcon(bgUrl));
			backgroundMenu.setLayout(new BorderLayout());
			gameBoardFrame.setContentPane(backgroundMenu);
		} else {
			System.out.println("Background image not found");
		}

		JPanel rightGameBoard = new JPanel(new GridLayout(3, 3, 20, 20));
		JPanel leftInfoBoard = new JPanel(new GridLayout(4, 1, 50, 20));
		JPanel infoBottom = new JPanel(new FlowLayout());
		JPanel scoreBoard = new JPanel(new GridLayout(1, 2, 25, 25));

		JLabel gameTitleJLabel = new JLabel("X O X - GAME");
		gameTitleJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		gameTitleJLabel.setHorizontalAlignment(JLabel.CENTER);

		JLabel user1StatsJLabel = new JLabel("User 1: ");
		JLabel user2StatsJLabel = new JLabel("User 2: ");

		user1StatsJLabel.setHorizontalAlignment(JLabel.CENTER);
		user2StatsJLabel.setHorizontalAlignment(JLabel.CENTER);

		scoreBoard.add(user1StatsJLabel);
		scoreBoard.add(user2StatsJLabel);

		JLabel gameGuideJLabel = new JLabel("<html>" + "<div style='margin: 20px;'>" + "<b>How to Play</b><br>"
				+ "Start the game and take turns placing " + "<font color='red'><b>X</b></font> and "
				+ "<font color='blue'><b>O</b></font> on the board.<br>"
				+ "The goal is to get three marks in a row.<br>"
				+ "You can win horizontally, vertically, or diagonally.<br>"
				+ "If no player gets three in a row, the game ends in a draw." + "</div>" + "</html>");
		gameGuideJLabel.setFont(new Font("Arial", Font.ITALIC, 12));
		gameGuideJLabel.setHorizontalAlignment(JLabel.CENTER);

		JButton startbtn = new JButton("Start");
		JButton stopbtn = new JButton("Stop");
		JButton restartbtn = new JButton("Restart");

		infoBottom.add(startbtn);
		infoBottom.add(stopbtn);
		infoBottom.add(restartbtn);

		JButton row1col1 = new JButton("");
		JButton row1col2 = new JButton("");
		JButton row1col3 = new JButton("");
		JButton row2col1 = new JButton("");
		JButton row2col2 = new JButton("");
		JButton row2col3 = new JButton("");
		JButton row3col1 = new JButton("");
		JButton row3col2 = new JButton("");
		JButton row3col3 = new JButton("");

		JButton[][] board = { { row1col1, row1col2, row1col3 }, { row2col1, row2col2, row2col3 },
				{ row3col1, row3col2, row3col3 } };

		JButton[] cells = { row1col1, row1col2, row1col3, row2col1, row2col2, row2col3, row3col1, row3col2, row3col3 };

		restartbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (JButton cell : cells) {
					cell.setText("");
				}
				user1StatsJLabel.setText("User 1: ");
				user2StatsJLabel.setText("User 2: ");
			}
		});

		for (JButton cell : cells) {
			cell.setBorderPainted(false);
			cell.setFocusPainted(false);
			cell.setFont(new Font("Arial", Font.BOLD, 150));
			cell.setForeground(Color.WHITE);
		}

		row1col1.addActionListener(e -> GameMechanics.selectCordinate(row1col1, board, 0, 0));
		row1col2.addActionListener(e -> GameMechanics.selectCordinate(row1col2, board, 0, 1));
		row1col3.addActionListener(e -> GameMechanics.selectCordinate(row1col3, board, 0, 2));
		row2col1.addActionListener(e -> GameMechanics.selectCordinate(row2col1, board, 1, 0));
		row2col2.addActionListener(e -> GameMechanics.selectCordinate(row2col2, board, 1, 1));
		row2col3.addActionListener(e -> GameMechanics.selectCordinate(row2col3, board, 1, 2));
		row3col1.addActionListener(e -> GameMechanics.selectCordinate(row3col1, board, 2, 0));
		row3col2.addActionListener(e -> GameMechanics.selectCordinate(row3col2, board, 2, 1));
		row3col3.addActionListener(e -> GameMechanics.selectCordinate(row3col3, board, 2, 2));

		user1StatsJLabel.setForeground(Color.WHITE);
		user2StatsJLabel.setForeground(Color.WHITE);
		gameTitleJLabel.setForeground(Color.WHITE);
		gameGuideJLabel.setForeground(Color.WHITE);

		leftInfoBoard.add(gameTitleJLabel);
		leftInfoBoard.add(scoreBoard);
		leftInfoBoard.add(gameGuideJLabel);
		leftInfoBoard.add(infoBottom);

		rightGameBoard.add(row1col1);
		rightGameBoard.add(row1col2);
		rightGameBoard.add(row1col3);
		rightGameBoard.add(row2col1);
		rightGameBoard.add(row2col2);
		rightGameBoard.add(row2col3);
		rightGameBoard.add(row3col1);
		rightGameBoard.add(row3col2);
		rightGameBoard.add(row3col3);

		gameBoardFrame.add(leftInfoBoard, BorderLayout.WEST);
		gameBoardFrame.add(rightGameBoard, BorderLayout.CENTER);

		leftInfoBoard.setOpaque(false);
		rightGameBoard.setOpaque(false);
		infoBottom.setOpaque(false);
		scoreBoard.setOpaque(false);

		gameBoardFrame.setSize(900, 540);
		gameBoardFrame.setResizable(false);
		gameBoardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameBoardFrame.setLocationRelativeTo(null);
		gameBoardFrame.setVisible(true);
	}
}