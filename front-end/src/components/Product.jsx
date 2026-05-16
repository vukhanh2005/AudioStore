// product là dữ liệu sản phẩm dạng json
function Product({product}) {
    const price = Number(product.price);
    const oldPrice = Number(product.oldPrice ?? product.old_price);

    function renderPrice() {
        if (price < 0) {
            return <p>Vui lòng liên hệ để biết thêm chi tiết!</p>;
        }

        if (price === 0) {
            return <p>FREE</p>;
        }

        if (oldPrice > price) {
            return (
                <>
                    <p className="old-price">Giá cũ: {oldPrice}</p>
                    <p>Giá mới: {price}</p>
                </>
            );
        }

        return <p>Giá: {price}</p>;
    }

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
                    {renderPrice()}
                </div>
            </a>
        </div>
     );
}

export default Product;
