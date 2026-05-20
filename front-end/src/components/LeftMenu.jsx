import { NavLink } from "react-router-dom";

const categories = [
  {name: "Tất cả", path: "/"},
  {name: "Tai nghe", path: "/tai-nghe"},
  {name: "Micro", path: "/micro"},
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
