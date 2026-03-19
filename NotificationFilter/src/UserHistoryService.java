import java.time.LocalDateTime;
import java.util.List;

public interface UserHistoryService {
    List<Notification> getUserHistory(long userId, long notificationId, LocalDateTime time);
}
