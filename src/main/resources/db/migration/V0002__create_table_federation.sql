CREATE TABLE `federations` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL,
    `surname` VARCHAR(50) NOT NULL,
    `status` VARCHAR(50) NOT NULL,
    `img_logo` VARCHAR(255),
    `created_at` DATETIME NOT NULL,
    `updated_at` DATETIME NOT NULL,
    `users_id` BIGINT,
    CONSTRAINT fk_owner FOREIGN KEY (`users_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
);

INSERT INTO FEDERATIONS VALUES(1, 'FEDERAÇÃO KOKAMA DE FUTEBOL', 'FKKF', 'ATIVO', 'federation/default.png', '2023-08-16', '2023-08-16', 1);