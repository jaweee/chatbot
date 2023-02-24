# chatbot
跟着小傅哥做的一个由chatapt做的一个知识问答项目


## 一、项目搭建

由于是一个DDD结构的项目，即使麻雀再小五脏俱全

### 1. 项目结构
- chatbot-application 
- chatbot-common 
- chatbot-domain，这是领域层，就像一个抽屉，把所有的
- chatbot-infrastructure，这是持久层，与数据库、缓存等交互 
- chatbot-interfaces，这是接口层，存放外部调用的借口

### 2. maven依赖

- chatbot的文件目录

```text
chatbot
├── README.md
├── chatbot-application
│   ├── pom.xml
│   └── src
├── chatbot-common
│   ├── pom.xml
│   └── src
├── chatbot-domain
│   ├── pom.xml
│   └── src
├── chatbot-infrastructure
│   ├── pom.xml
│   └── src
├── chatbot-interfaces
│   ├── pom.xml
│   └── src
└── pom.xml
```

chatbot目录下的pom文件引入一些插件、显示所包含的模块、以及各模块下的依赖版本

这个pom文件不起到实质性引入依赖的作用，但是可以控制依赖的版本

最后，chatbot-* 的所有模块需要什么依赖便引入什么依赖，不能犯错，即使需要springboot的web依赖却不引入，还以为通过父类引入

### 3. 管理与git仓库

<<<<<<< HEAD
git的一般操作是挺简单的，add、commit、push

创建分支现在不会，下章开始


=======
创建分支，用idea是不难的，直接有一个new branch的操作，添加你所想要的分支
>>>>>>> 23_jaweee_zsxq_api

然后可以使用Command + k 来推送`当前分支的新内容到远程仓库

## 二、调用接口，http消息发送和获取

### 1. http请求

http 请求的一应一答的规则
#### 1.1. http请求消息

请求消息所包含的内容
- 请求行 （请求方法[GET、POST、PUT、DELETE]、URL、协议版本）
- 请求头部（头部字段名:值，... ）
- 空行
- 请求数据（）


#### 1.2. http响应消息

响应消息所包含的内容
- 状态行
- 消息报头（Date、Content-Type、Content-Length）
- 空行
- 响应正文

### 2. 我所使用的http请求包

#### 2.1. RestTemplate
`getForObject、getForMap、postForObject、postForMap`
1. 创建请求头，`HttpHeaders header = new HttpHeaders()`
2. 设置请求头，`header.setContentType(MediaType.APPLICATION_JSON)`
3. 设置请求携带的数据，`HttpEntity<String> entity = new HttpEntity<>(json, header)`
4. 执行请求，`String s = postForObject(url, entity, String.class)`

#### 2.2. Apache的httpclient
1. 建立http客户端：`CloseableHttpClient http = HttpClientBuilder.create().build()`
2. 获取请求方法对象（HttpGet、HttpPost），`HttpGet get = new HttpGet(url)`
3. 设置请求头内容（Content-Type、cookie），`get.addHeader("cookie", "value")`,`get.addHeader("Content-Type", value)`
4. 设置请求的数据（POST中的json值[根据Content-Type中的内容设置]），`post.setEntity(string)`
5. 执行请求，获取返回的响应请求，`http.execute(get)`

#### 2.3. hutool的http工具
1. HttpUtil，在一个方法内实现get或者post请求，只需要提供url便可实现最简单的请求
2. HttpRequest，请求消息的主要类，以链式的方式将所以得参数配置到请求中（url，header，cookie，请求内容）
3. HttpResponse，响应消息的主要类，获取Http的响应消息

```
String s2 = HttpRequest.get("https://api.zsxq.com/v2/groups/88885851885242/topics?scope=unanswered_questions&count=20")
                .header(Header.CONTENT_TYPE, "application/json;charset=utf8")
                .header(Header.COOKIE, "zsxq_access_token=C28EF4D4-9DAF-F8AD-6612-7A9E02298004_665307D65BEA119D; zsxqsessionid=5c3c358a258ab816c161db1e9563801e; abtest_env=beta; sensorsdata2015jssdkcross={\"distinct_id\":\"215515852114851\",\"first_id\":\"17bbf4ad513658-0891bbdfb156bd-7a6b0055-1296000-17bbf4ad514347\",\"props\":{\"$latest_traffic_source_type\":\"直接流量\",\"$latest_search_keyword\":\"未取到值_直接打开\",\"$latest_referrer\":\"\"},\"$device_id\":\"17bbf4ad513658-0891bbdfb156bd-7a6b0055-1296000-17bbf4ad514347\",\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTgxMzk5OTE5ZTJlZDktMGJjYzc3NjU3Y2E5ZjctNjQ0NzI2NGEtMjA3MzYwMC0xODEzOTk5MTllMzExODYiLCIkaWRlbnRpdHlfbG9naW5faWQiOiIyMTU1MTU4NTIxMTQ4NTEifQ==\",\"history_login_id\":{\"name\":\"$identity_login_id\",\"value\":\"215515852114851\"}}")
                .execute().body();
        System.out.println(s2);
```