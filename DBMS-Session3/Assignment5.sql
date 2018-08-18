USE storefrontdatabase;

# Q. Create a view displaying the order information (Id, Title, Price, Shopper’s name, Email, Orderdate, Status) with latest ordered items should be displayed first for last 60 days.

CREATE VIEW order_information
AS
SELECT o.id AS order_id, p.id AS product_id, p.product_name, p.product_price, 
       u.firstname,u.lastname, u.email, o.order_date, i.order_status
FROM orders o
INNER JOIN order_items i 
ON o.id = i.order_id
INNER JOIN product p 
ON i.product_id = p.id
INNER JOIN user u 
ON o.user_id = u.id
WHERE o.order_date > CURDATE() - INTERVAL 60 DAY
ORDER BY o.order_date DESC;

SELECT * FROM order_information;

# Q. Use the above view to display the Products(Items) which are in ‘shipped’ state.

SELECT DISTINCT product_name
FROM order_information
WHERE order_status = 'shipped';

# Q. Use the above view to display the top 5 most selling products.

Select product_name, COUNT(product_id) AS product_sold
FROM order_information
GROUP BY product_id
ORDER BY product_sold DESC
LIMIT 5;