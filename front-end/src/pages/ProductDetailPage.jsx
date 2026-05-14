import { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import { formatPrice, getProductById } from "../services/api.js";

function ProductDetailPage() {
  const { productId } = useParams();
  const [product, setProduct] = useState(null);
  const [isLoading, setIsLoading] = useState(true);
  const [errorMessage, setErrorMessage] = useState("");

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
  }, [productId]);

  if (isLoading) {
    return <p className="notice">Đang tải chi tiết sản phẩm...</p>;
  }

  if (errorMessage || !product) {
    return (
      <div className="content-title">
        <h2>Không tìm thấy sản phẩm</h2>
        <p>{errorMessage}</p>
        <Link className="primary-button" to="/">Quay về trang chủ</Link>
      </div>
    );
  }

  return (
    <div>
      <div className="content-title">
        <h2>Chi tiết sản phẩm</h2>
        <p>Thông tin chi tiết được đọc từ cơ sở dữ liệu SQL Server.</p>
      </div>

      <div className="product-detail">
        {product.image ? (
          <img src={product.image} alt={product.name} />
        ) : (
          <div className="product-detail-placeholder">Chưa có ảnh sản phẩm</div>
        )}
        <div>
          <p className="product-code">{product.code}</p>
          <h3>{product.name}</h3>
          <p className="product-price product-price--large">{formatPrice(product.price)}</p>
          <p><strong>Danh mục:</strong> {product.category}</p>
          <p>{product.description}</p>
          <button className="primary-button" type="button">Thêm vào giỏ hàng</button>
        </div>
      </div>
    </div>
  );
}

export default ProductDetailPage;
