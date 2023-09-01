CREATE TABLE `leagues` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(255),
    `dt_start` DATETIME,
    `dt_end` DATETIME,
    `location` VARCHAR(255),
    `league_system` VARCHAR(255),
    `league_mode` VARCHAR(255),
    `qt_group` INT,
    `idd_fed` BIGINT,
    `img_logo` VARCHAR(255),
    `status` VARCHAR(50),
    `federations_id` BIGINT,
    `created_at` DATETIME NOT NULL,
    `updated_at` DATETIME NOT NULL,
    CONSTRAINT fk_federations FOREIGN KEY (federations_id) REFERENCES federations(id)
);

INSERT INTO LEAGUES VALUES(1, 'LIGA_A', '2023-09-01', '2024-09-01', 'Batatais/SP',
	'Pontos Corridos', 'Canindé', 1, 1, 'league/default.png', 'ATIVO', 1, '2023-08-16', '2023-08-16');