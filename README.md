**Using Spring Boot with Java Email Service to send email messages**

```text
Use a test account from https://mailtrap.io/
Fill all the values from SMTP Settings to your properties file.

```
```yaml
spring:
  mail:
    protocol: smtp
    host: smtp.mailtrap.io
    port: 2525
    username: d3408d0f0a3864
    password: 7868771e80653g
    properties:
      mail:
        smtp:
          auth: true
          starttls:
            enable: true
```