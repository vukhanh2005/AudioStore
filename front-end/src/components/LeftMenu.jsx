import { NavLink } from "react-router-dom";

const categories = [
  {name: "Tai nghe", path: "/tai-nghe"},
  {name: "Micro", path: "/micro"},
  {name: "Hàng mới", path: "/hang-moi"},
  {name: "Hàng bán chạy", path: "/hang-ban-chay"},
  {name: "Hàng giảm giá", path: "/hang-giam-gia"},
];

function LeftMenu() {
  return (
    <div className="left-menu">
      <h2>Danh mục sản phẩm</h2>
      <ul>
        {categories.map((category) => (
          <li key={category}>
            <NavLink to={category.path}><b>{category.name}</b></NavLink>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default LeftMenu;
