import java.awt.*;

public class Player implements Moveable {
    private Image avatar;
    private int coordinateX, coordinateY;

    public Player(Image avatar, int coordinateX, int coordinateY){
        this.avatar = avatar;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public Image getAvatar() {
        return avatar;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    @Override
    public void move(MoveDirection direction) {
        coordinateX += direction.getShiftX();
        coordinateY += direction.getShiftY();
    }
}
