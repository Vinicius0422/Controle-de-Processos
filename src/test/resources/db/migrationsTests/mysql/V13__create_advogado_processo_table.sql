CREATE TABLE IF NOT EXISTS advogado_processo (
	advogado_id BIGINT UNSIGNED NOT NULL,
    processo_id BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY (advogado_id, processo_id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
