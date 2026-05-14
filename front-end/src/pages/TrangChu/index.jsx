import { getProducts } from "../../services/api";

function TrangChu() {
    getProducts().then((data)=>{
        console.log(data);
    })
    return (
        <div className="trang-chu">
            <div className="trang-chu-title-content">
                <h1>Toàn bộ sản phẩm</h1>
                <hr></hr>
            </div>
            <div className="products-box">

            </div>
        </div>
    )
}

export default TrangChu;