    private String name;            // Tên sản phẩm
    private String description;     // Mô tả
    private double startingPrice;   // Giá khởi điểm
    private double currentPrice;    // Giá hiện tại (giá cao nhất đang được trả)
    private String highestBidderId; // ID của người đang trả giá cao nhất
    private LocalDateTime endTime;  // Thời gian kết thúc phiên đấu giá
    private boolean isActive;       // Trạng thái (đang mở hay đã đóng)