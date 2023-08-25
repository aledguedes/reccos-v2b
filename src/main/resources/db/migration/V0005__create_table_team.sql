CREATE TABLE `stadium` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(255),
    `surname` VARCHAR(255),
    `status` VARCHAR(50),
    `picture_profile` VARCHAR(255),
    `created_at` DATETIME NOT NULL,
    `updated_at` DATETIME NOT NULL
);

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
    `stadium_id` BIGINT,
    `federations_id` BIGINT,
    FOREIGN KEY (`stadium_id`) REFERENCES `stadium`(`id`) ON DELETE CASCADE,
    FOREIGN KEY (`federations_id`) REFERENCES `federations`(`id`) ON DELETE CASCADE
);

-- STADIUM
INSERT INTO STADIUM VALUES(1, 'Estádio Dr. Oswaldo Scatena', 'Scatenão', 'Ativo', 'stadium/default.jpg', '2023-08-16', '2023-08-16');

-- TEAMS
INSERT INTO TEAMS VALUES(1, 'Lango Lango Futebol Clube', 'Lango Lanho', 'LLFC', 'ATIVO', 'team/default.png', '1919-03-03', 1, '2023-08-16', '2023-08-16', 1, 1);







