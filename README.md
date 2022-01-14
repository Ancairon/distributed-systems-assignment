# distributed-systems-assignment

## This is the file to get you started.

- First run the docker image to get mySQL running:

```
sudo docker run --name mysqldb -v mysqldbvol:/home/evangelos/mysql -p 3306:3306 -e MYSQL_USER=fotis -e MYSQL_PASSWORD=mypassword -e MYSQL_DATABASE=ds_db -e MYSQL_ROOT_PASSWORD=mypassword --rm -d mysql
```

> Keep in mind, the username and the password must match the ones in the `application.properties` file.

- Then you can connect on the database by running:

```
mysql -h 127.0.0.1 -u fotis -p
```

and typing the password you selected.

- After that, you can add the first user (admin is recommended to be able to add more users from the UI) by:

Then run the application to create the tables and then in the mysql terminal, run:

```
use ds_db;

insert into user values ('1',1,'pass','ROLE_ADMIN','admin');
```

After this you can continue on the login page: `http://localhost:8080/login`
