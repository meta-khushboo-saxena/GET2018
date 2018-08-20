USE storefrontdatabase;

# Q. Display Shopper’s information along with number of orders he/she placed during last 30 days.
    
    SELECT u.id, u.firstname, u.lastname, u.email, u.date_of_birth, COUNT(o.user_id) AS no_of_orders
    FROM user u
    INNER JOIN orders o 
    ON u.id = o.user_id
    WHERE o.order_date > CURDATE() - INTERVAL 30 DAY 
    GROUP BY o.user_id;
    
# Q. Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.
    
    SELECT u.id, u.firstname, u.lastname, u.email, SUM(p.product_price) AS total_amount
    FROM order_items i
    INNER JOIN orders o
    ON i.order_id = o.id
    INNER JOIN product p
    ON p.id = i.product_id
    INNER JOIN user u
    ON u.id = o.user_id
    WHERE order_date > CURDATE() - INTERVAL 30 DAY 
    GROUP BY o.user_id
    ORDER BY total_amount DESC
    LIMIT 10;
    
# Q. Display top 20 Products which are ordered most in last 60 days along with numbers.

    SELECT p.product_name, COUNT(i.product_id) AS product_count
    FROM product as p
    INNER JOIN order_items i 
    ON p.id = i.product_id
    INNER JOIN orders o 
    ON i.order_id = o.id
    WHERE o.order_date > CURDATE() - INTERVAL 60 DAY 
    GROUP BY p.id
    ORDER BY product_count DESC
    LIMIT 20;
    
# Q. Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.
    
    SELECT MONTHNAME(order_date) AS month_name, SUM(p.product_price) AS total_amount
    FROM order_items i
    INNER JOIN orders o
    ON i.order_id = o.id
    INNER JOIN product p
    ON p.id = i.product_id
    WHERE o.order_date > CURDATE() - INTERVAL 6 MONTH 
    GROUP BY MONTH(order_date);
    
# Q. Mark the products as Inactive which are not ordered in last 90 days.

    ALTER TABLE product
    ADD product_state CHAR(10) DEFAULT 'Active'
    AFTER product_description;

    UPDATE product AS p
    SET p.product_state = "Active";

    UPDATE product p
    SET p.product_state = "Inactive"
    WHERE p.id Not IN(
                        SELECT product_id
                        FROM order_items i
                        INNER JOIN orders o 
                        ON i.order_id = o.id
                        WHERE o.order_date >= CURDATE() - INTERVAL 90 DAY
                       );

# Q. Given a category search keyword, display all the Products present in this category/categories. 

    SELECT p.product_name
    FROM product p
    INNER JOIN product_category pc 
    ON p.id = pc.product_id
    INNER JOIN category c ON pc.category_id = c.id
    WHERE c.category_name IN ('Sarees');

# Q. Display top 10 Items which were canceled most.

    SELECT product_id, COUNT(*) AS canceledCount
    FROM order_items
    WHERE order_status = 'canceled'
    GROUP BY product_id
    ORDER BY canceledCount DESC
    LIMIT 10;
