ALTER TABLE andamento ADD COLUMN processo_id BIGINT UNSIGNED NOT NULL;
ALTER TABLE andamento ADD CONSTRAINT FOREIGN KEY (processo_id) REFERENCES processo (id);