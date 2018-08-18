USE storefrontdatabase;

/*Q. Create appropriate tables and relationships for the same and write a SQL
         query for that returns a Resultset containing Zip Code, City Names and
         States ordered by State Name and City Name.*/
 

CREATE TABLE city_detail
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    city_name VARCHAR(50) NOT NULL,
    city_state VARCHAR(50) NOT NULL
);

CREATE TABLE zipcode
(
    zipcode VARCHAR(6) PRIMARY KEY,
    city_detailid int NOT NULL,
    FOREIGN KEY (city_detailid) REFERENCES city_detail(id) ON DELETE CASCADE
);

INSERT INTO city_detail
(city_name, city_state)
VALUES
('Udaipur', 'Rajasthan'),
('Jaipur', 'Rajasthan');

INSERT INTO zipcode
(zipcode, city_detailid)
VALUES
(313001, 1),
(302019, 2),
(302020, 2), 
(302021, 2);

SELECT z.zipcode, c.city_name, c.city_state
FROM zipcode z
INNER JOIN city_detail c
ON c.id = z.city_detailid
ORDER BY city_state, city_name;