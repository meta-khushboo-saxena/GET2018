USE storefrontdatabase;

# Q. Identify the columns require indexing in order, product, category tables and create indexes.

     # Appling indexes on product Table
        
        ALTER TABLE product ADD UNIQUE index_product_name(product_name);
        
        ALTER TABLE product ADD INDEX index_price(product_price);

     # Appling indexes on category Table
        
        ALTER TABLE category ADD UNIQUE index_category_name(category_name);
        
        ALTER TABLE category ADD INDEX index_parent_id(parent_id);
        
     # Appling indexes on product_category Table
     
        ALTER TABLE product_category ADD INDEX index_product_id(product_id);
        
        ALTER TABLE product_category ADD INDEX index_category_id(category_id);
        
     # Appling indexes on orders Table
     
        ALTER TABLE orders ADD INDEX index_user_id(user_id);
        
        ALTER TABLE orders ADD INDEX index_order_date(order_date);
        
     # Appling indexes on order_items Table
        
         ALTER TABLE order_items ADD INDEX index_order_id(order_id);
        
        ALTER TABLE order_items ADD INDEX index_product_id(product_id);
        
        ALTER TABLE order_items ADD INDEX index_order_status(order_status);
        