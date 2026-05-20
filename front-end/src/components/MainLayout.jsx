import { Outlet } from "react-router-dom";
import Banner from "./Banner.jsx";
import TopMenu from "./TopMenu.jsx";
import LeftMenu from "./LeftMenu.jsx";
import Footer from "./Footer.jsx";
import Logo from "./Logo.jsx";

function MainLayout() {
  return (
    <div className="main-layout">
      <Banner />
      <TopMenu />

      <div className="trang-chu-result-wrapper">
        <LeftMenu />
        <Outlet /> 
      </div>
      <Footer/>
    </div>
  );
}

export default MainLayout;
