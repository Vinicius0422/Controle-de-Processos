CREATE TABLE IF NOT EXISTS reclamado (
    id BIGINT UNSIGNED AUTO_INCREMENT NOT NULL,
    nome VARCHAR(150) NOT NULL,
    tipo_pessoa ENUM ('Física', 'Jurídica') NOT NULL,
    cpf_cnpj VARCHAR(18) NOT NULL,
    endereco VARCHAR(255),
    cidade VARCHAR(50),
    bairro VARCHAR(50),
    uf VARCHAR(2),
    cep VARCHAR(10),
    contato VARCHAR(255),
    email VARCHAR(150),
    PRIMARY KEY (id),
    UNIQUE (cpf_cnpj)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
