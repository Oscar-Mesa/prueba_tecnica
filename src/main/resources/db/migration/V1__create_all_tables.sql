-- Creación de la tabla DetBook
CREATE TABLE DetBook (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    autor VARCHAR(255),
    editorial VARCHAR(255),
    fecha_publicacion VARCHAR(255)
);

-- Creación de la tabla Book
CREATE TABLE Book (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    detalle_libro_id BIGINT,
    CONSTRAINT fk_detalle_libro FOREIGN KEY (detalle_libro_id) REFERENCES DetBook(id)
);

-- Creación de la tabla User
CREATE TABLE User (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    lastname VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255)
);

-- Creación de la tabla intermedia User_Book para la relación OneToMany entre User y Book
CREATE TABLE User_Book (
    user_id BIGINT,
    book_id BIGINT,
    PRIMARY KEY (user_id, book_id),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES User(id),
    CONSTRAINT fk_book FOREIGN KEY (book_id) REFERENCES Book(id)
);
