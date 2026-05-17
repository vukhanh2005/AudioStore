import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { register } from "../services/api";

function RegisterPage() {
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    fullName: "",
    username: "",
    email: "",
    phone: "",
    address: "",
    avatar: "",
    password: "",
    confirmPassword: ""
  });
  const [message, setMessage] = useState("");
  const [isLoading, setIsLoading] = useState(false);

  function handleChange(event) {
    const { name, value } = event.target;
    setFormData((current) => ({
      ...current,
      [name]: value
    }));
  }

  async function handleSubmit(event) {
    event.preventDefault();
    setMessage("");

    if (formData.password !== formData.confirmPassword) {
      setMessage("Mật khẩu nhập lại không khớp");
      return;
    }

    setIsLoading(true);
    try {
      const account = await register({
        fullName: formData.fullName,
        username: formData.username.trim(),
        email: formData.email,
        phone: formData.phone,
        address: formData.address,
        avatar: formData.avatar,
        password: formData.password
      });
      localStorage.setItem("currentUser", JSON.stringify(account));
      window.dispatchEvent(new Event("authChanged"));
      setMessage("Đăng ký thành công");
      setTimeout(() => navigate("/"), 500);
    } catch (error) {
      setMessage(error.message || "Đăng ký thất bại");
    } finally {
      setIsLoading(false);
    }
  }

  return (
    <div className="register-page">
      <div className="content-title">
        <h2>Đăng ký tài khoản</h2>
      </div>

      <form className="form-register" onSubmit={handleSubmit}>
        <div className="register-input-box">
          <label>Tên tài khoản</label>
          <input type="text" name="fullName" value={formData.fullName} onChange={handleChange} placeholder="Nhập họ và tên" required />
        </div>

        <div className="register-input-box">
          <label>Tên đăng nhập</label>
          <input type="text" name="username" value={formData.username} onChange={handleChange} placeholder="Nhập tên đăng nhập" required />
        </div>

        <div className="register-input-box">
          <label>Email</label>
          <input type="email" name="email" value={formData.email} onChange={handleChange} placeholder="Nhập email" />
        </div>

        <div className="register-input-box">
          <label>Số điện thoại</label>
          <input type="tel" name="phone" value={formData.phone} onChange={handleChange} placeholder="Nhập số điện thoại" />
        </div>

        <div className="register-input-box">
          <label>Địa chỉ</label>
          <input type="text" name="address" value={formData.address} onChange={handleChange} placeholder="Nhập địa chỉ" />
        </div>

        <div className="register-input-box">
          <label>Avatar</label>
          <input type="url" name="avatar" value={formData.avatar} onChange={handleChange} placeholder="Nhập đường dẫn ảnh đại diện" />
        </div>

        <div className="register-input-box">
          <label>Mật khẩu</label>
          <input type="password" name="password" value={formData.password} onChange={handleChange} placeholder="Nhập mật khẩu" required />
        </div>

        <div className="register-input-box">
          <label>Nhập lại mật khẩu</label>
          <input type="password" name="confirmPassword" value={formData.confirmPassword} onChange={handleChange} placeholder="Nhập lại mật khẩu" required />
        </div>

        {message && (
          <p className={`login-message ${message.includes("thành công") ? "success" : "error"}`}>
            {message}
          </p>
        )}

        <div className="register-button-box">
          <button className="register-button" type="submit" disabled={isLoading}>
            {isLoading ? "Đang đăng ký..." : "Đăng ký"}
          </button>
        </div>

        <div style={{ display: "flex" }} className="Already-Acc-Box">
          <p className="is-have-acc-title">Đã có tài khoản?</p>
          <a href="/dang-nhap">Đăng nhập</a>
        </div>
      </form>
    </div>
  );
}

export default RegisterPage;
