USE storefrontdatabase;

# Q. Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories.
    
    SELECT p.id,p.product_name,COUNT(pc.product_id) AS count
    FROM product_category pc
    INNER JOIN product p
    ON pc.product_id = p.id
    GROUP BY pc.product_id
    HAVING count > 1;
    
# Q. Display Count of products as per below price range:
    
    CREATE VIEW price_range
    AS 
    SELECT CASE
    WHEN product_price > 0 AND product_price < 100 THEN '0-100'
    WHEN product_price > 100 AND product_price < 500 THEN '100-500'
    ELSE 'Above 500' END AS priceRange
    FROM product;
    
    SELECT p.priceRange,COUNT(p.priceRange) AS ProductCount 
    FROM price_range p
    GROUP BY p.priceRange;
    
# Q. Display the Categories along with number of products under each category.

    SELECT c.id,c.category_name,COUNT(pc.category_id) AS count
    FROM product_category pc
    INNER JOIN category c
    ON pc.category_id = c.id
    GROUP BY pc.category_id;


