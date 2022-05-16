DROP TABLE climbing_rock if exists cascade;

CREATE TABLE climbing_rock
(
    location varchar(255) NOT NULL,
    name varchar(255),
    difficulty varchar(255),
    bolting varchar(255),
    PRIMARY KEY (location)
);

INSERT INTO climbing_rock (location, name, difficulty, bolting) VALUES
                                                              ('48.68984755044936, 8.362811253038053', 'Gausbach', 'EASY', 'VERY_GOOD');