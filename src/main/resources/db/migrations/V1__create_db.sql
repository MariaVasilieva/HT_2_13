CREATE TABLE client (
id BIGINT  GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
name VARCHAR (200) CHECK (LENGTH(name) >=3)
);


CREATE TABLE planet (
id VARCHAR PRIMARY KEY CHECK (id REGEXP '[A-Z0-9]+'),
name VARCHAR CHECK (LENGTH(name) >=1 AND  LENGTH(name) <=500)
);


CREATE TABLE tickets (
id INT  PRIMARY KEY AUTO_INCREMENT,
created_at TIMESTAMP,
client_id INT,
from_planet_id VARCHAR,
to_planet_id VARCHAR
);


alter table tickets add constraint client_id_fk foreign key (client_id)
references client (id) on delete cascade;



