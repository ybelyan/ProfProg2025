import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainClass {
    public static void main(String[] args) {
        Notification notification = new Notification(1111L, 1L, "hello", NotificationType.EMAIL);
        Notification notification2 = new Notification(1112L, 1L, "hi", NotificationType.EMAIL);
        System.out.println("Полученное уведомление: " + notification);
        System.out.println("Полученное уведомление: " + notification2);
        UserSettingsService userSettingsService = new DatabaseUserSettingsService();
        UserHistoryService userHistoryService = new DatabaseUserHistoryService();
        NotificationFilter notificationFilter = new NotificationFilter(userSettingsService, userHistoryService);
        List<Notification> filtered = notificationFilter.filter(List.of(notification, notification2), 4L);
        for (Notification n : filtered) {
            System.out.println("Отфильтрованное уведомление: " + n);
        }
    }
}