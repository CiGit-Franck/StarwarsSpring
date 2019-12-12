-- ********************** --
-- Planets related tables --
-- ********************** --

create table climates
(
    id           serial
        constraint climate_pk
            primary key,
    climate_name varchar(127)
);

create table terrains
(
    id           serial
        constraint terrain_pk
            primary key,
    terrain_name varchar(127)
);

create table planets
(
    id              serial
        constraint planet_pk
            primary key,
    planet_name     varchar(127),
    rotation_period smallint,
    orbital_period  smallint,
    diameter        int,
    gravity         numeric(4, 2),
    surface_water   smallint,
    population      bigint
);

create table planet_terrains
(
    planet_idx  int
        constraint planet_fk
            references planets
            on delete cascade,
    terrain_idx int
        constraint terrain_fk
            references terrains
            on delete cascade,
    primary key (planet_idx, terrain_idx)
);

create table planet_climates
(
    planet_idx  int
        constraint planet_fk
            references planets
            on delete cascade,
    climate_idx int
        constraint climate_fk
            references climates
            on delete cascade,
    primary key (planet_idx, climate_idx)
);



-- ********************** --
-- Species related tables --
-- ********************** --

create table classifications
(
    id                  serial
        constraint classification_pk
            primary key,
    classification_name varchar(127)
);

create table designations
(
    id               serial
        constraint designation_pk
            primary key,
    designation_name varchar(127)
);

create table languages
(
    id            serial
        constraint language_pk
            primary key,
    language_name varchar(127)
);

create table colors
(
    id         serial
        constraint color_pk
            primary key,
    color_name varchar(127)
);

create table species
(
    id                 serial
        constraint species_pk
            primary key,
    species_name       varchar(127),
    average_height     smallint,
    average_lifespan   smallint,
    classification_idx int
        constraint classification_fk
            references classifications,
    designation_idx    int
        constraint designation_fk
            references designations,
    language_idx       int
        constraint language_fk
            references languages,
    home_world_idx     int
        constraint home_world_fk
            references planets
);

create type color_type as enum ('skin', 'eye', 'hair');

create table species_colors
(
    species_idx int
        constraint species_fk
            references species
            on delete cascade,
    color_idx   int
        constraint color_fk
            references colors
            on delete cascade,
    color_type  color_type,
    primary key (species_idx, color_idx, color_type)
);



-- *********************************** --
-- Vehicles & Starships related tables --
-- *********************************** --

create table vehicle_classes
(
    id                 serial
        constraint vehicle_class_pk
            primary key,
    vehicle_class_name varchar(127)
);

create table manufacturers
(
    id                serial
        constraint manufacturer_pk
            primary key,
    manufacturer_name varchar(127)
);

create table vehicles
(
    id                     serial
        constraint vehicle_pk
            primary key,
    vehicle_name           varchar(127),
    vehicle_model          varchar(127),
    cost_in_credits        bigint,
    length                 numeric(9, 2),
    max_atmosphering_speed smallint,
    crew                   int,
    passengers             int,
    cargo_capacity         bigint,
    consumables            varchar(127),

    vehicle_class          int
        constraint vehicle_class_fk
            references vehicle_classes
);

create table vehicle_manufacturers
(
    vehicle_idx      int
        constraint vehicle_fk
            references vehicles
            on delete cascade,
    manufacturer_idx int
        constraint manufacturer_fk
            references manufacturers
            on delete cascade,
    primary key (vehicle_idx, manufacturer_idx)
);

create table starships
(
    vehicle_idx       int
        constraint vehicle_fk
            references vehicles
            on delete cascade,
    hyperdrive_rating numeric(2, 1),
    mglt              smallint,
    primary key (vehicle_idx)
);



-- ************************* --
-- Characters related tables --
-- ************************* --

create table genders
(
    id          serial
        constraint gender_pk
            primary key,
    gender_name varchar(127)
);

create table characters
(
    id            serial
        constraint character_pk
            primary key,
    full_name     varchar(255),
    height        numeric(4, 1),
    mass          numeric(5, 1),
    birthday      varchar(255),
    gender_idx    int
        constraint gender_fk
            references genders,
    homeworld_idx int
        constraint homeworld_fk
            references planets,
    species_idx   int
        constraint species_fk
            references species
);

create table characters_colors
(
    character_idx int
        constraint character_fk
            references characters
            on delete cascade,
    color_idx     int
        constraint color_fk
            references colors
            on delete cascade,
    color_type    color_type,
    primary key (character_idx, color_idx, color_type)
);
