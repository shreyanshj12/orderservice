CREATE TABLE order_header (
    id UUID DEFAULT gen_random_uuid(),
    customer VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);