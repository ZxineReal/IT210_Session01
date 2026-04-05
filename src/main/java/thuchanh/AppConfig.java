package thuchanh;

import org.springframework.context.annotation.Bean;

public class AppConfig {
    @Bean
    public VIPNotification vipNotification(){
        return new VIPNotification();
    }

    @Bean
    public NormalNotification normalNotification(){
        return new NormalNotification();
    }

    @Bean
    public AccountManagement accountManagement(){
        return new AccountManagement();
    }
}
