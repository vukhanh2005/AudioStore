import LoginPage from "../../pages/LoginPage";

function DangNhapLayout({children}) {
    return ( 
        <div className="dang-nhap-layout-wrapper">
            {children}
        </div>
     );
}

export default DangNhapLayout;