import { Link } from "react-router-dom";

function NotFoundPage() {
  return (
    <div className="content-title">
      <h2>Không tìm thấy trang</h2>
      <p>Đường dẫn bạn truy cập không tồn tại.</p>
      <Link className="primary-button" to="/">Quay về trang chủ</Link>
    </div>
  );
}

export default NotFoundPage;
