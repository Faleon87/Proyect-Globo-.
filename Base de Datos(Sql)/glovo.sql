-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 20-12-2023 a las 08:51:50
-- Versión del servidor: 8.2.0
-- Versión de PHP: 8.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `glovo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carrito`
--

DROP TABLE IF EXISTS `carrito`;
CREATE TABLE IF NOT EXISTS `carrito` (
  `ID_CARRITO` int NOT NULL AUTO_INCREMENT,
  `ID_CLIENTE` int DEFAULT NULL,
  `ID_PRODUCTO` int DEFAULT NULL,
  `CANTIDAD` int DEFAULT NULL,
  PRIMARY KEY (`ID_CARRITO`),
  KEY `FK_ID_CLIENTE_CARRITO` (`ID_CLIENTE`),
  KEY `FK_ID_PRODUCTO_CARRITO` (`ID_PRODUCTO`)
) ENGINE=MyISAM AUTO_INCREMENT=96 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `carrito`
--

INSERT INTO `carrito` (`ID_CARRITO`, `ID_CLIENTE`, `ID_PRODUCTO`, `CANTIDAD`) VALUES
(56, 0, 15, NULL),
(55, 0, 15, NULL),
(54, 0, 10, NULL),
(53, 103, 16, NULL),
(52, 0, 7, NULL),
(51, 0, 21, NULL),
(50, 102, 10, NULL),
(49, 0, 10, NULL),
(48, 0, 21, NULL),
(47, 0, 21, NULL),
(46, 0, 10, NULL),
(45, 0, 10, NULL),
(44, 0, 15, NULL),
(43, 0, 15, NULL),
(42, 102, 10, NULL),
(41, 102, 10, NULL),
(40, 102, 15, NULL),
(39, 102, 10, NULL),
(38, 102, 10, NULL),
(37, 102, 10, NULL),
(36, 102, 10, NULL),
(35, 102, 10, NULL),
(34, 102, 10, NULL),
(33, 102, 10, NULL),
(32, 102, 10, NULL),
(31, 103, 10, NULL),
(30, 103, 10, NULL),
(29, 102, 15, NULL),
(57, 102, 10, NULL),
(58, 102, 10, NULL),
(59, 102, 21, NULL),
(60, 103, 15, NULL),
(61, 103, 15, NULL),
(62, 103, 10, NULL),
(63, 103, 9, NULL),
(64, 103, 21, NULL),
(65, 103, 21, NULL),
(66, 103, 20, NULL),
(67, 103, 21, NULL),
(68, 102, 10, NULL),
(69, 102, 10, NULL),
(70, 0, 0, NULL),
(71, 102, 10, NULL),
(72, 0, 0, NULL),
(73, 102, 15, NULL),
(74, 102, 1, NULL),
(75, 102, 1, NULL),
(76, 102, 1, NULL),
(77, 102, 1, NULL),
(78, 102, 1, NULL),
(79, 102, 1, NULL),
(80, 102, 7, NULL),
(81, 102, 1, NULL),
(82, 102, 1, NULL),
(83, 102, 10, NULL),
(84, 102, 1, NULL),
(85, 102, 1, NULL),
(86, 102, 10, NULL),
(87, 102, 10, NULL),
(88, 102, 10, NULL),
(89, 102, 6, NULL),
(90, 102, 1, NULL),
(91, 102, 1, NULL),
(92, 102, 1, NULL),
(93, 102, 2, NULL),
(94, 102, 2, NULL),
(95, 102, 1, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `ID_CLIENTE` int NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `EMAIL` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `TELEFONO` int DEFAULT NULL,
  `DIRECCION` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID_CLIENTE`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`ID_CLIENTE`, `NOMBRE`, `EMAIL`, `TELEFONO`, `DIRECCION`) VALUES
(101, 'Cliente1', 'cliente1@example.com', 123456789, 'Dirección1'),
(102, 'Cliente2', 'cliente2@example.com', 987654321, 'Dirección2'),
(103, 'Cliente3', 'cliente3@example.com', 111223344, 'Dirección3'),
(104, 'Cliente4', 'cliente4@example.com', 444555666, 'Dirección4'),
(105, 'Cliente5', 'cliente5@example.com', 777888999, 'Dirección5'),
(106, 'Cliente6', 'cliente6@example.com', 123456789, 'Dirección6'),
(107, 'Cliente7', 'cliente7@example.com', 987654321, 'Dirección7'),
(108, 'Cliente8', 'cliente8@example.com', 111223344, 'Dirección8'),
(109, 'Cliente9', 'cliente9@example.com', 444555666, 'Dirección9'),
(110, 'Cliente10', 'cliente10@example.com', 777888999, 'Dirección10'),
(111, 'Cliente11', 'cliente11@example.com', 123456789, 'Dirección11'),
(112, 'Cliente12', 'cliente12@example.com', 987654321, 'Dirección12'),
(113, 'Cliente13', 'cliente13@example.com', 111223344, 'Dirección13'),
(114, 'Cliente14', 'cliente14@example.com', 444555666, 'Dirección14'),
(115, 'Cliente15', 'cliente15@example.com', 777888999, 'Dirección15'),
(116, 'Cliente16', 'cliente16@example.com', 123456789, 'Dirección16'),
(117, 'Cliente17', 'cliente17@example.com', 987654321, 'Dirección17'),
(118, 'Cliente18', 'cliente18@example.com', 111223344, 'Dirección18'),
(119, 'Cliente19', 'cliente19@example.com', 444555666, 'Dirección19'),
(120, 'Cliente20', 'cliente20@example.com', 777888999, 'Dirección20');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

DROP TABLE IF EXISTS `producto`;
CREATE TABLE IF NOT EXISTS `producto` (
  `ID_PRODUCTO` int NOT NULL AUTO_INCREMENT,
  `ID_RESTAURANTE` int DEFAULT NULL,
  `DESCRIPCION` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `IMAGEN` longtext COLLATE utf8mb4_general_ci,
  `NOMBRE` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `PRECIO` int DEFAULT NULL,
  PRIMARY KEY (`ID_PRODUCTO`),
  KEY `FK_ID_RESTAURANTE_PRODUCTO` (`ID_RESTAURANTE`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`ID_PRODUCTO`, `ID_RESTAURANTE`, `DESCRIPCION`, `IMAGEN`, `NOMBRE`, `PRECIO`) VALUES
(1, 1, 'El famoso plato de El Celler de Can Roca', 'img_url_1', 'El Celler Special', 50),
(2, 2, 'Un plato que representa la esencia de DiverXO', 'img_url_2', 'DiverXO Delight', 45),
(3, 3, 'La especialidad marina de Aponiente', 'img_url_3', 'Aponiente Seafood', 40),
(4, 4, 'Un plato que rompe los límites en Mugaritz', 'img_url_4', 'Mugaritz Magic', 35),
(5, 5, 'La combinación perfecta de Arzak', 'img_url_5', 'Arzak Fusion', 30),
(6, 6, 'Un plato que refleja la cocina vasca de Martín Berasategui', 'img_url_6', 'Berasategui Basque', 25),
(7, 7, 'La innovación constante de Quique Dacosta', 'img_url_7', 'Dacosta Discovery', 20),
(8, 8, 'Un plato sostenible de Azurmendi', 'img_url_8', 'Azurmendi Green', 15),
(9, 9, 'Un viaje culinario de El Poblet', 'img_url_9', 'Poblet Journey', 10),
(10, 10, 'La cocina catalana de Sant Pau', 'https://imgs.search.brave.com/B_SEGPpoXRdVfH7pHMHrzZFMFawBhmCnmULLkmiVsMI/rs:fit:860:0:0/g:ce/aHR0cHM6Ly91cGxv/YWQud2lraW1lZGlh/Lm9yZy93aWtpcGVk/aWEvY29tbW9ucy9m/L2YxL1Bhbl9jb25f/VHVtYWNhLmpwZw', 'Sant Pau Catalan', 5),
(11, 11, 'La simplicidad y elegancia de Nerua', 'img_url_11', 'Nerua Elegance', 50),
(12, 12, 'La propuesta culinaria sofisticada de Lasarte', 'img_url_12', 'Lasarte Sophistication', 45),
(13, 13, 'Un plato para disfrutar en Disfrutar', 'img_url_13', 'Disfrutar Delight', 40),
(14, 14, 'La cocina de dos estrellas Michelin de Coque', 'img_url_14', 'Coque Star', 35),
(15, 15, 'Un viaje a Al-Ándalus con Noor', 'https://imgs.search.brave.com/4FiPmByT6xn7zGVxDgJbUx39Ki402g5xViK1us4dQ9I/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9pbWcu/ZnJlZXBpay5jb20v/Zm90b3MtcHJlbWl1/bS9wZXJzb25hLXF1/ZS1sbGV2YS10cmFq/ZS1jYWJlemEtcGV6/Xzc3MTMzNS01MjUy/NC5qcGc_c2l6ZT02/MjYmZXh0PWpwZw', 'Noor Andalus', 3000),
(16, 16, 'La apuesta por los productos locales de Cinc Sentits', 'img_url_16', 'Cinc Sentits Local', 25),
(17, 17, 'La experiencia sensorial de Ricard Camarena', 'img_url_17', 'Camarena Sensation', 20),
(18, 18, 'La alta cocina española de Paco Roncero', 'img_url_18', 'Roncero High Cuisine', 15),
(19, 19, 'La combinación de tradición y modernidad de Ramón Freixa', 'img_url_19', 'Freixa Fusion', 10),
(20, 20, 'La fusión de la cocina japonesa y mediterránea de Kabuki', 'img_url_20', 'Kabuki Fusion', 5),
(21, 87, 'picha bloja musculo fuerte', 'https://imgs.search.brave.com/HJSGJwkq5VMwx0E10nxLB8-VvXnlHNmJJxcRY71oOK4/rs:fit:860:0:0/g:ce/aHR0cHM6Ly93d3cu/bGFuZGVybGFuLmNv/L2ltYWdlcy9wcm9k/dWN0cy90cmVtYm9s/b25hLWFjZXRhdG8t/MTUzNzA2LmpwZw', 'trembo', 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `puntuacion`
--

DROP TABLE IF EXISTS `puntuacion`;
CREATE TABLE IF NOT EXISTS `puntuacion` (
  `ID_PUNTUACION` int NOT NULL AUTO_INCREMENT,
  `ID_RESTAURANTE` int DEFAULT NULL,
  `ID_CLIENTE` int DEFAULT NULL,
  `puntuacion` int DEFAULT NULL,
  `comentario` longtext COLLATE utf8mb4_general_ci,
  PRIMARY KEY (`ID_PUNTUACION`),
  KEY `FK_ID_RESTAURANTE_PUNTUACION` (`ID_RESTAURANTE`),
  KEY `FK_ID_CLIENTE_PUNTUACION` (`ID_CLIENTE`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `puntuacion`
--

INSERT INTO `puntuacion` (`ID_PUNTUACION`, `ID_RESTAURANTE`, `ID_CLIENTE`, `puntuacion`, `comentario`) VALUES
(4, 18, 102, 5, 'me gusta\n'),
(5, 18, 102, 4, 'me gusta pero poco\n'),
(6, 18, 102, 5, 'me gusta solo un poco pero muuy poco'),
(7, 3, 102, 3, NULL),
(8, 18, 102, 3, 'me gusta solo un poco estoy triste.'),
(11, 13, 102, 5, ''),
(12, 9, 102, 5, 'todo esta bien'),
(16, 0, 102, 2, 'no\n'),
(23, 0, 102, 3, 'xd\n'),
(24, 19, 102, 4, 'prueba'),
(26, 19, 102, 5, 'jaime\n'),
(27, 8, 102, 4, 'pruebaaaa\n'),
(28, 19, 102, 4, 'jaime\n'),
(36, 0, 102, 5, 'joderrrr\n'),
(37, 19, 102, 5, 'me gustan los chinos\n'),
(38, 0, 102, 5, 'muy bonito\n'),
(39, 0, 102, 5, 'muy bonito\n'),
(40, 0, 102, 5, 'muy bonito\n'),
(41, 0, 102, 5, 'muy bonito\n'),
(42, 0, 102, 5, 'muy bonito\n'),
(43, 0, 102, 5, 'muy bonito\n'),
(44, 0, 102, 5, 'muy bonito\n'),
(45, 0, 102, 5, 'muy bonito\n'),
(46, 0, 102, 5, 'muy bonito\n'),
(47, 0, 102, 5, 'muy bonito\n'),
(48, 0, 102, 5, 'muy bonito\n'),
(49, 0, 102, 5, 'muy bonito\n'),
(50, 0, 102, 5, 'muy bonito\n'),
(51, 0, 102, 5, 'muy bonito\n'),
(52, 0, 102, 5, 'muy bonito\n'),
(53, 0, 102, 5, 'muy bonito\n'),
(54, 0, 102, 5, 'muy bonito\n'),
(55, 0, 102, 5, 'muy bonito\n'),
(56, 0, 102, 5, 'muy bonito\n'),
(57, 18, 102, 4, ''),
(58, 18, 102, 4, ''),
(59, 18, 102, 4, ''),
(60, 18, 102, 4, ''),
(61, 18, 102, 4, ''),
(62, 18, 102, 5, 'david\n'),
(63, 18, 102, 5, 'david'),
(64, 1, 102, 5, 'Muy bien'),
(65, 1, 102, 5, 'Muy bien'),
(66, 13, 102, 4, 'muy bien'),
(67, 19, 102, 4, 'jaime\n'),
(68, 19, 102, 4, 'jaime\n'),
(69, 19, 102, 4, 'jaime\n'),
(70, 13, 102, 5, 'david gracias'),
(71, 18, 102, 3, 'ffdff'),
(72, 18, 102, 3, 'rfff'),
(73, 18, 102, 3, 'rfff'),
(74, 19, 102, 3, 'kkk'),
(75, 18, 102, 3, 'ffff'),
(76, 18, 102, 3, 'ggg'),
(77, 18, 102, 3, 'ggg'),
(78, 18, 102, 3, 'dddd'),
(79, 18, 102, 3, 'dddd'),
(80, 18, 102, 3, 'fffff'),
(81, 18, 102, 3, 'fff'),
(82, 18, 102, 3, 'fff'),
(83, 18, 102, 0, 'ffff'),
(84, 14, 102, 3, 'ffff'),
(85, 14, 102, 3, 'ffff'),
(86, 14, 102, 3, 'ffff'),
(87, 14, 102, 3, 'ffff'),
(88, 18, 102, 3, 'fff'),
(89, 18, 102, 3, 'fff');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservas`
--

DROP TABLE IF EXISTS `reservas`;
CREATE TABLE IF NOT EXISTS `reservas` (
  `ID_RESERVAS` int NOT NULL AUTO_INCREMENT,
  `ID_RESTAURANTE` int DEFAULT NULL,
  `CONFIRMADA` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID_RESERVAS`),
  KEY `FK_ID_RESTAURANTE_RESERVAS` (`ID_RESTAURANTE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `restaurante`
--

DROP TABLE IF EXISTS `restaurante`;
CREATE TABLE IF NOT EXISTS `restaurante` (
  `ID_RESTAURANTE` int NOT NULL,
  `NOMBRE` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `IMAGEN` longtext COLLATE utf8mb4_general_ci,
  `DESCRIPCION` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `VENTAS` int DEFAULT NULL,
  `TEMATICA` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID_RESTAURANTE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `restaurante`
--

INSERT INTO `restaurante` (`ID_RESTAURANTE`, `NOMBRE`, `IMAGEN`, `DESCRIPCION`, `VENTAS`, `TEMATICA`) VALUES
(0, 'Marisco Recio', 'https://imgs.search.brave.com/EQNKHh2hYjjg-d_PR25mmFLTkz0S_TSXf3WTLm0t6jU/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9pbWFn/ZXMubWlsYW51bmNp/b3MuY29tL2FwaS92/MS9tYS1hZC1tZWRp/YS1wcm8vaW1hZ2Vz/L2RmZTM1YWE3LTU4/ODgtNDI5YS04MmQ2/LTE3YmM3ZmU3NjY5/OD9ydWxlPWh3Mzk2/Xzcw', 'la mar esta fresquisima', 80000, 'Espanol'),
(1, 'El Bocado Delicioso', 'https://imgs.search.brave.com/6GEfDwaR9nIyhxe3Twy-tjOHC6WBtQ3MCDDt4cCwDKg/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9vZmZs/b2FkbWVkaWEuZmV2/ZXJ1cC5jb20vbWFk/cmlkc2VjcmV0by5j/by93cC1jb250ZW50/L3VwbG9hZHMvMjAy/Mi8wMS8yNTA0MzY0/Mi9UZXJyYWNvdHRh/LTUyMDBweC1TYWxv/bi1wcmluY2lwYWwt/MS0xLTEwMjR4Njgz/LmpwZw', 'Un lugar acogedor con una amplia variedad de platos españoles.', 1200, 'Italiano'),
(2, 'La Cocina de la Abuela', 'https://imgs.search.brave.com/jB0i2XvoUfVTfUf-vxeQVwr2UrPrr1oa_2OE8ig2YPg/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS1jZG4udHJpcGFk/dmlzb3IuY29tL21l/ZGlhL3Bob3RvLW8v/MjYvN2YvMWYvYWIv/cmVzdGF1cmFudGUt/Z2FzdHJvbm9taWNv/LmpwZw', 'Comida casera como la que hacía la abuela.', 900, 'Americano'),
(3, 'Sabores del Mundo', 'https://imgs.search.brave.com/cg_DKFIYKDc0oxfedUqJKvgV9UBrajXbWxCR-0NxiH4/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS1jZG4udHJpcGFk/dmlzb3IuY29tL21l/ZGlhL3Bob3RvLW8v/MTIvNmIvNDIvYzAv/cmVzdGF1cmFudGUt/ZWwtbWVzb24uanBn', 'Una mezcla de sabores de todo el mundo en un solo lugar.', 1500, 'Chino'),
(4, 'El Rinconcito', 'https://imgs.search.brave.com/hieVKn832tT-sdMCoThV2NQmIQ8m5yrA26ZWTT0dsjY/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9saDUu/Z29vZ2xldXNlcmNv/bnRlbnQuY29tL3Av/QUYxUWlwUDlLNVJh/UWc4YmpoTHRON0RR/MjRhZWZreUlMNVpX/S05vTXZsa2s', 'Un pequeño restaurante con grandes sabores.', 700, 'Espanol'),
(5, 'Mar y Tierra', NULL, 'Los mejores platos de mariscos y carnes en un solo lugar.', 1800, 'Italiano'),
(6, 'Bistro Moderno', NULL, 'Cocina moderna en un ambiente elegante.', 2100, 'Espanol'),
(7, 'Parrilla al Aire Libre', NULL, 'Disfruta de la mejor parrilla bajo el cielo abierto.', 1300, 'Italiano'),
(8, 'Sabor Asiático', NULL, 'Los sabores más auténticos de la cocina asiática.', 1600, 'Chino'),
(9, 'La Trattoria', NULL, 'Disfruta de la auténtica cocina italiana en un ambiente cálido.', 2000, 'Italiano'),
(10, 'Café y Más', NULL, 'No solo un café, un lugar para relajarse y disfrutar.', 800, 'Americano'),
(11, 'Cocina Vegana', NULL, 'Deliciosos y saludables platos veganos.', 950, 'Italiano'),
(12, 'El Sabor de México', NULL, 'Auténtica cocina mexicana en el corazón de la ciudad.', 1700, 'Espanol'),
(13, 'Cocina Mediterránea', 'https://imgs.search.brave.com/Fd-KIoJ1AClcbgv4yXLvyTHNtByNJONaHd1ZvOeoZAw/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS50aW1lb3V0LmNv/bS9pbWFnZXMvMTAw/NTcyNjM5LzYzMC80/NzIvaW1hZ2UuanBn', 'Los sabores frescos y saludables del Mediterráneo.', 2200, 'Italiano'),
(14, 'El Gourmet Francés', NULL, 'Experimenta la sofisticación de la cocina francesa.', 2300, 'Italiano'),
(15, 'Sabores del Sur', NULL, 'Cocina sureña tradicional en un ambiente familiar.', 1400, 'Italiano'),
(16, 'El Jardín Secreto', NULL, 'Un oasis de tranquilidad donde disfrutar de una buena comida.', 1100, 'Americano'),
(17, 'Cocina Fusión', NULL, 'Una mezcla innovadora de diferentes estilos culinarios.', 1900, 'Italiano'),
(18, 'El Asador', 'https://imgs.search.brave.com/NDSBMeBBJg--uEwkwWI50E5jxegzt07d-gt7N3231tc/rs:fit:860:0:0/g:ce/aHR0cDovL2VsYXNh/ZG9yLmNvbS5teC93/cC1jb250ZW50L3Ro/ZW1lcy9hc2Fkb3JM/RlMvaW1nL2hvbWUy/LnBuZw', 'Los mejores cortes de carne en un ambiente rústico.', 2400, 'Italiano'),
(19, 'Mariscos del Pacífico', NULL, 'Los mariscos más frescos directamente del Pacífico.', 2500, 'Chino'),
(20, 'Bocados Dulces', NULL, 'Un lugar para los amantes de los postres.', 1000, 'Italiano'),
(87, 'YinBar', NULL, NULL, NULL, 'Chino');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `ID_USUARIO` int NOT NULL AUTO_INCREMENT,
  `ID_CLIENTE` int DEFAULT NULL,
  `USERNAME` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID_USUARIO`),
  KEY `FK_ID_CLIENTE_USUARIO` (`ID_CLIENTE`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`ID_USUARIO`, `ID_CLIENTE`, `USERNAME`, `password`) VALUES
(1, 101, 'jaime', '1234'),
(2, 102, 'jaimevijuesca', '1234'),
(3, 103, 'amancio_ortega', 'megustalafruta'),
(4, 104, 'user4', 'hashed_password4'),
(5, 105, 'user5', 'hashed_password5'),
(6, 106, 'user6', 'hashed_password6'),
(7, 107, 'user7', 'hashed_password7'),
(8, 108, 'user8', 'hashed_password8'),
(9, 109, 'user9', 'hashed_password9'),
(10, 110, 'user10', 'hashed_password10'),
(11, 111, 'user11', 'hashed_password11'),
(12, 112, 'user12', 'hashed_password12'),
(13, 113, 'user13', 'hashed_password13'),
(14, 114, 'user14', 'hashed_password14'),
(15, 115, 'user15', 'hashed_password15'),
(16, 116, 'user16', 'hashed_password16'),
(17, 117, 'user17', 'hashed_password17'),
(18, 118, 'user18', 'hashed_password18'),
(19, 119, 'user19', 'hashed_password19'),
(20, 120, 'user20', 'hashed_password20');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `FK_ID_RESTAURANTE_PRODUCTO` FOREIGN KEY (`ID_RESTAURANTE`) REFERENCES `restaurante` (`ID_RESTAURANTE`);

--
-- Filtros para la tabla `puntuacion`
--
ALTER TABLE `puntuacion`
  ADD CONSTRAINT `FK_ID_CLIENTE_PUNTUACION` FOREIGN KEY (`ID_CLIENTE`) REFERENCES `cliente` (`ID_CLIENTE`),
  ADD CONSTRAINT `FK_ID_RESTAURANTE_PUNTUACION` FOREIGN KEY (`ID_RESTAURANTE`) REFERENCES `restaurante` (`ID_RESTAURANTE`);

--
-- Filtros para la tabla `reservas`
--
ALTER TABLE `reservas`
  ADD CONSTRAINT `FK_ID_RESTAURANTE_RESERVAS` FOREIGN KEY (`ID_RESTAURANTE`) REFERENCES `restaurante` (`ID_RESTAURANTE`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `FK_ID_CLIENTE_USUARIO` FOREIGN KEY (`ID_CLIENTE`) REFERENCES `cliente` (`ID_CLIENTE`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
