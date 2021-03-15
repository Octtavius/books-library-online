-- author create
CREATE SEQUENCE authorseq
INCREMENT 1
START 100;

CREATE TABLE author (
	id bigint primary key DEFAULT NEXTVAL('authorseq'),
	first_name VARCHAR (50) NOT NULL,
	last_name VARCHAR (50) NOT NULL,
	email  VARCHAR (50) NOT NULL
);

-- END author create

CREATE SEQUENCE bookseq
INCREMENT 1
START 100;

CREATE TABLE book (
	id bigint primary key DEFAULT NEXTVAL('bookseq'),
	title VARCHAR (64) NOT NULL,
	short_description VARCHAR (512) NOT NULL,
	"language" VARCHAR (32) NOT NULL,
	genre VARCHAR (32) NOT NULL,
	format VARCHAR (32) NOT NULL,
	published_date VARCHAR (64) NOT NULL,
	uploaded_date VARCHAR (64) NOT NULL,
	document_url VARCHAR (512) NOT NULL,
	uuid VARCHAR (512) NOT NULL,
	author_id BIGINT NOT NULL,
	unique(uuid),
	unique(title, author_id)
);