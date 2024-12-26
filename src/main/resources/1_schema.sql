--Create sql script to create H2 database with name booksdb
CREATE SCHEMA booksdb;

--Create sql script to create H2 database with name booksdb using Book.java entity
DROP TABLE IF EXISTS booksdb.BOOKS;
CREATE OR REPLACE TABLE booksdb.BOOKS (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    ISBN VARCHAR(255) NOT NULL,
    publication_date DATE NOT NULL,
    author_name VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL
);
