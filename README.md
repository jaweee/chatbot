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




