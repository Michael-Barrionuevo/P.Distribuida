-- Insertar datos de ejemplo en todas las tablas

-- LIBROS
insert into books (isbn, price, title, version) values
('978-0134685991', 45.99, 'Effective Java', 1),
('978-0201633610', 55.50, 'Design Patterns', 1),
('978-0596009205', 39.90, 'Head First Design Patterns', 1);

-- INVENTARIO
insert into inventory (book_isbn, sold, supplied, version) values
('978-0134685991', 10, 100, 1),
('978-0201633610', 5, 50, 1),
('978-0596009205', 2, 30, 1);

-- CLIENTES
insert into customers (email, name, version) values
('ana.gomez@example.com', 'Ana Gomez', 1),
('carlos.morales@example.com', 'Carlos Morales', 1),
('lia.rodriguez@example.com', 'Lia Rodriguez', 1);

-- ORDENES DE COMPRA
insert into purchase_orders (deliveredon, placedon, status, total, customer_id) values
(NULL, '2026-05-01 10:00:00', 0, 95, 1),
('2026-05-05 15:30:00', '2026-05-02 12:20:00', 1, 55, 2),
(NULL, '2026-05-03 09:15:00', 0, 39, 3);

-- LINE ITEMS
insert into line_items (quantity, book_isbn, order_id) values
(2, '978-0134685991', 1),
(1, '978-0201633610', 2),
(1, '978-0596009205', 3);

-- ASIGNACIÓN AUTOR-LIBRO
insert into books_authors (books_isbn, authors_id) values
('978-0134685991', 1),
('978-0201633610', 2),
('978-0596009205', 3),
('978-0134685991', 2);

