#!/bin/bash
cd ../CDIO_final_docker
git pull
docker-compose up -d
mysql -u root -h 127.0.0.1 -P 3306 -p secret < tables.sql