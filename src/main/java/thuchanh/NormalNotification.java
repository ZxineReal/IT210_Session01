package thuchanh;

import org.springframework.context.annotation.Bean;

public class NormalNotification implements Notification {
    @Override
    public void sendNoti(String username, double balace) {
        System.out.println("[Sound] Tài khoản: " + username + " | Số dư: " + balace);
    }
}
