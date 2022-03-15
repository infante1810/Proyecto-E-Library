-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema biblioteca
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema biblioteca
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `biblioteca` DEFAULT CHARACTER SET utf8 ;
USE `biblioteca` ;

-- -----------------------------------------------------
-- Table `biblioteca`.`carreras`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`carreras` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(256) NOT NULL,
  `activo` BIT(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `biblioteca`.`alumnos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`alumnos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(256) NOT NULL,
  `apellidos` VARCHAR(256) NOT NULL,
  `genero` VARCHAR(8) NOT NULL,
  `carrera_id` INT NOT NULL,
  `fecha_ingreso` DATE NOT NULL,
  `fecha_nacimiento` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_alumnos_carreras_idx` (`carrera_id` ASC) VISIBLE,
  CONSTRAINT `FK_alumnos_carreras`
    FOREIGN KEY (`carrera_id`)
    REFERENCES `biblioteca`.`carreras` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `biblioteca`.`editoriales`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`editoriales` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(256) NOT NULL,
  `pais` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `activo` BIT(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `biblioteca`.`tipos_recursos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`tipos_recursos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(256) NOT NULL,
  `activo` BIT(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `biblioteca`.`libros`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`libros` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(512) NOT NULL,
  `tipo_recurso_id` INT NOT NULL,
  `edicion` VARCHAR(128) NULL DEFAULT NULL,
  `editorial_id` INT NULL DEFAULT NULL,
  `autores` VARCHAR(1024) NULL DEFAULT NULL,
  `isbn` VARCHAR(256) NULL DEFAULT NULL,
  `activo` BIT(1) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_recursos_recursos1_idx` (`tipo_recurso_id` ASC) VISIBLE,
  INDEX `FK_recursos_editoriales_idx` (`editorial_id` ASC) VISIBLE,
  CONSTRAINT `FK_recursos_editoriales`
    FOREIGN KEY (`editorial_id`)
    REFERENCES `biblioteca`.`editoriales` (`id`),
  CONSTRAINT `FK_recursos_tipos_recursos`
    FOREIGN KEY (`tipo_recurso_id`)
    REFERENCES `biblioteca`.`tipos_recursos` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `biblioteca`.`libros_inventario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`libros_inventario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `libro_id` INT NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `disponible` BIT(1) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_inventario_libros_idx` (`libro_id` ASC) VISIBLE,
  CONSTRAINT `FK_inventario_libros`
    FOREIGN KEY (`libro_id`)
    REFERENCES `biblioteca`.`libros` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `biblioteca`.`prestamos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`prestamos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `libro_inventario_id` INT NOT NULL,
  `alumno_id` INT NOT NULL,
  `fecha_prestamo` DATETIME NOT NULL,
  `fecha_devuelto` DATETIME NULL DEFAULT NULL,
  `fecha_debe_devolver` DATETIME NOT NULL,
  `disponible` BIT(1) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_prestamos_alumnos_idx` (`alumno_id` ASC) VISIBLE,
  INDEX `FK_prestamos_libros_inventario_idx` (`libro_inventario_id` ASC) VISIBLE,
  CONSTRAINT `FK_prestamos_alumnos`
    FOREIGN KEY (`alumno_id`)
    REFERENCES `biblioteca`.`alumnos` (`id`),
  CONSTRAINT `FK_prestamos_libros_inventario`
    FOREIGN KEY (`libro_inventario_id`)
    REFERENCES `biblioteca`.`libros_inventario` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

USE `biblioteca` ;

-- -----------------------------------------------------
-- Placeholder table for view `biblioteca`.`alumnos_v`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`alumnos_v` (`id` INT, `nombre` INT, `apellidos` INT, `carrera_id` INT, `carrera_nombre` INT, `carrera_activo` INT, `fecha_ingreso` INT, `fecha_nacimiento` INT, `genero` INT);

-- -----------------------------------------------------
-- Placeholder table for view `biblioteca`.`libros_inventario_existencia_v`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`libros_inventario_existencia_v` (`id` INT, `titulo` INT, `tipo_recurso_id` INT, `tipo_recurso_nombre` INT, `tipo_recurso_activo` INT, `edicion` INT, `editorial_id` INT, `editorial_nombre` INT, `editorial_pais` INT, `editorial_emial` INT, `editorial_activo` INT, `autores` INT, `isbn` INT, `activo` INT, `cantidad_en_inventario` INT);

-- -----------------------------------------------------
-- Placeholder table for view `biblioteca`.`libros_inventario_v`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`libros_inventario_v` (`id` INT, `titulo` INT, `tipo_recurso_id` INT, `tipo_recurso_nombre` INT, `tipo_recurso_activo` INT, `edicion` INT, `editorial_id` INT, `editorial_nombre` INT, `editorial_pais` INT, `editorial_emial` INT, `editorial_activo` INT, `autores` INT, `isbn` INT, `activo` INT, `inventario_id` INT, `estado` INT, `disponible` INT);

-- -----------------------------------------------------
-- Placeholder table for view `biblioteca`.`libros_v`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`libros_v` (`id` INT, `titulo` INT, `tipo_recurso_id` INT, `tipo_recurso_nombre` INT, `tipo_recurso_activo` INT, `edicion` INT, `editorial_id` INT, `editorial_nombre` INT, `editorial_pais` INT, `editorial_emial` INT, `editorial_activo` INT, `autores` INT, `isbn` INT, `activo` INT);

-- -----------------------------------------------------
-- Placeholder table for view `biblioteca`.`prestamos_v`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`prestamos_v` (`id` INT, `libro_inventario_id` INT, `libro_id` INT, `libro_titulo` INT, `libro_tipo_recurso_nombre` INT, `libro_edicion` INT, `libro_editorial_nombre` INT, `libro_autores` INT, `libro_isbn` INT, `libro_estado` INT, `alumno_id` INT, `alumno_nombre` INT, `alumno_apellidos` INT, `alumno_carrera_nombre` INT, `fecha_prestamo` INT, `fecha_debe_devolver` INT, `fecha_devuelto` INT);

-- -----------------------------------------------------
-- procedure update_alumno
-- -----------------------------------------------------

DELIMITER $$
USE `biblioteca`$$
CREATE PROCEDURE `update_alumno`(
	 IN p_id int
    ,IN p_nombre  varchar(256)
    ,IN p_apellidos varchar(256)
    ,IN p_genero varchar(8)
    ,IN p_carrera_id int
    ,IN p_fecha_ingreso date
    ,IN p_fecha_nacimiento date
)
BEGIN
	UPDATE alumnos 
		SET
			 nombre = p_nombre
            ,apellidos = p_apellidos
            ,genero = p_genero
            ,carrera_id = p_carrera_id
            ,fecha_ingreso = p_fecha_ingreso
            ,fecha_nacimiento = p_fecha_nacimiento
		WHERE id = p_id;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure update_libro
-- -----------------------------------------------------

DELIMITER $$
USE `biblioteca`$$
CREATE PROCEDURE `update_libro`(
	 IN p_id int
    ,IN p_titulo varchar(512)
	,IN p_tipo_recurso_id int
    ,IN p_edicion varchar(128)
    ,IN p_editorial_id int
    ,IN p_autores varchar(1024)
    ,IN p_isbn varchar(256)
    ,IN p_activo bit(1))
BEGIN
	UPDATE libros
	SET
		 titulo = p_titulo
        ,tipo_recurso_id = p_tipo_recurso_id
        ,edicion = p_edicion
        ,editorial_id = p_editorial_id
        ,autores = p_autores
        ,isbn = p_isbn
        ,activo = p_activo
	WHERE id = p_id;
END$$

-- -----------------------------------------------------
-- procedure insert_alumno
-- -----------------------------------------------------
DELIMITER ;

USE `biblioteca`;
DROP procedure IF EXISTS `insert_alumno`;

DELIMITER $$
USE `biblioteca`$$
CREATE PROCEDURE `insert_alumno` (
	 IN p_id int
    ,IN p_nombre  varchar(256)
    ,IN p_apellidos varchar(256)
    ,IN p_genero varchar(8)
    ,IN p_carrera_id int
    ,IN p_fecha_ingreso date
    ,IN p_fecha_nacimiento date
)
BEGIN
	INSERT INTO alumnos(nombre, apellidos, genero,carrera_id,fecha_ingreso,fecha_nacimiento) 
		VALUES(p_nombre, p_apellidos,p_genero,p_carrera_id,p_fecha_ingreso,p_fecha_nacimiento);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure insert_editorial
-- -----------------------------------------------------
DELIMITER ;

USE `biblioteca`;
DROP procedure IF EXISTS `insert_editorial`;

DELIMITER $$
USE `biblioteca`$$
CREATE PROCEDURE `insert_editorial`(
	 IN p_nombre  varchar(256)
    ,IN p_pais varchar(45)
    ,IN p_email varchar(45)
    ,IN p_activo int
)
BEGIN
	INSERT INTO editoriales(nombre, pais, email,activo) 
		VALUES(p_nombre, p_pais, p_email, p_activo);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure insert_libro
-- -----------------------------------------------------
DELIMITER ;

USE `biblioteca`;
DROP procedure IF EXISTS `insert_libro`;

DELIMITER $$
USE `biblioteca`$$
CREATE PROCEDURE `insert_libro` (
	 IN p_titulo varchar(512)
	,IN p_tipo_recurso_id int
    ,IN p_edicion varchar(128)
    ,IN p_editorial_id int
    ,IN p_autores varchar(1024)
    ,IN p_isbn varchar(256)
    ,IN p_activo bit(1))
BEGIN
	INSERT INTO libros(titulo,tipo_recurso_id,edicion,editorial_id,autores,isbn,activo) 
		VALUES(p_titulo,p_tipo_recurso_id,p_edicion,p_editorial_id,p_autores,p_isbn,p_activo);
END$$

DELIMITER ;




-- -----------------------------------------------------
-- View `biblioteca`.`alumnos_v`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`alumnos_v`;
USE `biblioteca`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `biblioteca`.`alumnos_v` AS select `a`.`id` AS `id`,`a`.`nombre` AS `nombre`,`a`.`apellidos` AS `apellidos`,`a`.`carrera_id` AS `carrera_id`,`c`.`nombre` AS `carrera_nombre`,`c`.`activo` AS `carrera_activo`,`a`.`fecha_ingreso` AS `fecha_ingreso`,`a`.`fecha_nacimiento` AS `fecha_nacimiento`,`a`.`genero` AS `genero` from (`biblioteca`.`alumnos` `a` join `biblioteca`.`carreras` `c` on((`a`.`carrera_id` = `c`.`id`)));

-- -----------------------------------------------------
-- View `biblioteca`.`libros_inventario_existencia_v`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`libros_inventario_existencia_v`;
USE `biblioteca`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `biblioteca`.`libros_inventario_existencia_v` AS select `biblioteca`.`l`.`id` AS `id`,`biblioteca`.`l`.`titulo` AS `titulo`,`biblioteca`.`l`.`tipo_recurso_id` AS `tipo_recurso_id`,`biblioteca`.`l`.`tipo_recurso_nombre` AS `tipo_recurso_nombre`,`biblioteca`.`l`.`tipo_recurso_activo` AS `tipo_recurso_activo`,`biblioteca`.`l`.`edicion` AS `edicion`,`biblioteca`.`l`.`editorial_id` AS `editorial_id`,`biblioteca`.`l`.`editorial_nombre` AS `editorial_nombre`,`biblioteca`.`l`.`editorial_pais` AS `editorial_pais`,`biblioteca`.`l`.`editorial_emial` AS `editorial_emial`,`biblioteca`.`l`.`editorial_activo` AS `editorial_activo`,`biblioteca`.`l`.`autores` AS `autores`,`biblioteca`.`l`.`isbn` AS `isbn`,`biblioteca`.`l`.`activo` AS `activo`,(select count(0) from `biblioteca`.`libros_inventario` `li` where (`li`.`libro_id` = `biblioteca`.`l`.`id`)) AS `cantidad_en_inventario` from `biblioteca`.`libros_v` `l`;

-- -----------------------------------------------------
-- View `biblioteca`.`libros_inventario_v`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`libros_inventario_v`;
USE `biblioteca`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `biblioteca`.`libros_inventario_v` AS select `biblioteca`.`l`.`id` AS `id`,`biblioteca`.`l`.`titulo` AS `titulo`,`biblioteca`.`l`.`tipo_recurso_id` AS `tipo_recurso_id`,`biblioteca`.`l`.`tipo_recurso_nombre` AS `tipo_recurso_nombre`,`biblioteca`.`l`.`tipo_recurso_activo` AS `tipo_recurso_activo`,`biblioteca`.`l`.`edicion` AS `edicion`,`biblioteca`.`l`.`editorial_id` AS `editorial_id`,`biblioteca`.`l`.`editorial_nombre` AS `editorial_nombre`,`biblioteca`.`l`.`editorial_pais` AS `editorial_pais`,`biblioteca`.`l`.`editorial_emial` AS `editorial_emial`,`biblioteca`.`l`.`editorial_activo` AS `editorial_activo`,`biblioteca`.`l`.`autores` AS `autores`,`biblioteca`.`l`.`isbn` AS `isbn`,`biblioteca`.`l`.`activo` AS `activo`,`li`.`id` AS `inventario_id`,`li`.`estado` AS `estado`,`li`.`disponible` AS `disponible` from (`biblioteca`.`libros_inventario` `li` join `biblioteca`.`libros_v` `l` on((`li`.`libro_id` = `biblioteca`.`l`.`id`)));

-- -----------------------------------------------------
-- View `biblioteca`.`libros_v`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`libros_v`;
USE `biblioteca`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `biblioteca`.`libros_v` AS select `l`.`id` AS `id`,`l`.`titulo` AS `titulo`,`l`.`tipo_recurso_id` AS `tipo_recurso_id`,`tr`.`nombre` AS `tipo_recurso_nombre`,`tr`.`activo` AS `tipo_recurso_activo`,`l`.`edicion` AS `edicion`,`l`.`editorial_id` AS `editorial_id`,`e`.`nombre` AS `editorial_nombre`,`e`.`pais` AS `editorial_pais`,`e`.`email` AS `editorial_emial`,`e`.`activo` AS `editorial_activo`,`l`.`autores` AS `autores`,`l`.`isbn` AS `isbn`,`l`.`activo` AS `activo` from ((`biblioteca`.`libros` `l` join `biblioteca`.`tipos_recursos` `tr` on((`l`.`tipo_recurso_id` = `tr`.`id`))) left join `biblioteca`.`editoriales` `e` on((`l`.`editorial_id` = `e`.`id`)));

-- -----------------------------------------------------
-- View `biblioteca`.`prestamos_v`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`prestamos_v`;
USE `biblioteca`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `biblioteca`.`prestamos_v` AS select `p`.`id` AS `id`,`p`.`libro_inventario_id` AS `libro_inventario_id`,`biblioteca`.`li`.`id` AS `libro_id`,`biblioteca`.`li`.`titulo` AS `libro_titulo`,`biblioteca`.`li`.`tipo_recurso_nombre` AS `libro_tipo_recurso_nombre`,`biblioteca`.`li`.`edicion` AS `libro_edicion`,`biblioteca`.`li`.`editorial_nombre` AS `libro_editorial_nombre`,`biblioteca`.`li`.`autores` AS `libro_autores`,`biblioteca`.`li`.`isbn` AS `libro_isbn`,`biblioteca`.`li`.`estado` AS `libro_estado`,`p`.`alumno_id` AS `alumno_id`,`biblioteca`.`a`.`nombre` AS `alumno_nombre`,`biblioteca`.`a`.`apellidos` AS `alumno_apellidos`,`biblioteca`.`a`.`carrera_nombre` AS `alumno_carrera_nombre`,`p`.`fecha_prestamo` AS `fecha_prestamo`,`p`.`fecha_debe_devolver` AS `fecha_debe_devolver`,`p`.`fecha_devuelto` AS `fecha_devuelto` from ((`biblioteca`.`prestamos` `p` join `biblioteca`.`libros_inventario_v` `li` on((`p`.`libro_inventario_id` = `biblioteca`.`li`.`inventario_id`))) join `biblioteca`.`alumnos_v` `a` on((`p`.`alumno_id` = `biblioteca`.`a`.`id`)));

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
