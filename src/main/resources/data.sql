INSERT INTO `biobanks` (`id`, `acronym`, `name`, `url`, `juristic_person`, `country`, `contact_information`, `description`)
VALUES
	(1, 'BIOBANK ACRONYM','BIOBANK NAME','BIOBANK  URL','BIOBANK  JURISTIC PERSON','BIOBANK COUNTRY','{}','BIOBANK DESCRIPTION');

INSERT INTO `document_types` (`id`, `name`)
VALUES
	(1,'Shipment'),
	(2,'Consent'),
	(3,'Clinical');

INSERT INTO `documents` (`id`, `object_id`, `file_name`, `size`, `GUID`, `type_id`, `deleted_at`, `created_at`, `updated_at`)
VALUES
	(1,1,'eeee',123002.00,'02CB717FCB2AB4C4C873FCC09A5EE19A',1,NULL,'2019-08-08 13:25:10','2019-08-08 13:25:10');

INSERT INTO `rooms` (`id`, `name`, `created_at`, `updated_at`, `deleted_at`)
VALUES
	(1,'Room 1',NULL,NULL,NULL),
	(2,'Room 2',NULL,NULL,NULL);

/*INSERT INTO `opts` (`id`, `name`, `value`)
VALUES
	(1,'biobank_director','BIOBANK DIRECTOR');
*/
INSERT INTO `freezers` (`id`, `room_id`, `name`, `parent_id`, `created_at`, `updated_at`, `deleted_at`)
VALUES
	(1,1,'Freezer 1', NULL, NULL, NULL, NULL),
	(2,1,'Freezer 2', NULL, NULL, NULL, NULL),
	(3,1,'Division 1', 1, NULL, NULL, NULL),
	(4,1,'Division 2', 1, NULL, NULL, NULL),
	(5,1,'Drawer 1', 3, NULL, NULL, NULL),
	(6,1,'Drawer 2', 3, NULL, NULL, NULL),
	(7,1,'Slot 1', 5 , NULL, NULL, NULL),
	(8,1,'Slot 2', 5, NULL, NULL, NULL),
	(9,1,'Slot 3', 5, NULL, NULL, NULL),
	(10,1,'Slot 1', 6, NULL, NULL, NULL),
	(11,1,'Slot 2',6, NULL, NULL, NULL),
	(12,1,'Slot 3',6, NULL, NULL, NULL);