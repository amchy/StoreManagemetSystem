CREATE DATABASE IF NOT EXISTS `maxomus_ais` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `maxomus_ais`;
CREATE TABLE IF NOT EXISTS `approved_by` (
  `orderNo` varchar(25) COLLATE utf8mb4_unicode_ci NOT NULL,
  `approvedBy` int(11) NOT NULL,
  PRIMARY KEY (`orderNo`,`approvedBy`),
  KEY `approvedBy` (`approvedBy`),
  KEY `orderNo` (`orderNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
CREATE TABLE IF NOT EXISTS `checked_by` (
  `orderNo` int(11) NOT NULL,
  `checked_by` int(11) NOT NULL,
  PRIMARY KEY (`orderNo`,`checked_by`),
  KEY `checked_by` (`checked_by`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
CREATE TABLE IF NOT EXISTS `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(190) COLLATE utf8mb4_unicode_ci NOT NULL,
  `shipping` text COLLATE utf8mb4_unicode_ci,
  `address` text COLLATE utf8mb4_unicode_ci,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `customer_contact` (
  `c_id` int(11) NOT NULL,
  `phone_no` int(14) NOT NULL,
  PRIMARY KEY (`c_id`),
  UNIQUE KEY `phone_no` (`phone_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `customer_image` (
  `customer_id` int(11) NOT NULL,
  `image_location` text COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
CREATE TABLE IF NOT EXISTS `customer_login` (
  `customer_id` int(11) NOT NULL,
  `username` varchar(35) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
CREATE TABLE IF NOT EXISTS `employeeinfo` (
  `employeeID` int(11) NOT NULL,
  `name` varchar(55) COLLATE utf32_unicode_ci NOT NULL,
  `email` varchar(55) COLLATE utf32_unicode_ci NOT NULL,
  `picture` longblob,
  `address` varchar(255) COLLATE utf32_unicode_ci NOT NULL,
  `username` varchar(25) COLLATE utf32_unicode_ci NOT NULL,
  `password` varchar(25) COLLATE utf32_unicode_ci NOT NULL,
  `piority` int(11) NOT NULL,
  `locationID` int(11) NOT NULL,
  `status` varchar(255) COLLATE utf32_unicode_ci NOT NULL,
  PRIMARY KEY (`employeeID`,`locationID`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`),
  KEY `locationID` (`locationID`),
  KEY `employeeID` (`employeeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;
CREATE TABLE IF NOT EXISTS `e_contact` (
  `employeeID` int(11) NOT NULL,
  `contactNo` varchar(20) COLLATE utf32_unicode_ci NOT NULL,
  PRIMARY KEY (`employeeID`,`contactNo`),
  UNIQUE KEY `contactNo` (`contactNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;
CREATE TABLE IF NOT EXISTS `invoice` (
  `orderNo` int(11) NOT NULL,
  `due_date` date NOT NULL,
  `shipping` varchar(36) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`orderNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
CREATE TABLE IF NOT EXISTS `itemlocation` (
  `ItemID` int(11) NOT NULL,
  `orderNo` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `storageID` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`ItemID`,`orderNo`,`storageID`),
  KEY `orderNo` (`orderNo`),
  KEY `storageID` (`storageID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;
CREATE TABLE IF NOT EXISTS `location` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `region` varchar(25) COLLATE utf32_unicode_ci NOT NULL,
  `district` varchar(25) COLLATE utf32_unicode_ci NOT NULL,
  `sub_district` varchar(25) COLLATE utf32_unicode_ci NOT NULL,
  `city` varchar(25) COLLATE utf32_unicode_ci NOT NULL,
  `zip` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;
CREATE TABLE IF NOT EXISTS `ordertable` (
  `orderNo` varchar(25) COLLATE utf8mb4_unicode_ci NOT NULL,
  `req_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `discount` decimal(10,2) NOT NULL,
  `vat` decimal(10,2) NOT NULL,
  `term` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`orderNo`,`req_id`),
  UNIQUE KEY `req_id` (`req_id`),
  UNIQUE KEY `orderNo` (`orderNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
CREATE TABLE IF NOT EXISTS `po_checked_by` (
  `orderNo` varchar(25) COLLATE utf8mb4_unicode_ci NOT NULL,
  `approvedBy` int(11) NOT NULL,
  PRIMARY KEY (`orderNo`,`approvedBy`),
  KEY `approvedBy` (`approvedBy`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
CREATE TABLE IF NOT EXISTS `prepared_by` (
  `cretedby` int(11) NOT NULL,
  `orderNo` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`cretedby`,`orderNo`),
  KEY `cretedby` (`cretedby`),
  KEY `orderNo` (`orderNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;
CREATE TABLE IF NOT EXISTS `price` (
  `orderNo` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `p_ID` int(11) NOT NULL,
  `unit_cost` decimal(10,2) NOT NULL,
  PRIMARY KEY (`orderNo`,`p_ID`),
  KEY `p_ID` (`p_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;
CREATE TABLE IF NOT EXISTS `product` (
  `ItemID` int(11) NOT NULL,
  `name` varchar(35) COLLATE utf32_unicode_ci NOT NULL,
  PRIMARY KEY (`ItemID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;
CREATE TABLE IF NOT EXISTS `product_img` (
  `img_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_ID` int(11) NOT NULL,
  `productImage` text COLLATE utf32_unicode_ci NOT NULL,
  PRIMARY KEY (`img_id`,`product_ID`),
  KEY `product_ID` (`product_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;
CREATE TABLE IF NOT EXISTS `product_vendore_price` (
  `pid` int(11) NOT NULL,
  `vid` int(11) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`pid`,`vid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
CREATE TABLE IF NOT EXISTS `receive` (
  `orderNo` varchar(25) COLLATE utf8mb4_unicode_ci NOT NULL,
  `req_no` int(11) NOT NULL,
  `received_by` int(11) NOT NULL,
  `status` varchar(5) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`orderNo`,`req_no`,`received_by`),
  KEY `req_no` (`req_no`),
  KEY `received_by` (`received_by`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
CREATE TABLE IF NOT EXISTS `requisition` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `warehouse` int(11) NOT NULL,
  `date` date NOT NULL,
  `status` int(11) DEFAULT NULL,
  `reff` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`warehouse`),
  KEY `warehouse` (`warehouse`)
) ENGINE=InnoDB AUTO_INCREMENT=213 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
CREATE TABLE IF NOT EXISTS `requisition_des` (
  `req_id` int(11) NOT NULL,
  `itemID` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`req_id`,`itemID`),
  KEY `itemID` (`itemID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
CREATE TABLE IF NOT EXISTS `sales_cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`customer_id`),
  KEY `customer_id` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
CREATE TABLE IF NOT EXISTS `sales_order` (
  `customer_id` int(11) NOT NULL,
  `orderNo` int(11) NOT NULL,
  `VAT` double(10,2) NOT NULL,
  `date` date NOT NULL,
  `payment_method` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` text COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`customer_id`,`orderNo`),
  KEY `orderNo` (`orderNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
CREATE TABLE IF NOT EXISTS `sales_order_description` (
  `orderNo` int(11) NOT NULL AUTO_INCREMENT,
  `itemID` int(11) NOT NULL,
  `price` double(10,2) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`orderNo`,`itemID`),
  KEY `itemID` (`itemID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
CREATE TABLE IF NOT EXISTS `selling_price` (
  `ItemID` int(11) NOT NULL,
  `cost_per_unit` decimal(10,2) NOT NULL,
  PRIMARY KEY (`ItemID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
CREATE TABLE IF NOT EXISTS `shipped_by` (
  `orderNo` int(11) NOT NULL,
  `shipped_by` int(11) NOT NULL,
  PRIMARY KEY (`orderNo`,`shipped_by`),
  KEY `shipped_by` (`shipped_by`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
CREATE TABLE IF NOT EXISTS `so_approved` (
  `orderNo` int(11) NOT NULL,
  `approvedBy` int(11) NOT NULL,
  PRIMARY KEY (`orderNo`,`approvedBy`),
  KEY `approvedBy` (`approvedBy`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
CREATE TABLE IF NOT EXISTS `supervisior` (
  `supervisor_ID` int(11) NOT NULL,
  `employeeID` int(11) NOT NULL,
  PRIMARY KEY (`supervisor_ID`,`employeeID`),
  KEY `employeeID` (`employeeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;
CREATE TABLE IF NOT EXISTS `supplier` (
  `id` int(11) NOT NULL,
  `name` varchar(30) COLLATE utf32_unicode_ci NOT NULL,
  `email` text COLLATE utf32_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;
CREATE TABLE IF NOT EXISTS `supplierac` (
  `supplierID` int(11) NOT NULL,
  `bankName` varchar(25) COLLATE utf32_unicode_ci NOT NULL,
  `accountNo` varchar(25) COLLATE utf32_unicode_ci NOT NULL,
  PRIMARY KEY (`supplierID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;
CREATE TABLE IF NOT EXISTS `supplier_approve` (
  `supplierID` int(11) NOT NULL,
  `approvedBy` int(11) NOT NULL,
  PRIMARY KEY (`supplierID`,`approvedBy`),
  KEY `supplierID` (`supplierID`),
  KEY `approvedBy` (`approvedBy`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
CREATE TABLE IF NOT EXISTS `supplier_location` (
  `supplierID` int(11) NOT NULL,
  `areaID` int(11) NOT NULL,
  `address` text COLLATE utf32_unicode_ci NOT NULL,
  PRIMARY KEY (`supplierID`,`areaID`),
  KEY `areaID` (`areaID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;
CREATE TABLE IF NOT EXISTS `supplier_no` (
  `supplierID` int(11) NOT NULL,
  `phoneNo` varchar(15) COLLATE utf32_unicode_ci NOT NULL,
  PRIMARY KEY (`supplierID`,`phoneNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;
CREATE TABLE IF NOT EXISTS `supplier_order` (
  `supplierID` int(11) NOT NULL,
  `purchase_orderNo` varchar(25) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`supplierID`,`purchase_orderNo`),
  KEY `purchase_orderNo` (`purchase_orderNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
CREATE TABLE IF NOT EXISTS `s_cart_item` (
  `cart_id` int(11) NOT NULL,
  `itemID` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`cart_id`,`itemID`),
  KEY `itemID` (`itemID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
CREATE TABLE IF NOT EXISTS `warehousestatus` (
  `id` int(11) NOT NULL,
  `capacity` int(11) NOT NULL,
  `status` varchar(11) COLLATE utf32_unicode_ci NOT NULL,
  `rent` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;
CREATE TABLE IF NOT EXISTS `warehouse_contact` (
  `warehouseID` int(11) NOT NULL,
  `contactNo` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`warehouseID`,`contactNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
CREATE TABLE IF NOT EXISTS `warehouse_location` (
  `storageID` int(11) NOT NULL,
  `locationID` int(11) NOT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`storageID`,`locationID`),
  KEY `locationID` (`locationID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;
CREATE TABLE IF NOT EXISTS `warehouse_manager` (
  `employeeID` int(11) NOT NULL,
  `warehouse` int(11) NOT NULL,
  PRIMARY KEY (`employeeID`,`warehouse`),
  KEY `warehouse` (`warehouse`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
--
-- Constraints for table `approved_by`
--
ALTER TABLE `approved_by`
  ADD CONSTRAINT `approved_by_ibfk_1` FOREIGN KEY (`approvedBy`) REFERENCES `supervisior` (`supervisor_ID`) ON UPDATE CASCADE,
  ADD CONSTRAINT `approved_by_ibfk_2` FOREIGN KEY (`orderNo`) REFERENCES `po_checked_by` (`orderNo`) ON UPDATE CASCADE;

--
-- Constraints for table `checked_by`
--
ALTER TABLE `checked_by`
  ADD CONSTRAINT `checked_by_ibfk_1` FOREIGN KEY (`orderNo`) REFERENCES `sales_order` (`orderNo`) ON UPDATE CASCADE,
  ADD CONSTRAINT `checked_by_ibfk_2` FOREIGN KEY (`checked_by`) REFERENCES `supervisior` (`employeeID`) ON UPDATE CASCADE;

--
-- Constraints for table `customer_contact`
--
ALTER TABLE `customer_contact`
  ADD CONSTRAINT `customer_contact_ibfk_1` FOREIGN KEY (`c_id`) REFERENCES `customer` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `customer_image`
--
ALTER TABLE `customer_image`
  ADD CONSTRAINT `customer_image_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `customer_login`
--
ALTER TABLE `customer_login`
  ADD CONSTRAINT `customer_login_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `employeeinfo`
--
ALTER TABLE `employeeinfo`
  ADD CONSTRAINT `employeeinfo_ibfk_1` FOREIGN KEY (`locationID`) REFERENCES `location` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `e_contact`
--
ALTER TABLE `e_contact`
  ADD CONSTRAINT `e_contact_ibfk_1` FOREIGN KEY (`employeeID`) REFERENCES `employeeinfo` (`employeeID`) ON UPDATE CASCADE;

--
-- Constraints for table `invoice`
--
ALTER TABLE `invoice`
  ADD CONSTRAINT `invoice_ibfk_1` FOREIGN KEY (`orderNo`) REFERENCES `checked_by` (`orderNo`) ON UPDATE CASCADE;

--
-- Constraints for table `itemlocation`
--
ALTER TABLE `itemlocation`
  ADD CONSTRAINT `itemlocation_ibfk_1` FOREIGN KEY (`ItemID`) REFERENCES `product` (`ItemID`) ON UPDATE CASCADE,
  ADD CONSTRAINT `itemlocation_ibfk_2` FOREIGN KEY (`storageID`) REFERENCES `warehousestatus` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `itemlocation_ibfk_3` FOREIGN KEY (`orderNo`) REFERENCES `ordertable` (`orderNo`) ON UPDATE CASCADE;

--
-- Constraints for table `ordertable`
--
ALTER TABLE `ordertable`
  ADD CONSTRAINT `ordertable_ibfk_1` FOREIGN KEY (`req_id`) REFERENCES `requisition_des` (`req_id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `ordertable_ibfk_2` FOREIGN KEY (`orderNo`) REFERENCES `supplier_order` (`purchase_orderNo`) ON UPDATE CASCADE;

--
-- Constraints for table `po_checked_by`
--
ALTER TABLE `po_checked_by`
  ADD CONSTRAINT `po_checked_by_ibfk_1` FOREIGN KEY (`approvedBy`) REFERENCES `supervisior` (`supervisor_ID`) ON UPDATE CASCADE,
  ADD CONSTRAINT `po_checked_by_ibfk_2` FOREIGN KEY (`orderNo`) REFERENCES `prepared_by` (`orderNo`) ON UPDATE CASCADE;

--
-- Constraints for table `prepared_by`
--
ALTER TABLE `prepared_by`
  ADD CONSTRAINT `prepared_by_ibfk_4` FOREIGN KEY (`cretedby`) REFERENCES `supervisior` (`employeeID`) ON UPDATE CASCADE,
  ADD CONSTRAINT `prepared_by_ibfk_5` FOREIGN KEY (`orderNo`) REFERENCES `ordertable` (`orderNo`) ON UPDATE CASCADE;

--
-- Constraints for table `price`
--
ALTER TABLE `price`
  ADD CONSTRAINT `price_ibfk_2` FOREIGN KEY (`p_ID`) REFERENCES `product` (`ItemID`) ON UPDATE CASCADE,
  ADD CONSTRAINT `price_ibfk_3` FOREIGN KEY (`orderNo`) REFERENCES `ordertable` (`orderNo`) ON UPDATE CASCADE;

--
-- Constraints for table `product_img`
--
ALTER TABLE `product_img`
  ADD CONSTRAINT `product_img_ibfk_1` FOREIGN KEY (`product_ID`) REFERENCES `product` (`ItemID`) ON UPDATE CASCADE;

--
-- Constraints for table `receive`
--
ALTER TABLE `receive`
  ADD CONSTRAINT `receive_ibfk_1` FOREIGN KEY (`req_no`) REFERENCES `ordertable` (`req_id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `receive_ibfk_2` FOREIGN KEY (`orderNo`) REFERENCES `ordertable` (`orderNo`) ON UPDATE CASCADE,
  ADD CONSTRAINT `receive_ibfk_3` FOREIGN KEY (`received_by`) REFERENCES `supervisior` (`employeeID`) ON UPDATE CASCADE;

--
-- Constraints for table `requisition`
--
ALTER TABLE `requisition`
  ADD CONSTRAINT `requisition_ibfk_1` FOREIGN KEY (`warehouse`) REFERENCES `warehouse_location` (`storageID`) ON UPDATE CASCADE;

--
-- Constraints for table `requisition_des`
--
ALTER TABLE `requisition_des`
  ADD CONSTRAINT `requisition_des_ibfk_1` FOREIGN KEY (`req_id`) REFERENCES `requisition` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `requisition_des_ibfk_2` FOREIGN KEY (`itemID`) REFERENCES `product` (`ItemID`) ON UPDATE CASCADE;

--
-- Constraints for table `sales_cart`
--
ALTER TABLE `sales_cart`
  ADD CONSTRAINT `sales_cart_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer_login` (`customer_id`) ON UPDATE CASCADE;

--
-- Constraints for table `sales_order`
--
ALTER TABLE `sales_order`
  ADD CONSTRAINT `sales_order_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `sales_order_description`
--
ALTER TABLE `sales_order_description`
  ADD CONSTRAINT `sales_order_description_ibfk_2` FOREIGN KEY (`orderNo`) REFERENCES `sales_order` (`orderNo`) ON UPDATE CASCADE,
  ADD CONSTRAINT `sales_order_description_ibfk_3` FOREIGN KEY (`itemID`) REFERENCES `selling_price` (`ItemID`) ON UPDATE CASCADE;

--
-- Constraints for table `selling_price`
--
ALTER TABLE `selling_price`
  ADD CONSTRAINT `selling_price_ibfk_1` FOREIGN KEY (`ItemID`) REFERENCES `product` (`ItemID`) ON UPDATE CASCADE;

--
-- Constraints for table `shipped_by`
--
ALTER TABLE `shipped_by`
  ADD CONSTRAINT `shipped_by_ibfk_2` FOREIGN KEY (`shipped_by`) REFERENCES `supervisior` (`employeeID`) ON UPDATE CASCADE,
  ADD CONSTRAINT `shipped_by_ibfk_3` FOREIGN KEY (`orderNo`) REFERENCES `so_approved` (`orderNo`) ON UPDATE CASCADE;

--
-- Constraints for table `so_approved`
--
ALTER TABLE `so_approved`
  ADD CONSTRAINT `so_approved_ibfk_1` FOREIGN KEY (`orderNo`) REFERENCES `invoice` (`orderNo`) ON UPDATE CASCADE,
  ADD CONSTRAINT `so_approved_ibfk_2` FOREIGN KEY (`approvedBy`) REFERENCES `supervisior` (`supervisor_ID`) ON UPDATE CASCADE;

--
-- Constraints for table `supervisior`
--
ALTER TABLE `supervisior`
  ADD CONSTRAINT `supervisior_ibfk_1` FOREIGN KEY (`supervisor_ID`) REFERENCES `employeeinfo` (`employeeID`) ON UPDATE CASCADE,
  ADD CONSTRAINT `supervisior_ibfk_2` FOREIGN KEY (`employeeID`) REFERENCES `employeeinfo` (`employeeID`) ON UPDATE CASCADE;

--
-- Constraints for table `supplierac`
--
ALTER TABLE `supplierac`
  ADD CONSTRAINT `supplierac_ibfk_1` FOREIGN KEY (`supplierID`) REFERENCES `supplier` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `supplier_approve`
--
ALTER TABLE `supplier_approve`
  ADD CONSTRAINT `supplier_approve_ibfk_1` FOREIGN KEY (`supplierID`) REFERENCES `supplier` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `supplier_approve_ibfk_2` FOREIGN KEY (`approvedBy`) REFERENCES `supervisior` (`supervisor_ID`) ON UPDATE CASCADE;

--
-- Constraints for table `supplier_location`
--
ALTER TABLE `supplier_location`
  ADD CONSTRAINT `supplier_location_ibfk_1` FOREIGN KEY (`supplierID`) REFERENCES `supplier` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `supplier_location_ibfk_2` FOREIGN KEY (`areaID`) REFERENCES `location` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `supplier_no`
--
ALTER TABLE `supplier_no`
  ADD CONSTRAINT `supplier_no_ibfk_1` FOREIGN KEY (`supplierID`) REFERENCES `supplier` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `supplier_order`
--
ALTER TABLE `supplier_order`
  ADD CONSTRAINT `supplier_order_ibfk_1` FOREIGN KEY (`supplierID`) REFERENCES `supplier_approve` (`supplierID`) ON UPDATE CASCADE;

--
-- Constraints for table `s_cart_item`
--
ALTER TABLE `s_cart_item`
  ADD CONSTRAINT `s_cart_item_ibfk_1` FOREIGN KEY (`cart_id`) REFERENCES `sales_cart` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `s_cart_item_ibfk_2` FOREIGN KEY (`itemID`) REFERENCES `selling_price` (`ItemID`) ON UPDATE CASCADE;

--
-- Constraints for table `warehouse_contact`
--
ALTER TABLE `warehouse_contact`
  ADD CONSTRAINT `warehouse_contact_ibfk_1` FOREIGN KEY (`warehouseID`) REFERENCES `warehouse_location` (`storageID`) ON UPDATE CASCADE;

--
-- Constraints for table `warehouse_location`
--
ALTER TABLE `warehouse_location`
  ADD CONSTRAINT `warehouse_location_ibfk_3` FOREIGN KEY (`storageID`) REFERENCES `warehousestatus` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `warehouse_location_ibfk_4` FOREIGN KEY (`locationID`) REFERENCES `location` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `warehouse_manager`
--
ALTER TABLE `warehouse_manager`
  ADD CONSTRAINT `warehouse_manager_ibfk_1` FOREIGN KEY (`warehouse`) REFERENCES `warehouse_location` (`storageID`) ON UPDATE CASCADE,
  ADD CONSTRAINT `warehouse_manager_ibfk_2` FOREIGN KEY (`employeeID`) REFERENCES `employeeinfo` (`employeeID`) ON UPDATE CASCADE;
