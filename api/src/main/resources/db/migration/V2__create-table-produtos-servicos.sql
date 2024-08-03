CREATE TABLE produtos_servicos (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    preco NUMERIC(10, 2) NOT NULL,
    ativo BOOLEAN DEFAULT TRUE NOT NULL,
    is_produto BOOLEAN NOT NULL CHECK (is_produto IN (TRUE, FALSE))
);

