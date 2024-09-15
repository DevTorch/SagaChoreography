-- liquibase formatted sql

-- changeset Torchez:1726346057581-1
CREATE TABLE book
(
    id       UUID NOT NULL,
    title    VARCHAR(255),
    author   VARCHAR(255),
    isbn     VARCHAR(255),
    cost     DECIMAL,
    quantity INTEGER,
    CONSTRAINT pk_book PRIMARY KEY (id)
);

-- changeset Torchez:1726346057581-2
CREATE TABLE mobile_device
(
    id        UUID NOT NULL,
    brand     VARCHAR(255),
    model     VARCHAR(255),
    mobile_os VARCHAR(255),
    cost      DECIMAL,
    quantity  INTEGER,
    CONSTRAINT pk_mobiledevice PRIMARY KEY (id)
);

