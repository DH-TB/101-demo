CREATE TABLE goods(
  id int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name varchar(1000),
  price int(10),
  item_id int(10),
  FOREIGN KEY (item_id) REFERENCES item(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;