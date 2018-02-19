##### Authorization Server
认证服务器，进行认证和授权
1. AuthorizationEndpoint:进行授权的服务，Default URL: /oauth/authorize

2. TokenEndpoint：获取token的服务，Default URL: /oauth/token

3. 应用方法
> @EnableAuthorizationServer
> spring应用自动生成以下Endpoint:
> /oauth/authorize：验证
> /oauth/token：获取token
> /oauth/confirm_access：用户授权
> /oauth/error：认证失败
> /oauth/check_token：资源服务器用来校验token
> /oauth/token_key：如果jwt模式则可以用此来从认证服务器获取公钥

4. 包含三种配置

1). ClientDetailsServiceConfigurer

client客户端的信息配置，client信息包括：clientId、secret、scope、authorizedGrantTypes、authorities
authorizedGrantTypes
Authorization Code：用验证获取code，再用code去获取token（用的最多的方式，也是最安全的方式）
Implicit: 隐式授权模式
Client Credentials (用來取得 App Access Token)
Resource Owner Password Credentials
具体实现：
in-memory
JdbcClientDetailsService
jwt
client的信息的读取：在ClientDetailsServiceConfigurer类里面进行配置，可以有in-memory、jdbc等多种读取方式。

jdbc需要调用JdbcClientDetailsService类，此类需要传入相应的DataSource.

2). AuthorizationServerSecurityConfigurer

声明安全约束，哪些允许访问，哪些不允许访问

3). AuthorizationServerEndpointsConfigurer

声明授权和token的端点以及token的服务的一些配置信息，比如采用什么存储方式、token的有效期等



##### Resource Server
资源服务器，保护受保护的资源
1. OAuth2AuthenticationProcessingFilter：给带有访问令牌的请求加载认证
2. 应用方法
（1）tokenServices：ResourceServerTokenServices的实例，声明了token的服务

（2）resourceId：资源Id，由auth Server验证。

（3）其它一些扩展点，比如可以从请求中提取token的tokenExtractor

（4）一些自定义的资源保护配置，通过HttpSecurity来设置


如何访问资源服务器中的API？

如果资源服务器和授权服务器在同一个应用程序中，并且您使用DefaultTokenServices，那么您不必太考虑这一点，因为它实现所有必要的接口，因此它是自动一致的。如果您的资源服务器是一个单独的应用程序，那么您必须确保您匹配授权服务器的功能，并提供知道如何正确解码令牌的ResourceServerTokenServices。与授权服务器一样，您可以经常使用DefaultTokenServices，并且选项大多通过TokenStore（后端存储或本地编码）表示。

（1）在校验request中的token时，使用RemoteTokenServices去调用AuthServer中的/auth/check_token。

（2）共享数据库，使用Jdbc存储和校验token，避免再去访问AuthServer。

（3）使用JWT签名的方式，资源服务器自己直接进行校验，不借助任何中间媒介。


##### Oauth 2.0 Provider
包括Authorization Server和Resource Server



##### 管理token
AuthorizationServerTokenServices接口:声明必要的关于token的操作
DefaultTokenServices是其默认实现，他使用了默认的InMemoryTokenStore，不会持久化token
token存储方式共有三种分别是：

（1）InMemoryTokenStore：存放内存中，不会持久化

（2）JdbcTokenStore：存放数据库中

（3）Jwt: json web token,详见 http://blog.leapoahead.com/2015/09/06/understanding-jwt/

##### 授权类型

可以通过AuthorizationServerEndpointsConfigurer来进行配置，默认情况下，支持除了密码外的所有授权类型。相关授权类型的一些类：

（1）authenticationManager：直接注入一个AuthenticationManager，自动开启密码授权类型

（2）userDetailsService：如果注入UserDetailsService，那么将会启动刷新token授权类型，会判断用户是否还是存活的

（3）authorizationCodeServices：AuthorizationCodeServices的实例，auth code 授权类型的服务

（4）implicitGrantService：imlpicit grant

（5）tokenGranter：

##### endpoint的URL的配置

（1）AuthorizationServerEndpointsConfigurer的pathMapping()方法，有两个参数，第一个是默认的URL路径，第二个是自定义的路径

（2）WebSecurityConfigurer的实例，可以配置哪些路径不需要保护，哪些需要保护。默认全都保护。

##### 自定义UI

（1）有时候，我们可能需要自定义的登录页面和认证页面。登陆页面的话，只需要创建一个login为前缀名的网页即可，在代码里，设置为允许访问，这样，系统会自动执行你的登陆页。此登陆页的action要注意一下，必须是跳转到认证的地址。

（2）另外一个是授权页，让你勾选选项的页面。此页面可以参考源码里的实现，自己生成一个controller的类，再创建一个对应的web页面即可实现自定义的功能。



参考:http://blog.csdn.net/j754379117/article/details/70175198


执行postman
获取token
```
curl -X POST localhost:8080/oauth/token?grant_type=password&client_id=client&client_secret&username=user01&password=123456
response:
{
  "access_token": "0e864b49-659d-40c5-88cc-c4a65968071f",
  "token_type": "bearer",
  "refresh_token": "ae451665-e8e8-4963-9dff-7f2d83820588",
  "expires_in": 41823,
  "scope": "app"
}
```

刷新token
```
curl -X POST localhost:8080/oauth/token&grant_type=refresh_token&client_id=client&client_secret&refresh_token=ae451665-e8e8-4963-9dff-7f2d83820588
{
  "access_token": "67581a75-1faf-49c5-88e6-3fe370778c69",
  "token_type": "bearer",
  "refresh_token": "ae451665-e8e8-4963-9dff-7f2d83820588",
  "expires_in": 43199,
  "scope": "app"
}
```

验证 token
```
curl -X POST -u client:secret localhost:8080/oauth/check_token?token=a9c56f0b-d675-4983-af6b-edfc2932310f
{
  "exp": 1519106136,
  "user_name": "admin",
  "authorities": [
    "ROLE_ADMIN"
  ],
  "client_id": "client",
  "scope": [
    "app"
  ]
}
```
在 application.yml 中加入以下参数不受 oauth2 保护
```
security:
  ignored: /oauth/check_token
```