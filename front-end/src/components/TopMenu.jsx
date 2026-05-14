import { NavLink, useLocation } from "react-router-dom";

function TopMenu() {
  return (
    <div className="top-menu">
      <NavLink to="/"><b>Trang chủ</b></NavLink>
      <NavLink to="/dang-nhap"><b>Đăng nhập</b></NavLink>
      <NavLink to="/dang-ky"><b>Đăng ký</b></NavLink>
      <NavLink to="/lien-he"><b>Liên hệ</b></NavLink>
      <NavLink to="/gio-hang"><b>Giỏ hàng</b></NavLink>
    </div>
  );
}

export default TopMenu;
