# Giỏi 4: Tối ưu Cổng Thông báo Nạp tiền

## 1. Phân tích yêu cầu
Hệ thống Cyber Center cần gửi thông báo khi khách hàng nạp tiền thành công.  
`NotificationService` phụ thuộc vào hai thành phần:
- `EmailSender`
- `SmsSender`

Có 3 cách tiêm Dependency Injection:
- Constructor Injection
- Field Injection
- Setter Injection

Nhiệm vụ: Phân tích và chọn cách tối ưu nhất.

## 2. Bảng so sánh hai giải pháp chính

| Tiêu chí                    | Constructor Injection                          | Field Injection (@Autowired)                  |
|-----------------------------|------------------------------------------------|-----------------------------------------------|
| Tính rõ ràng                | Rất rõ ràng (phụ thuộc hiển thị ngay constructor) | Ít rõ ràng, phụ thuộc ẩn                      |
| Tính an toàn                | Rất cao (không tạo được object nếu thiếu phụ thuộc) | Thấp hơn                                      |
| Dễ viết Unit Test           | Rất dễ                                         | Khó hơn                                       |
| Hỗ trợ final                | Có                                             | Không                                         |
| Loose Coupling              | Tốt nhất                                       | Trung bình                                    |
| Có thể thay đổi sau khi tạo | Không                                          | Có (nhưng ít dùng)                            |
| Phù hợp với mandatory dependencies | Rất phù hợp                                    | Không khuyến khích                           |
| Độ ngắn gọn của code        | Trung bình                                     | Ngắn hơn                                      |

## 3. Phân tích bẫy dữ liệu
Hệ thống có thể gặp lỗi mạng khi kết nối dịch vụ SMS.  
Do đó cần một giải pháp DI giúp code dễ bảo trì, dễ thay thế SmsSender khi xảy ra lỗi (ví dụ: fallback sang chỉ gửi Email).

## 4. Lựa chọn tối ưu

**Giải pháp được chọn: Constructor Injection**

### Lý do chọn Constructor Injection:
- Phù hợp nhất với các phụ thuộc bắt buộc (mandatory dependencies)
- Code rõ ràng, dễ đọc và dễ hiểu
- Dễ viết Unit Test
- Hỗ trợ khai báo `final` → an toàn và immutable
- Dễ dàng thay thế SmsSender khi mạng bị lỗi
- Tuân thủ tốt nguyên tắc Loose Coupling và Dependency Inversion
