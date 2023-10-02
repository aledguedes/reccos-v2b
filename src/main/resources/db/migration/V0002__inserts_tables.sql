INSERT INTO users (name, surname, email, status, img_perfil, phone, password, birth_date, federation, role, created_at, updated_at)
VALUES
    ('John Doe', 'John', 'john@example.com', TRUE, 'profile1.jpg', '123456789', 'hashed_password1', '1990-01-15', 1, 'admin', '2023-08-07', '2023-08-07'),
    ('Jane Smith', 'Jane', 'jane@example.com', TRUE, 'profile2.jpg', '987654321', 'hashed_password2', '1985-05-20', 1, 'controller', '2023-08-07', '2023-08-07'),
    ('Alice Johnson', 'Johnson', 'alice@example.com', TRUE, 'profile3.jpg', '555555555', 'hashed_password3', '1992-11-10', 1, 'user','2023-08-07', '2023-08-07');

INSERT INTO FEDERATIONS VALUES(1, 'FEDERAÇÃO KOKAMA DE FUTEBOL', 'FKKF', 'ATIVO', 'federation/default.png', '2023-08-16', '2023-08-16', 1);
INSERT INTO FEDERATIONS VALUES(2, 'FEDERAÇÃO XANDIANA', 'FEXAN', 'ATIVO', 'federation/default.png', '2023-08-31', '2023-08-31', 2);

INSERT INTO LEAGUES VALUES(1, 'LIGA_A', '2023-09-01', '2024-09-01', '2024-09-01', '2024-09-01', 'Batatais/SP', 'Pontos Corridos', 'Canindé', 1, 1, 'league/default.png', 'Em preparação', 1, true, '2023-08-16', '2023-08-16');

INSERT INTO REFREES VALUES (1, 'Oscar Roberto Goddoy', 'Goddoy', 'ATIVO', 'orob_goddoy@mail.com', 'refree/default.png', '1980-03-03', 1, '592.633.090-43', '282838132', '2023-08-16', '2023-08-16', 1);

INSERT INTO STADIUM VALUES(1, 'Estádio Dr. Oswaldo Scatena', 'Scatenão', 1, 'Ativo', 1, 'stadium/default.jpg', '2023-08-16', '2023-08-16');
INSERT INTO STADIUM VALUES(2, 'Estádio Paulo Machado de Carvalho', 'Pacaembu', 1, 'Ativo', 1, 'stadium/default.jpg', '2023-08-16', '2023-08-16');

INSERT INTO TEAMS VALUES(1, 'Lango Lango Futebol Clube', 'Lango Lanho', 'LLFC', 'ATIVO', 'team/default.png', '1919-03-03', 1, '2023-08-16', '2023-08-16', 1, 1);
INSERT INTO TEAMS VALUES(2, 'Herdeiros Futebol Clube', 'Herdeiros', 'HFC', 'ATIVO', 'team/default.png', '1919-03-03', 1, '2023-08-16', '2023-08-16', 1, 1);
INSERT INTO TEAMS VALUES(3, 'Sport Clube Desumildes', 'Desumildes', 'SCD', 'ATIVO', 'team/default.png', '1919-03-03', 1, '2023-08-16', '2023-08-16', 1, 1);
INSERT INTO TEAMS VALUES(4, 'LosMigos Club', 'LosMigos', 'LMC', 'ATIVO', 'team/default.png', '1919-03-03', 1, '2023-08-16', '2023-08-16', 1, 1);
INSERT INTO TEAMS VALUES(5, 'Blades Sociedade Sportiva', 'Blades', 'BSE', 'ATIVO', 'team/default.png', '1919-03-03', 1, '2023-08-16', '2023-08-16', 1, 1);
INSERT INTO TEAMS VALUES(6, 'Binagas Futebol Clube', 'Binagas', 'BFC', 'ATIVO', 'team/default.png', '1919-03-03', 1, '2023-08-16', '2023-08-16', 1, 1);
INSERT INTO TEAMS VALUES(7, 'Sport Club Biná', 'Biná', 'SCB', 'ATIVO', 'team/default.png', '1919-03-03', 1, '2023-08-16', '2023-08-16', 1, 1);
INSERT INTO TEAMS VALUES(8, 'Tocão Amigos de Futebol', 'Tocão', 'TAM', 'ATIVO', 'team/default.png', '1919-03-03', 1, '2023-08-16', '2023-08-16', 1, 1);
INSERT INTO TEAMS VALUES(9, 'Sem Café Sports Club', 'Sem Café', 'SCS', 'ATIVO', 'team/default.png', '1919-03-03', 1, '2023-08-16', '2023-08-16', 1, 1);
INSERT INTO TEAMS VALUES(10, 'Sem Camisa Futebol Clube', 'Sem Camisa', 'SCFC', 'ATIVO', 'team/default.png', '1919-03-03', 1, '2023-08-16', '2023-08-16', 1, 1);
INSERT INTO TEAMS VALUES(11, 'Com Camisa Futebol Clube', 'Com Camisa', 'CCFC', 'ATIVO', 'team/default.png', '1919-03-03', 1, '2023-08-16', '2023-08-16', 1, 1);
INSERT INTO TEAMS VALUES(12, 'Sports Boa Dominada', 'Boa Dominada', 'SBD', 'ATIVO', 'team/default.png', '1919-03-03', 1, '2023-08-16', '2023-08-16', 1, 1);
INSERT INTO TEAMS VALUES(13, 'Mesma Linha Futebol e Sports', 'Mesma Linha', '', 'ATIVO', 'team/default.png', '1919-03-03', 1, '2023-08-16', '2023-08-16', 1, 1);
INSERT INTO TEAMS VALUES(14, 'Sem Idéia Club', 'Sem Idéia', 'SIFC', 'ATIVO', 'team/default.png', '1919-03-03', 1, '2023-08-16', '2023-08-16', 1, 1);

INSERT INTO PLAYERS VALUES (1, 'Alexandre Guedes', 'Kokhym', 'ale@gmail.com', 'ATIVO', 'player/default.png', '2023-04-07', '000.000.000-00', '00.000.000-X', false, 'ATACANTE', '2023-09-11', '2023-09-11');

INSERT INTO CONTRACTS VALUES(1, '2023-09-12', '2024-09-12', 'ATIVO', 1, 1, '2023-09-12', '2023-09-12');

--INSERT INTO GROUPS VALUES(1, 'Grupo 1', 1), (2, 'Grupo 2', 1), (3, 'Grupo 3', 1);
