USE storefrontdb;   

#table 1:
CREATE TABLE User(
	UserId int NOT NULL AUTO_INCREMENT,
	User_firstname VARCHAR(100),
  User_lastname VARCHAR(100),
	Email VARCHAR(100),
	Password VARCHAR(15),
	DateOfBirth DATE,
	Gender VARCHAR(20),
	UNIQUE(Email),
	PRIMARY KEY(UserId)
    ); 

#table 2: 
CREATE TABLE Contact(
	ContactId int NOT NULL AUTO_INCREMENT,
	Contact VARCHAR(20) NOT NULL,
	UserId int,
	PRIMARY KEY(ContactId),
 	FOREIGN KEY (UserId) REFERENCES User(UserId) ON DELETE CASCADE
   );

#table 3:
CREATE TABLE Product(
	ProductId int NOT NULL AUTO_INCREMENT,
	Product_Name VARCHAR(100),
	Product_Price int NOT NULL,
	Product_Quantity int,
	Product_Description VARCHAR(255),
	Product_CategoryId int NOT NULL,
	PRIMARY KEY(ProductId)
    );
 

#table 4:
CREATE TABLE Image(
	ImageId int NOT NULL AUTO_INCREMENT,
	Image VARCHAR(100) NOT NULL, 
	ProductId int,
	PRIMARY KEY(ImageId),
 	FOREIGN KEY (ProductId) REFERENCES Product(ProductId) ON DELETE CASCADE
   );
   
#table 5:
CREATE TABLE Category(
	CategoryId int NOT NULL AUTO_INCREMENT,
	Category_Name VARCHAR(255), 
	Parent_CategryId int,
	PRIMARY KEY(CategoryId),
  FOREIGN KEY (Parent_CategryId) REFERENCES Category(CategoryId) ON DELETE CASCADE
   );
   
#table 6:
CREATE TABLE Orders(
	OrderId int NOT NULL AUTO_INCREMENT,
	ShopperId int,
	Order_Quantity int,
	Order_ShippingDate Date,
  Order_Date Date NOT NULL,
	PRIMARY KEY(OrderId),
  FOREIGN KEY (ShopperId) REFERENCES User(UserId)
    );
    
CREATE TABLE OrderItems(
   OrderId INT,
   ProductId INT,
   Quantity INT,
   OrderStatus VARCHAR(100),
   FOREIGN KEY (ProductId) REFERENCES Product(ProductId)
   );
   
#table 7:
CREATE TABLE Payment(
	PaymentId int NOT NULL AUTO_INCREMENT,
	OrderId int,
	Payment_mode int,
	Payment_ShippingAddress VARCHAR(255),
	PRIMARY KEY(PaymentId  ),
  FOREIGN KEY (OrderId ) REFERENCES Orders(OrderId ) ON DELETE CASCADE
    );

#table 8:
CREATE TABLE PaymentMode(
	PaymentModeId int NOT NULL AUTO_INCREMENT,
	PaymentMode_Name VARCHAR(255),
  PRIMARY KEY(PaymentModeId)
    );
    
#table 9:
CREATE TABLE Address(
	AddressId int NOT NULL AUTO_INCREMENT,
  ShopperId int,	
  Address_street VARCHAR(255),
	Address_city VARCHAR(255),
	Address_state VARCHAR(255),
  Address_pincode VARCHAR(255),
	PRIMARY KEY(AddressId),
  FOREIGN KEY (ShopperId) REFERENCES User(UserId) ON DELETE CASCADE
    );

# Query to show all tables
SHOW tables;

# Query to Remove Product Table of storefrontdb
DROP TABLE Image;
DROP TABLE Product;

#Query to Create Product Table in storefrontdb

CREATE TABLE Product(
	ProductId int NOT NULL AUTO_INCREMENT,
	Product_Name VARCHAR(100),
	Product_Price int NOT NULL,
	Product_Quantity int,
	Product_Description VARCHAR(255),
	Product_CategoryId int NOT NULL,
	PRIMARY KEY(ProductId)
    );
    
  CREATE TABLE Image(
	ImageId int NOT NULL AUTO_INCREMENT,
	Image VARCHAR(100) NOT NULL, 
	ProductId int,
	PRIMARY KEY(ImageId),
 	FOREIGN KEY (ProductId) REFERENCES Product(ProductId) ON DELETE CASCADE
   );  