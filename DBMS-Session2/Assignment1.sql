USE storefrontdatabase;   
 
#table 1:
CREATE TABLE user(
	id int AUTO_INCREMENT PRIMARY KEY,
	firstname VARCHAR(100),
        lastname VARCHAR(100),
	email VARCHAR(100) UNIQUE NOT NULL,
	password VARCHAR(15),
	date_of_birth DATE,
	gender VARCHAR(20) CHECK (gender IN ('male','female'))
    ); 
    
#table 2: 
CREATE TABLE contact(
	id int AUTO_INCREMENT PRIMARY KEY,
	contact_number VARCHAR(20) NOT NULL,
	user_id int,
 	FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE
   );

#table 3:
CREATE TABLE product(
	id int AUTO_INCREMENT PRIMARY KEY,
	product_name VARCHAR(100),
	product_price int NOT NULL,
	product_quantity int,
	product_description VARCHAR(255)
    );
 
#table 4:
CREATE TABLE category(
	id int AUTO_INCREMENT PRIMARY KEY,
	category_name VARCHAR(255), 
	parent_id int,	
  	FOREIGN KEY (parent_id) REFERENCES category(id) ON DELETE CASCADE
   );
   
   #table 5:
CREATE TABLE product_category(
	id int AUTO_INCREMENT PRIMARY KEY,
	product_id int, 
	category_id int,	
   	FOREIGN KEY (product_id) REFERENCES product(id) ON DELETE CASCADE,
	FOREIGN KEY (category_id) REFERENCES category(id) ON DELETE CASCADE
   );
   
#table 6:
CREATE TABLE image(
	id int AUTO_INCREMENT PRIMARY KEY,
	image_name VARCHAR(100) NOT NULL, 
	product_id int,
 	FOREIGN KEY (product_id) REFERENCES product(id) ON DELETE CASCADE
   );

#table 7:
  CREATE TABLE address(
	id int AUTO_INCREMENT PRIMARY KEY,
  	address_line1 VARCHAR(255),
	address_city VARCHAR(255),
	address_state VARCHAR(255),
  	address_pincode VARCHAR(6)
    );
    
   #table 8: 
   CREATE TABLE user_address(
   id int AUTO_INCREMENT PRIMARY KEY,
   user_id INT,
   address_id INT,
   FOREIGN KEY (user_id) REFERENCES user(id),
   FOREIGN KEY (address_id) REFERENCES address(id)
   );
   
#table 9:
CREATE TABLE orders(
	id int AUTO_INCREMENT PRIMARY KEY,
	user_id int,
	order_quantity int,
  	order_date Date NOT NULL,
  	order_address_id int,
  	FOREIGN KEY (order_address_id) REFERENCES address(id),
  	FOREIGN KEY (user_id) REFERENCES user(id)
    );
    
 #table 10:   
CREATE TABLE order_items(
   id int AUTO_INCREMENT PRIMARY KEY,
   order_id INT,
   product_id INT,
   order_status VARCHAR(100) CHECK (order_status IN ('Shipped','Not Shipped','Canceled','Returned')),
   order_shipping_date Date,
   last_update_date Date,
   FOREIGN KEY (product_id) REFERENCES product(id),
   FOREIGN KEY (order_id) REFERENCES orders(id)
   );
  
# Query to show all tables
SHOW tables;

# Query to Remove Product Table of storefrontdb

DROP TABLE image;
DROP TABLE product;

#Query to Create Product Table in storefrontdb

CREATE TABLE product(
	id int AUTO_INCREMENT PRIMARY KEY,
	product_name VARCHAR(100),
	Product_price int NOT NULL,
	Product_quantity int,
	Product_description VARCHAR(255),
	Product_categoryId int NOT NULL
    );
 
CREATE TABLE image(
	id int AUTO_INCREMENT PRIMARY KEY,
	image VARCHAR(100) NOT NULL, 
	product_id int,
 	FOREIGN KEY (product_id) REFERENCES product(id) ON DELETE CASCADE
   );
