# distributed-systems-assignment

## This is the file to get you started.

- First run the docker image to get mySQL running:

```
sudo docker run --name mysqldb -v mysqldbvol:/home/evangelos/mysql -p 3306:3306 -e MYSQL_USER=fotis -e MYSQL_PASSWORD=mypassword -e MYSQL_DATABASE=ds_db -e MYSQL_ROOT_PASSWORD=mypassword --rm -d mysql
```

> Keep in mind, the username and the password must match the ones in the `application.properties` file.

The pre-installed users, are:

|  Username  | Password | 
|:----------:|:--------:|
|  `admin`   |  `pass`  |
| `citizen`  |  `pass`  |
|   `vet`    |  `pass`  |
| `employee` |  `pass`  |

After this you can continue on the login page: `http://localhost:8080/login`
