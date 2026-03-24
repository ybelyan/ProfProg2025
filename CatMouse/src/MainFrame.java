import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.BorderLayout.NORTH;


public class MainFrame extends JFrame {

    private final GameBoard gameBoard;

    public MainFrame(){
        setBounds(100,100,Constants.GAME_BOARD_WIDTH, Constants.GAME_BOARD_HEIGHT);
        setTitle("Кошки-мышки");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        gameBoard = new GameBoard();
        add(gameBoard);
        JButton button = new JButton("Сделать ход");
        add(button, NORTH);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameBoard.gameStep();
            }
        });
        setVisible(true);
    }

    public static void main(String[] args){
        new MainFrame();
    }

}