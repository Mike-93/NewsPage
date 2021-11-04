--liquibase formatted sql
--changeset M:create-all-tables

CREATE TABLE IF NOT EXISTS news_type
(
    id         SERIAL  NOT NULL,
    name       TEXT    NOT NULL,
    color      TEXT    NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS news
(
    id          SERIAL  NOT NULL,
    name        TEXT    NOT NULL,
    short_desc  TEXT    NOT NULL,
    full_desc   TEXT    NOT NULL,
    type        INT     NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (type) REFERENCES news_type (id)
);