DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id BIGSERIAL PRIMARY KEY,
  login VARCHAR(255) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  balance DOUBLE PRECISION
);

INSERT INTO users (login, password, balance) VALUES
  ('Admin', '12345', 0),
  ('User', '123', 0);