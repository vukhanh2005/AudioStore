function RegisterPage() {
  return (
    <div className="register-page">
      <div className="content-title">
        <h2>Đăng ký tài khoản</h2>
      </div>

      <form className="form-register" method="post">
        <div className="register-input-box">
          <label>
            Tên tài khoản
          </label>
          <input type="text" name="fullName" placeholder="Nhập họ và tên" />
        </div>

        <div className="register-input-box">
          <label>
            Tên đăng nhập
          </label>
          <input type="text" name="username" placeholder="Nhập tên đăng nhập" />
        </div>

        <div className="register-input-box">
          <label>
            Email
          </label>
          <input type="email" name="email" placeholder="Nhập email" />
        </div>

        <div className="register-input-box">
          <label>
            Số điện thoại
          </label>
          <input type="tel" name="phone" placeholder="Nhập số điện thoại" />
        </div>

        <div className="register-input-box">
          <label>
            Địa chỉ
          </label>
          <input type="text" name="address" placeholder="Nhập địa chỉ" />
        </div>

        <div className="register-input-box">
          <label>
            Mật khẩu
          </label>
          <input type="password" name="password" placeholder="Nhập mật khẩu" />
        </div>

        <div className="register-input-box">
          <label>
            Nhập lại mật khẩu
          </label>
          <input type="password" name="confirmPassword" placeholder="Nhập lại mật khẩu" />
        </div>

        <div className="register-button-box">
          <button className="register-button" type="submit">Đăng ký</button>
        </div>

        <div style={{
          display: "flex"
        }} className="Already-Acc-Box">
          <p className="is-have-acc-title">Đã có tài khoản?</p>
          <a href="/dang-nhap">Đăng nhập</a>
        </div>
      </form>
    </div>
  );
}

export default RegisterPage;
