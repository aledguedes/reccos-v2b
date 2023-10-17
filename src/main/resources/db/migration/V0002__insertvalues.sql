INSERT INTO users (name, surname, email, status, img_perfil, phone, password, birth_date, federation, role, created_at, updated_at)
VALUES
    ('John Doe', 'John', 'john@example.com', 'ATIVO', 'user/default.jpg', '00123456789', 'hashed_password1', '1990-01-15', 1, 'admin', '2023-08-07', '2023-08-07'),
    ('Jane Smith', 'Jane', 'jane@example.com', 'ATIVO', 'user/default.jpg', '11111111111', 'hashed_password2', '1985-05-20', 1, 'controller', '2023-08-07', '2023-08-07'),
    ('Alice Johnson', 'Johnson', 'alice@example.com', 'ATIVO', null, '22222222222', 'hashed_password3', '1992-11-10', 1, 'user','2023-08-07', '2023-08-07');

INSERT INTO FEDERATIONS VALUES(1, 'FEDERAÇÃO KOKAMA DE FUTEBOL', 'FKKF', 'ATIVO', 'federation/default.png', '2023-08-16', '2023-08-16', 1);
INSERT INTO FEDERATIONS VALUES(2, 'FEDERAÇÃO XANDIANA', 'FEXAN', 'ATIVO', 'federation/default.png', '2023-08-31', '2023-08-31', 2);