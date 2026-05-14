import { getProductsByCategory } from "../services/api.js";
import ProductCard from "./ProductCard.jsx";
import Product from "./Product.jsx"
function ProductSection({category}) {
  var title = category;
  console.log("Render: " + category);
  
  return (
    <div className="products-result-wrapper">
        <Product/>
        <Product/>
        <Product/>
        <Product/>
        <Product/>
        <Product/>
        <Product/>
        <Product/>
        <Product/>
        <Product/>
        <Product/>
        <Product/>
        <Product/>
    </div>
    
  );
}

export default ProductSection;
