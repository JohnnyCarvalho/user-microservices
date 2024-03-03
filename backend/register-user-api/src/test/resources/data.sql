-- Criar o esquema se não existir
CREATE SCHEMA IF NOT EXISTS testdb;

-- Criar a tabela se não existir
CREATE TABLE IF NOT EXISTS testdb.user_data (
    id INT PRIMARY KEY,
    country VARCHAR(255),
    document_number VARCHAR(255),
    email VARCHAR(255),
    first_name VARCHAR(255),
    house_number VARCHAR(255),
    last_name VARCHAR(255),
    middle_name VARCHAR(255),
    password VARCHAR(255),
    phone_number VARCHAR(255),
    reference_point VARCHAR(255),
    state VARCHAR(255),
    status BOOLEAN,
    street VARCHAR(255),
    user_name VARCHAR(255),
    zip_code VARCHAR(255)
    );

-- Inserir dados na tabela
INSERT INTO testdb.user_data (id, country, document_number, email, first_name, house_number,
                              last_name, middle_name, password, phone_number, reference_point,
                              state, status, street, user_name, zip_code)
VALUES (1, 'EXAMPLE', 'EXAMPLE', 'example@blocked.com', 'EXAMPLE', 'EXAMPLE',
        'EXAMPLE', 'EXAMPLE', 'EXAMPLE', 'EXAMPLE', 'EXAMPLE', 'EXAMPLE',
        0, 'EXAMPLE', 'Example.Blocked', 'EXAMPLE');
