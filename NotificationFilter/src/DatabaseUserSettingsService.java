import java.util.List;

public class DatabaseUserSettingsService implements UserSettingsService{
    @Override
    public UserSettings getUserSettings(long userId) {
        return new UserSettings(1L, List.of(NotificationType.EMAIL, NotificationType.SMS), List.of(2L, 3L));
    }
}
