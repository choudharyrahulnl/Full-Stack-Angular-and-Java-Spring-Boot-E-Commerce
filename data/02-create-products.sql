-- -----------------------------------------------------
-- Schema full-stack-ecommerce
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `full-stack-ecommerce`;

CREATE SCHEMA `full-stack-ecommerce`;
USE `full-stack-ecommerce` ;

-- -----------------------------------------------------
-- Table `full-stack-ecommerce`.`product_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `full-stack-ecommerce`.`product_category` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE=InnoDB
AUTO_INCREMENT = 1;

-- -----------------------------------------------------
-- Table `full-stack-ecommerce`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `full-stack-ecommerce`.`product` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `sku` VARCHAR(255) DEFAULT NULL,
  `name` VARCHAR(255) DEFAULT NULL,
  `description` VARCHAR(255) DEFAULT NULL,
  `unit_price` DECIMAL(13,2) DEFAULT NULL,
  `image_url` VARCHAR(255) DEFAULT NULL,
  `active` BIT DEFAULT 1,
  `units_in_stock` INT(11) DEFAULT NULL,
   `date_created` DATETIME(6) DEFAULT NULL,
  `last_updated` DATETIME(6) DEFAULT NULL,
  `category_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_category` (`category_id`),
  CONSTRAINT `fk_category` FOREIGN KEY (`category_id`) REFERENCES `product_category` (`id`)
) 
ENGINE=InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Add sample data
-- -----------------------------------------------------

INSERT INTO product_category(category_name) VALUES ('BOOKS'), ('CLOTHS'), ('SHOES'), ('LAPTOPS');

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created, last_updated)
VALUES ('BOOK-TECH-1000', 'JavaScript - The Fun Parts', 'Learn JavaScript',
'assets/images/products/placeholder.png'
,1,100,19.99,1, NOW(), NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created, last_updated)
VALUES ('BOOK-TECH-1001', 'Spring Framework Tutorial', 'Learn Spring',
'assets/images/products/placeholder.png'
,1,100,29.99,1, NOW(), NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created, last_updated)
VALUES ('BOOK-TECH-1002', 'Kubernetes - Deploying Containers', 'Learn Kubernetes',
'assets/images/products/placeholder.png'
,1,100,24.99,1, NOW(), NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created, last_updated)
VALUES ('BOOK-TECH-1003', 'Internet of Things (IoT) - Getting Started', 'Learn IoT',
'assets/images/products/placeholder.png'
,1,100,29.99,1, NOW(), NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
unit_price, category_id, date_created, last_updated)
VALUES ('BOOK-TECH-1004', 'The Go Programming Language: A to Z', 'Learn Go',
'assets/images/products/placeholder.png'
,1,100,24.99,1, NOW(), NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
                     unit_price, category_id, date_created, last_updated)
VALUES ('CLOTH-SHIRT-1000', 'CHECK SHIRT', 'FULL SLEEVES',
        'assets/images/products/placeholder.png'
           ,1,100,24.99,2, NOW(), NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
                     unit_price, category_id, date_created, last_updated)
VALUES ('CLOTH-SHIRT-1001', 'PLAIN SHIRT', 'HALF SLEEVES',
        'assets/images/products/placeholder.png'
           ,1,100,24.99,2, NOW(), NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
                     unit_price, category_id, date_created, last_updated)
VALUES ('SHOE-RUNNING-1000', 'SUMMERS SHOE', 'RUNNING SHOES FOR SUMMERS',
        'assets/images/products/placeholder.png'
           ,1,100,24.99,3, NOW(), NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
                     unit_price, category_id, date_created, last_updated)
VALUES ('SHOE-RUNNING-1001', 'WINTERS SHOE', 'RUNNING SHOES FOR WINTERS',
        'assets/images/products/placeholder.png'
           ,1,100,24.99,3, NOW(), NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
                     unit_price, category_id, date_created, last_updated)
VALUES ('LAPTOP-DELL-1000', 'INSPIRON LAPTOP', 'GOOD FOR PROGRAMING',
        'assets/images/products/placeholder.png'
           ,1,100,24.99,4, NOW(), NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock,
                     unit_price, category_id, date_created, last_updated)
VALUES ('LAPTOP-DELL-1000', 'VOSTRO LAPTOP', 'GOOD FOR ENTERTAINMENT',
        'assets/images/products/placeholder.png'
           ,1,100,24.99,4, NOW(), NOW());
