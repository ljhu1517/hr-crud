insert into department values (nextval('deparment_id_seq'),'HQ','Toronto');
insert into department values (nextval('deparment_id_seq'),'Tech','Toronto');
insert into department values (nextval('deparment_id_seq'),'Accounting','Chicago');
insert into department values (nextval('deparment_id_seq'),'Marketing','Chicago');
insert into department values (nextval('deparment_id_seq'),'Finance','New York');
commit;

insert into job values (nextval('job_id_seq'),'Accountant','50,000-100,000');
insert into job values (nextval('job_id_seq'),'CEO','500,000-1,000,000');
insert into job values (nextval('job_id_seq'),'Sales Manager','50,000-75,000');
insert into job values (nextval('job_id_seq'),'Clerk','50,000-75,000');
commit;

INSERT INTO users (id, username, password, enabled) VALUES (nextval('users_id_seq'), 'user', '$2a$06$yjCUFgTGH3QEVaqbPfKkzOAq3j2wEkYB88QXlzUp4f1VGaYS9rb6m', true);
INSERT INTO users (id, username, password, enabled) VALUES (nextval('users_id_seq'), 'admin', '$2a$06$yjCUFgTGH3QEVaqbPfKkzOAq3j2wEkYB88QXlzUp4f1VGaYS9rb6m', true);
INSERT INTO users (id, username, password, enabled) VALUES (nextval('users_id_seq'), 'dba', '$2a$06$yjCUFgTGH3QEVaqbPfKkzOAq3j2wEkYB88QXlzUp4f1VGaYS9rb6m', true);

commit;

INSERT INTO authorities (id, username, authority) VALUES (nextval('authorities_id_seq'), 'user', 'ROLE_USER');
INSERT INTO authorities (id, username, authority) VALUES (nextval('authorities_id_seq'), 'admin', 'ROLE_ADMIN');
INSERT INTO authorities (id, username, authority) VALUES (nextval('authorities_id_seq'), 'dba', 'ROLE_DBA');
INSERT INTO authorities (id, username, authority) VALUES (nextval('authorities_id_seq'), 'admin', 'ROLE_USER');
INSERT INTO authorities (id, username, authority) VALUES (nextval('authorities_id_seq'), 'dba', 'ROLE_USER');
commit;