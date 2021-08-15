create table films
(
    id serial
        constraint films_pk
            primary key,
    name varchar not null,
    duration integer not null
);

alter table films owner to postgres;

create table seance
(
    id serial
        constraint seance_pk
            primary key,
    film_id integer not null
        constraint seance_film_fk
            references films
            on update cascade on delete cascade,
    seance_start_time timestamp,
    price double precision
);

alter table seance owner to postgres;

create table ticket
(
    id serial
        constraint ticket_pk
            primary key,
    seance_id integer not null
        constraint ticket_seance_fk
            references seance
            on update cascade on delete cascade
);

alter table ticket owner to postgres;

INSERT INTO public.films (id, name, duration) VALUES (1, 'film1', 60);
INSERT INTO public.films (id, name, duration) VALUES (2, 'film2', 60);
INSERT INTO public.films (id, name, duration) VALUES (3, 'film3', 90);
INSERT INTO public.films (id, name, duration) VALUES (4, 'film4', 90);
INSERT INTO public.films (id, name, duration) VALUES (5, 'film5', 120);
INSERT INTO public.films (id, name, duration) VALUES (6, 'film6', 120);

INSERT INTO public.seance (id, film_id, seance_start_time, price) VALUES (1, 1, '2021-01-01 12:00:25.000000', 3);
INSERT INTO public.seance (id, film_id, seance_start_time, price) VALUES (2, 1, '2021-01-01 19:00:00.000000', 6);
INSERT INTO public.seance (id, film_id, seance_start_time, price) VALUES (3, 2, '2021-01-01 13:00:00.000000', 4);
INSERT INTO public.seance (id, film_id, seance_start_time, price) VALUES (4, 3, '2021-01-01 14:00:00.000000', 3);
INSERT INTO public.seance (id, film_id, seance_start_time, price) VALUES (5, 4, '2021-01-01 20:00:00.000000', 7);

INSERT INTO public.ticket (id, seance_id) VALUES (1, 1);
INSERT INTO public.ticket (id, seance_id) VALUES (2, 3);
INSERT INTO public.ticket (id, seance_id) VALUES (3, 4);
INSERT INTO public.ticket (id, seance_id) VALUES (4, 1);
INSERT INTO public.ticket (id, seance_id) VALUES (5, 1);
INSERT INTO public.ticket (id, seance_id) VALUES (6, 1);
INSERT INTO public.ticket (id, seance_id) VALUES (7, 3);
INSERT INTO public.ticket (id, seance_id) VALUES (8, 4);
INSERT INTO public.ticket (id, seance_id) VALUES (9, 5);

-- число посетителей и кассовые сборы, сгруппированные по времени начала фильма
select f.name, s.seance_start_time, count(t.*) as "count", sum(s.price) as "sum"
from ticket as t
         left join seance s on s.id = t.seance_id
         left join films f on f.id = s.film_id
group by t.seance_id, f.name, s.seance_start_time
order by sum desc ;