import { useEffect, useMemo, useState } from "react";
import { NavLink } from "react-router-dom";
import { getCurrentAccount, logout } from "../services/api";

function readStoredUser() {
  try {
    return JSON.parse(localStorage.getItem("currentUser") || "null");
  } catch {
    localStorage.removeItem("currentUser");
    return null;
  }
}

function TopMenu() {
  const [currentUser, setCurrentUser] = useState(() => null);

  useEffect(() => {
    getCurrentAccount()
      .then((account) => {
        // Đã từng đăng nhập
          setCurrentUser(account);
      }).catch((error)=>{
        // Chưa từng đăng nhập
          setCurrentUser(null);
      })

    function handleAuthChanged() {
      setCurrentUser(readStoredUser());
    }

    window.addEventListener("authChanged", handleAuthChanged);
    window.addEventListener("storage", handleAuthChanged);

    return () => {
      window.removeEventListener("authChanged", handleAuthChanged);
      window.removeEventListener("storage", handleAuthChanged);
    };
  }, []);


  async function handleLogout() {
    try {
      await logout();
    } catch {
      
    } finally {
      localStorage.removeItem("currentUser");
      setCurrentUser(null);
      window.dispatchEvent(new Event("authChanged"));
    }
  }
  
  return (
    <div className="top-menu">
      <div className="top-menu-links">
        <NavLink to="/"><b>Trang chủ</b></NavLink>
        <NavLink to="/lien-he"><b>Liên hệ</b></NavLink>
        <NavLink to="/lich-su-dat-hang"><b>Lịch sử</b></NavLink>
      </div>

      <div className="top-menu-auth">
        {currentUser ? (
          <>
            <button className="logout-button" type="button" onClick={handleLogout}>
              Đăng xuất
            </button>
          </>
        ) : (
          <NavLink className="login-link" to="/dang-nhap"><b>Đăng nhập</b></NavLink>
        )}
      </div>
    </div>
  );
}

export default TopMenu;
