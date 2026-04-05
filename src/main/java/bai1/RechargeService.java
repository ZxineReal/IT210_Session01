package bai1;

public class RechargeService {
    /*
    private PaymentGateway gateway;

    public RechargeService() {
        // Lỗi: Tự khởi tạo thủ công (Hard-code dependency)
        this.gateway = new InternalPaymentGateway();
    }

    public void processRecharge(String username, double amount) {
        gateway.pay(amount);
        System.out.println("Nạp " + amount + " cho " + username);
    }

    Đoạn code sai: this.gateway = new InternalPaymentGateway();
    Vì:
    - RechargeService tự tạo ra InternalPaymentGateway
    - Khi muốn thêm phương thức thanh toán mới sẽ phải sửa trực tiếp RechargeService
    - Làm mất tính linh hoạt của hệ thống
     */
}