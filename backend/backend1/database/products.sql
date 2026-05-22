CREATE DATABASE IF NOT EXISTS qlisanpham
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE qlisanpham;

CREATE TABLE IF NOT EXISTS products (
  id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  category VARCHAR(255) NOT NULL,
  price INT(11) NOT NULL DEFAULT 0,
  old_price INT(11) NOT NULL,
  image VARCHAR(255) NULL,
  soluong INT(11) NOT NULL DEFAULT 0,
  status TINYINT(1) NOT NULL DEFAULT 1,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

TRUNCATE TABLE products;

INSERT INTO products (name, category, price, old_price, image, soluong, status) VALUES
('Tai nghe Sony WH-1000XM5', 'Tai nghe', 7490000, 8490000, 'sony-wh-1000xm5.jpg', 10, 1),
('Tai nghe Marshall Major IV', 'Tai nghe', 3190000, 3690000, 'marshall-major-iv.jpg', 8, 1),
('Loa Bluetooth JBL Charge 5', 'Loa', 3290000, 3790000, 'jbl-charge-5.jpg', 12, 1),
('Loa Edifier R1280DB', 'Loa', 2890000, 3290000, 'edifier-r1280db.jpg', 7, 1),
('Micro Audio-Technica AT2020', 'Micro', 2790000, 3190000, 'audio-technica-at2020.jpg', 5, 1),
('Micro Shure SM58', 'Micro', 2590000, 2990000, 'shure-sm58.jpg', 4, 1),
('Sound card Focusrite Scarlett 2i2', 'Sound card', 4590000, 5290000, 'focusrite-scarlett-2i2.jpg', 6, 1),
('Mixer Yamaha MG10XU', 'Mixer', 6590000, 7290000, 'yamaha-mg10xu.jpg', 3, 1),
('Ampli Denon PMA-600NE', 'Ampli', 8990000, 9990000, 'denon-pma-600ne.jpg', 0, 0);
