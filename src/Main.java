import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.foreign.AddressLayout;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main {

	public static void main(String args[]) {

		JFrame gameBoardFrame = new JFrame("X O X - GAME");
		gameBoardFrame.setLayout(new BorderLayout());

		URL bgUrl = Main.class.getResource("/assets/bg.png");
//		System.out.println("bgUrl = " + bgUrl);

		if (bgUrl != null) {
		    JLabel backgroundMenu = new JLabel(new ImageIcon(bgUrl));
		    backgroundMenu.setLayout(new BorderLayout());
		    backgroundMenu.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		    gameBoardFrame.setContentPane(backgroundMenu);
		} else {
			System.out.println("Background image not found");
		}

		JMenuBar menuBar = new JMenuBar();
		JMenu game = new JMenu("Game");
		JMenuItem nGame = new JMenuItem("New Game");
		JMenuItem cGame = new JMenuItem("Clear");
		JMenuItem eGame = new JMenuItem("Exit");
		game.add(nGame);
		game.add(cGame);
		game.add(eGame);
		JMenu gameMode = new JMenu("Mode");
		JMenuItem pwb = new JMenuItem("Play with AI");
		JMenuItem pwp = new JMenuItem("Play with Player");
		gameMode.add(pwb);
		gameMode.add(pwp);
		JMenu help = new JMenu("Help");
		JMenuItem howToPlay = new JMenuItem("How to play");
		JMenuItem aboutGame = new JMenuItem("About");
		help.add(howToPlay);
		help.add(aboutGame);
		menuBar.add(game);
		menuBar.add(gameMode);
		menuBar.add(help);

		JPanel rightGameBoard = new JPanel(new GridLayout(3, 3, 10, 10));
		JPanel leftInfoBoard = new JPanel(new GridLayout(4, 1, 50, 20));
		JPanel infoBottom = new JPanel(new FlowLayout());
		JPanel scoreBoard = new JPanel(new GridLayout(1, 2, 25, 25));

		JLabel gameTitleJLabel = new JLabel("X O X - GAME");
		gameTitleJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		gameTitleJLabel.setHorizontalAlignment(JLabel.CENTER);

		JLabel user1StatsJLabel = new JLabel("User 1: ");
		user1StatsJLabel.setFont(new Font("Arial", Font.BOLD, 15));
		JLabel user2StatsJLabel = new JLabel("User 2: ");
		user2StatsJLabel.setFont(new Font("Arial", Font.BOLD, 15));

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

		JButton restartbtn = new JButton("Restart Game");
		JButton clearbtn = new JButton("Clear Board");

		infoBottom.add(restartbtn);
		infoBottom.add(clearbtn);

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

		restartbtn.addActionListener(e -> GameMechanics.restartGame(board, user1StatsJLabel, user2StatsJLabel));
		clearbtn.addActionListener(e -> GameMechanics.clearBoard(board, user1StatsJLabel, user2StatsJLabel));

		nGame.addActionListener(e -> GameMechanics.restartGame(board, user1StatsJLabel, user2StatsJLabel));
		cGame.addActionListener(e -> GameMechanics.clearBoard(board, user1StatsJLabel, user2StatsJLabel));
		eGame.addActionListener(e -> System.exit(0));
		
		pwb.addActionListener(e-> GameMechanics.changeMode(false,board,user1StatsJLabel,user2StatsJLabel));
		pwp.addActionListener(e-> GameMechanics.changeMode(true,board,user1StatsJLabel,user2StatsJLabel));

		row1col1.addActionListener(e -> GameMechanics.selectCordinate(gameBoardFrame, row1col1, board, 0, 0,
				user1StatsJLabel, user2StatsJLabel));
		row1col2.addActionListener(e -> GameMechanics.selectCordinate(gameBoardFrame, row1col2, board, 0, 1,
				user1StatsJLabel, user2StatsJLabel));
		row1col3.addActionListener(e -> GameMechanics.selectCordinate(gameBoardFrame, row1col3, board, 0, 2,
				user1StatsJLabel, user2StatsJLabel));
		row2col1.addActionListener(e -> GameMechanics.selectCordinate(gameBoardFrame, row2col1, board, 1, 0,
				user1StatsJLabel, user2StatsJLabel));
		row2col2.addActionListener(e -> GameMechanics.selectCordinate(gameBoardFrame, row2col2, board, 1, 1,
				user1StatsJLabel, user2StatsJLabel));
		row2col3.addActionListener(e -> GameMechanics.selectCordinate(gameBoardFrame, row2col3, board, 1, 2,
				user1StatsJLabel, user2StatsJLabel));
		row3col1.addActionListener(e -> GameMechanics.selectCordinate(gameBoardFrame, row3col1, board, 2, 0,
				user1StatsJLabel, user2StatsJLabel));
		row3col2.addActionListener(e -> GameMechanics.selectCordinate(gameBoardFrame, row3col2, board, 2, 1,
				user1StatsJLabel, user2StatsJLabel));
		row3col3.addActionListener(e -> GameMechanics.selectCordinate(gameBoardFrame, row3col3, board, 2, 2,
				user1StatsJLabel, user2StatsJLabel));

		howToPlay.addActionListener(e -> {
			JLabel dialogLabel = new JLabel(gameGuideJLabel.getText());
			dialogLabel.setFont(gameGuideJLabel.getFont());
			dialogLabel.setHorizontalAlignment(JLabel.CENTER);
			JOptionPane.showMessageDialog(null, dialogLabel, "How to play", JOptionPane.PLAIN_MESSAGE);
		});

		aboutGame.addActionListener(e -> {
			JLabel aboutText = new JLabel("<html>"
					+ "<h2>X O X - GAME</h2>" 
					+ "<b>Developer:</b> Mahmut Caner Arslan<br>" 
					+ "<b>GitHub:</b> mcanerarslan<br><br>" 
					+ "This is a simple Tic-Tac-Toe game developed with Java Swing." 
					+ "</html>");
			aboutText.setFont(gameGuideJLabel.getFont());
			aboutText.setHorizontalAlignment(JLabel.CENTER);
			JOptionPane.showMessageDialog(null, aboutText, "About", JOptionPane.PLAIN_MESSAGE);
		});

		for (JButton cell : cells) {
			cell.setBorderPainted(false);
			cell.setFocusPainted(false);
			cell.setFont(new Font("Arial", Font.BOLD, 140));
			cell.setHorizontalAlignment(JLabel.CENTER);
			cell.setVerticalAlignment(JLabel.CENTER);
			cell.setForeground(Color.WHITE);
		}

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

		gameBoardFrame.setJMenuBar(menuBar);

		gameBoardFrame.setSize(900, 540);
		gameBoardFrame.setResizable(false);
		gameBoardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameBoardFrame.setLocationRelativeTo(null);
		gameBoardFrame.setVisible(true);
	}
}