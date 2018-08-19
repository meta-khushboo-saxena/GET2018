USE storefrontdb;

# Q. Display Recent 50 Orders placed (Id, Order Date, Order Total).

    SELECT o.user_id, o.id AS order_id,o.order_date, SUM(p.product_price) AS total_amount
    FROM order_items i
    INNER JOIN orders o
    ON i.order_id = o.id
    INNER JOIN product p
    ON p.id = i.product_id
    GROUP BY i.order_id
    ORDER BY order_date DESC
    LIMIT 50;
    
# Q. Display 10 most expensive Orders.
   
    SELECT o.user_id, o.id AS order_id,o.order_date, SUM(p.product_price) AS total_amount
    FROM order_items i
    INNER JOIN orders o
    ON i.order_id = o.id
    INNER JOIN product p
    ON p.id = i.product_id
    GROUP BY i.order_id
    ORDER BY total_amount DESC
    LIMIT 10;

# Q. Display all the Orders which are placed more than 10 days old and one or more items from those orders are still not shipped.
    
    SELECT id,order_date
    FROM orders
    WHERE order_date < CURDATE() - INTERVAL 10 DAY
    AND id IN (SELECT order_id
					 FROM order_items
                     WHERE order_status = 'Not Shipped');
               
# Q. Display list of shoppers which havent ordered anything since last month.

    SELECT id, firstname, lastname
    FROM user
    WHERE id NOT IN (
                       SELECT user_id 
                       FROM orders
                       WHERE order_date >= CURDATE() - INTERVAL 30 DAY
                       );
    
# Q. Display list of shopper along with orders placed by them in last 15 days. 

    SELECT u.firstname,u.lastname ,o.id AS order_id,o.order_date
    FROM orders o
    INNER JOIN user u
    ON u.id = o.user_id
    WHERE o.order_date > CURDATE() - INTERVAL 15 DAY;

# Q. Display list of order items which are in “shipped” state for particular Order Id (i.e.: 1020))
    
    SELECT p.product_name
    FROM order_items o,product p 
    WHERE o.product_id = p.id AND 
    o.id = 6 AND
    o.order_status = 'Shipped';

# Q. Display list of order items along with order placed date which fall between Rs 20 to Rs 5000 price.

    SELECT i.order_id, i.product_id, o.order_date, p.product_price
    FROM order_items i
    INNER JOIN orders o
    ON i.order_id = o.id
    INNER JOIN product p
    ON i.product_id = p.id
    WHERE p.product_price BETWEEN 20 AND 5000;
    
# Q. Update first 20 Order items status to “Shipped” which are placed today.

    SET SQL_SAFE_UPDATES = 0 ;

    UPDATE order_items
    SET order_status = "Shipped"
    WHERE order_id IN(
                        SELECT id
                        FROM orders
                        WHERE order_date = CURDATE()
                        ORDER BY order_date
                             )
    LIMIT 20;
    
    SELECT * FROM order_items;
