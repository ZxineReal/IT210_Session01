package thuchanh;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountManagement {
    List<Account> list = new ArrayList<>(
            Arrays.asList(
                    new Account("nguyenvana", 4000),
                    new Account("nguyenvanb", 10000),
                    new Account("tranvanc", 50000)
            )
    );

    public void checkBalance(String username, String area) {
        if (username.trim().isEmpty() || username == null) {
            System.out.println("Username không hợp lệ");
            return;
        }

        boolean isExist = list.stream().anyMatch(account -> account.getUsername().equals(username));

        if (!isExist) {
            System.out.println("Account không tồn tại");
            return;
        }

        Account account = list.stream().filter(u -> u.getUsername().equals(username)).findFirst().orElse(null);
        if (account != null) {
            if (account.getBalance() < 0) {
                System.out.println("Không đủ số dư");
                return;
            }

            ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

            if (account.getBalance() < 5000) {
                String nameBean = "";
                if (area.equals("Vip")) {
                    nameBean += "vip";
                    VIPNotification vipNotification = context.getBean("vipNotification", VIPNotification.class);
                    vipNotification.sendNoti(username, account.getBalance());
                } else {
                    nameBean += "normal";
                    NormalNotification normalNotification = context.getBean("normalNotification", NormalNotification.class);
                    normalNotification.sendNoti(username, account.getBalance());
                }
                nameBean += "Notification";

                Notification notification = context.getBean(nameBean, Notification.class);
            }
        }
    }
}
