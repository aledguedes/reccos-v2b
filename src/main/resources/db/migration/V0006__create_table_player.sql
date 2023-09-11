CREATE TABLE `players` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL,
    `surname` VARCHAR(100) NOT NULL,
    `email` VARCHAR(255) NOT NULL UNIQUE,
    `status` VARCHAR(50) NOT NULL,
    `picture_profile` VARCHAR(255),
    `birth_date` DATETIME NOT NULL,
    `cpf` VARCHAR(100) NOT NULL UNIQUE,
    `rg` VARCHAR(100) NOT NULL,
    `suspended` BOOLEAN NOT NULL,
    `position` VARCHAR(100) NOT NULL,
    `created_at` DATETIME NOT NULL,
    `updated_at` DATETIME NOT NULL
);

INSERT INTO PLAYERS VALUES (1, 'Alexandre Guedes', 'Kokhym', 'ale@gmail.com', 'ATIVO', 'player/default.png', '2023-04-07', '000.000.000-00', '00.000.000-X', false, 'ATACANTE', '2023-09-11', '2023-09-11');