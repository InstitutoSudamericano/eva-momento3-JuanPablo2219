CREATE TABLE IF NOT EXISTS scene (
id SERIAL PRIMARY KEY,
description VARCHAR(255),
budget DECIMAL(10, 2),
minutes INT,
film_id INT,
FOREIGN KEY (film_id) REFERENCES film(id)
);

CREATE TABLE IF NOT EXISTS character (
id SERIAL PRIMARY KEY,
cost DECIMAL(10,2),
stock INT,
scene_id INT,
FOREIGN KEY (scene_id) REFERENCES scene(id)
);