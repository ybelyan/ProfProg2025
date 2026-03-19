import java.util.List;

public record UserSettings(long userId, List<NotificationType> allowedTypes, List<Long> blackSenderIdList) {
}
