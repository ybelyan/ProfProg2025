import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NotificationFilter {
    private final UserSettingsService userSettingsService;
    private final UserHistoryService userHistoryService;

    public NotificationFilter(UserSettingsService userSettingsService,
                              UserHistoryService userHistoryService) {
        this.userSettingsService = userSettingsService;
        this.userHistoryService = userHistoryService;
    }

    public List<Notification> filter(List<Notification> notifications, long senderId){
        List<Notification> filtered = new ArrayList<>();
        Set<Notification> unique = new HashSet<>();
        for(Notification n : notifications) {
            if(unique.add(n)) {
                UserSettings userSettings = userSettingsService.getUserSettings(n.getUserId());
                List<Notification> userHistory = userHistoryService.getUserHistory(n.getUserId(), n.getId(), LocalDateTime.now());
                if (userSettings.allowedTypes().contains(n.getType())
                        && !userSettings.blackSenderIdList().contains(senderId)
                        && userHistory.isEmpty()) {
                    filtered.add(n);
                }
            }
        }
        return filtered;
    }
}
