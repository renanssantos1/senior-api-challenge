CREATE TABLE pedido (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    status VARCHAR(50) NOT NULL DEFAULT 'Aberto' CHECK (status IN ('Aberto', 'Fechado')),
    desconto NUMERIC(5, 2) DEFAULT 0 NOT NULL
);