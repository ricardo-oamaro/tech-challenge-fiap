drop table endereco;
CREATE TABLE endereco (
    id INT PRIMARY KEY AUTO_INCREMENT,
    rua VARCHAR(255),
    cidade VARCHAR(255),
    estado VARCHAR(255),
    cep VARCHAR(20),
    numero VARCHAR(20),
    complemento VARCHAR(255)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

INSERT INTO endereco (rua, cidade, estado, cep, numero, complemento)
VALUES
  ('Rua Principal', 'São Paulo', 'SP', '01234-567', '123', 'Apartamento 101'),
  ('Avenida Central', 'Rio de Janeiro', 'RJ', '23456-789', '456', 'Bloco B'),
  ('Rua da Paz', 'Belo Horizonte', 'MG', '34567-890', '789', 'Casa');
drop table pessoa;
CREATE TABLE pessoa (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255),
    data_ultima_alteracao DATE,
    email VARCHAR(255),
    tipo INT,
    endereco_id INT,
    FOREIGN KEY (endereco_id) REFERENCES endereco(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

INSERT INTO pessoa (nome, data_ultima_alteracao, email, tipo, endereco_id)
VALUES
  ('João Silva', '2023-11-22', 'joao@email.com', 1, 1),
  ('Maria Souza', '2023-12-01', 'maria@email.com', 2, 2),
  ('Pedro Santos', '2023-11-15', 'pedro@email.com', 1, 3);
drop table usuario;
CREATE TABLE usuario (
    id INT PRIMARY KEY AUTO_INCREMENT,
    usuario VARCHAR(255),
    senha VARCHAR(255),
    pessoa_id INT,
    FOREIGN KEY (pessoa_id) REFERENCES pessoa(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

INSERT INTO usuario (usuario, senha, pessoa_id)
VALUES
  ('joao123', 'password123', 1),
  ('maria456', 'password456', 2),
  ('pedro789', 'password789', 3);