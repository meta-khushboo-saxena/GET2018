USE storefrontdb;

# Q. Display Recent 50 Orders placed (Id, Order Date, Order Total).
    
   SELECT O.OrderId,O.Order_Date ,SUM(I.Quantity * P.Product_Price) as Order_Total 
   FROM OrderItems I
   INNER JOIN Orders O 
   ON I.OrderId = O.OrderId
   INNER JOIN Product P
   ON I.ProductId = P.ProductId
   GROUP BY OrderId
   ORDER BY Order_Date DESC;

# Q. Display 10 most expensive Orders.

   SELECT O.OrderId,O.Order_Date ,SUM(I.Quantity * P.Product_Price) as Order_Total 
   FROM OrderItems I
   INNER JOIN Orders O 
   ON I.OrderId = O.OrderId
   INNER JOIN Product P
   ON I.ProductId = P.ProductId
   GROUP BY OrderId
   ORDER BY Order_Total DESC
   LIMIT 10;

# Q. Display all the Orders which are placed more than 10 days old and one or more items from those orders are still not shipped.
    
    SELECT OrderId,Order_ShippingDate,Order_Date
    FROM Orders
    WHERE Order_Date < CURDATE() - INTERVAL 10 DAY
    AND OrderId IN (SELECT OrderId
					 FROM OrderItems
                     WHERE OrderStatus = 'Not Shipped');
                     
# Q. Display list of shoppers which havent ordered anything since last month.

    SELECT u.UserId, u.User_firstname, u.User_lastname
    FROM User u
    WHERE u.UserId NOT IN (
                       SELECT ShopperId 
                       FROM Orders
                       WHERE Order_Date >= CURDATE() - INTERVAL 30 DAY
                       );
                       
# Q. Display list of shopper along with orders placed by them in last 15 days. 

    SELECT U.User_firstname,U.User_lastname ,O.OrderId,O.Order_Date
    FROM Orders O
    INNER JOIN User U
    ON U.UserId = O.ShopperId
    WHERE O.Order_Date <= CURDATE()
    AND O.Order_Date > CURDATE() - INTERVAL 15 DAY;

# Q. Display list of order items which are in “shipped” state for particular Order Id (i.e.: 1020))
    
    SELECT P.Product_Name
    FROM OrderItems O,Product P 
    WHERE O.ProductId = P.ProductId AND 
    OrderId = 15 AND
    OrderStatus = "Shipped";

# Q. Display list of order items along with order placed date which fall between Rs 20 to Rs 5000 price.

    SELECT I.OrderId, I.ProductId, O.Order_Date, P.Product_Price
    FROM OrderItems I
    INNER JOIN Orders O
    ON I.OrderId = O.OrderId
    INNER JOIN Product P
    ON I.ProductId = P.ProductId
    WHERE P.Product_Price BETWEEN 20 AND 5000;
    
# Q. Update first 20 Order items status to “Shipped” which are placed today.

    UPDATE OrderItems
    SET OrderStatus = "Shipped"
    WHERE OrderId IN(
                        SELECT OrderId
                        FROM Orders
                        WHERE Order_Date = CURDATE() 
                             )
    LIMIT 20;
    
    SELECT * FROM OrderItems;