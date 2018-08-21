USE storefrontdatabase;

# Q. Create a function to calculate number of orders in a month. Month and year will be input parameter to function.

DELIMITER $$
CREATE FUNCTION number_of_orders(month int, year int)
RETURNS INT

BEGIN

    DECLARE num INT;

    SELECT COUNT(id) INTO num 
    FROM orders 
    WHERE MONTH(order_date) = month 
    AND YEAR(order_date) = year;
    
  RETURN (num);
  
END$$

SELECT number_of_orders(08,2018);
    
# Q. Create a function to return month in a year having maximum orders. Year will be input parameter.
   
   DELIMITER $$
CREATE FUNCTION max_order(year int)
RETURNS INT

BEGIN

    DECLARE max_order_month INT;

    SELECT month INTO max_order_month
    FROM (
        SELECT MONTH(order_date) AS month,COUNT(MONTH(order_date)) AS count 
        FROM orders 
        WHERE YEAR(order_date) = year 
        GROUP BY MONTH(order_date)
        ORDER BY count DESC
        ) max
         LIMIT 1;
        
    RETURN (max_order_month);
END$$

  SELECT max_order(2017);    
