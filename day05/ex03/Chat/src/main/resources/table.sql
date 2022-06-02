insert into chat.users(name, password) values ('Lebron', 'nba');
insert into chat.users(name, password) values ('Ronaldo', 'football');
insert into chat.users(name, password) values ('Bubka', 'pole');
insert into chat.users(name, password) values ('Gretzky', 'hockey');
insert into chat.users(name, password) values ('Aboba', 'Aboba');

insert into chat.room(roomname, chatownerID) values ('Redroom',1);
insert into chat.room(roomname, chatownerID) values ('Blueroom',2);
insert into chat.room(roomname, chatownerID) values ('Pinkroom',2);
insert into chat.room(roomname, chatownerID) values ('Violetroom',4);
insert into chat.room(roomname, chatownerID) values ('Blackroom',5);

insert into  chat.messages(room_id, author, message, time)
values (1,2,'Hello',to_timestamp('2022     Jun','YYYY MON'));
insert into  chat.messages(room_id, author, message, time)
values (2,3,'Wazzzup',to_timestamp('2022     Jun','YYYY MON'));
insert into  chat.messages(room_id, author, message, time)
values (4,5,'Message',to_timestamp('2022     Jun','YYYY MON'));
insert into  chat.messages(room_id, author, message, time)
values (3,1,'Yo mates',to_timestamp('2022     Jun','YYYY MON'));
insert into  chat.messages(room_id, author, message, time)
values (2,5,'Aboba',to_timestamp('2022     Jun','YYYY MON'));