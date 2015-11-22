CREATE SCHEMA `programming_tasks` ;

CREATE TABLE `programming_tasks`.`category` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `programming_tasks`.`complexity_level` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `programming_tasks`.`status` (
  `id` INT NOT NULL,
  `status` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `programming_tasks`.`tag` (
  `id` INT NOT NULL,
  `tag` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS app_user
(
    username VARCHAR (50)
        PRIMARY KEY,
    password VARCHAR (50)
        NOT NULL,
    enabled INT(2)
        NOT NULL
        DEFAULT 1,
    firstname VARCHAR(50)
    NOT NULL,
    lastname VARCHAR(50)
        NOT NULL,
    status VARCHAR(20)
    	NOT NULL,
    FOREIGN KEY (status) REFERENCES status(status)
);

CREATE TABLE IF NOT EXISTS user_role
(
    user_role_id INTEGER
        PRIMARY KEY,
    role VARCHAR(50)
        NOT NULL,
    username VARCHAR (50)
        NOT NULL,
    FOREIGN KEY (username) REFERENCES app_user(username)
);


ALTER TABLE `programming_tasks`.`app_user` 
CHANGE COLUMN `USERNAME` `username` VARCHAR(50) NOT NULL ,
CHANGE COLUMN `PASSWORD` `password` VARCHAR(50) NOT NULL ,
CHANGE COLUMN `ENABLED` `enabled` INT(2) NOT NULL DEFAULT '1' ,
CHANGE COLUMN `FIRSTNAME` `firstname` VARCHAR(50) NOT NULL ,
CHANGE COLUMN `LASTNAME` `lastname` VARCHAR(50) NOT NULL ,
ADD COLUMN `status_id` INT NOT NULL DEFAULT 1 AFTER `lastname`,
ADD INDEX `user_status_idx` (`status_id` ASC);
ALTER TABLE `programming_tasks`.`app_user` 
ADD CONSTRAINT `user_status`
  FOREIGN KEY (`status_id`)
  REFERENCES `programming_tasks`.`status` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;


CREATE TABLE `programming_tasks`.`task` (
  `id` INT NOT NULL,
  `task` LONGTEXT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `solution` LONGTEXT NOT NULL,
  `category_id` INT NOT NULL,
  `comp_level_id` INT NOT NULL,
  `user_creator` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `complexity_level_idx` (`comp_level_id` ASC),
  INDEX `cathegory_idx` (`category_id` ASC),
  INDEX `user_creator_idx` (`user_creator` ASC),
  CONSTRAINT `complexity_level`
    FOREIGN KEY (`comp_level_id`)
    REFERENCES `programming_tasks`.`complexity_level` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `cathegory`
    FOREIGN KEY (`category_id`)
    REFERENCES `programming_tasks`.`category` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `user_creator`
    FOREIGN KEY (`user_creator`)
    REFERENCES `programming_tasks`.`app_user` (`username`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `programming_tasks`.`comment` (
  `id` INT NOT NULL,
  `comment` LONGTEXT NOT NULL,
  `task_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `task_idx` (`task_id` ASC),
  CONSTRAINT `task`
    FOREIGN KEY (`task_id`)
    REFERENCES `programming_tasks`.`task` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `programming_tasks`.`task_tag` (
  `task_id` INT NOT NULL,
  `tag_id` INT NOT NULL,
  PRIMARY KEY (`task_id`, `tag_id`),
  CONSTRAINT `task`
    FOREIGN KEY (`task_id`)
    REFERENCES `programming_tasks`.`task` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `tag`
    FOREIGN KEY (`tag_id`)
    REFERENCES `programming_tasks`.`tag` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `programming_tasks`.`task_rating` (
  `id` INT NOT NULL,
  `task_id` INT NOT NULL,
  `rating` INT NOT NULL,
  `user` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `task_idx` (`task_id` ASC),
  INDEX `user_rate_idx` (`user` ASC),
  CONSTRAINT `user_rate`
    FOREIGN KEY (`user`)
    REFERENCES `programming_tasks`.`app_user` (`username`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `task`
    FOREIGN KEY (`task_id`)
    REFERENCES `programming_tasks`.`task` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
