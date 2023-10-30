CREATE TABLE IF NOT EXISTS andamento (
	id BIGINT UNSIGNED AUTO_INCREMENT NOT NULL,
    data_andamento DATE NOT NULL,
    faseprocessual_id BIGINT UNSIGNED NOT NULL,
   	data_prevista DATE,
    hora_prevista TIME,
    descricao VARCHAR(255) NOT NULL,
    data_criacao TIMESTAMP NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (faseprocessual_id) REFERENCES fase_processual (id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
