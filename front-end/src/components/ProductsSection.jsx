import { useEffect, useState } from "react";
import { getProductsByCategory } from "../services/api.js";
import Product from "./Product.jsx";

function ProductSection({category}) {
  const [products, setProducts] = useState([]);
  const [isLoading, setIsLoading] = useState(true);
  const [errorText, setErrorText] = useState("");

  useEffect(() => {
    setIsLoading(true);
    getProductsByCategory(category)
      .then((data) => {
        setProducts(data);
        setErrorText("");
      })
      .catch(() => {
        setErrorText("Có lỗi xảy ra khi tải sản phẩm.");
      })
      .finally(() => {
        setIsLoading(false);
      });
  }, [category]);

  if (isLoading) {
    return <p className="notice">Đang tải sản phẩm...</p>;
  }

  if (errorText || products.length === 0) {
    return <p className="notice">{errorText || "Không có sản phẩm nào."}</p>;
  }

  return (
    <div className="products-result-wrapper">
      {products.map((product) => (
        <Product key={product.id} product={product} />
      ))}
    </div>
  );
}

export default ProductSection;
