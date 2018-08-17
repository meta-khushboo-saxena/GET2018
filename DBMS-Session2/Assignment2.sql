USE storefrontdb;

# Q.Insert sample data in StoreFront tables by using SQL files:

# Insering data into User Table
INSERT INTO User
(User_firstname,User_lastname, Email, Password, DateOfBirth, Gender)
VALUES
("John","rathore", "john@gmail.com","1234",'1000-01-01', "male"),
("Harry","singh", "harry@gmail.com","3647",'1990-05-20', "male"),
("Priya","kumari", "priya@gmail.com","9387", '2013-08-30', "female"),
("Raj","yadav", "raj@gmail.com","1234", '2012-10-14', "male"),
("Sita","singh", "sita@gmail.com", "5754", '1997-11-07', "female"),
("Anu","kumari", "anu@gmail.com", "7533", '1877-12-03', "female");

#Inserting data into Contact Table
INSERT INTO Contact
(UserId, Contact)
VALUES
(13, 8736127123),
(14, 3748974907),
(13, 8737838938),
(13, 8736342123),
(14, 9736127129),
(15, 7263787121),
(15, 8734447128),
(16, 3478677433),
(15, 9376736784);

#Inserting data into Category Table
INSERT INTO Category
(Parent_CategryId, Category_Name)
VALUES
(NULL, "Electronic_Gadgets"),
(NULL, "Clothing"),
(NULL, "Footwear"),
(1, "Laptops"),
(1, "Cameras"),
(1, "Mobiles"),
(2, "Mens_Wear"),
(2, "Womens_Wear"),
(2, "Kids_Wear"),
(3, "Slippers"),
(3, "Shoes"),
(7, "Jeans"),
(7, "Shirt"),
(8, "Sarees"),
(8, "Topper"),
(8, "Kurtis"),
(9, "Jackets"),
(9, "Dresses");

#Inserting data into Product Table
INSERT INTO Product
(Product_CategoryId, Product_Price, Product_Description, Product_Quantity, Product_Name)
VALUES
(7, 3000,"Comfortable, Smart", 20, "SportShoes"),
(11, 2000,"Flat Sole, Shimmering", 500, "SneakersShoes"),
(10, 50,"1 year warranty, Daily wear", 10, "FlatsSlippers"),
(12, 2000,"Blue Color, Denim", 30, "LevisJeans"),
(12, 4000,"Black color, Ankle", 200, "WoodlandJeans"),
(13, 100,"White color, Round neck", 3000, "AdidasShirt"),
(13, 1500,"Black color, Party wear", 20, "ReebokShirt"),
(14, 5000,"Beautiful, Red color, Limited stock", 150, "SilkSaree"),
(14, 7000,"Green color, Party wear, Light weight", 40, "CheffonSaree"),
(14, 200,"Free length, Blue color", 0, "CottonSaree"),
(15, 2500,"Purple color, Off shoulder", 30, "PeopleTop"),
(15, 1500,"Black color, Striped", 120, "MaxTop"),
(16, 2000,"Floor length", 600, "AnarkaliKurti"),
(16, 130,"Parrot green color", 0, "ShortKurtis"),
(17, 500,"Woollen, Red black color", 1100, "LittleJackets"),
(17, 3000,"Half sleeves, comfortable, woollen", 70, "JiniJackets"),
(18, 2000,"Beautiful, Dress, pink color", 200, "GirlsDress"),
(18, 150,"Smart shirt and pant pair, Tie", 10, "BoysDress"),
(4, 47000,"15Inch display, Black", 1700, "LenovoLaptop"),
(4, 70000,"I7 processor, Graphic card", 20, "DellLaptop"),
(4, 50000,"Red color, 8GB RAM", 40, "SamsungLaptop"),
(5, 65000,"Small skirt for kids, top", 70, "SkirtDress"),
(6, 1700,"Slim, Light weight, Rose gold color", 220, "LenovoMobile"),
(6, 25000,"40 MP front caera, 4GB RAM", 410, "MIMobile");

#Inserting data into Image Table

INSERT INTO Image 
(ProductId, Image) 
VALUES
(1, "ShoesImg.jpg"),
(1, "ShoesBack.jpg"),
(3, "FlatSlipper.jpg"),
(4, "JeansFront.png"),
(4, "JeansBack.jpg"),
(6, "AdidasShirtFront.jpg"),
(6, "AdidasShirtBack.jpg"),
(7, "ReebokFront.jpg"),
(8, "SareeFront.jpg"),
(8, "SareeSideView.jpg"),
(9, "CheffonSaree.jpg"),
(11, "PeopleTopFront.jpg"),
(11, "PeopleTopBack.jpg"),
(12, "MaxTop.jpg"),
(13, "Kurtis.jpg"),
(15, "JacketFront.jpg"),
(15, "JacketBack.jpg"),
(17, "GirlsDress.jpg"),
(17, "Frock.jpg"),
(18, "BoysDress.jpg"),
(19, "ShortSkirtDress.jpg"),
(19, "LongSkirtDress.jpg");

#Inserting data into Orders Table

INSERT INTO Orders
(ShopperId, Order_Date, Order_ShippingDate, Order_Quantity)
VALUES
(13, CURDATE(), '2018-08-10', 2),
(14, CURDATE(), '2018-08-10', 1),
(13, CURDATE(), '2018-07-15', 1),
(15, CURDATE(), '2018-05-01', 1),
(14, CURDATE(), '2018-06-10', 2),
(17, CURDATE(), '2018-06-10', 2);

#Inserting data into Order Items table

INSERT INTO OrderItems
(OrderId, ProductId, Quantity, OrderStatus)
VALUES
(11, 3, 1, "Not Shipped"),
(11, 22, 1, "Shipped"),
(12, 19, 1, "Not Shipped"),
(12, 22, 3, "Not Shipped"),
(13, 22, 1, "Not Shipped"),
(14, 13, 1, "Not Shipped"),
(15, 2, 2, "Shipped"),
(15, 2, 2, "Shipped");

# Q. Display Id, Title, Category Title, Price of the products which are Active and recently added products should be at top

Select P.ProductId, P.Product_Name, C.Category_Name, P.Product_Price
FROM Product P
INNER JOIN Category C
ON P.Product_CategoryId = C.CategoryId
WHERE P.Product_Quantity > 0
ORDER BY P.ProductId DESC;

# Q. Display the list of products which don't have any images.

    SELECT P.Product_Name
    FROM Product P
    LEFT JOIN Image I
    ON P.ProductId= I.ProductId
    WHERE I.ImageId is NULL;

# Q. Display all Id, Title and Parent Category Title for all the Categories listed, sorted by Parent Category Title and then Category Title. (If Category is top category then Parent Category Title column should display “Top Category” as value.)

SELECT C.CategoryId, C.Category_Name, 
IFNULL(P.Category_Name, 'Top Category') as Parent_Category
FROM Category C
LEFT JOIN Category P
ON C.Parent_CategryId = P.CategoryId;

# Q. Display Id, Title, Parent Category Title of all the leaf Categories (categories which are not parent of any other category)

SELECT b.CategoryId, b.Category_Name AS Leaf_Category,l.Category_Name AS Parent_Category
FROM Category b 
LEFT JOIN Category l
ON b.Parent_CategryId = l.CategoryId
WHERE b.CategoryId NOT IN(
                         SELECT s.CategoryId
                         FROM Category s
                         INNER JOIN Category c
                         ON s.CategoryId = c.Parent_CategryId
                         );

# Q. Display Product Title, Price & Description which falls into particular category Title (i.e. “Mobile”)

SELECT P.Product_Name, P.Product_Price,P.Product_Description
FROM Product P
INNER JOIN Category C
ON P.Product_CategoryId = C.CategoryId
WHERE C.Category_Name="Mobiles";

# Q. Display the list of Products whose Quantity on hand (Inventory) is under 50.

SELECT Product_Name
FROM Product 
WHERE Product_Quantity < 50;

# Q. Increase the Inventory of all the products by 100.

SET SQL_SAFE_UPDATES = 0 ;
UPDATE Product SET Product_Quantity = Product_Quantity + 100;
