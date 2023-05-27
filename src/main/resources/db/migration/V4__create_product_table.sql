CREATE TABLE product (
    id UUID DEFAULT gen_random_uuid(),
    product_description VARCHAR(64),
    product_status VARCHAR(20),
    created_date TIMESTAMP,
    last_modified_date TIMESTAMP,
    PRIMARY KEY (id)
);