USE storefrontdatabase;

# Create a Stored procedure to retrieve average sales of each product in a month. Month and year will be input parameter to function.
    SELECT * from order_items;
    
    DELIMITER $$
    CREATE PROCEDURE average_sale(month int, year int)
    BEGIN
    
    SELECT p.id,p.product_name,o.order_date,i.order_status, AVG(p.product_price) AS average_sale
    FROM order_items i
    INNER JOIN orders o
    ON i.order_id = o.id
    INNER JOIN product p
    ON p.id = i.product_id
    WHERE MONTH(o.order_date) = month AND YEAR(o.order_date) = year AND i.order_status <> 'Canceled' 
    GROUP BY i.product_id;
    
    END$$

    CALL average_sale(08,2018);
    
# Q. Create a stored procedure to retrieve table having order detail with status for a given period. Start date and end date will be input parameter. Put validation on input dates like start date is less than end date. If start date is greater than end date take first date of month as start date.
    
    DELIMITER $$ 
    CREATE FUNCTION validate_date(start_date Date,end_date Date)
    RETURNS Date
    BEGIN
    DECLARE set_start_date Date;
    
        if (start_date <= end_date)
            then
                return start_date;
                
        else
            SET set_start_date = CONCAT(DATE_FORMAT(end_date, '%Y-%m-'), '01');
            return set_start_date;
            
        END if;
    END$$
    
    DELIMITER $$
    CREATE PROCEDURE order_details(IN start_date Date,IN end_date Date)
    BEGIN
    DECLARE set_start_date Date;
    
    SET set_start_date = validate_date(start_date,end_date);
    
                SELECT o.id AS order_id,p.id AS product_id,p.product_name,o.order_date,i.order_status
                FROM order_items i
                INNER JOIN orders o
                ON i.order_id = o.id
                INNER JOIN product p
                ON p.id = i.product_id
                WHERE o.order_date BETWEEN set_start_date AND end_date;

    END$$
    
    CALL order_details('2018-08-20','2018-08-18');
