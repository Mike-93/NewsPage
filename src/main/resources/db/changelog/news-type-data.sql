--liquibase formatted sql
--changeset M:data-newsType

INSERT INTO news_type (name, color)
VALUES ('Политика', 'Красный'),
       ('Спорт', 'Зеленый'),
       ('Погода', 'Синий');