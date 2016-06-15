# jim-captcha

- This project will generate captcha image in src/main/resources/static/app/dist/img, you can config the path in application.properties file.
- If you run it, http://YOUR-DOMAIN:PORT/captcha will generate challenge code & a new PNG file
- And you can validate it.
- demo png:
![](src/main/resources/static/app/dist/img/7726ceb5-d751-4d81-a0bb-d87efdb50f1f.png)



# install

    mvn clean install

# run

    jar -jar captcha-0.0.1-SNAPSHOT.jar