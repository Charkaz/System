/*
 Navicat MySQL Data Transfer

 Source Server         : Charkaz
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost:3306
 Source Schema         : system

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 12/12/2018 15:15:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for digerodenis
-- ----------------------------
DROP TABLE IF EXISTS `digerodenis`;
CREATE TABLE `digerodenis`  (
  `id` int(11) NOT NULL,
  `Sebeb` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Miqdar` double NOT NULL,
  `TarixDiger` date NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for girismusteri
-- ----------------------------
DROP TABLE IF EXISTS `girismusteri`;
CREATE TABLE `girismusteri`  (
  `id` int(11) NOT NULL,
  `ad` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `mebleg` double NOT NULL,
  `zaman` date NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hesab
-- ----------------------------
DROP TABLE IF EXISTS `hesab`;
CREATE TABLE `hesab`  (
  `id` int(11) NOT NULL,
  `AdSoyad` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Sirket` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Sifre` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `QeydTarix` date NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hesab
-- ----------------------------
INSERT INTO `hesab` VALUES (1, 'Alisan Cerkez', 'Charkaz Corp', '12345', '2018-12-08');

-- ----------------------------
-- Table structure for isciler
-- ----------------------------
DROP TABLE IF EXISTS `isciler`;
CREATE TABLE `isciler`  (
  `id` int(11) NOT NULL,
  `İsciAdSoyad` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Telefon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Adres` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `DogumTarix` date NOT NULL,
  `QeydTarix` date NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for isciodenisi
-- ----------------------------
DROP TABLE IF EXISTS `isciodenisi`;
CREATE TABLE `isciodenisi`  (
  `id` int(11) NOT NULL,
  `isciAd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `OdenisIsci` double NOT NULL,
  `Tarixisci` date NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mehsulalma
-- ----------------------------
DROP TABLE IF EXISTS `mehsulalma`;
CREATE TABLE `mehsulalma`  (
  `id` int(11) NOT NULL,
  `MehsulAd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TechizatciAd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `miqdar` double NOT NULL,
  `tutar` double NOT NULL,
  `Tarix` date NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mehsullar
-- ----------------------------
DROP TABLE IF EXISTS `mehsullar`;
CREATE TABLE `mehsullar`  (
  `id` int(11) NOT NULL,
  `MehsulAd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Olcu` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Barkod` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `MehsulSay` double NOT NULL,
  `AlisQiymet` double NOT NULL,
  `SatisQiymet` double NOT NULL,
  `SonTarix` date NOT NULL,
  `QeydTarix` date NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mehsulqaytarma
-- ----------------------------
DROP TABLE IF EXISTS `mehsulqaytarma`;
CREATE TABLE `mehsulqaytarma`  (
  `id` int(11) NOT NULL,
  `MehsulAd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TechizatciAd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Miqdar` double NOT NULL,
  `Tutar` double NOT NULL,
  `tarix` date NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for musteriler
-- ----------------------------
DROP TABLE IF EXISTS `musteriler`;
CREATE TABLE `musteriler`  (
  `id` int(11) NOT NULL,
  `MusteriAdSoyad` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Telefon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Adres` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `DogumTarixi` date NOT NULL,
  `QeydTarix` date NOT NULL,
  `QaliqBorc` double NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for nagd
-- ----------------------------
DROP TABLE IF EXISTS `nagd`;
CREATE TABLE `nagd`  (
  `id` int(11) NOT NULL,
  `negd` double NOT NULL,
  `Tarix` date NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for picture
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture`  (
  `id` int(11) NOT NULL,
  `Profil` longblob NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for qaime
-- ----------------------------
DROP TABLE IF EXISTS `qaime`;
CREATE TABLE `qaime`  (
  `id` int(11) NOT NULL,
  `MusteriAdSoyad` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Odenecek` double NOT NULL,
  `Odenildi` double NOT NULL,
  `Zaman` date NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for satis
-- ----------------------------
DROP TABLE IF EXISTS `satis`;
CREATE TABLE `satis`  (
  `id` int(11) NOT NULL,
  `Mehsul` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Miqdar` double NOT NULL,
  `Qiymet` double NOT NULL,
  `Endrim` double NOT NULL,
  `Tutar` double NOT NULL,
  `Qaime` int(11) NOT NULL,
  `Musteri` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Tarix` date NOT NULL,
  `Vahid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for techizatcilar
-- ----------------------------
DROP TABLE IF EXISTS `techizatcilar`;
CREATE TABLE `techizatcilar`  (
  `id` int(11) NOT NULL,
  `TechizatciAdSoyad` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Telefon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Adres` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `DogumTarix` date NOT NULL,
  `QeydTarix` date NOT NULL,
  `Borcumuz` double NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for techizatciodenisi
-- ----------------------------
DROP TABLE IF EXISTS `techizatciodenisi`;
CREATE TABLE `techizatciodenisi`  (
  `id` int(11) NOT NULL,
  `techizatciAd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `techizatciOdenis` double NOT NULL,
  `TarixTechizatci` date NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
