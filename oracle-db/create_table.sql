DROP TABLE attendees;
CREATE TABLE attendees
(
    attendee_id  INT PRIMARY KEY,
    first_name   VARCHAR(30) NOT NULL,
    last_name    VARCHAR(30) NOT NULL,
    title        VARCHAR(40) NULL,
    company      VARCHAR(50) NULL,
    email        VARCHAR(80) NOT NULL,
    phone_number VARCHAR(20) NULL
);

DROP TABLE ticket_types;
CREATE TABLE ticket_types
(
    ticket_type_code  VARCHAR(1) PRIMARY KEY,
    ticket_type_name  VARCHAR(30)  NOT NULL,
    description       VARCHAR(100) NOT NULL,
    includes_workshop INT          NOT NULL
);

DROP TABLE pricing_categories;
CREATE TABLE pricing_categories
(
    pricing_category_code VARCHAR(1) PRIMARY KEY,
    pricing_category_name VARCHAR(20) NOT NULL,
    pricing_start_date    DATE        NOT NULL,
    pricing_end_date      DATE        NOT NULL
);

DROP TABLE ticket_prices;
CREATE TABLE ticket_prices
(
    ticket_price_id       INTEGER PRIMARY KEY,
    ticket_type_code      VARCHAR(1)    NOT NULL,
    pricing_category_code VARCHAR(1)    NOT NULL,
    base_price            NUMERIC(8, 2) NOT NULL
);

DROP TABLE discount_codes;
CREATE TABLE discount_codes
(
    discount_code_id INT PRIMARY KEY,
    discount_code    VARCHAR(20)   NOT NULL,
    discount_name    VARCHAR(30)   NOT NULL,
    discount_type    VARCHAR(1)    NOT NULL,
    discount_amount  NUMERIC(8, 2) NOT NULL
);

DROP TABLE attendee_tickets;
CREATE TABLE attendee_tickets
(
    attendee_ticket_id INT PRIMARY KEY,
    attendee_id        INT           NOT NULL,
    ticket_price_id    INT           NOT NULL,
    discount_code_id   INT           NULL,
    net_price          NUMERIC(8, 2) NOT NULL
);

DROP TABLE time_slots;
CREATE TABLE time_slots
(
    time_slot_id         INT PRIMARY KEY,
    time_slot_date       DATE            NOT NULL,
    start_time           TIMESTAMP		 NOT NULL,
    end_time             TIMESTAMP		 NOT NULL,
    is_keynote_time_slot INT default 0   NOT NULL
);

DROP TABLE sessions;
CREATE TABLE sessions
(
    session_id          INTEGER PRIMARY KEY,
    session_name        VARCHAR(200)  NOT NULL,
    session_description VARCHAR(1024) NOT NULL,
    session_length      INTEGER           NOT NULL
);

DROP TABLE session_schedule;
CREATE TABLE session_schedule
(
    schedule_id  INT PRIMARY KEY,
    time_slot_id INT         NOT NULL,
    session_id   INT         NOT NULL,
    room         VARCHAR(30) NOT NULL
);

DROP TABLE tags;
CREATE TABLE tags
(
    tag_id      INTEGER PRIMARY KEY,
    description VARCHAR(30) NOT NULL
);


DROP TABLE session_tags;
CREATE TABLE session_tags
(
    session_id INT NOT NULL,
    tag_id     INT NOT NULL
);

DROP TABLE speakers;
CREATE TABLE speakers
(
    speaker_id    INT PRIMARY KEY,
    first_name    VARCHAR(30)   NOT NULL,
    last_name     VARCHAR(30)   NOT NULL,
    title         VARCHAR(40)   NOT NULL,
    company       VARCHAR(50)   NOT NULL,
    speaker_bio   VARCHAR(2000) NOT NULL,
    speaker_photo BLOB   		NULL
);

DROP TABLE session_speakers;
CREATE TABLE session_speakers
(
    session_id INT NOT NULL,
    speaker_id INT NOT NULL
);

DROP TABLE workshops;
CREATE TABLE workshops
(
    workshop_id   INT PRIMARY KEY,
    workshop_name VARCHAR(60)   NOT NULL,
    description   VARCHAR(1024) DEFAULT NULL,
    requirements  VARCHAR(1024) DEFAULT NULL,
    room          VARCHAR(30)   NOT NULL,
    capacity      INT           NOT NULL
);

DROP TABLE workshop_speakers;
CREATE TABLE workshop_speakers
(
    workshop_id INT NOT NULL,
    speaker_id  INT NOT NULL
);

DROP TABLE workshop_registrations;
CREATE TABLE workshop_registrations
(
    workshop_id        INT NOT NULL,
    attendee_ticket_id INT NOT NULL
);
