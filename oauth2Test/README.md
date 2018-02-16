# 调用
1. http://localhost:8080/oauth/token
```
body:form-data

grant_type: password
client_id: client
client_secret: secret
username: user01
password: 123456
```

2. http://localhost:8080/oauth/token?grant_type=password&client_id=client&client_secret=secret&username=user01&password=123456
