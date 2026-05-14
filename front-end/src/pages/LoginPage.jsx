import { NavLink } from "react-router-dom";

function LoginPage() {
  return (
    <div className="login-page">
      <form className="form-login" action={"/login"}>
        <div className="login-input-box">
          <label>
            <b>Username</b>
          </label>
          <input type="text" name="username" placeholder="Nhập tên đăng nhập" />
        </div>

        <div className="login-input-box">
          <label>
            <b>Password</b>
          </label>
          <input type="password" name="password" placeholder="Nhập mật khẩu" />
        </div>

        <div className="sign-up-box">
          <p style={{
            display: "inline-block"
          }} className="title-is-have-acc">Chưa có tài khoản?</p>
          <a href="/dang-ky"><b>Đăng ký</b></a>
        </div>
        <div className="form-login-button-box">
          <button className="login-button" type="submit">Đăng nhập</button>
        </div>
      </form>
    </div>
  );
}

export default LoginPage;
