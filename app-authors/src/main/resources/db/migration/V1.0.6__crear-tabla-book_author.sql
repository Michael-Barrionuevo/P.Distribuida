CREATE TABLE book_author
(
    books_isbn VARCHAR(255) NOT NULL,
    authors_id INTEGER      NOT NULL,
    CONSTRAINT pk_book_author PRIMARY KEY (books_isbn, authors_id)
);
