# dl-test-service
Driving Licence application for demonstrating microservice architecture and communication between microservices.

The application comprises of two services:
1. dl-issue-service - for applying DL, generating DL and checking application status
2. dl-test-service - for checking test slot availability, submitting test result


## Prerequisites
1. Java version 17
2. Maven version 3.8.8
3. Kafka 2.13

## Setup

1. Create tables in Postgres:
```
CREATE TABLE IF NOT EXISTS public.dl_application
(
    applicationid text COLLATE pg_catalog."default" NOT NULL,
    name text COLLATE pg_catalog."default",
    mobile text COLLATE pg_catalog."default",
    address text COLLATE pg_catalog."default",
    test_date date,
    test_slot text COLLATE pg_catalog."default",
    CONSTRAINT dl_application_pkey PRIMARY KEY (applicationid)
)

```

```
CREATE TABLE IF NOT EXISTS public.dl_issued
(
    dl_no text COLLATE pg_catalog."default" NOT NULL,
    name text COLLATE pg_catalog."default",
    mobile text COLLATE pg_catalog."default",
    address text COLLATE pg_catalog."default",
    CONSTRAINT dl_issued_pkey PRIMARY KEY (dl_no)
)

```

```
CREATE TABLE IF NOT EXISTS public.dlno_applicationid
(
    dlno text COLLATE pg_catalog."default",
    applicationid text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT dlno_applicationid_pkey PRIMARY KEY (applicationid)
)

```

2. Install and start Kafka:

```
./bin/zookeeper-server-start.sh config/zookeeper.properties

./bin/kafka-server-start.sh config/server.properties
```


3. `mvn clean install`

4. `docker build -t dl-test-service:latest .`

5. `docker run  --network host -p 9000:9000 dl-test-service:latest .`

## Run

Submit Test Result:
```
http://localhost:9000/dl/result/submit
```

