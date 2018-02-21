insert into oauth_client_details(client_id, client_secret, scope, authorized_grant_types, access_token_validity, refresh_token_validity)
--values('client', 'secret', 'app', 'password,refresh_token');
values('client', '$2a$11$F3zUBAKamiA0qJN73Ner5uDlmL4b37FWJHaE8q4PuZCIEaTmBiy8e', 'app', 'password,refresh_token', 2592001, 600);

insert into users(username, password, enabled)
--values('user01', '123456', true);
values('user01', '$2a$10$e1cI5nYlKxw4ZcjpiMLqTewITkkuQ4pqcslqcderXT3JDUwihVsqq', true);
insert into users(username, password, enabled)
--values('admin', 'admin', true);
values('admin', '$2a$10$JsE5KseKIZAz1GCiWh9JXuJn3giTsly7INTNIlCBh6e7i6IICYw2C', true);

insert into authorities(username, authority)
values('user01', 'ROLE_READ');
insert into authorities(username, authority)
values('admin', 'ROLE_ADMIN');