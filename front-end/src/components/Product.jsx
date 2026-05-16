import { getProducts } from "../services/api";

// product là dữ liệu sản phẩm dạng json
function Product({product}) { 
    return ( 
        <div className="product-wrapper">
            <a href="">
                <div className="image-box">
                    <img src={product.image} alt="image-product" />
                </div>
                <div className="info-product-box">
                    <p><b>{product.name}</b></p>
                </div>
                <div className="price-product-box">
                    {
                        product.old_price < 0 || <p>Vui lòng liên hệ để biết thêm chi tiết!</p>
                    }
                    {
                        (product.old_price == product.price || product.old_price < product.price) && product.price >= 0?
                        <p>Giá: {product.price}</p>
                        :
                        <p>Giá: {product.price}</p>
                    }
                </div>
            </a>
        </div>
     );
}

export default Product;