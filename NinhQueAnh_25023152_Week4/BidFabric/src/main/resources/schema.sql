
CREATE TABLE users (
   id VARCHAR(50) PRIMARY KEY,
   username VARCHAR(50) NOT NULL,
   password VARCHAR(255) NOT NULL,
   full_name VARCHAR(100),
   role VARCHAR(20)
);