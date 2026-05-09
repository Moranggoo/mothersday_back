CREATE TABLE cupom (
    id serial PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    icone VARCHAR(100),
    status VARCHAR(30)
);