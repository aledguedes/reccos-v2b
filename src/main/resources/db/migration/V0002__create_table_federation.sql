CREATE TABLE `federations` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL,
    `surname` VARCHAR(50) NOT NULL,
    `status` VARCHAR(50) NOT NULL,
    `img_logo` VARCHAR(255),
    `created_at` DATETIME NOT NULL,
    `updated_at` DATETIME NOT NULL,
    `users_id` BIGINT,
    FOREIGN KEY (`users_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
);