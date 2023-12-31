CREATE TABLE IF NOT EXISTS reclamante (
    id BIGINT UNSIGNED AUTO_INCREMENT NOT NULL,
    nome VARCHAR(150) NOT NULL,
    data_nascimento DATE,
    nacionalidade_id BIGINT UNSIGNED NOT NULL,
    estadocivil_id BIGINT UNSIGNED NOT NULL,
    profissao VARCHAR(50),
    ctps VARCHAR(9) NOT NULL,
    serie VARCHAR(9) NOT NULL,
    rg VARCHAR(10) NOT NULL,
    orgao_rg VARCHAR(10) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    pis VARCHAR(50),
    endereco VARCHAR(255) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    bairro VARCHAR(50) NOT NULL,
    uf VARCHAR(2) NOT NULL,
    cep VARCHAR(10) NOT NULL,
    banco VARCHAR(50),
    agencia VARCHAR(10),
    operacao VARCHAR(10),
    conta VARCHAR(20),
    tipoconta_id BIGINT UNSIGNED NOT NULL,
    contato VARCHAR(255) NOT NULL,
    email VARCHAR(150),
    PRIMARY KEY (id),
    FOREIGN KEY (nacionalidade_id) REFERENCES nacionalidade (id),
    FOREIGN KEY (estadocivil_id) REFERENCES estado_civil (id),
    FOREIGN KEY (tipoconta_id) REFERENCES tipo_conta (id),
    UNIQUE (rg),
    UNIQUE (cpf)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
