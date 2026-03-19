import java.time.LocalDateTime;
import java.util.List;

public class DatabaseUserHistoryService implements UserHistoryService{
    @Override
    public List<Notification> getUserHistory(long userId, long notificationId, LocalDateTime time) {
        return List.of();
    }
}
