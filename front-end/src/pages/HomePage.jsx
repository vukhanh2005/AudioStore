import { useEffect, useState } from "react";
import ProductsSection from "../components/ProductsSection.jsx";
import { getProducts } from "../services/api.js";

function HomePage() {
  const [products, setProducts] = useState([]);
  const [isLoading, setIsLoading] = useState(true);
  const [errorMessage, setErrorMessage] = useState("");

  useEffect(() => {
    getProducts()
      .then((data) => {
        setProducts(data);
        setErrorMessage("");
      })
      .catch(() => {
        setErrorMessage("Chưa lấy được sản phẩm từ backend. Hãy kiểm tra Spring Boot và SQL Server.");
      })
      .finally(() => {
        setIsLoading(false);
      });
  }, []);

  function renderProducts(){
    return (
      <div className="all-products-box">
        {
          products.map((product)=>{
            return (
              <div>
                <h1>{product.name}</h1>
                <p>Giá: {product.price}</p>
              </div>
            )
          })
        }
      </div>
    )
  }
  return (
    <>
      <div className="content-title">
        <h2>Trang chủ</h2>
        <p>Danh sách sản phẩm</p>
      </div>

      {isLoading && <p className="notice">Đang tải sản phẩm...</p>}
      {errorMessage && <p className="notice notice--error">{errorMessage}</p>}
      {!isLoading && !errorMessage && products.length === 0 && (
        <p className="notice">Cơ sở dữ liệu chưa có sản phẩm nào.</p>
      )}
      {!isLoading && errorMessage==="" && renderProducts()}
    </>
  );
}

export default HomePage;
