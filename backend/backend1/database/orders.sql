USE qlisanpham;

CREATE TABLE IF NOT EXISTS orders (
  id INT(11) NOT NULL AUTO_INCREMENT,
  account_id INT(11) NOT NULL,
  username VARCHAR(100) NOT NULL,
  product_id INT(11) NOT NULL,
  product_name VARCHAR(255) NOT NULL,
  price INT(11) NOT NULL DEFAULT 0,
  quantity INT(11) NOT NULL DEFAULT 1,
  status VARCHAR(30) NOT NULL DEFAULT 'SUCCESS',
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  INDEX idx_orders_account_id (account_id),
  INDEX idx_orders_username (username),
  INDEX idx_orders_product_id (product_id),
  CONSTRAINT fk_orders_accounts
    FOREIGN KEY (account_id) REFERENCES accounts(account_id)
    ON UPDATE CASCADE
    ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
