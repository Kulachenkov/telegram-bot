--liquibase formatted sql

--changeset Nik_k:1
CREATE TABLE notification_task (
                                   id SERIAL PRIMARY KEY,
                                   chat_id BIGINT,
                                   notification TEXT,
                                   sign_up_date TIMESTAMP
);

--changeset Nik_k:2
ALTER TABLE notification_task ADD COLUMN received_date timestamp;