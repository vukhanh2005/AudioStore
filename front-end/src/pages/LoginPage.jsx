import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { login } from "../services/api";

function LoginPage() {
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    username: "",
    password: ""
  });
  const [message, setMessage] = useState("");
  const [isLoading, setIsLoading] = useState(false);

  function handleChange(e) {
    const { name, value } = e.target;
    console.log(name, "  ", value);
    
    setFormData((current) => ({
      ...current,
      [name]: value
    }));
  }

  async function handleSubmit(event) {
    event.preventDefault();
    setMessage("");
    setIsLoading(true);

    try {
      const token = await login(formData.username.trim(), formData.password);
      localStorage.setItem("mytoken", JSON.stringify(token));


      setMessage("Đăng nhập thành công");
      setTimeout(() => navigate("/"), 500);
    } catch (error) {
      setMessage(error.message || "Đăng nhập thất bại");
    } finally {
      setIsLoading(false);
    }
  }

  return (
    <div className="login-page">
      <form className="form-login" onSubmit={handleSubmit}>
        <div className="login-input-box">
          <label>
            <b>Email</b>
          </label>
          <input
            type="text"
            name="username"
            value={formData.username}
            onChange={handleChange}
            placeholder="Nhập email"
            required
          />
        </div>

        <div className="login-input-box">
          <label>
            <b>Password</b>
          </label>
          <input
            type="password"
            name="password"
            value={formData.password}
            onChange={handleChange}
            placeholder="Nhập mật khẩu"
            required
          />
        </div>

        {message && (
          <p className={`login-message ${message.includes("thành công") ? "success" : "error"}`}>
            {message}
          </p>
        )}

        <div className="sign-up-box">
          <p style={{ display: "inline-block" }} className="title-is-have-acc">Chưa có tài khoản?</p>
          <a href="/dang-ky"><b>Đăng ký</b></a>
        </div>

        <div className="form-login-button-box">
          <button className="login-button" type="submit" disabled={isLoading}>
            {isLoading ? "Đang đăng nhập..." : "Đăng nhập"}
          </button>
        </div>
      </form>
    </div>
  );
}

export default LoginPage;
