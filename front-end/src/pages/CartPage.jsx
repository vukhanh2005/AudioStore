function CartPage() {
  return (
    <div>
      <div className="content-title">
        <h2>Giỏ hàng</h2>
        <p>Danh sách sản phẩm người dùng đã chọn sẽ hiển thị tại đây.</p>
      </div>

      <div className="empty-cart">
        <h3>Giỏ hàng đang trống</h3>
        <p>Hãy chọn sản phẩm từ trang chủ để thêm vào giỏ hàng.</p>
      </div>
    </div>
  );
}

export default CartPage;
