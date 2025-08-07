import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;

public class GameBoard extends JPanel {
    private Player mouse, cat;

    public GameBoard(){
        mouse = new Player(Toolkit.getDefaultToolkit().getImage("img/mouse.jpg"), 0, 0);
        cat =  new Player(Toolkit.getDefaultToolkit().getImage("img/cat.jpg"), 100, 100);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0,0, Constants.GAME_BOARD_WIDTH, Constants.GAME_BOARD_HEIGHT);
        g.drawImage(mouse.getAvatar(), mouse.getCoordinateX(), mouse.getCoordinateY(), this);
        g.drawImage(cat.getAvatar(), cat.getCoordinateX(), cat.getCoordinateY(), this);
    }

    public void gameStep(){
        mouse.move(MoveDirection.UP);
        repaint();
    }

}
