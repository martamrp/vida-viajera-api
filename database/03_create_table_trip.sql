CREATE TABLE trip (
	id INT PRIMARY KEY AUTO_INCREMENT,
	userId INT NOT NULL,
	reasonId INT NOT NULL,
	origin VARCHAR(50) NOT NULL,
	destination VARCHAR(50) NOT NULL,
	startDate DATE NOT NULL,
	endDate DATE NOT NULL,
    FOREIGN KEY (userId) REFERENCES user(id),
    FOREIGN KEY (reasonId) REFERENCES reason(id)
);