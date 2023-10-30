CREATE TABLE IF NOT EXISTS processo (
    id BIGINT UNSIGNED AUTO_INCREMENT NOT NULL,
    numero_processo VARCHAR(30) NOT NULL,
    vara VARCHAR(5) NOT NULL,
    data_distribuicao DATE NOT NULL,
    valor_causa DECIMAL(10,2),
    faseprocessual_id BIGINT UNSIGNED DEFAULT(1),
    resultado_id BIGINT UNSIGNED DEFAULT(1),
    localizacao_id BIGINT UNSIGNED DEFAULT(1),
    reclamante_id BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (faseprocessual_id) REFERENCES fase_processual (id),
    FOREIGN KEY (resultado_id) REFERENCES resultado (id),
    FOREIGN KEY (localizacao_id) REFERENCES localizacao (id),
    FOREIGN KEY (reclamante_id) REFERENCES reclamante (id),
    UNIQUE (numero_processo)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
