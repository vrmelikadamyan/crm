insert into user (id, username, full_name, email_address, address, city, country, phone_number) values (1, 'test1', 'Белов Алексей Иванович', 'bvelez0@google.pl', '4747 Butternut Crossing', 'Pestovo', 'Russia', '+7 (584) 984-8612');
insert into user (id, username, full_name, email_address, address, city, country, phone_number) values (2, 'test2', 'Иванов Иван Иванович', 'mhaydn1@multiply.com', '713 Maple Wood Circle', 'Carmen', 'Philippines', '+63 (477) 280-2056');
insert into user (id, username, full_name, email_address, address, city, country, phone_number) values (3, 'test3', 'Рыбкин Алексей Петрович', 'mpawelek2@state.gov', '034 Mariners Cove Point', 'Itaberaí', 'Brazil', '+55 (445) 165-2033');
insert into user (id, username, full_name, email_address, address, city, country, phone_number) values (4, 'test4', 'Мамкин Денис Сергеевич', 'mborit3@google.it', '78 Buell Court', 'Charxin', 'Uzbekistan', '+998 (642) 742-1954');
insert into user (id, username, full_name, email_address, address, city, country, phone_number) values (5, 'test5', 'Чуплыгин Александр Викторович', 'prahill4@soundcloud.com', '43 Lawn Street', 'Zárate', 'Argentina', '+54 (368) 282-2644');
insert into user (id, username, full_name, email_address, address, city, country, phone_number) values (6, 'test6', 'Крутой Игорь Игоревич', 'sogborne5@europa.eu', '6588 Mallory Center', 'Saint-Pierre-Montlimart', 'France', '+33 (111) 706-0255');
insert into user (id, username, full_name, email_address, address, city, country, phone_number) values (7, 'test7', 'Матвеев Денис Петрович', 'gverrillo6@linkedin.com', '7171 Waywood Court', 'Oeleu', 'Indonesia', '+62 (857) 330-9040');
insert into user (id, username, full_name, email_address, address, city, country, phone_number) values (8, 'user', 'Алексеев Геннадий Петрович', 'gverrillo6@linkedin.com', '7171 Waywood Court', 'Oeleu', 'Indonesia', '+62 (857) 330-9040');

insert into request(name, full_name, description, email_address, phone_number, status, type, start_date, end_date, grade, id_user) values ('Заявка 1', 'Белов Алексей Иванович', 'Описание...', 'bvelez0@google.pl', '+7 (584) 984-8612', 'Выполнена', 'Банк', '2023-05-04 10:00:00', '2010-01-01 10:00:00', 5, 1);
insert into request(name, full_name, description, email_address, phone_number, status, type, start_date, end_date, grade, id_user) values ('Заявка 2', 'Иванов Иван Иванович', 'Описание...', 'mhaydn1@multiply.com', '+63 (477) 280-2056', 'В обработке', 'Оператор', '2022-04-05 10:00:00', '2010-01-01 10:00:00', 5, 2);
insert into request(name, full_name, description, email_address, phone_number, status, type, start_date, end_date, grade, id_user) values ('Заявка 3', 'Рыбкин Алексей Петрович', 'Описание...', 'mpawelek2@state.gov', '+55 (445) 165-2033', 'Зарегистрирована', 'Оператор', '2023-05-05 10:00:00', '2010-01-01 10:00:00', 5, 3);
insert into request(name, full_name, description, email_address, phone_number, status, type, start_date, end_date, grade, id_user) values ('Заявка 4', 'Михеев Денис Сергеевич', 'Описание...', 'mborit3@google.it', '+998 (642) 742-1954', 'Зарегистрирована', 'Банк', '2023-01-01 10:00:00', '2010-01-01 10:00:00', 5, 4);
insert into request(name, full_name, description, email_address, phone_number, status, type, start_date, end_date, grade, id_user) values ('Заявка 5', 'Чуплыгин Александр Викторович', 'Описание...', 'prahill4@soundcloud.com', '+54 (368) 282-2644', 'В обработке', 'Банк', '2023-02-23 10:00:00', '2010-01-01 10:00:00', 5, 5);
