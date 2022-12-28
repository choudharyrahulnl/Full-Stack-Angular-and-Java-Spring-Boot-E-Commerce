DROP SCHEMA IF EXISTS `full-stack-ecommerce-unit-test`;

CREATE SCHEMA `full-stack-ecommerce-unit-test`;
USE `full-stack-ecommerce-unit-test`;


CREATE TABLE address
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    city     VARCHAR(255)          NULL,
    country  VARCHAR(255)          NULL,
    state    VARCHAR(255)          NULL,
    street   VARCHAR(255)          NULL,
    zip_code VARCHAR(255)          NULL,
    CONSTRAINT PK_ADDRESS PRIMARY KEY (id)
);

CREATE TABLE country
(
    id   SMALLINT UNSIGNED NOT NULL,
    code VARCHAR(2)        NULL,
    name VARCHAR(255)      NULL,
    CONSTRAINT PK_COUNTRY PRIMARY KEY (id)
);

CREATE TABLE customer
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(255)          NULL,
    last_name  VARCHAR(255)          NULL,
    email      VARCHAR(255)          NULL,
    CONSTRAINT PK_CUSTOMER PRIMARY KEY (id)
);

CREATE TABLE order_item
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    image_url  VARCHAR(255)          NULL,
    quantity   INT                   NULL,
    unit_price DECIMAL(19, 2)        NULL,
    order_id   BIGINT                NULL,
    product_id BIGINT                NULL,
    CONSTRAINT PK_ORDER_ITEM PRIMARY KEY (id)
);

CREATE TABLE orders
(
    id                    BIGINT AUTO_INCREMENT NOT NULL,
    order_tracking_number VARCHAR(255)          NULL,
    total_price           DECIMAL(19, 2)        NULL,
    total_quantity        INT                   NULL,
    billing_address_id    BIGINT                NULL,
    customer_id           BIGINT                NULL,
    shipping_address_id   BIGINT                NULL,
    status                VARCHAR(128)          NULL,
    date_created          datetime              NULL,
    last_updated          datetime              NULL,
    CONSTRAINT PK_ORDERS PRIMARY KEY (id),
    UNIQUE (billing_address_id),
    UNIQUE (shipping_address_id)
);

CREATE TABLE product
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    sku            VARCHAR(255)          NULL,
    name           VARCHAR(255)          NULL,
    `description`  VARCHAR(255)          NULL,
    unit_price     DECIMAL(13, 2)        NULL,
    image_url      VARCHAR(255)          NULL,
    active         BIT(1) DEFAULT 1      NULL,
    units_in_stock INT                   NULL,
    date_created   datetime              NULL,
    last_updated   datetime              NULL,
    category_id    BIGINT                NOT NULL,
    CONSTRAINT PK_PRODUCT PRIMARY KEY (id)
);

CREATE TABLE product_category
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    category_name VARCHAR(255)          NULL,
    CONSTRAINT PK_PRODUCT_CATEGORY PRIMARY KEY (id)
);

CREATE TABLE state
(
    id         SMALLINT UNSIGNED AUTO_INCREMENT NOT NULL,
    name       VARCHAR(255)                     NULL,
    country_id SMALLINT UNSIGNED                NOT NULL,
    CONSTRAINT PK_STATE PRIMARY KEY (id)
);

CREATE INDEX FK_product_id ON order_item (product_id);

CREATE INDEX K_customer_id ON orders (customer_id);

CREATE INDEX K_order_id ON order_item (order_id);

CREATE INDEX fk_category ON product (category_id);

CREATE INDEX fk_country ON state (country_id);

ALTER TABLE orders
    ADD CONSTRAINT FK_billing_address_id FOREIGN KEY (billing_address_id) REFERENCES address (id) ON UPDATE RESTRICT ON DELETE RESTRICT;

ALTER TABLE orders
    ADD CONSTRAINT FK_customer_id FOREIGN KEY (customer_id) REFERENCES customer (id) ON UPDATE RESTRICT ON DELETE RESTRICT;

ALTER TABLE order_item
    ADD CONSTRAINT FK_order_id FOREIGN KEY (order_id) REFERENCES orders (id) ON UPDATE RESTRICT ON DELETE RESTRICT;

ALTER TABLE order_item
    ADD CONSTRAINT FK_product_id FOREIGN KEY (product_id) REFERENCES product (id) ON UPDATE RESTRICT ON DELETE RESTRICT;

ALTER TABLE orders
    ADD CONSTRAINT FK_shipping_address_id FOREIGN KEY (shipping_address_id) REFERENCES address (id) ON UPDATE RESTRICT ON DELETE RESTRICT;

ALTER TABLE product
    ADD CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES product_category (id) ON UPDATE RESTRICT ON DELETE RESTRICT;

ALTER TABLE state
    ADD CONSTRAINT fk_country FOREIGN KEY (country_id) REFERENCES country (id) ON UPDATE RESTRICT ON DELETE RESTRICT;