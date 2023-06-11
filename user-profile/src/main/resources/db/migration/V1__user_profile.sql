CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE user_profile(
    id          uuid     DEFAULT uuid_generate_v4(),
    first_name  TEXT NOT NULL,
    last_name   TEXT NOT NULL,
    email       TEXT NOT NULL,
    phone       TEXT NOT NULL,
    username    TEXT NOT NULL,
    password    TEXT NOT NULL,
    created     TIMESTAMPTZ NOT NULL,
    updated     TIMESTAMPTZ NOT NULL,
    created_by  TEXT NOT NULL,
    updated_by  TEXT NOT NULL,
    CONSTRAINT user_profile_pkey PRIMARY KEY (id),
    CONSTRAINT user_profile_email_uk UNIQUE (email),
    CONSTRAINT user_profile_phone_uk UNIQUE (phone),
    CONSTRAINT user_profile_username_uk UNIQUE (username)
)
select
    up.created,
    up.created_by,
    up.email,
    up.first_name,
    up."id",
    up.last_name,
    up."password",
    up.phone,
    up.updated,
    up.updated_by,
    up.username
from
    user_profile up;

truncate table user_profile;