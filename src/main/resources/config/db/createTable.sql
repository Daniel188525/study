--mysql 5.7
CREATE TABLE users(id INT PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR(20), age INT);

CREATE TABLE test(id INT PRIMARY KEY AUTO_INCREMENT, test VARCHAR(20));

INSERT INTO users(NAME, age) VALUES('¹Â°Á²ÔÀÇ', 27);
INSERT INTO users(NAME, age) VALUES('°×»¢Éñ»Ê', 27);
INSERT INTO test(test) VALUES('test');

CREATE TABLE t_customer( 
  id int(10) not null auto_increment, 
  address varchar(120), 
  postcode varchar(6), 
  sex varchar(2), 
  cname varchar(24), 
  primary key(id) 
); 

CREATE TABLE t_orders( 
  id int(10) not null auto_increment, 
  code varchar(24), 
  customer_id int(3) not null, 
  primary key(id) 
);

ALTER TABLE t_orders ADD CONSTRAINT orders_customer_fk FOREIGN KEY (customer_id) REFERENCES t_customer(id);
alter table t_orders modify column code varchar(32);
