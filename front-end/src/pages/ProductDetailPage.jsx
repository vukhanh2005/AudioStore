import { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import Product from "../components/Product.jsx";
import { getCurrentAccount, getProductById, orderProduct } from "../services/api.js";

function ProductDetailPage() {
  const { productId } = useParams();
  const navigate = useNavigate();
  const [product, setProduct] = useState(null);
  const [currentAccount, setCurrentAccount] = useState(null);
  const [isLoading, setIsLoading] = useState(true);
  const [isOrdering, setIsOrdering] = useState(false);
  const [errorMessage, setErrorMessage] = useState("");
  const [popup, setPopup] = useState(null);

  useEffect(() => {
    getProductById(productId)
      .then((data) => {
        setProduct(data);
        setErrorMessage("");
      })
      .catch(() => {
        setErrorMessage("Không tìm thấy sản phẩm hoặc backend chưa sẵn sàng.");
      })
      .finally(() => {
        setIsLoading(false);
      });

    getCurrentAccount()
      .then((account) => {
        setCurrentAccount(account);
        localStorage.setItem("currentUser", JSON.stringify(account));
      })
      .catch(() => {
        setCurrentAccount(null);
        localStorage.removeItem("currentUser");
      });
  }, [productId]);

  async function handleOrder() {
    if (!currentAccount) {
      setPopup({
        type: "login",
        title: "Bạn cần đăng nhập",
        message: "Vui lòng đăng nhập trước khi đặt hàng."
      });
      return;
    }

    setIsOrdering(true);
    try {
      const order = await orderProduct(product.id);
      setPopup({
        type: "success",
        title: "Đặt hàng thành công",
        message: order.message || "Đơn hàng của bạn đã được ghi nhận."
      });
      setProduct((current) => ({
        ...current,
        soluong: Math.max(Number(current.soluong || 0) - 1, 0)
      }));
    } catch (error) {
      if (error.status === 401) {

      }

      setPopup({
        type: "error",
        title: "Không thể đặt hàng",
        message: error.message || "Sản phẩm đã hết hàng hoặc backend chưa sẵn sàng."
      });
    } finally {
      setIsOrdering(false);
    }
  }

  if (isLoading) {
    return <p className="notice">Đang tải chi tiết sản phẩm...</p>;
  }

  if (errorMessage || !product) {
    return (
      <div className="history-page">
        <h2>Không tìm thấy sản phẩm</h2>
        <p>{errorMessage}</p>
        <Link className="primary-button" to="/">Quay về trang chủ</Link>
      </div>
    );
  }

  return (
    <div className="product-detail-page">
      <div className="content-title product-detail-title">
        <h2>Chi tiết sản phẩm</h2>
      </div>

      <div className="product-detail">
        <Product product={product} isDetail />
        <div className="product-detail-actions">
          <p>
            {currentAccount
              ? ""
              : "Bạn chưa đăng nhập"}
          </p>
          <button className="primary-button" type="button" onClick={handleOrder} disabled={isOrdering}>
            {isOrdering ? "Đang đặt hàng..." : "Đặt hàng"}
          </button>
        </div>
      </div>

      {popup && (
        <div className="popup-backdrop">
          <div className="popup">
            <button className="popup-close" type="button" onClick={() => setPopup(null)}>X</button>
            <h3>{popup.title}</h3>
            <p>{popup.message}</p>
            {popup.type === "login" && (
              <button className="primary-button" type="button" onClick={() => navigate("/dang-nhap")}>
                Đăng nhập
              </button>
            )}
          </div>
        </div>
      )}
    </div>
  );
}

export default ProductDetailPage;
