-- MySQL Script generated by MySQL Workbench
-- mar 22 nov 2022 21:43:10
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Ccu
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Ccu
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Ccu` DEFAULT CHARACTER SET utf8 ;
USE `Ccu` ;

-- -----------------------------------------------------
-- Table `Ccu`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Ccu`.`cliente` (
  `numrut_cliente` INT NOT NULL,
  `dvrut_cliente` VARCHAR(1) NOT NULL,
  `nombre_cliente` VARCHAR(25) NOT NULL,
  `appaterno_cliente` VARCHAR(15) NOT NULL,
  `apmaterno_cliente` VARCHAR(15) NOT NULL,
  `direccion_cliente` VARCHAR(60) NOT NULL,
  `comuna_cliente` VARCHAR(30) NOT NULL,
  `telefono_cliente` INT NOT NULL,
  `email_cliente` VARCHAR(50) NOT NULL,
  `nombre_empresa` VARCHAR(50) NOT NULL,
  `tipo_empresa` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`numrut_cliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Ccu`.`inventario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Ccu`.`inventario` (
  `id_inventario` INT NOT NULL,
  `fecha_movimiento` DATE NOT NULL,
  `tipo_movimiento` VARCHAR(45) NOT NULL,
  `cantidad_movimiento` INT NOT NULL,
  PRIMARY KEY (`id_inventario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Ccu`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Ccu`.`producto` (
  `id_producto` INT NOT NULL,
  `nombre_producto` VARCHAR(30) NOT NULL,
  `tipo_producto` VARCHAR(20) NOT NULL,
  `formato` VARCHAR(20) NOT NULL,
  `cantidad_stock` INT NOT NULL,
  `grado_etilico` FLOAT NOT NULL,
  `costo` INT NOT NULL,
  `precio_venta` INT NOT NULL,
  `inventario_id_inventario` INT NOT NULL,
  PRIMARY KEY (`id_producto`, `inventario_id_inventario`),
  INDEX `fk_producto_inventario1_idx` (`inventario_id_inventario` ASC) VISIBLE,
  CONSTRAINT `fk_producto_inventario1`
    FOREIGN KEY (`inventario_id_inventario`)
    REFERENCES `Ccu`.`inventario` (`id_inventario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Ccu`.`venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Ccu`.`venta` (
  `id_venta` INT NOT NULL AUTO_INCREMENT,
  `fecha_venta` DATE NULL,
  `producto_id_producto` INT NOT NULL,
  `producto_inventario_id_inventario` INT NOT NULL,
  `cliente_numrut_cliente` INT NOT NULL,
  PRIMARY KEY (`id_venta`, `producto_id_producto`, `producto_inventario_id_inventario`, `cliente_numrut_cliente`),
  INDEX `fk_venta_producto1_idx` (`producto_id_producto` ASC, `producto_inventario_id_inventario` ASC) VISIBLE,
  INDEX `fk_venta_cliente1_idx` (`cliente_numrut_cliente` ASC) VISIBLE,
  CONSTRAINT `fk_venta_producto1`
    FOREIGN KEY (`producto_id_producto` , `producto_inventario_id_inventario`)
    REFERENCES `Ccu`.`producto` (`id_producto` , `inventario_id_inventario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venta_cliente1`
    FOREIGN KEY (`cliente_numrut_cliente`)
    REFERENCES `Ccu`.`cliente` (`numrut_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;