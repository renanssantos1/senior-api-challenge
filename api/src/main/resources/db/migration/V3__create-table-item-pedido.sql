CREATE TABLE item_pedido (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    quantidade INTEGER NOT NULL,
    produto_servico_id UUID REFERENCES produto_servico(id) ON DELETE RESTRICT,
    pedido_id UUID REFERENCES pedido(id) ON DELETE CASCADE
);