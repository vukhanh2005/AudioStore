import { getProducts } from "../services/api";

// product là dữ liệu sản phẩm dạng json
function Product({product}) { 
    return ( 
        <div className="product-wrapper">
            <div className="image-box">
                <img src={product.image} alt="image-product" />
            </div>
            <div className="info-product-box">
                <p>{product.name}</p>
            </div>
        </div>
     );
}

export default Product;