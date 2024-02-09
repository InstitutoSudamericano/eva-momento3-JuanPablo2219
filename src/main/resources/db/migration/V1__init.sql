CREATE TABLE IF NOT EXISTS film (
    id SERIAL PRIMARY KEY,
    title VARCHAR (100),
    director VARCHAR (100),
    duration INT,
    release_date DATE
);
