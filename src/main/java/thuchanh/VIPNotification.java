package thuchanh;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class VIPNotification implements Notification {
    @Override
    public void sendNoti(String username, double balace) {
        System.out.println("[Popup] Tài khoản: " + username + " | Số dư: " + balace);
    }
}
