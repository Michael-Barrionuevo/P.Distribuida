CREATE TABLE inventory
(
    book_isbn VARCHAR(255) NOT NULL,
    sold      INTEGER      NOT NULL,
    supplied  INTEGER      NOT NULL,
    version   INTEGER      NOT NULL,
    CONSTRAINT pk_inventory PRIMARY KEY (book_isbn)
);