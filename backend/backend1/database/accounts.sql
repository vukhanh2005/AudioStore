CREATE DATABASE IF NOT EXISTS qlisanpham
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE qlisanpham;

CREATE TABLE IF NOT EXISTS accounts (
  account_id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  username VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  phone VARCHAR(10) NOT NULL,
  address VARCHAR(100) NOT NULL,
  avatar NVARCHAR(255) NULL,
  password VARCHAR(100) NOT NULL,
  PRIMARY KEY (account_id),
  UNIQUE KEY uk_accounts_username (username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Nếu bảng accounts đã tồn tại giống ảnh cũ và chưa có account_id,
-- chạy dòng ALTER dưới đây một lần trong phpMyAdmin trước khi tạo bảng orders.
-- ALTER TABLE accounts ADD COLUMN account_id INT(11) NOT NULL AUTO_INCREMENT UNIQUE FIRST;

-- Nếu bảng accounts đã tồn tại và chưa có avatar,
-- chạy dòng ALTER dưới đây một lần để lưu đường dẫn ảnh đại diện.
-- ALTER TABLE accounts ADD COLUMN avatar NVARCHAR(255) NULL AFTER address;
