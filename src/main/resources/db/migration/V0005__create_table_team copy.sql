CREATE TABLE `stadium` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(255),
    `surname` VARCHAR(255),
    `idd_fed` BIGINT,
    `status` VARCHAR(50),
    `federations_id` BIGINT,
    `picture_profile` VARCHAR(255),
    `created_at` DATETIME NOT NULL,
    `updated_at` DATETIME NOT NULL,
    FOREIGN KEY (`federations_id`) REFERENCES `federations`(`id`) ON DELETE CASCADE
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
INSERT INTO STADIUM VALUES(1, 'Estádio Dr. Oswaldo Scatena', 'Scatenão', 1, 'Ativo', 1, 'stadium/default.jpg', '2023-08-16', '2023-08-16');
INSERT INTO STADIUM VALUES(2, 'Estádio Paulo Machado de Carvalho', 'Pacaembu', 1, 'Ativo', 1, 'stadium/default.jpg', '2023-08-16', '2023-08-16');

-- TEAMS
INSERT INTO TEAMS VALUES(1, 'Lango Lango Futebol Clube', 'Lango Lanho', 'LLFC', 'ATIVO', 'team/default.png', '1919-03-03', 1, '2023-08-16', '2023-08-16', 1, 1);
-- INSERT INTO TEAMS VALUES(2, 'Sport Clube Los Lunáticos', 'Lunáticos', 'SCL', 'ATIVO', 'team/default.png', '1919-03-03', 1, '2023-08-16', '2023-08-16', 1, 1);
-- INSERT INTO TEAMS VALUES(3, 'Sociedade Esportiva Desvairados', 'Desvairados', 'SED', 'ATIVO', 'team/default.png', '1919-03-03', 2, '2023-08-16', '2023-08-16', 2, 2);