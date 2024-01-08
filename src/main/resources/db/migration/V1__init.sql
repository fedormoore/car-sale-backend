---------------------------
-- Create the Table      --
---------------------------

--      CATEGORY
CREATE TABLE CATEGORY
(
    id         UUID         NOT NULL
                         DEFAULT gen_random_uuid() PRIMARY KEY,

    name       VARCHAR(100) NOT NULL,

    deleted    BOOLEAN   DEFAULT FALSE
);

--      TYPE
CREATE TABLE TYPE
(
    id         UUID         NOT NULL
                         DEFAULT gen_random_uuid() PRIMARY KEY,

    name       VARCHAR(100) NOT NULL,

    deleted    BOOLEAN   DEFAULT FALSE
);

--      CAR
CREATE TABLE CAR
(
    id         UUID         NOT NULL
                         DEFAULT gen_random_uuid() PRIMARY KEY,

    make       VARCHAR(100) NOT NULL,
    model      VARCHAR(100) NOT NULL,
    category_id         UUID REFERENCES CATEGORY (id),
    gos_number VARCHAR(10)  NOT NULL,
    type_id         UUID REFERENCES TYPE (id),
    year_issue int          NOT NULL,
    trailer    BOOLEAN      NOT NULL,

    created_at TIMESTAMP DEFAULT current_TIMESTAMP,
    update_at  TIMESTAMP DEFAULT current_TIMESTAMP,
    deleted    BOOLEAN   DEFAULT FALSE
);
