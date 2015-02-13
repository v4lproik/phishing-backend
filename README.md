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

    cd phishing-backend v 
    mvn compile war:war


API (User controller)
---------

The url to send the data from the auth form is /user/auth.
Try yourself with : 

    curl -H "Content-Type: application/json" -H "Cookie: PHPSSID=authcookie" -d '{"login":"xyz","password":"xyz"}' http://localhost:8080/user/auth -vv)

The form needs to have at least these input fields with these names:

    <input login="login" ... />
    <input login="password" ... />


Contributing
------------

See [Contributing](CONTRIBUTING.md)


Build Status
------------
[![Build Status](https://travis-ci.org/v4lproik/phishing-backend.svg?branch=master)](https://travis-ci.org/v4lproik/phishing-backend)
