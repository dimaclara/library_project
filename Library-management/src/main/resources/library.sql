--
-- PostgreSQL database dump
--

-- Dumped from database version 17.2
-- Dumped by pg_dump version 17.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: book; Type: TABLE; Schema: public; Owner: postgres
--
 DROP DATABASE IF  EXISTS postgres;
 CREATE DATABASE  postgres;

\c library
drop table if exists book;
drop table if exists emprunt;
drop table if exists members;


CREATE TABLE public.book (
    id_book integer NOT NULL,
    title character varying(255) NOT NULL,
    author character varying(255) NOT NULL,
    categorie character varying(50) NOT NULL,
    numberexemplaire integer
);


ALTER TABLE public.book OWNER TO postgres;

--
-- Name: book_id_book_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.book_id_book_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.book_id_book_seq OWNER TO postgres;

--
-- Name: book_id_book_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.book_id_book_seq OWNED BY public.book.id_book;


--
-- Name: emprunts; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.emprunts (
    id_emprunt integer NOT NULL,
    id_book integer,
    id_member integer,
    date_emprunt date NOT NULL,
    date_retourprevue date NOT NULL,
    date_retoureffective date
);


ALTER TABLE public.emprunts OWNER TO postgres;

--
-- Name: emprunts_id_emprunt_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.emprunts_id_emprunt_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.emprunts_id_emprunt_seq OWNER TO postgres;

--
-- Name: emprunts_id_emprunt_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.emprunts_id_emprunt_seq OWNED BY public.emprunts.id_emprunt;


--
-- Name: members; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.members (
    id_member integer NOT NULL,
    name_member character varying(50) NOT NULL,
    first_namemember character varying(50) NOT NULL,
    email character varying(255),
    adhesiondate date NOT NULL
);


ALTER TABLE public.members OWNER TO postgres;

--
-- Name: members_id_member_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.members_id_member_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.members_id_member_seq OWNER TO postgres;

--
-- Name: members_id_member_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.members_id_member_seq OWNED BY public.members.id_member;


--
-- Name: book id_book; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book ALTER COLUMN id_book SET DEFAULT nextval('public.book_id_book_seq'::regclass);


--
-- Name: emprunts id_emprunt; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.emprunts ALTER COLUMN id_emprunt SET DEFAULT nextval('public.emprunts_id_emprunt_seq'::regclass);


--
-- Name: members id_member; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.members ALTER COLUMN id_member SET DEFAULT nextval('public.members_id_member_seq'::regclass);


--
-- Data for Name: book; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.book (id_book, title, author, categorie, numberexemplaire) FROM stdin;
1	Le Petit Prince	Antoine de Saint-Exupéry	Roman	3
2	1984	George Orwell	Science-Fiction	2
3	Le Seigneur des Anneaux	J.R.R. Tolkien	Fantastique	5
4	Moby Dick	Herman Melville	Roman	1
5	Les Misérables	Victor Hugo	Roman	4
6	Bimane	Severin cecile abega	Roman	5
\.


--
-- Data for Name: emprunts; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.emprunts (id_emprunt, id_book, id_member, date_emprunt, date_retourprevue, date_retoureffective) FROM stdin;
1	1	1	2024-01-15	2024-01-25	\N
2	2	2	2024-01-20	2024-01-30	\N
3	3	1	2024-01-25	2024-02-05	\N
4	2	1	2024-11-02	2024-11-12	2024-11-27
5	2	1	2024-11-02	2024-11-12	2024-11-27
6	2	1	2024-11-02	2024-11-12	2024-11-27
7	2	1	2024-11-02	2024-11-12	2024-11-27
8	2	1	2024-11-02	2024-11-12	2024-11-27
9	2	1	2024-11-02	2024-11-12	2024-11-27
10	2	1	2024-11-02	2024-11-12	2024-11-27
11	2	1	2024-11-02	2024-11-12	2024-11-27
12	2	1	2024-11-02	2024-11-12	2024-11-27
13	2	1	2024-11-02	2024-11-12	2024-11-27
14	2	1	2024-11-02	2024-11-12	2024-11-27
15	2	1	2024-11-02	2024-11-12	2024-11-27
16	2	1	2024-11-02	2024-11-12	2024-11-27
17	2	1	2024-11-02	2024-11-12	2024-11-27
18	2	1	2024-11-02	2024-11-12	2024-11-27
19	2	1	2024-11-02	2024-11-12	2024-11-27
20	2	1	2024-11-02	2024-11-12	2024-11-27
21	2	1	2024-11-02	2024-11-12	2024-11-27
22	2	1	2024-11-02	2024-11-12	2024-11-27
23	2	1	2024-11-02	2024-11-12	2024-11-27
24	2	1	2024-11-02	2024-11-12	2024-11-27
25	2	1	2024-11-02	2024-11-12	2024-11-27
26	2	1	2024-11-02	2024-11-12	2024-11-27
27	2	1	2024-11-02	2024-11-12	2024-11-27
28	2	1	2024-11-02	2024-11-12	2024-11-27
29	2	1	2024-11-02	2024-11-12	2024-11-27
30	2	1	2024-11-02	2024-11-12	2024-11-27
31	2	1	2024-11-02	2024-11-12	2024-11-27
32	2	1	2024-11-02	2024-11-12	2024-11-27
33	2	1	2024-11-02	2024-11-12	2024-11-27
34	2	1	2024-11-02	2024-11-12	2024-11-27
35	2	1	2024-11-02	2024-11-12	2024-11-27
36	2	1	2024-11-02	2024-11-12	2024-11-27
37	2	1	2024-11-02	2024-11-12	2024-11-27
38	2	1	2024-11-02	2024-11-12	2024-11-27
39	2	1	2024-11-02	2024-11-12	2024-11-27
40	2	1	2024-11-02	2024-11-12	2024-11-27
41	2	1	2024-11-02	2024-11-12	2024-11-27
42	2	1	2024-11-02	2024-11-12	2024-11-27
43	2	1	2024-11-02	2024-11-12	2024-11-27
44	2	1	2024-11-02	2024-11-12	2024-11-27
45	2	1	2024-11-02	2024-11-12	2024-11-27
46	2	1	2024-11-02	2024-11-12	2024-11-27
47	2	1	2024-11-02	2024-11-12	2024-11-27
48	2	1	2024-11-02	2024-11-12	2024-11-27
\.


--
-- Data for Name: members; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.members (id_member, name_member, first_namemember, email, adhesiondate) FROM stdin;
1	Dupont	Jean	jean.dupont@gmail.com	2024-01-01
2	Martin	Marie	marie.martin@gmail.com	2023-12-15
3	Smith	John	john.smith@yahoo.com	2024-02-10
4	Leale	Ashley	ashley@yahoo.com	2024-10-11
5	Angoni	Myrcella	myrcellajohanna@gmail.com	2024-11-23
\.


--
-- Name: book_id_book_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.book_id_book_seq', 6, true);


--
-- Name: emprunts_id_emprunt_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.emprunts_id_emprunt_seq', 48, true);


--
-- Name: members_id_member_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.members_id_member_seq', 5, true);


--
-- Name: book book_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_pkey PRIMARY KEY (id_book);


--
-- Name: emprunts emprunts_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.emprunts
    ADD CONSTRAINT emprunts_pkey PRIMARY KEY (id_emprunt);


--
-- Name: members members_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.members
    ADD CONSTRAINT members_email_key UNIQUE (email);


--
-- Name: members members_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.members
    ADD CONSTRAINT members_pkey PRIMARY KEY (id_member);


--
-- Name: emprunts emprunts_id_member_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.emprunts
    ADD CONSTRAINT emprunts_id_member_fkey FOREIGN KEY (id_member) REFERENCES public.members(id_member);


--
-- PostgreSQL database dump complete
--

