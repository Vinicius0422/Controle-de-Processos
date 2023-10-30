CREATE TABLE IF NOT EXISTS reclamado_processo (
	reclamado_id BIGINT UNSIGNED NOT NULL,
    processo_id BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY (reclamado_id, processo_id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
