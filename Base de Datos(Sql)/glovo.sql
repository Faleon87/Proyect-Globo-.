-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-11-2023 a las 00:18:22
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

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
CREATE DATABASE IF NOT EXISTS `glovo` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `glovo`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `ID_CLIENTE` int(11) NOT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `TELEFONO` int(11) DEFAULT NULL,
  `DIRECCION` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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

CREATE TABLE `producto` (
  `ID_PRODUCTO` int(11) NOT NULL,
  `ID_RESTAURANTE` int(11) DEFAULT NULL,
  `DESCRIPCION` varchar(255) DEFAULT NULL,
  `IMAGEN` longtext DEFAULT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `PRECIO` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
(10, 10, 'La cocina catalana de Sant Pau', 'img_url_10', 'Sant Pau Catalan', 5),
(11, 11, 'La simplicidad y elegancia de Nerua', 'img_url_11', 'Nerua Elegance', 50),
(12, 12, 'La propuesta culinaria sofisticada de Lasarte', 'img_url_12', 'Lasarte Sophistication', 45),
(13, 13, 'Un plato para disfrutar en Disfrutar', 'img_url_13', 'Disfrutar Delight', 40),
(14, 14, 'La cocina de dos estrellas Michelin de Coque', 'img_url_14', 'Coque Star', 35),
(15, 15, 'Un viaje a Al-Ándalus con Noor', 'img_url_15', 'Noor Andalus', 30),
(16, 16, 'La apuesta por los productos locales de Cinc Sentits', 'img_url_16', 'Cinc Sentits Local', 25),
(17, 17, 'La experiencia sensorial de Ricard Camarena', 'img_url_17', 'Camarena Sensation', 20),
(18, 18, 'La alta cocina española de Paco Roncero', 'img_url_18', 'Roncero High Cuisine', 15),
(19, 19, 'La combinación de tradición y modernidad de Ramón Freixa', 'img_url_19', 'Freixa Fusion', 10),
(20, 20, 'La fusión de la cocina japonesa y mediterránea de Kabuki', 'img_url_20', 'Kabuki Fusion', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `puntuacion`
--

CREATE TABLE `puntuacion` (
  `ID_PUNTUACION` int(11) NOT NULL,
  `ID_RESTAURANTE` int(11) DEFAULT NULL,
  `ID_CLIENTE` int(11) DEFAULT NULL,
  `puntuacion` int(11) DEFAULT NULL,
  `comentario` longtext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `puntuacion`
--

INSERT INTO `puntuacion` (`ID_PUNTUACION`, `ID_RESTAURANTE`, `ID_CLIENTE`, `puntuacion`, `comentario`) VALUES
(4, 18, 102, 5, 'me gusta\n'),
(5, 18, 102, 4, 'me gusta pero poco\n'),
(6, 18, 102, 5, 'me gusta solo un poco pero muuy poco');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservas`
--

CREATE TABLE `reservas` (
  `ID_RESERVAS` int(11) NOT NULL,
  `ID_RESTAURANTE` int(11) DEFAULT NULL,
  `CONFIRMADA` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `restaurante`
--

CREATE TABLE `restaurante` (
  `ID_RESTAURANTE` int(11) NOT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `IMAGEN` longtext DEFAULT NULL,
  `DESCRIPCION` varchar(255) DEFAULT NULL,
  `VENTAS` int(11) DEFAULT NULL,
  `TEMATICA` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `restaurante`
--

INSERT INTO `restaurante` (`ID_RESTAURANTE`, `NOMBRE`, `IMAGEN`, `DESCRIPCION`, `VENTAS`, `TEMATICA`) VALUES
(1, 'El Bocado Delicioso', NULL, 'Un lugar acogedor con una amplia variedad de platos españoles.', 1200, 'Italiano'),
(2, 'La Cocina de la Abuela', NULL, 'Comida casera como la que hacía la abuela.', 900, 'Frances'),
(3, 'Sabores del Mundo', NULL, 'Una mezcla de sabores de todo el mundo en un solo lugar.', 1500, 'Chino'),
(4, 'El Rinconcito', NULL, 'Un pequeño restaurante con grandes sabores.', 700, 'Español'),
(5, 'Mar y Tierra', NULL, 'Los mejores platos de mariscos y carnes en un solo lugar.', 1800, 'Italiano'),
(6, 'Bistro Moderno', NULL, 'Cocina moderna en un ambiente elegante.', 2100, 'Italiano'),
(7, 'Parrilla al Aire Libre', NULL, 'Disfruta de la mejor parrilla bajo el cielo abierto.', 1300, 'Italiano'),
(8, 'Sabor Asiático', NULL, 'Los sabores más auténticos de la cocina asiática.', 1600, 'Italiano'),
(9, 'La Trattoria', NULL, 'Disfruta de la auténtica cocina italiana en un ambiente cálido.', 2000, 'Italiano'),
(10, 'Café y Más', NULL, 'No solo un café, un lugar para relajarse y disfrutar.', 800, 'Italiano'),
(11, 'Cocina Vegana', NULL, 'Deliciosos y saludables platos veganos.', 950, 'Italiano'),
(12, 'El Sabor de México', NULL, 'Auténtica cocina mexicana en el corazón de la ciudad.', 1700, 'Italiano'),
(13, 'Cocina Mediterránea', NULL, 'Los sabores frescos y saludables del Mediterráneo.', 2200, 'Italiano'),
(14, 'El Gourmet Francés', NULL, 'Experimenta la sofisticación de la cocina francesa.', 2300, 'Italiano'),
(15, 'Sabores del Sur', NULL, 'Cocina sureña tradicional en un ambiente familiar.', 1400, 'Italiano'),
(16, 'El Jardín Secreto', NULL, 'Un oasis de tranquilidad donde disfrutar de una buena comida.', 1100, 'Italiano'),
(17, 'Cocina Fusión', NULL, 'Una mezcla innovadora de diferentes estilos culinarios.', 1900, 'Italiano'),
(18, 'El Asador', 'https://imgs.search.brave.com/NDSBMeBBJg--uEwkwWI50E5jxegzt07d-gt7N3231tc/rs:fit:860:0:0/g:ce/aHR0cDovL2VsYXNh/ZG9yLmNvbS5teC93/cC1jb250ZW50L3Ro/ZW1lcy9hc2Fkb3JM/RlMvaW1nL2hvbWUy/LnBuZw', 'Los mejores cortes de carne en un ambiente rústico.', 2400, 'Italiano'),
(19, 'Mariscos del Pacífico', NULL, 'Los mariscos más frescos directamente del Pacífico.', 2500, 'Italiano'),
(20, 'Bocados Dulces', NULL, 'Un lugar para los amantes de los postres.', 1000, 'Italiano');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `ID_USUARIO` int(11) NOT NULL,
  `ID_CLIENTE` int(11) DEFAULT NULL,
  `USERNAME` varchar(50) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`ID_USUARIO`, `ID_CLIENTE`, `USERNAME`, `password`) VALUES
(1, 101, 'jaime', '1234'),
(2, 102, 'jaimevijuesca', '1234'),
(3, 103, 'user3', 'hashed_password3'),
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
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`ID_CLIENTE`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`ID_PRODUCTO`),
  ADD KEY `FK_ID_RESTAURANTE_PRODUCTO` (`ID_RESTAURANTE`);

--
-- Indices de la tabla `puntuacion`
--
ALTER TABLE `puntuacion`
  ADD PRIMARY KEY (`ID_PUNTUACION`),
  ADD KEY `FK_ID_RESTAURANTE_PUNTUACION` (`ID_RESTAURANTE`),
  ADD KEY `FK_ID_CLIENTE_PUNTUACION` (`ID_CLIENTE`);

--
-- Indices de la tabla `reservas`
--
ALTER TABLE `reservas`
  ADD PRIMARY KEY (`ID_RESERVAS`),
  ADD KEY `FK_ID_RESTAURANTE_RESERVAS` (`ID_RESTAURANTE`);

--
-- Indices de la tabla `restaurante`
--
ALTER TABLE `restaurante`
  ADD PRIMARY KEY (`ID_RESTAURANTE`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`ID_USUARIO`),
  ADD KEY `FK_ID_CLIENTE_USUARIO` (`ID_CLIENTE`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `ID_CLIENTE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=121;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `ID_PRODUCTO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `puntuacion`
--
ALTER TABLE `puntuacion`
  MODIFY `ID_PUNTUACION` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `reservas`
--
ALTER TABLE `reservas`
  MODIFY `ID_RESERVAS` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `ID_USUARIO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

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
