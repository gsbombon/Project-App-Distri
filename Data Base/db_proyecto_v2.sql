CREATE DATABASE lgh;
USE lgh;
-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-05-2022 a las 17:22:57
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `lgh`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulo`
--

CREATE TABLE `articulo` (
  `CODIGO_ART` int(11) NOT NULL,
  `NOMBRE_ART` varchar(128) DEFAULT NULL,
  `PRECIO_ART` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `articulo`
--

INSERT INTO `articulo` (`CODIGO_ART`, `NOMBRE_ART`, `PRECIO_ART`) VALUES
(1, 'Papas', '1.30'),
(2, 'Coca Cola', '0.80'),
(3, 'Helado Polito', '0.25'),
(4, 'Trident', '0.50');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cabecera_comprobante_inventario`
--

CREATE TABLE `cabecera_comprobante_inventario` (
  `NUMERO_CABECERA_INVEN` int(11) NOT NULL,
  `CODIGO_TMOV` int(11) NOT NULL,
  `FECHA_CABECERA_INVEN` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cabecera_comprobante_inventario`
--

INSERT INTO `cabecera_comprobante_inventario` (`NUMERO_CABECERA_INVEN`, `CODIGO_TMOV`, `FECHA_CABECERA_INVEN`) VALUES
(1, 1, '2022-05-07'),
(2, 2, '2022-04-05');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cabecera_factura`
--

CREATE TABLE `cabecera_factura` (
  `NUMERO_CABECERA_FACTU` int(11) NOT NULL,
  `CODIGO_CLI` int(11) NOT NULL,
  `FECHA_CABECERA_FACTU` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cabecera_factura`
--

INSERT INTO `cabecera_factura` (`NUMERO_CABECERA_FACTU`, `CODIGO_CLI`, `FECHA_CABECERA_FACTU`) VALUES
(1, 1, '2022-03-05'),
(2, 2, '2022-04-08'),
(3, 1, '2022-06-04');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cabecera_facturacion_cuentaxcobrar`
--

CREATE TABLE `cabecera_facturacion_cuentaxcobrar` (
  `NUMERO_CABECERA_FACT_CXC` int(11) NOT NULL,
  `CODIGO_CLI` int(11) DEFAULT NULL,
  `CODIGO_COB` int(11) NOT NULL,
  `FECHA_CABECERA_FACT_CXC` date DEFAULT NULL,
  `VALOR_CABECERA_FACT_CXC` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cabecera_facturacion_cuentaxcobrar`
--

INSERT INTO `cabecera_facturacion_cuentaxcobrar` (`NUMERO_CABECERA_FACT_CXC`, `CODIGO_CLI`, `CODIGO_COB`, `FECHA_CABECERA_FACT_CXC`, `VALOR_CABECERA_FACT_CXC`) VALUES
(1, 1, 2, '2022-05-04', '200.5'),
(2, 2, 2, '2022-06-07', '500.2'),
(3, 1, 2, '2022-11-25', '12.35');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudad`
--

CREATE TABLE `ciudad` (
  `CODIGO_CIU` int(11) NOT NULL,
  `NOMBRE_CIU` varchar(128) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ciudad`
--

INSERT INTO `ciudad` (`CODIGO_CIU`, `NOMBRE_CIU`) VALUES
(1, 'Quito'),
(2, 'Guayaquil'),
(3, 'Cuenca'),
(4, 'Esmeraldas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `CODIGO_CLI` int(11) NOT NULL,
  `CODIGO_CIU` int(11) NOT NULL,
  `RUC_CLI` varchar(13) DEFAULT NULL,
  `NOM_CLI` varchar(128) DEFAULT NULL,
  `DIR_CLI` varchar(1258) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`CODIGO_CLI`, `CODIGO_CIU`, `RUC_CLI`, `NOM_CLI`, `DIR_CLI`) VALUES
(1, 1, '1751133552001', 'Carmen Torres', '6 de diciembre '),
(2, 4, '1762453829001', 'Marta Flores', 'Garcia Moreno'),
(3, 1, '1762538273001', 'Juan Perez', '10 de Agosto');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cobrador`
--

CREATE TABLE `cobrador` (
  `CODIGO_COB` int(11) NOT NULL,
  `NOM_COB` varchar(128) DEFAULT NULL,
  `DIR_COB` varchar(128) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cobrador`
--

INSERT INTO `cobrador` (`CODIGO_COB`, `NOM_COB`, `DIR_COB`) VALUES
(1, 'Ricardo Loor', 'Naciones Unidas'),
(2, 'Fernando Morales', 'Isla Seymour');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_comprobante_factura`
--

CREATE TABLE `detalle_comprobante_factura` (
  `CODIGO_ART` int(11) NOT NULL,
  `NUMERO_CABECERA_FACTU` int(11) NOT NULL,
  `CODIGO_DETALLE_COMPROBANTE_FACTURA` int(11) NOT NULL,
  `CANTIDAD_DETALLE_COMPROBANTE_FACTURA` varchar(16) DEFAULT NULL,
  `PRECIO__DETALLE_COMPROBANTE_FACTURA` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detalle_comprobante_factura`
--

INSERT INTO `detalle_comprobante_factura` (`CODIGO_ART`, `NUMERO_CABECERA_FACTU`, `CODIGO_DETALLE_COMPROBANTE_FACTURA`, `CANTIDAD_DETALLE_COMPROBANTE_FACTURA`, `PRECIO__DETALLE_COMPROBANTE_FACTURA`) VALUES
(1, 1, 1, '179', '200.5'),
(3, 2, 2, '2000', '500.2'),
(4, 3, 3, '25', '12.35');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_comprobante_inventario`
--

CREATE TABLE `detalle_comprobante_inventario` (
  `CODIGO_ART` int(11) NOT NULL,
  `NUMERO_CABECERA_INVEN` int(11) NOT NULL,
  `CODIGO_DETALLE_COMPROBANTE_INVENTARIO` int(11) NOT NULL,
  `CANTIDAD_DETALLE_COMPROBANTE_INVENTARIO` varchar(16) DEFAULT NULL,
  `PRECIO_DETALLE_COMPROBANTE_INVENTARIO` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detalle_comprobante_inventario`
--

INSERT INTO `detalle_comprobante_inventario` (`CODIGO_ART`, `NUMERO_CABECERA_INVEN`, `CODIGO_DETALLE_COMPROBANTE_INVENTARIO`, `CANTIDAD_DETALLE_COMPROBANTE_INVENTARIO`, `PRECIO_DETALLE_COMPROBANTE_INVENTARIO`) VALUES
(1, 1, 1, '179', '200.5'),
(2, 2, 2, '2000', '500.2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_pagos_cuentasxcobrar`
--

CREATE TABLE `detalle_pagos_cuentasxcobrar` (
  `CODIGO_FP` int(11) NOT NULL,
  `NUMERO_CABECERA_FACT_CXC` int(11) NOT NULL,
  `FECHA_DETALLE_PAGOS_CUENTASXCOBRAR` date NOT NULL,
  `VALOR_DETALLE_PAGOS_CUENTASXCOBRAR` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detalle_pagos_cuentasxcobrar`
--

INSERT INTO `detalle_pagos_cuentasxcobrar` (`CODIGO_FP`, `NUMERO_CABECERA_FACT_CXC`, `FECHA_DETALLE_PAGOS_CUENTASXCOBRAR`, `VALOR_DETALLE_PAGOS_CUENTASXCOBRAR`) VALUES
(1, 1, '2022-07-05', '200.5'),
(2, 3, '2022-01-02', '12.35'),
(3, 2, '2022-08-14', '500.2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `formapago`
--

CREATE TABLE `formapago` (
  `CODIGO_FP` int(11) NOT NULL,
  `NOM_FP` varchar(128) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `formapago`
--

INSERT INTO `formapago` (`CODIGO_FP`, `NOM_FP`) VALUES
(1, 'Cheque'),
(2, 'Efectivo'),
(3, 'Tarjeta'),
(4, 'Transferencia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipomovimiento`
--

CREATE TABLE `tipomovimiento` (
  `CODIGO_TMOV` int(11) NOT NULL,
  `NOMBRE_TMOV` varchar(128) DEFAULT NULL,
  `SIGNO_TMOV` varchar(128) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipomovimiento`
--

INSERT INTO `tipomovimiento` (`CODIGO_TMOV`, `NOMBRE_TMOV`, `SIGNO_TMOV`) VALUES
(1, 'Ingreso', 'Positivo'),
(2, 'Egreso', 'Negativo');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `articulo`
--
ALTER TABLE `articulo`
  ADD PRIMARY KEY (`CODIGO_ART`);

--
-- Indices de la tabla `cabecera_comprobante_inventario`
--
ALTER TABLE `cabecera_comprobante_inventario`
  ADD PRIMARY KEY (`NUMERO_CABECERA_INVEN`),
  ADD KEY `FK_CABCERAINVENTARIO_TIPOMOVIMINETO` (`CODIGO_TMOV`);

--
-- Indices de la tabla `cabecera_factura`
--
ALTER TABLE `cabecera_factura`
  ADD PRIMARY KEY (`NUMERO_CABECERA_FACTU`),
  ADD KEY `FK_TIENE` (`CODIGO_CLI`);

--
-- Indices de la tabla `cabecera_facturacion_cuentaxcobrar`
--
ALTER TABLE `cabecera_facturacion_cuentaxcobrar`
  ADD PRIMARY KEY (`NUMERO_CABECERA_FACT_CXC`),
  ADD KEY `FK_CABECERAFACTURA_COBRADOR` (`CODIGO_COB`),
  ADD KEY `FK_PAGA` (`CODIGO_CLI`);

--
-- Indices de la tabla `ciudad`
--
ALTER TABLE `ciudad`
  ADD PRIMARY KEY (`CODIGO_CIU`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`CODIGO_CLI`),
  ADD KEY `FK_CIUDAD_CLIENTE` (`CODIGO_CIU`);

--
-- Indices de la tabla `cobrador`
--
ALTER TABLE `cobrador`
  ADD PRIMARY KEY (`CODIGO_COB`);

--
-- Indices de la tabla `detalle_comprobante_factura`
--
ALTER TABLE `detalle_comprobante_factura`
  ADD PRIMARY KEY (`CODIGO_ART`,`NUMERO_CABECERA_FACTU`,`CODIGO_DETALLE_COMPROBANTE_FACTURA`),
  ADD KEY `FK_DETALLE_COMPROBANTE_FACTURA2` (`NUMERO_CABECERA_FACTU`);

--
-- Indices de la tabla `detalle_comprobante_inventario`
--
ALTER TABLE `detalle_comprobante_inventario`
  ADD PRIMARY KEY (`CODIGO_ART`,`NUMERO_CABECERA_INVEN`,`CODIGO_DETALLE_COMPROBANTE_INVENTARIO`),
  ADD KEY `FK_DETALLE_COMPROBANTE_INVENTARIO2` (`NUMERO_CABECERA_INVEN`);

--
-- Indices de la tabla `detalle_pagos_cuentasxcobrar`
--
ALTER TABLE `detalle_pagos_cuentasxcobrar`
  ADD PRIMARY KEY (`CODIGO_FP`,`NUMERO_CABECERA_FACT_CXC`,`FECHA_DETALLE_PAGOS_CUENTASXCOBRAR`),
  ADD KEY `FK_DETALLE_PAGOS_CUENTASXCOBRAR2` (`NUMERO_CABECERA_FACT_CXC`);

--
-- Indices de la tabla `formapago`
--
ALTER TABLE `formapago`
  ADD PRIMARY KEY (`CODIGO_FP`);

--
-- Indices de la tabla `tipomovimiento`
--
ALTER TABLE `tipomovimiento`
  ADD PRIMARY KEY (`CODIGO_TMOV`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cabecera_comprobante_inventario`
--
ALTER TABLE `cabecera_comprobante_inventario`
  ADD CONSTRAINT `FK_CABCERAINVENTARIO_TIPOMOVIMINETO` FOREIGN KEY (`CODIGO_TMOV`) REFERENCES `tipomovimiento` (`CODIGO_TMOV`);

--
-- Filtros para la tabla `cabecera_factura`
--
ALTER TABLE `cabecera_factura`
  ADD CONSTRAINT `FK_TIENE` FOREIGN KEY (`CODIGO_CLI`) REFERENCES `cliente` (`CODIGO_CLI`);

--
-- Filtros para la tabla `cabecera_facturacion_cuentaxcobrar`
--
ALTER TABLE `cabecera_facturacion_cuentaxcobrar`
  ADD CONSTRAINT `FK_CABECERAFACTURA_COBRADOR` FOREIGN KEY (`CODIGO_COB`) REFERENCES `cobrador` (`CODIGO_COB`),
  ADD CONSTRAINT `FK_PAGA` FOREIGN KEY (`CODIGO_CLI`) REFERENCES `cliente` (`CODIGO_CLI`);

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `FK_CIUDAD_CLIENTE` FOREIGN KEY (`CODIGO_CIU`) REFERENCES `ciudad` (`CODIGO_CIU`);

--
-- Filtros para la tabla `detalle_comprobante_factura`
--
ALTER TABLE `detalle_comprobante_factura`
  ADD CONSTRAINT `FK_DETALLE_COMPROBANTE_FACTURA` FOREIGN KEY (`CODIGO_ART`) REFERENCES `articulo` (`CODIGO_ART`),
  ADD CONSTRAINT `FK_DETALLE_COMPROBANTE_FACTURA2` FOREIGN KEY (`NUMERO_CABECERA_FACTU`) REFERENCES `cabecera_factura` (`NUMERO_CABECERA_FACTU`);

--
-- Filtros para la tabla `detalle_comprobante_inventario`
--
ALTER TABLE `detalle_comprobante_inventario`
  ADD CONSTRAINT `FK_DETALLE_COMPROBANTE_INVENTARIO` FOREIGN KEY (`CODIGO_ART`) REFERENCES `articulo` (`CODIGO_ART`),
  ADD CONSTRAINT `FK_DETALLE_COMPROBANTE_INVENTARIO2` FOREIGN KEY (`NUMERO_CABECERA_INVEN`) REFERENCES `cabecera_comprobante_inventario` (`NUMERO_CABECERA_INVEN`);

--
-- Filtros para la tabla `detalle_pagos_cuentasxcobrar`
--
ALTER TABLE `detalle_pagos_cuentasxcobrar`
  ADD CONSTRAINT `FK_DETALLE_PAGOS_CUENTASXCOBRAR` FOREIGN KEY (`CODIGO_FP`) REFERENCES `formapago` (`CODIGO_FP`),
  ADD CONSTRAINT `FK_DETALLE_PAGOS_CUENTASXCOBRAR2` FOREIGN KEY (`NUMERO_CABECERA_FACT_CXC`) REFERENCES `cabecera_facturacion_cuentaxcobrar` (`NUMERO_CABECERA_FACT_CXC`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
