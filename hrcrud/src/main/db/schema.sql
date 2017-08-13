-- Sequence: public.deparment_id_seq

-- DROP SEQUENCE public.deparment_id_seq;

CREATE SEQUENCE public.deparment_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 5
  CACHE 1;
ALTER TABLE public.deparment_id_seq
  OWNER TO lydia;

-- Sequence: public.job_id_seq

-- DROP SEQUENCE public.job_id_seq;

CREATE SEQUENCE public.job_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE public.job_id_seq
  OWNER TO lydia;

-- Sequence: public.employee_id_seq

-- DROP SEQUENCE public.employee_id_seq;

CREATE SEQUENCE public.employee_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE public.employee_id_seq
  OWNER TO lydia;
  
  CREATE SEQUENCE public.users_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE public.users_id_seq
  OWNER TO lydia;

DROP TABLE department cascade
CREATE TABLE
    department
    (
        id INTEGER DEFAULT nextval('deparment_id_seq'::regclass) NOT NULL,
        name CHARACTER VARYING NOT NULL,
        location CHARACTER VARYING NOT NULL,
        CONSTRAINT deparment_pkey PRIMARY KEY (id)
    );
    
    DROP TABLE job cascade
    CREATE TABLE
    job
    (
        id BIGINT DEFAULT nextval('job_id_seq'::regclass) NOT NULL,
        name CHARACTER VARYING NOT NULL,
        salary_range CHARACTER VARYING NOT NULL,
        PRIMARY KEY (id)
    );
    
    DROP TABLE employee cascade
    CREATE TABLE
    employee
    (
        id BIGINT DEFAULT nextval('employee_id_seq'::regclass) NOT NULL,
        first_name CHARACTER VARYING NOT NULL,
        last_name CHARACTER VARYING NOT NULL,
        email CHARACTER VARYING NOT NULL,
        hire_date DATE NOT NULL,
        department_id INTEGER NOT NULL,
        manager_id BIGINT,
        job_id BIGINT NOT NULL,
        salary NUMERIC NOT NULL,
        PRIMARY KEY (id),
        CONSTRAINT employee_fk2 FOREIGN KEY (job_id) REFERENCES job (id),
        CONSTRAINT employee_fk1 FOREIGN KEY (department_id) REFERENCES department (id)
    );
    
    CREATE TABLE
    users
    (
        id BIGINT DEFAULT nextval('users_id_seq'::regclass) NOT NULL,
        username CHARACTER VARYING NOT NULL,
        password CHARACTER VARYING NOT NULL,
        enabled BOOLEAN NOT NULL,
        PRIMARY KEY (id),
        UNIQUE (username)
    );
    
CREATE TABLE
    authorities
    (
        username CHARACTER VARYING(255) NOT NULL,
        authority CHARACTER VARYING(255) NOT NULL,
        CONSTRAINT authorities_fk1 FOREIGN KEY (username) REFERENCES users (username)
    );