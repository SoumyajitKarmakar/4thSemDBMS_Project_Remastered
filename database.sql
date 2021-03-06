DROP DATABASE project;
CREATE DATABASE project;
USE project;


-- FOR BUILDER
-- ===========

-- Builder table
CREATE TABLE Builder(
    name varchar(20) NOT NULL,
    PRIMARY KEY(name),
    rating numeric
);

-- Builder email table
CREATE TABLE Builder_email(
    builder_name varchar(40) NOT NULL,
    FOREIGN KEY(builder_name) REFERENCES Builder(name),
    email varchar(40)
);

-- Builder Phone table
CREATE TABLE Builder_phone(
    builder_name varchar(40) NOT NULL,
    FOREIGN KEY(builder_name) REFERENCES Builder(name),
    phone numeric(10)
);

-- FOR PROPERTY
-- ============

CREATE TABLE Property(
    id int NOT NULL PRIMARY KEY,
    type varchar(20),
    sold tinyint(1),
    sale_rent varchar(10),
    price int,
    carpet_area numeric,
    surface_area numeric,
    status varchar(20),
    furnishing varchar(20),
    possession_date date,
    builder varchar(20) REFERENCES Builder(name),
    bhk int,
    sale_date date,
    parking_space numeric,
    address_housenum varchar(20),
    address_street varchar(20),
    address_area varchar(20),
    address_city varchar(20),
    address_district varchar(20),
    address_state varchar(20)
);


-- FOR AGENT
-- =========

-- Agent table
CREATE TABLE Agent(
    id int NOT NULL PRIMARY KEY,
    name varchar(20),
    rating numeric
);

-- Agent_phone table
CREATE TABLE Agent_phone(
    Agent_id int NOT NULL REFERENCES Agent(id),
    phone numeric(10)
);


-- Agent_email table
CREATE TABLE Agent_email(
    Agent_id int NOT NULL REFERENCES Agent(id),
    email varchar(40)
);


-- Agent_property table
CREATE TABLE Agent_property(
    Agent_id int NOT NULL REFERENCES Agent(id),
    property int REFERENCES Property(id)
);

-- FOR LOGIN TABLE :
-- ================
CREATE TABLE Login(
    id numeric NOT NULL, -- Treating id as username
    password varchar(20),
    designation varchar(20)
);

-- FOR POPULATING LOGIN TABLES :
-- ============================
INSERT INTO Login VALUES(320085632, 'darshana', 'agent'), (433129593, 'reyansh', 'agent'), (479207032, 'diksha','agent'),  
(861427340, 'kalpana','agent'), (967320855, 'charu','agent');
INSERT INTO Login VALUES (999999999, "admin", "Admin"), (111111111, "agentoffice", "AgentOffice");



-- FOR POPULATING TABLES :
-- =====================

-- ==============================================================================
-- Builder
-- ============================================================================

INSERT INTO Builder (name, rating) VALUES ('Unidark group', '8') ; 
INSERT INTO Builder (name, rating) VALUES ('Prime group', '7');
INSERT INTO Builder (name, rating) VALUES ('Diamond group', '9');


-- ==============================================================================
-- Property
-- ============================================================================
-- THIS WORKS NOW.
-- ============================================================================
INSERT INTO Property VALUES (163238051, "apartment", 0, "sale", 4565000, 450, 850, "ready",
"unfurnished", NULL, "Unidark group", 2, NULL, 1, 84, "313 S.j.road",
"Delisle Road", "Mumbai","Mumbai City" ," Maharashtra");

INSERT INTO Property VALUES (884911864, "apartment", 0, "rent", 21000, 550, 750, "ready",
"unfurnished", NULL, "Prime group", 3, NULL, NULL, 56, "Private Road",
"Ghosh Para", "DumDum","North-24 parganas" ,"West Bengal");

INSERT INTO Property VALUES (616636795 , "apartment", 0, "rent", 12000, 600, 900, "ready",
"unfurnished", NULL, "Prime group", 2, NULL, 1, 45, "13 J.road",
"isle Road", "DumDum","North-24 parganas" ,"West Bengal");

INSERT INTO Property VALUES (359368434, "bunglow", 0, "rent", 35000, 750, 1490, "ready",
"furnished", NULL, "Diamond group", 4, NULL, 2, 21 ,"Olive Street",
"Jubilee Hills", "Hyderabad","Hyderabad" ,"Telangana");

INSERT INTO Property VALUES (165428051, "apartment", 1, "sale", 5565000, 450, 850, "ready",
"furnished", '2018-07-18', "Unidark group", 2, '2018-05-07', 1, 88, "S.G.road",
"Magnolia Road", "Mumbai","Mumbai City" ," Maharashtra");

INSERT INTO Property VALUES (844441864, "apartment", 1, "rent", 24600, 560, 750, "ready",
"unfurnished", '2019-02-18', "Prime group", 3, '2019-01-01', 1, 98, "MN Road",
"Satgachi", "DumDum","North-24 parganas" ,"West Bengal");

INSERT INTO Property VALUES (116676795 , "apartment", 1, "rent", 12000, 600, 900, "ready",
"unfurnished", '2019-05-22', "Unidark group", 2, '2019-02-25', 1, 145, "J.D.road",
"Imaginary Road", "Mumbai","Mumbai City" ," Maharashtra");

INSERT INTO Property VALUES (359968434, "bunglow", 0, "rent", 56000, 1750, 2000, "ready",
"furnished", NULL, "Diamond group", 4, NULL, 2, 21 ,"Olive Street",
"Jubilee Hills", "Hyderabad","Hyderabad" ,"Telangana");

-- ==============================================================================
-- Agent
-- ============================================================================

INSERT INTO Agent (id, name, rating) VALUES ('433129593', 'Reyansh Chhabra', '7');
INSERT INTO Agent (id, name, rating) VALUES ('967320855', 'Charu Kant', '8');
INSERT INTO Agent (id, name, rating) VALUES ('320085632', 'Darshana Murty', '9');
INSERT INTO Agent (id, name, rating) VALUES ('479207032', 'Diksha Mehra', '6');
INSERT INTO Agent (id, name, rating) VALUES ('861427340', 'Kalpana Banerjee', '8');

insert into Agent_phone values(433129593, 9876486372);
insert into Agent_phone values(967320855, 9847254782), (320085632, 9836482649), (479207032, 8739264875), (861427340, 7253609846);

-- This works too.
insert into Agent_property values (433129593, 616636795),(967320855, 359368434),(320085632, 163238051),(479207032, 884911864),(861427340, 884911864);

create index city_index on property(address_city);
