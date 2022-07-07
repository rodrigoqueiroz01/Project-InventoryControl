-- Table: public.category

-- DROP TABLE IF EXISTS public.category;

CREATE TABLE IF NOT EXISTS public.category
(
    cod_category uuid NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT category_pkey PRIMARY KEY (cod_category)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.category
    OWNER to postgres;


-- Table: public.city

-- DROP TABLE IF EXISTS public.city;

CREATE TABLE IF NOT EXISTS public.city
(
    cod_city uuid NOT NULL,
    city_name character varying(255) COLLATE pg_catalog."default",
    uf character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT city_pkey PRIMARY KEY (cod_city)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.city
    OWNER to postgres;


-- Table: public.conveyor

-- DROP TABLE IF EXISTS public.conveyor;

CREATE TABLE IF NOT EXISTS public.conveyor
(
    cod_conveyor uuid NOT NULL,
    address character varying(255) COLLATE pg_catalog."default",
    cnpj character varying(255) COLLATE pg_catalog."default",
    contact character varying(255) COLLATE pg_catalog."default",
    conveyor character varying(255) COLLATE pg_catalog."default",
    district character varying(255) COLLATE pg_catalog."default",
    "number" integer,
    subscription character varying(255) COLLATE pg_catalog."default",
    telephone character varying(255) COLLATE pg_catalog."default",
    zip_code character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT conveyor_pkey PRIMARY KEY (cod_conveyor)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.conveyor
    OWNER to postgres;


-- Table: public.conveyor_city

-- DROP TABLE IF EXISTS public.conveyor_city;

CREATE TABLE IF NOT EXISTS public.conveyor_city
(
    cod_conveyor_fk uuid NOT NULL,
    cod_city_fk uuid NOT NULL,
    CONSTRAINT fkd25qxluoig2jke4dx7ww29fci FOREIGN KEY (cod_conveyor_fk)
        REFERENCES public.conveyor (cod_conveyor) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkpt0j2333hro43pl7ii95vskjv FOREIGN KEY (cod_city_fk)
        REFERENCES public.city (cod_city) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.conveyor_city
    OWNER to postgres;


-- Table: public.entry_item

-- DROP TABLE IF EXISTS public.entry_item;

CREATE TABLE IF NOT EXISTS public.entry_item
(
    cod_entry_item uuid NOT NULL,
    amount integer,
    batch character varying(255) COLLATE pg_catalog."default",
    value double precision,
    cod_product_fk uuid,
    cod_prohibited_fk uuid,
    CONSTRAINT entry_item_pkey PRIMARY KEY (cod_entry_item),
    CONSTRAINT fk1ignwcjybrak5colookobhwwr FOREIGN KEY (cod_prohibited_fk)
        REFERENCES public.prohibited (cod_prohibited) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkpn43clj2ystehbfbxahcy30ag FOREIGN KEY (cod_product_fk)
        REFERENCES public.product (cod_product) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.entry_item
    OWNER to postgres;


-- Table: public.exit

-- DROP TABLE IF EXISTS public.exit;

CREATE TABLE IF NOT EXISTS public.exit
(
    cod_exit uuid NOT NULL,
    shipping double precision,
    tax double precision,
    total double precision,
    store_cod uuid,
    CONSTRAINT exit_pkey PRIMARY KEY (cod_exit),
    CONSTRAINT fk6gyqw942esblb9dvphsu3sl43 FOREIGN KEY (store_cod)
        REFERENCES public.store (cod_store) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.exit
    OWNER to postgres;


-- Table: public.exit_conveyor

-- DROP TABLE IF EXISTS public.exit_conveyor;

CREATE TABLE IF NOT EXISTS public.exit_conveyor
(
    cod_exit_fk uuid NOT NULL,
    cod_conveyor_fk uuid NOT NULL,
    CONSTRAINT fkb2l9rtuwk7bgki43fr44wpmuy FOREIGN KEY (cod_conveyor_fk)
        REFERENCES public.conveyor (cod_conveyor) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkmeqegfw1g301698dodw5ebgue FOREIGN KEY (cod_exit_fk)
        REFERENCES public.exit (cod_exit) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.exit_conveyor
    OWNER to postgres;


-- Table: public.output_item

-- DROP TABLE IF EXISTS public.output_item;

CREATE TABLE IF NOT EXISTS public.output_item
(
    cod_output_item uuid NOT NULL,
    amount integer,
    batch character varying(255) COLLATE pg_catalog."default",
    value double precision,
    cod_exit_fk uuid,
    cod_product_fk uuid,
    CONSTRAINT output_item_pkey PRIMARY KEY (cod_output_item),
    CONSTRAINT fkbomcfb8h542ct67nkllko8f5r FOREIGN KEY (cod_product_fk)
        REFERENCES public.product (cod_product) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkp29lq0xq13q5vh9k1qtfbhpfc FOREIGN KEY (cod_exit_fk)
        REFERENCES public.exit (cod_exit) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.output_item
    OWNER to postgres;


-- Table: public.product

-- DROP TABLE IF EXISTS public.product;

CREATE TABLE IF NOT EXISTS public.product
(
    cod_product uuid NOT NULL,
    controlled boolean,
    description character varying(255) COLLATE pg_catalog."default",
    minimum_amount integer,
    weight double precision,
    cod_category_fk uuid,
    CONSTRAINT product_pkey PRIMARY KEY (cod_product),
    CONSTRAINT fksovhd36gbd3ta4eousv0j7op7 FOREIGN KEY (cod_category_fk)
        REFERENCES public.category (cod_category) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.product
    OWNER to postgres;


-- Table: public.product_provider

-- DROP TABLE IF EXISTS public.product_provider;

CREATE TABLE IF NOT EXISTS public.product_provider
(
    cod_product_fk uuid NOT NULL,
    cod_provider_fk uuid NOT NULL,
    CONSTRAINT fkmudtfuaduefsx931kmoa6x2rc FOREIGN KEY (cod_provider_fk)
        REFERENCES public.provider (cod_provider) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkrihtp5r1k2hjxwss6twrqkmpn FOREIGN KEY (cod_product_fk)
        REFERENCES public.product (cod_product) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.product_provider
    OWNER to postgres;


-- Table: public.prohibited

-- DROP TABLE IF EXISTS public.prohibited;

CREATE TABLE IF NOT EXISTS public.prohibited
(
    cod_prohibited uuid NOT NULL,
    entry_date date,
    invoice_number integer,
    request_date date,
    shipping double precision,
    tax double precision,
    total double precision,
    CONSTRAINT prohibited_pkey PRIMARY KEY (cod_prohibited)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.prohibited
    OWNER to postgres;


-- Table: public.prohibited_conveyor

-- DROP TABLE IF EXISTS public.prohibited_conveyor;

CREATE TABLE IF NOT EXISTS public.prohibited_conveyor
(
    cod_prohibiteed_fk uuid NOT NULL,
    cod_conveyor_fk uuid NOT NULL,
    CONSTRAINT fkbkr0bva2yqq01pejbdtln3fy5 FOREIGN KEY (cod_prohibiteed_fk)
        REFERENCES public.prohibited (cod_prohibited) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkjhl2i28eoiuox84vs1nhk4240 FOREIGN KEY (cod_conveyor_fk)
        REFERENCES public.conveyor (cod_conveyor) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.prohibited_conveyor
    OWNER to postgres;


-- Table: public.provider

-- DROP TABLE IF EXISTS public.provider;

CREATE TABLE IF NOT EXISTS public.provider
(
    cod_provider uuid NOT NULL,
    address character varying(255) COLLATE pg_catalog."default",
    cep character varying(255) COLLATE pg_catalog."default",
    cnpj character varying(255) COLLATE pg_catalog."default",
    contact character varying(255) COLLATE pg_catalog."default",
    district character varying(255) COLLATE pg_catalog."default",
    "number" integer,
    provider character varying(255) COLLATE pg_catalog."default",
    subscription character varying(255) COLLATE pg_catalog."default",
    telephone character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT provider_pkey PRIMARY KEY (cod_provider)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.provider
    OWNER to postgres;


-- Table: public.provider_city

-- DROP TABLE IF EXISTS public.provider_city;

CREATE TABLE IF NOT EXISTS public.provider_city
(
    cod_provider_fk uuid NOT NULL,
    cod_city_fk uuid NOT NULL,
    CONSTRAINT fkkfui48d47pcse6jex8g9b3dfl FOREIGN KEY (cod_provider_fk)
        REFERENCES public.provider (cod_provider) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkplj6b6gxpq5tivfy1bgs6nn9 FOREIGN KEY (cod_city_fk)
        REFERENCES public.city (cod_city) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.provider_city
    OWNER to postgres;


-- Table: public.store

-- DROP TABLE IF EXISTS public.store;

CREATE TABLE IF NOT EXISTS public.store
(
    cod_store uuid NOT NULL,
    address character varying(255) COLLATE pg_catalog."default",
    cnpj character varying(255) COLLATE pg_catalog."default",
    district character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    "number" integer,
    subscription character varying(255) COLLATE pg_catalog."default",
    telephone character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT store_pkey PRIMARY KEY (cod_store)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.store
    OWNER to postgres;


-- Table: public.store_city

-- DROP TABLE IF EXISTS public.store_city;

CREATE TABLE IF NOT EXISTS public.store_city
(
    cod_store_fk uuid NOT NULL,
    cod_city_fk uuid NOT NULL,
    CONSTRAINT fk7gn18arxd960r9t7m09w80tmv FOREIGN KEY (cod_store_fk)
        REFERENCES public.store (cod_store) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkpaorkoo2lwfcuoknug1ec84ib FOREIGN KEY (cod_city_fk)
        REFERENCES public.city (cod_city) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.store_city
    OWNER to postgres;