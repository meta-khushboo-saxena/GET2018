USE storefrontdatabase;

# Insering data into User Table
INSERT INTO user
(firstname,lastname, email, password, date_of_birth, gender)
VALUES
("John","rathore", "john@gmail.com","1234",'1000-01-01', "male"),
("Harry","singh", "harry@gmail.com","3647",'1990-05-20', "male"),
("Priya","kumari", "priya@gmail.com","9387", '2013-08-30', "female"),
("Raj","yadav", "raj@gmail.com","1234", '2012-10-14', "male"),
("Sita","singh", "sita@gmail.com", "5754", '1997-11-07', "female"),
("Anu","kumari", "anu@gmail.com", "7533", '1877-12-03', "female");

# Inserting data into Contact Table
INSERT INTO contact
(user_id, contact_number)
VALUES
(1, 8736127123),
(1, 3748974907),
(6, 8737838938),
(6, 8736342123),
(5, 9736127129),
(4, 7263787121),
(5, 8734447128),
(6, 3478677433),
(2, 9376736784);

# Inserting data into Category Table
INSERT INTO category
(parent_id, category_name)
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

# Inserting data into Product Table
INSERT INTO product
(product_price, product_description, product_quantity, product_name)
VALUES
(3000,"Comfortable, Smart", 20, "SportShoes"),
(2000,"Flat Sole, Shimmering", 500, "SneakersShoes"),
(50,"1 year warranty, Daily wear", 10, "FlatsSlippers"),
(2000,"Blue Color, Denim", 30, "LevisJeans"),
(4000,"Black color, Ankle", 200, "WoodlandJeans"),
(100,"White color, Round neck", 3000, "AdidasShirt"),
(1500,"Black color, Party wear", 20, "ReebokShirt"),
(5000,"Beautiful, Red color, Limited stock", 150, "SilkSaree"),
(7000,"Green color, Party wear, Light weight", 40, "CheffonSaree"),
(200,"Free length, Blue color", 0, "CottonSaree"),
(2500,"Purple color, Off shoulder", 30, "PeopleTop"),
(1500,"Black color, Striped", 120, "MaxTop"),
(2000,"Floor length", 600, "AnarkaliKurti"),
(130,"Parrot green color", 0, "ShortKurtis"),
(500,"Woollen, Red black color", 1100, "LittleJackets"),
(3000,"Half sleeves, comfortable, woollen", 70, "JiniJackets"),
(2000,"Beautiful, Dress, pink color", 200, "GirlsDress"),
(150,"Smart shirt and pant pair, Tie", 10, "BoysDress"),
(7000,"15Inch display, Black", 1700, "LenovoLaptop"),
(40000,"I7 processor, Graphic card", 20, "DellLaptop"),
(50000,"Red color, 8GB RAM", 40, "SamsungLaptop"),
(65000,"Small skirt for kids, top", 70, "SkirtDress"),
(1700,"Slim, Light weight, Rose gold color", 220, "LenovoMobile"),
(25000,"40 MP front camera, 4GB RAM", 410, "MIMobile");

# Inserting data into product Category
INSERT INTO product_category
(product_id, category_id)
VALUES
(1, 7),
(1, 8),
(4, 12),
(5, 12),
(8, 14),
(9, 14),
(10, 14),
(2, 11),
(3, 10),
(6, 13),
(7, 13),
(7, 2);

#Inserting data into Image Table

INSERT INTO image 
(product_id, image_name) 
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

#Inserting data into Address Table
INSERT INTO address
(address_line1, address_city, address_state, address_pincode)
VALUES
("Pratap Nagar", "jaipur", "rajasthan", "201001"),
("Sitapura", "jaipur", "rajasthan", "637281"),
("Chandni Chok", "noida", "up", "632911"),
("Swarn Jayanti Nagar", "aligarh", "up", "934832"),
("Shankar vihar Colony", "aligarh", "up", "323545"),
("India gate", "jaipur", "rajasthan", "213444");

#Inserting data into User Address Table
INSERT INTO user_address
(user_id, address_id)
VALUES
(1, 6),
(1, 2),
(2, 6),
(2, 2),
(3, 1),
(6, 1),
(5, 1),
(3, 5),
(3, 6),
(6, 2),
(1, 3);

#Inserting data into Orders Table

INSERT INTO orders
(user_id, order_date,order_quantity,order_address_id)
VALUES
(1, CURDATE(), 2, 6),
(2, CURDATE(), 1, 6),
(2, CURDATE(), 1, 2),
(1, CURDATE(), 1, 2),
(5, CURDATE(), 2, 1),
(6, CURDATE(), 2, 1);

INSERT INTO orders
(user_id, order_date,order_quantity,order_address_id)
VALUES
(1, '2017-08-10', 2, 6),
(1, '2016-08-10', 2, 6);
#Inserting data into Order Items table

INSERT INTO order_items
(order_id, product_id, order_status,order_shipping_date,last_update_date)
VALUES
(1, 3, "Not Shipped",'2018-08-10','2018-08-03'),
(1, 2, "Shipped",'2018-08-10','2018-08-02'),
(2, 9, "Not Shipped",'2018-07-15','2018-08-01'),
(2, 22, "Not Shipped",'2018-07-15','2018-07-10'),
(3, 22, "Not Shipped",'2018-05-01','2018-08-02'),
(4, 13, "Not Shipped",'2018-06-10','2018-08-04'),
(5, 2, "Shipped",'2018-06-10','2018-06-10'),
(6, 2, "Shipped",'2018-06-10','2018-02-11');
 
# Q. Display Id, Title, Category Title, Price of the products which are Active and recently added products should be at top

    Select p.id, p.product_name, c.category_name, p.product_price
    FROM product_category pc
    INNER JOIN category c
    ON pc.category_id = c.id
    INNER JOIN product p
    ON pc.product_id = p.id
    WHERE p.product_quantity > 0
    ORDER BY p.id DESC;

# Q. Display the list of products which don't have any images.

    SELECT P.id,P.product_name
    FROM product P
    WHERE P.id NOT IN ( SELECT I.product_id
    FROM Image I);

# Q. Display all Id, Title and Parent Category Title for all the Categories listed, sorted by Parent Category Title and then Category Title. (If Category is top category then Parent Category Title column should display “Top Category” as value.)

SELECT C.id, C.category_name, 
IFNULL(P.category_name, 'Top Category') as parent_category
FROM category C
LEFT JOIN category P
ON C.parent_id = P.id;

# Q. Display Id, Title, Parent Category Title of all the leaf Categories (categories which are not parent of any other category)

SELECT b.id, b.category_name AS leaf_category,l.category_name AS parent_category
FROM category b 
LEFT JOIN category l
ON b.parent_id = l.id
WHERE b.id NOT IN(
                         SELECT s.id
                         FROM category s
                         INNER JOIN category c
                         ON s.id = c.parent_id
                         );

# Q. Display Product Title, Price & Description which falls into particular category Title (i.e. “Mobile”)

SELECT p.product_name, p.product_price,p.product_description
FROM product_category pc
    INNER JOIN category c
    ON PC.category_id = c.id
    INNER JOIN product p
    ON pc.product_id = p.id
WHERE c.category_name = "Sarees";

# Q. Display the list of Products whose Quantity on hand (Inventory) is under 50.

SELECT product_name
FROM product 
WHERE product_quantity < 50;

# Q. Increase the Inventory of all the products by 100.

SET SQL_SAFE_UPDATES = 0 ;
UPDATE product SET product_quantity = product_quantity + 100;
