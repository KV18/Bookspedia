CREATE TABLE Category(

	categoryId IDENTITY,
	categoryName VARCHAR(50),
	categoryDescription VARCHAR(255),
	image_url VARCHAR(50),
	is_active BOOLEAN,
	
	CONSTRAINT pk_category_id PRIMARY KEY(categoryId)
);
INSERT INTO Category (categoryName,categoryDescription,image_url,is_active) VALUES('Television','There is some description','cat_01.png',true);
INSERT INTO Category (categoryName,categoryDescription,image_url,is_active) VALUES('Laptop','There is some description','cat_02.png',true);
INSERT INTO Category (categoryName,categoryDescription,image_url,is_active) VALUES('Mobile','There is some description','cat_03.png',true);

CREATE TABLE user_detail(

	userId IDENTITY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(50),
	enabled BOOLEAN,
	password VARCHAR(50),
	email VARCHAR(100),
	contact_number VARCHAR(15),
	
	CONSTRAINT pk_user_id PRIMARY KEY(userId)	

);

INSERT INTO user_detail
(first_name,last_name,role,enabled,password,email,contact_number)
VALUES('Virat','Kohli','ADMIN',true,'admin','vk@gmail.com','1234567890');

INSERT INTO user_detail
(first_name,last_name,role,enabled,password,email,contact_number)
VALUES('Ravindra','Jadeja','SUPPLIER',true,'12345','rj@gmail.com','8888888888');

INSERT INTO user_detail
(first_name,last_name,role,enabled,password,email,contact_number)
VALUES('Ravi','Ashwin','SUPPLIER',true,'54321','ravi@gmail.com','7777777777');


CREATE TABLE product(

	productId IDENTITY,
	productCode VARCHAR(20),
	productName VARCHAR(50),
	brand VARCHAR(50),
	productDescription VARCHAR(255),
	unit_price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	
	CONSTRAINT pk_product_id PRIMARY KEY(productId),
	CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category(categoryId),
	CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(userId),

);

INSERT INTO product(productCode,productName,brand,productDescription,unit_price,quantity,is_active,category_id,supplier_id)
VALUES ('MOBIPH5S' , 'Iphone 5s' , 'Apple' , 'The best mobile you can get right now' , 65000 , 5 , true , 3 , 2 );

INSERT INTO product(productCode,productName,brand,productDescription,unit_price,quantity,is_active,category_id,supplier_id)
VALUES ('MOBSAMS7' , 'Samsung S7' , 'Samsung' , 'The best android you can get right now' , 38000 , 4 , true , 3 , 2 );

INSERT INTO product(productCode,productName,brand,productDescription,unit_price,quantity,is_active,category_id,supplier_id)
VALUES ('MOBGOPIX' , 'Google Pixel' , 'Google' , 'The best android you can get right now' , 57000 , 5 , true , 3 , 2 );

INSERT INTO product(productCode,productName,brand,productDescription,unit_price,quantity,is_active,category_id,supplier_id)
VALUES ('LAPAPPMAC' , 'Mackbook Pro' , 'Apple' , 'The best laptop you can get right now' , 54000 , 4 , true , 2 , 2 );

INSERT INTO product(productCode,productName,brand,productDescription,unit_price,quantity,is_active,category_id,supplier_id)
VALUES ('LAPDELLLAT' , 'Dell Lattitude E6510' , 'Dell' , 'The best laptop you can get right now' , 48000 , 5 , true , 2 , 3 );