create schema if not exists chat;

drop table if exists chat.users, chat.room, chat.messages;

create table if not exists chat.users(

                                         id bigserial primary key,
                                         name varchar (50) unique not null ,
    password    varchar(50)
    );

create table if not exists chat.room(
                                        id bigserial primary key ,
                                        roomname varchar(50) unique not null ,
                                        chatownerID bigserial not null references chat.users(id)
    );

create table if not exists chat.messages(
                                            id bigserial primary key ,
                                            room_id bigserial not null references chat.room(id),
                                            author bigserial not null references chat.users(id),
                                            message text not null,
                                            time timestamp
    );
