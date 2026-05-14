import { Link } from "react-router-dom";
import { formatPrice } from "../services/api.js";

function ProductCard({ product }) {
  return (
    <article className="product-card">
      <Link to={`/san-pham/${product.id}`}>
        {product.image ? (
          <img src={product.image} alt={product.name} />
        ) : (
          <div className="product-image-placeholder">Chưa có ảnh</div>
        )}
      </Link>
      <div className="product-card__body">
        <p className="product-code">{product.code}</p>
        <h3>
          <Link to={`/san-pham/${product.id}`}>{product.name}</Link>
        </h3>
        <p className="product-price">{formatPrice(product.price)}</p>
        <Link className="detail-link" to={`/san-pham/${product.id}`}>
          Xem chi tiết
        </Link>
      </div>
    </article>
  );
}

export default ProductCard;
