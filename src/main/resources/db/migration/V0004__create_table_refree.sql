CREATE TABLE `refrees` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL,
    `surname` VARCHAR(100) NOT NULL,
    `email` VARCHAR(255) NOT NULL UNIQUE,
    `status` VARCHAR(50) NOT NULL,
    `picture_profile` VARCHAR(255),
    `birth_date` DATETIME NOT NULL,
    `registered_federation` INTEGER,
    `cpf` VARCHAR(100) NOT NULL UNIQUE,
    `rg` VARCHAR(100) NOT NULL,
    `created_at` DATETIME NOT NULL,
    `updated_at` DATETIME NOT NULL,
    `federations_id` BIGINT,
    FOREIGN KEY (`federations_id`) REFERENCES `federations`(`id`) ON DELETE CASCADE
);
INSERT INTO REFREES VALUES (1, 'Oscar Roberto Goddoy', 'Goddoy', 'ATIVO', 'orob_goddoy@mail.com', 'picture_profile.png', '1980-03-03', 1, '592.633.090-43', '282838132', '2023-08-16', '2023-08-16', 1);
-- INSERT INTO REFREES  VALUES(1, 'Oscar Larionda', 'Oscar', 'oscar@email.com', 'ativo', 'phot.jpg', '1980-12-12', 1, '30890561869', '282838132', '2023-08-15', '2023-08-15', 1);