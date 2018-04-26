INSERT INTO category(id,name) VALUES (1,'饮料');
INSERT INTO category(id,name) VALUES (2,'主食');

INSERT INTO item(id,name,price,category_id) VALUES (1,'可乐',3,1);
INSERT INTO item(id,name,price,category_id) VALUES (2,'雪碧',3,1);
INSERT INTO item(id,name,price,category_id) VALUES (3,'泡面',5,2);

INSERT INTO cart(id,name) VALUES (1,'cart1');
INSERT INTO cart(id,name) VALUES (2,'cart2');

INSERT INTO cart_item(id,item_id,cart_id) VALUES (1,1,1);
INSERT INTO cart_item(id,item_id,cart_id) VALUES (2,2,2);

INSERT INTO goods(id,name,price,item_id) VALUES (1,'可乐1',3,1);
INSERT INTO goods(id,name,price,item_id) VALUES (2,'雪碧1',3,2);
INSERT INTO goods(id,name,price,item_id) VALUES (3,'泡面1',3,3);