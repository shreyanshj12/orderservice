ALTER TABLE order_header
  ADD COLUMN order_status VARCHAR(30),
  ADD COLUMN created_date TIMESTAMP,
  ADD COLUMN last_modified_date TIMESTAMP; 