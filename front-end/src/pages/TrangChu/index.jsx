import Product from "../../components/Product";
import { getProducts } from "../../services/api";
import {useState, useEffect} from 'react'
function TrangChu() {
    const [products, setProducts] = useState([])
    const [isLoading, setIsLoading] = useState(true);
    const [errorText, setErrorText] = useState("");
    
    useEffect(() => {
        getProducts().then((data)=>{
            setProducts(data);
        }
        ).catch(()=>{
            setErrorText("Có lỗi xảy ra!")
            console.log("Wrong at TrangChu component");
            
        }).finally(()=>{
            setIsLoading(false)
        })
    }, []);

    if(errorText || products.length===0){
        return (
            <div>
                Không có sản phẩm nào.
            </div>
        )
    }
    
    return (
        <div className="trang-chu">
            {
                products.map((product)=>{
                    return <Product product={product}/>
                })
            }
        </div>
    )
}

export default TrangChu;