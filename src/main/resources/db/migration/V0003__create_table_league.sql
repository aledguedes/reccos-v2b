CREATE TABLE `leagues` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(255),
    `dt_start` DATETIME,
    `dt_end` DATETIME,
    `league_system` VARCHAR(255),
    `league_mode` VARCHAR(255),
    `qt_group` INT,
    `idd_fed` BIGINT,
    `img_logo` VARCHAR(255),
    `status` VARCHAR(255),
    `federations_id` BIGINT,
    `created_at` DATETIME NOT NULL,
    `updated_at` DATETIME NOT NULL,
    CONSTRAINT fk_federations FOREIGN KEY (federations_id) REFERENCES federations(id)
);

INSERT INTO FEDERATIONS VALUES (1, 'Liga BemAgro', 'LIBA', 'Ativa', 'photo_1.jpg', '2023-08-15', '2023-08-15', 1);