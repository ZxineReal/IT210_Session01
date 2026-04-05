BÁO CÁO PHÂN TÍCH VÀ THIẾT KẾ GIẢI PHÁP
Tính năng: Đặt đồ ăn tại máy trạm (Order Food)
1. Dữ liệu đầu vào (Input)

userId: String (mã khách hàng)
foodItem: String (tên món ăn, ví dụ: "Mì xào bò")
quantity: int (số lượng)

2. Kết quả mong đợi (Output)

Thành công:
success = true, thông báo “Đặt hàng thành công!”, có orderId
Thất bại:
success = false, kèm thông báo lỗi:
Hết hàng → “Món ăn đã hết hàng”
Không đủ tiền → “Số dư không đủ”
Sai dữ liệu → “Thông tin không hợp lệ”


3. Các bước xử lý logic 

- Nhận thông tin đặt hàng: userId, foodItem, quantity
- Kiểm tra quantity > 0. Nếu không → báo lỗi
- Kiểm tra kho hàng (InventoryRepository):
- Nếu tồn kho < quantity → báo lỗi “Hết hàng”

- Tính tổng tiền = giá món × quantity
- Kiểm tra số dư tài khoản (UserAccountRepository):
- Nếu số dư < tổng tiền → báo lỗi “Không đủ tiền”

- Trừ tiền trong tài khoản
- Trừ số lượng trong kho
- Tạo mã đơn hàng và trả về kết quả thành công