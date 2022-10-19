<h1 align="center"> Cache aggregation service </h1> <br>

<p align="center">
  This service will serve to aggregate information, for quick access to this information for the FE part of the application (if any).
When starting the service, service send request to receive information about the list of sell point and operators.
The received information will be cached using Redis.
Service have end-point that returns a list of sell points along with a list of operators working for them.
</p>


## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Requirements](#requirements)
- [Quick Start](#quick-start)
- [API](#requirements)
- [Acknowledgements](#acknowledgements)




## Introduction

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/e91606af4a364076a7058c5ea1c006a8)](https://www.codacy.com/app/joneubank/microservice-template-java?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=overture-stack/microservice-template-java&amp;utm_campaign=Badge_Grade)
[![CircleCI](https://circleci.com/gh/overture-stack/microservice-template-java/tree/master.svg?style=shield)](https://circleci.com/gh/overture-stack/microservice-template-java/tree/master)

## Features
This project use Redis for data storing and WebSocket for data aggregation

## Requirements
The application can be run locally or in a docker container, the requirements for each setup are listed below.

### Local
* [Java 17 SDK](https://www.oracle.com/java/technologies/downloads/#java17)
* [Maven](https://maven.apache.org/download.cgi)
* [Redis](https://github.com/microsoftarchive/redis/releases/tag/win-3.2.100)


### Docker
* [Docker](https://www.docker.com/get-docker)


## Quick Start

### Run Local
```bash
$ mvn spring-boot:run
```

Application will run by default on port `9088`

Configure the port by changing `server.port` in __application.properties__


### Run Docker

First build the image:
```bash
$ docker-compose build
```

When ready, run it:
```bash
$ docker-compose up
```

## API
To get full information about Sell Points and Operators, which work on them
{host}:{port}/sellPointsFullInfo

## Acknowledgements
Thanks a lot for Yevhenii Khudolii for interesting trainig project and support =)
