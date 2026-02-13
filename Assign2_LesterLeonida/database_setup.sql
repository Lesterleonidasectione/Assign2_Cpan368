-- Create the project-specific schema
CREATE DATABASE IF NOT EXISTS cpan368;
USE cpan368;

-- Create the users table
CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    firstname VARCHAR(50),
    lastname VARCHAR(50),
    email VARCHAR(100),
    username VARCHAR(50),
    password VARCHAR(100)
);

-- Create specific user with password (as seen in your screenshot)
-- Note: You already did this, but keep it in the script for documentation
CREATE USER IF NOT EXISTS 'cpan368_lesterleonida'@'localhost' IDENTIFIED BY 'Pass123';

-- Grant select and insert only to the specific table (Requirement)
GRANT SELECT, INSERT ON cpan368.users TO 'cpan368_lesterleonida'@'localhost';

-- Finalize and Verify
FLUSH PRIVILEGES;
SHOW GRANTS FOR 'cpan368_lesterleonida'@'localhost';