import { Routes, Route } from 'react-router-dom'
import MainLayout from "./components/MainLayout.jsx";
import TrangChu from "./pages/TrangChu/index.jsx";
import ProductsSection from "./components/ProductsSection.jsx";
import LoginPage from './pages/LoginPage.jsx';
import DangNhapLayout from './Layouts/DangNhapLayout'
import DangKyLayout from './Layouts/DangKyLayout'
import RegisterPage from './pages/RegisterPage.jsx'
import ContactPage from './pages/ContactPage.jsx'
function App() {
  return (
    <Routes>
      <Route path="/" element={<MainLayout/>}>
        <Route index element={<TrangChu/>}></Route>
        <Route path="/tai-nghe" element={<ProductsSection category={"tai-nghe"}/>}></Route>
        <Route path="/micro" element={<ProductsSection category={"micro"}/>}></Route>
        <Route path="/hang-moi" element={<ProductsSection category={"hang-moi"}/>}></Route>
        <Route path="/hang-ban-chay" element={<ProductsSection category={"hang-ban-chay"}/>}></Route>
        <Route path="/hang-giam-gia" element={<ProductsSection category={"hang-giam-gia"}/>}></Route>
      </Route>
      {/* __________________________ */}
      <Route path="/dang-nhap" element={
        <DangNhapLayout>
          <LoginPage/>
        </DangNhapLayout>
      }>
      </Route>
      {/* __________________________ */}
      <Route
          path="/dang-ky"
          element={
            <DangKyLayout>
              <RegisterPage/>
            </DangKyLayout>
          }
        >
      </Route>
      {/* _________________________- */}
      <Route
          path="/lien-he"
          element={
            <ContactPage/>
          }
        >
      </Route>
    </Routes>
  );
}

export default App;