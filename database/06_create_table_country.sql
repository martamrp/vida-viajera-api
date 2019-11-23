CREATE TABLE country (
	code VARCHAR(2) PRIMARY KEY,
    regionId INT NOT NULL,
	name VARCHAR(50) NOT NULL,
	lat float(2) NOT NULL,
	lng float(2) NOT NULL,
    CONSTRAINT FK_RegionId FOREIGN KEY (regionId) REFERENCES region(id)
);