CREATE TABLE itens_pedido (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    quantidade INTEGER NOT NULL,
    produto_servico_id UUID REFERENCES produtos_servicos(id) ON DELETE RESTRICT,
    pedido_id UUID REFERENCES pedidos(id) ON DELETE CASCADE
);