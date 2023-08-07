CREATE TABLE `users` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL,
    `surname` VARCHAR(100) NOT NULL,
    `email` VARCHAR(255) NOT NULL UNIQUE,
    `status` VARCHAR(50) NOT NULL,
    `img_perfil` VARCHAR(255),
    `phone` VARCHAR(100) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `birth_date` DATETIME NOT NULL,
    `federation` INTEGER,
    `role` VARCHAR(50) NOT NULL,
    `created_at` DATETIME NOT NULL,
    `updated_at` DATETIME NOT NULL
);

INSERT INTO users (name, surname, email, status, img_perfil, phone, password, birth_date, federation, role, created_at, updated_at)
VALUES
    ('John Doe', 'John', 'john@example.com', TRUE, 'profile1.jpg', '123456789', 'hashed_password1', '1990-01-15', 1, 'admin', '2023-08-07', '2023-08-07'),
    ('Jane Smith', 'Jane', 'jane@example.com', TRUE, 'profile2.jpg', '987654321', 'hashed_password2', '1985-05-20', 1, 'controller', '2023-08-07', '2023-08-07'),
    ('Alice Johnson', 'Johnson', 'alice@example.com', TRUE, 'profile3.jpg', '555555555', 'hashed_password3', '1992-11-10', 1, 'user','2023-08-07', '2023-08-07');
