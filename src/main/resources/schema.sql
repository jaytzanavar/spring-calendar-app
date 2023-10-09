CREATE TABLE IF NOT EXISTS Content (
    id SERIAL PRIMARY KEY,
    title varchar(225) NOT NULL,
    description text,
    status VARCHAR(20) NOT NULL,
    content_type VARCHAR(50) NOT NULL,
    date_created TIMESTAMP NOT NULL
    ,date_updated TIMESTAMP ,
    url VARCHAR(225)
);

--INSERT INTO Content(title,desc, status,content_type,date_created)
--VALUES('My spring data blog post', 'A post about spring data', 'IDEA','ARTICLE', CURRENT_TIMESTAMP)