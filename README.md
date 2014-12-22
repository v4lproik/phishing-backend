phishing-backend
================

This project aims to collect information from a user when is going through the process of authentication.


Why creating this project
---------
It was needed to quickly up and run a back-end so we can collect user information from a front-end.
This application is a rest service so you just have to send your JSON information to the controllers.


Usage
-----

   Change the general properties located at : src/main/resources/default.properties

Installation
-----------

    cd phishing-backend
    mvn compile war:war


API (Not admin controller)
---------
The url to send the data from the auth form is /user/auth (try yourself curl -H "Content-Type: application/json" -H "Accept: application/json" -H "Cookie: PHPSSID=authcookie" -d '{"name":"xyz","password":"xyz"}' http://localhost:8080/user/auth -vv)
Your login input has to be named "login" eg. <input login="login" ... />
Your password input has to be named "password" eg. <input login="password" ... />


Contributing
------------

See [Contributing](CONTRIBUTING.md)
