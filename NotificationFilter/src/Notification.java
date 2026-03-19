import java.util.Objects;

public class Notification extends Object {
    private final long id;
    private final long userId;
    private final String text;
    private final NotificationType type;

    public Notification(long id, long userId, String text, NotificationType type){
        this.id = id;
        this.userId = userId;
        this.text = text;
        this.type = type;
    }

    public String getText(){
        return text;
    }

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public NotificationType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", userId=" + userId +
                ", text='" + text + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Notification that)) return false;
        return id == that.id && userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId);
    }
}
