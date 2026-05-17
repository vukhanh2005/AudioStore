import { useState } from "react";
import { submitContact } from "../services/api";

function ContactPage() {
  const [formData, setFormData] = useState({
    fullName: "",
    email: "",
    phone: "",
    message: ""
  });
  const [popup, setPopup] = useState(null);
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
    setIsLoading(true);
    setPopup(null);

    try {
      const response = await submitContact(formData);
      setFormData({
        fullName: "",
        email: "",
        phone: "",
        message: ""
      });
      setPopup({
        type: "success",
        title: "Gửi liên hệ thành công",
        message: response.message || "Thông tin liên hệ của bạn đã được lưu lại."
      });
    } catch (error) {
      setPopup({
        type: "error",
        title: "Gửi liên hệ thất bại",
        message: error.message || "Không thể gửi liên hệ, vui lòng thử lại."
      });
    } finally {
      setIsLoading(false);
    }
  }

  return (
    <div className="contact-page">
      <div className="content-title">
        <h2>Liên hệ</h2>
      </div>

      <form className="form-contact" onSubmit={handleSubmit}>
        <div className="contact-input-box">
          <label>
            Họ và tên
          </label>
          <input
            type="text"
            name="fullName"
            value={formData.fullName}
            onChange={handleChange}
            placeholder="Nhập họ và tên"
            required
          />
        </div>

        <div className="contact-input-box">
          <label>
            Email
          </label>
          <input
            type="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
            placeholder="Nhập email"
            required
          />
        </div>

        <div className="contact-input-box">
          <label>
            Số điện thoại
          </label>
          <input
            type="tel"
            name="phone"
            value={formData.phone}
            onChange={handleChange}
            placeholder="Nhập số điện thoại"
          />
        </div>

        <div className="contact-input-box">
          <label>
            Nội dung
          </label>
          <textarea
            name="message"
            rows="5"
            value={formData.message}
            onChange={handleChange}
            placeholder="Nhập ý kiến của bạn"
            required
          ></textarea>
        </div>

        <div className="contact-button-wrapper">
          <button className="contact-button" type="submit" disabled={isLoading}>
            {isLoading ? "Đang gửi..." : "Gửi liên hệ"}
          </button>
        </div>
      </form>

      {popup && (
        <div className="popup-backdrop">
          <div className={`popup contact-popup ${popup.type}`}>
            <button className="popup-close" type="button" onClick={() => setPopup(null)}>
              x
            </button>
            <h3>{popup.title}</h3>
            <p>{popup.message}</p>
          </div>
        </div>
      )}
    </div>
  );
}

export default ContactPage;
