CREATE TABLE `teams` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL,
    `surname` VARCHAR(100) NOT NULL,
    `acronym` VARCHAR(15) NOT NULL,
    `status` VARCHAR(50) NOT NULL,
    `picture_profile` VARCHAR(255),
    `birth_date` DATETIME NOT NULL,
    `registered_federation` INTEGER,
    `created_at` DATETIME NOT NULL,
    `updated_at` DATETIME NOT NULL,
    `federations_id` BIGINT,
    FOREIGN KEY (`federations_id`) REFERENCES `federations`(`id`) ON DELETE CASCADE
);
INSERT INTO TEAMS VALUES (1, 'Lango Lango Futebol Clube', 'Lango Lanho', 'LLFC', 'ATIVO', 'picture_profile.png', '1980-03-03', 1, '2023-08-16', '2023-08-16', 1);