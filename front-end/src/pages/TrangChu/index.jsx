import { getProducts } from "../../services/api";

function TrangChu() {
    getProducts().then((data)=>{
        console.log(data);
    })
    return (
        <div className="trang-chu">
        </div>
    )
}

export default TrangChu;