-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 09-06-2019 a las 16:28:22
-- Versión del servidor: 8.0.13-4
-- Versión de PHP: 7.2.19-0ubuntu0.18.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `uCCuEdldr1`
--
CREATE DATABASE IF NOT EXISTS `uCCuEdldr1` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `uCCuEdldr1`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `CATEGORIAS`
--

CREATE TABLE `CATEGORIAS` (
  `Id` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Imagen` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `CATEGORIAS`
--

INSERT INTO `CATEGORIAS` (`Id`, `Nombre`, `Imagen`) VALUES
(1, 'Carne', 'https://i.imgur.com/6mAu46E.png'),
(2, 'Pescado', 'https://i.imgur.com/HEkyNdM.png'),
(3, 'Bebidas', 'https://i.imgur.com/ut1yhH6.png'),
(4, 'Pasta, Arroz y Legumbres', 'https://i.imgur.com/tPKhC7G.png'),
(5, 'Panadería y Desayunos', 'https://i.imgur.com/xXHxxeo.png'),
(6, 'Higiene y Belleza', 'https://i.imgur.com/k4QKqlU.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `DET_FACTURAS`
--

CREATE TABLE `DET_FACTURAS` (
  `Id` int(11) NOT NULL,
  `Id_Factura` int(11) NOT NULL,
  `Id_Producto` int(11) NOT NULL,
  `Cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Volcado de datos para la tabla `DET_FACTURAS`
--

INSERT INTO `DET_FACTURAS` (`Id`, `Id_Factura`, `Id_Producto`, `Cantidad`) VALUES
(1, 1, 1, 1),
(2, 1, 2, 1),
(3, 1, 3, 1),
(4, 2, 1, 1),
(5, 3, 1, 1),
(6, 4, 1, 1),
(7, 5, 1, 1),
(8, 6, 1, 1),
(9, 7, 9, 1),
(10, 8, 1, 1),
(11, 9, 1, 1),
(12, 10, 1, 1),
(13, 11, 2, 1),
(14, 12, 1, 1),
(15, 13, 1, 1),
(16, 14, 1, 1),
(17, 14, 1, 1),
(18, 15, 1, 1),
(19, 16, 1, 1),
(20, 16, 2, 1),
(21, 16, 3, 5),
(22, 16, 4, 1),
(23, 17, 1, 1),
(24, 17, 2, 1),
(25, 17, 6, 1),
(26, 18, 1, 5),
(27, 18, 2, 1),
(28, 18, 3, 1),
(29, 19, 2, 1),
(30, 19, 3, 5),
(31, 19, 4, 1),
(32, 19, 8, 1),
(33, 19, 6, 1),
(34, 20, 1, 1),
(35, 20, 2, 1),
(36, 20, 6, 1),
(37, 20, 15, 1),
(38, 20, 5, 5),
(39, 20, 5, 1),
(40, 20, 5, 1),
(41, 20, 5, 9),
(42, 20, 5, 1),
(43, 20, 5, 1),
(44, 20, 5, 1),
(45, 20, 5, 1),
(46, 20, 5, 1),
(47, 20, 5, 1),
(48, 20, 6, 1),
(49, 20, 2, 1),
(50, 20, 1, 1),
(51, 20, 3, 1),
(52, 21, 1, 1),
(53, 21, 2, 1),
(54, 21, 3, 5),
(55, 21, 4, 1),
(56, 21, 6, 1),
(57, 21, 5, 4),
(58, 21, 7, 1),
(59, 21, 8, 1),
(60, 21, 15, 1),
(61, 22, 1, 1),
(62, 22, 2, 1),
(63, 22, 3, 1),
(64, 22, 4, 1),
(65, 22, 1, 1),
(66, 22, 6, 1),
(67, 22, 1, 1),
(68, 22, 2, 1),
(69, 23, 1, 1),
(70, 23, 1, 1),
(71, 23, 1, 1),
(72, 23, 1, 1),
(73, 23, 5, 1),
(74, 23, 10, 1),
(75, 23, 15, 1),
(76, 23, 14, 1),
(77, 23, 15, 1),
(78, 23, 15, 1),
(79, 23, 7, 1),
(80, 23, 7, 1),
(81, 23, 12, 1),
(82, 23, 12, 1),
(83, 23, 14, 1),
(84, 23, 14, 1),
(85, 23, 15, 1),
(86, 23, 15, 1),
(87, 23, 15, 1),
(88, 23, 15, 1),
(89, 23, 14, 1),
(90, 23, 14, 1),
(91, 23, 13, 1),
(92, 23, 15, 1),
(93, 23, 9, 1),
(94, 24, 1, 1),
(95, 25, 1, 1),
(96, 25, 1, 1),
(99, 26, 23, 1),
(100, 26, 23, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `FACTURAS`
--

CREATE TABLE `FACTURAS` (
  `Id` int(11) NOT NULL,
  `Id_Usuario` int(11) NOT NULL,
  `Fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Cerrado` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Volcado de datos para la tabla `FACTURAS`
--

INSERT INTO `FACTURAS` (`Id`, `Id_Usuario`, `Cerrado`) VALUES
(1, 1, -1),
(2, 1, -1),
(3, 1, 1),
(4, 1, 1),
(5, 1, 1),
(6, 1, 1),
(7, 1, 1),
(8, 1, 1),
(9, 1, 1),
(10, 1, 1),
(11, 1, 1),
(12, 1, 1),
(13, 1, 1),
(14, 1, 1),
(15, 1, 1),
(16, 1, 1),
(17, 1, 1),
(18, 1, -1),
(19, 1, 1),
(20, 1, 1),
(21, 1, 1),
(22, 1, -1),
(23, 1, 1),
(24, 1, 1),
(25, 1, 1),
(26, 1, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `PRODUCTOS`
--

CREATE TABLE `PRODUCTOS` (
  `Id` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Precio` float NOT NULL,
  `Id_Categoria` int(11) NOT NULL,
  `Stock` int(11) NOT NULL,
  `Iva` int(11) NOT NULL DEFAULT '21',
  `Imagen` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `PRODUCTOS`
--

INSERT INTO `PRODUCTOS` (`Id`, `Nombre`, `Precio`, `Id_Categoria`, `Stock`, `Iva`, `Imagen`) VALUES
(1, 'Hamburguesas', 2, 1, 100, 24, 'https://i.imgur.com/A6wPzXN.png'),
(2, 'Carne picada', 5.95, 1, 100, 21, 'https://i.imgur.com/hdNqA8D.png'),
(3, 'Solomillo', 11.5, 1, 100, 21, 'https://i.imgur.com/PMlovwi.png'),
(4, 'Chuletas', 11.98, 1, 100, 5, 'https://i.imgur.com/j7zPXoC.png'),
(5, 'Jamoncitos', 1.98, 1, 100, 21, 'https://i.imgur.com/awIs6P8.png'),
(6, 'Salchichas', 5.99, 1, 200, 21, 'https://i.imgur.com/IoUtBJY.png'),
(7, 'Carpaccio', 3.59, 1, 100, 21, 'https://i.imgur.com/BPpMyxp.png'),
(8, 'Chorizo', 3.5, 1, 100, 12, 'https://i.imgur.com/lXYM26S.png'),
(9, 'Rodaja de Emperador', 5.45, 2, 100, 21, 'https://i.imgur.com/vqSJHfk.png'),
(10, 'Salmón noruego', 6.56, 2, 100, 21, 'https://i.imgur.com/VuqFi4r.png'),
(11, 'Sepia', 7.85, 2, 100, 21, 'https://i.imgur.com/0VWJFEs.png'),
(12, 'Lubina', 3.39, 2, 100, 21, 'https://i.imgur.com/Ojyn5cC.png'),
(13, 'Patas de Pulpo', 7.99, 2, 100, 21, 'https://i.imgur.com/j4kb8iC.png'),
(14, 'Palitos de cangrejo', 2.75, 2, 100, 21, 'https://i.imgur.com/cTfKwRH.png'),
(15, 'Huesos de Jamón', 1.85, 1, 100, 21, 'https://i.imgur.com/QlDUuCL.png'),
(16, 'Coca Cola Pack x24', 12.96, 3, 100, 21, 'https://i.imgur.com/6vppKVQ.png'),
(17, 'Bezoya', 0.59, 3, 100, 21, 'https://i.imgur.com/dOypdoI.png'),
(18, 'Cola Cao', 4.9, 3, 100, 21, 'https://i.imgur.com/YHDBCOC.png'),
(19, 'Aquarius', 1.39, 3, 100, 21, 'https://i.imgur.com/GD0gkGA.png'),
(20, 'Mahou', 2.57, 3, 250, 21, 'https://i.imgur.com/zFW7DHU.png'),
(21, 'Bacardi', 15.43, 3, 55, 21, 'https://i.imgur.com/4sQpXW3.png'),
(23, 'Arroz SOS', 1.52, 4, 555, 21, 'https://i.imgur.com/tPKhC7G.png'),
(24, 'Spaguettis Gallo', 1.02, 4, 778, 21, 'https://i.imgur.com/iX81nY6.png'),
(25, 'Lentejas Luengo', 2.89, 4, 546, 21, 'https://i.imgur.com/OaS1UGA.png'),
(26, 'Alubias Blancas', 1.29, 4, 646, 21, 'https://i.imgur.com/jhLzimn.png'),
(27, 'Pan Bimbo', 2.04, 5, 2, 21, 'https://i.imgur.com/xXHxxeo.png'),
(28, 'Galletas Tosta Rica', 3.02, 5, 54465, 21, 'https://i.imgur.com/Tlz5gzs.png'),
(29, 'Oreo', 1.79, 5, 645, 21, 'https://i.imgur.com/71jmZlO.png'),
(30, 'Galletas Principe', 4.69, 5, 5654, 21, 'https://i.imgur.com/h8300zp.png'),
(33, 'Colgate', 1.65, 6, 8464, 21, 'https://i.imgur.com/k4QKqlU.png'),
(34, 'Sanex', 2.98, 6, 549, 21, 'https://i.imgur.com/nLn9E1o.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `USUARIOS`
--

CREATE TABLE `USUARIOS` (
  `Id` int(11) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Contraseña` varchar(255) NOT NULL,
  `Tipo` tinyint(1) NOT NULL,
  `Estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `USUARIOS`
--

INSERT INTO `USUARIOS` (`Id`, `Nombre`, `Contraseña`, `Tipo`, `Estado`) VALUES
(1, 'Kaiserdj', 'prueba', 1, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `CATEGORIAS`
--
ALTER TABLE `CATEGORIAS`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `Nombre` (`Nombre`);

--
-- Indices de la tabla `DET_FACTURAS`
--
ALTER TABLE `DET_FACTURAS`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `FACTURAS`
--
ALTER TABLE `FACTURAS`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `id_usuario` (`Id_Usuario`);

--
-- Indices de la tabla `PRODUCTOS`
--
ALTER TABLE `PRODUCTOS`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `Nombre` (`Nombre`,`Precio`,`Stock`,`Iva`),
  ADD KEY `Id_Categoria` (`Id_Categoria`);

--
-- Indices de la tabla `USUARIOS`
--
ALTER TABLE `USUARIOS`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `Nombre` (`Nombre`,`Contraseña`,`Tipo`,`Estado`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `CATEGORIAS`
--
ALTER TABLE `CATEGORIAS`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `DET_FACTURAS`
--
ALTER TABLE `DET_FACTURAS`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;

--
-- AUTO_INCREMENT de la tabla `FACTURAS`
--
ALTER TABLE `FACTURAS`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT de la tabla `PRODUCTOS`
--
ALTER TABLE `PRODUCTOS`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT de la tabla `USUARIOS`
--
ALTER TABLE `USUARIOS`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `FACTURAS`
--
ALTER TABLE `FACTURAS`
  ADD CONSTRAINT `id_usuario` FOREIGN KEY (`Id_Usuario`) REFERENCES `USUARIOS` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Filtros para la tabla `PRODUCTOS`
--
ALTER TABLE `PRODUCTOS`
  ADD CONSTRAINT `PRODUCTOS_ibfk_1` FOREIGN KEY (`Id_Categoria`) REFERENCES `CATEGORIAS` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
