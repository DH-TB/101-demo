CREATE TABLE item(
  id int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name varchar(1000),
  price int(10),
  category_id int(10),
  FOREIGN KEY (category_id) REFERENCES category(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;