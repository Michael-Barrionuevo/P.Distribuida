CREATE TABLE books
(
    isbn    VARCHAR(255)     NOT NULL,
    price   DOUBLE PRECISION NOT NULL,
    title   VARCHAR(255),
    version INTEGER          NOT NULL,
    CONSTRAINT pk_books PRIMARY KEY (isbn)
);