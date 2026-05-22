import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { getOrderHistory } from "../services/api.js";

function OrderHistoryPage() {
  const [orders, setOrders] = useState([]);
  const [isLoading, setIsLoading] = useState(true);
  const [errorMessage, setErrorMessage] = useState("");

  useEffect(() => {
    getOrderHistory()
      .then((data) => {
        setOrders(data);
        setErrorMessage("");
      })
      .catch((error) => {
        setErrorMessage("Bạn cần đăng nhập để xem lịch sử đặt hàng.");
      })
      .finally(() => {
        setIsLoading(false);
      });
  }, []);

  if (isLoading) {
    return <p className="notice">Đang tải lịch sử đặt hàng...</p>;
  }

  if (errorMessage) {
    return (
      <div className="history-page">
        <h2>Lịch sử đặt hàng</h2>
        <p>{errorMessage}</p>
        <Link className="primary-button" to="/dang-nhap">Đăng nhập</Link>
      </div>
    );
  }

  return (
    <div className="history-page">
      <h2>Lịch sử đặt hàng</h2>
      {orders.length === 0 ? (
        <p>Bạn chưa có đơn hàng nào.</p>
      ) : (
        <div className="history-list">
          {orders.map((order) => (
            <div className="history-item" key={order.id}>
              <h3>{order.productName}</h3>
              <p>Mã đơn: #{order.id}</p>
              <p>Số lượng: {order.quantity}</p>
              <p>Giá: {order.price}</p>
              <p>Trạng thái: {order.status}</p>
              <p>Ngày đặt: {order.createdAt ? new Date(order.createdAt).toLocaleString("vi-VN") : "Đang cập nhật"}</p>
            </div>
          ))}
        </div>
      )}
    </div>
  );
}

export default OrderHistoryPage;
