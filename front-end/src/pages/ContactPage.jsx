function ContactPage() {
  return (
    <div className="contact-page">
      <div className="content-title">
        <h2>Liên hệ</h2>
      </div>

      <form className="form-contact">
        <div className="contact-input-box">
          <label>
            Họ và tên
          </label>
          <input type="text" name="fullName" placeholder="Nhập họ và tên" />
        </div>

        <div className="contact-input-box">
          <label>
            Email
          </label>
          <input type="email" name="email" placeholder="Nhập email" />
        </div>

        <div className="contact-input-box">
          <label>
            Số điện thoại
          </label>
          <input type="tel" name="phone" placeholder="Nhập số điện thoại" />
        </div>

        <div className="contact-input-box">
          <label>
            Nội dung
          </label>
          <textarea name="message" rows="5" placeholder="Nhập ý kiến của bạn"></textarea>
        </div>

        <div className="contact-button-wrapper">
          <button className="contact-button" type="submit">Gửi liên hệ</button>
        </div>
      </form>
    </div>
  );
}

export default ContactPage;
