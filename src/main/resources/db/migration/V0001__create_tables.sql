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

CREATE TABLE `leagues` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(255),
    `dt_start` DATETIME,
    `dt_end` DATETIME,
    `enrollment_end` DATETIME,
    `enrollment_start` DATETIME,
    `location` VARCHAR(255),
    `league_system` VARCHAR(255),
    `league_mode` VARCHAR(255),
    `qt_group` INT,
    `idd_fed` BIGINT,
    `img_logo` VARCHAR(255),
    `status` VARCHAR(50),
    `federations_id` BIGINT,
    `turn` BOOLEAN,
    `created_at` DATETIME NOT NULL,
    `updated_at` DATETIME NOT NULL,
    CONSTRAINT fk_federations FOREIGN KEY (federations_id) REFERENCES federations(id)
);

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

CREATE TABLE `contracts` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `dt_start` DATETIME NOT NULL,
    `dt_end` DATETIME NOT NULL,
    `status` VARCHAR(100),
    `team_id` BIGINT NOT NULL,
    `player_id` BIGINT NOT NULL,
    `created_at` DATETIME NOT NULL,
    `updated_at` DATETIME NOT NULL,
    FOREIGN KEY (team_id) REFERENCES teams (id) ON DELETE CASCADE,
    FOREIGN KEY (player_id) REFERENCES players (id) ON DELETE CASCADE
);