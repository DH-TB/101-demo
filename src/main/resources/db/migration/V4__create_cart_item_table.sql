CREATE TABLE cart_item(
  id int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  item_id int(10),
  cart_id int(10),
  FOREIGN KEY (item_id) REFERENCES item(id),
  FOREIGN KEY (cart_id) REFERENCES cart(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
