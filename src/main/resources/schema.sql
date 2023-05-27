CREATE TABLE USER
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
--     first_name    VARCHAR(64),
--     last_name     VARCHAR(64),
    full_name     VARCHAR(64),
    email_address VARCHAR(64),
    address       VARCHAR(64),
    city          VARCHAR(64),
    country       VARCHAR(64),
    phone_number  VARCHAR(24)
);

CREATE TABLE REQUEST
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(100),
    full_name   VARCHAR(64),
    description VARCHAR(100),
    email_address VARCHAR(64),
    phone_number  VARCHAR(24),
    status      VARCHAR(64),
    type        VARCHAR(64),
    start_date  TIMESTAMP,
    end_date    TIMESTAMP,
    grade       INTEGER,
    id_user     BIGINT REFERENCES USER (id)
);