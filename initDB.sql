CREATE DATABASE lib_collections
DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;

USE lib_collections;

CREATE TABLE category (
	id INTEGER NOT NULL AUTO_INCREMENT,
	name VARCHAR(60) NOT NULL,
	remark VARCHAR(60) NOT NULL,
	imported TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
	updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP
	ON UPDATE CURRENT_TIMESTAMP NOT NULL,
	PRIMARY KEY(id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;

CREATE TABLE book (
	id INTEGER NOT NULL AUTO_INCREMENT,
	isbn VARCHAR(15) UNIQUE DEFAULT NULL,
	title VARCHAR(60) NOT NULL,
	author VARCHAR(60) NOT NULL,
	publisher VARCHAR(60) NOT NULL,
	pubdate VARCHAR(15) NOT NULL,
	category INTEGER NOT NULL,
	cover VARCHAR(100),
	imported TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
	updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP
	ON UPDATE CURRENT_TIMESTAMP NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY (category) REFERENCES category(id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;

CREATE TABLE tag (
	id INTEGER NOT NULL AUTO_INCREMENT,
	name VARCHAR(60) NOT NULL,
	remark VARCHAR(60) NOT NULL,
	imported TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
	updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP
	ON UPDATE CURRENT_TIMESTAMP NOT NULL,
	PRIMARY KEY(id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;

CREATE TABLE book_tag (
	id INTEGER NOT NULL AUTO_INCREMENT,
	book_id INTEGER NOT NULL,
	tag_id INTEGER NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY (book_id) REFERENCES book(id),
	FOREIGN KEY (tag_id) REFERENCES tag(id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;
