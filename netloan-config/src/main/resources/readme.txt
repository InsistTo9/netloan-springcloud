##本地文件存储配置配置####
spring:
  application:
    name: netloan-config
  cloud:
    config:
      server:
        native:
          search-locations: classpath:/shared
  profiles:
     active: native 
server:
  port: 8888
eureka:
  client:
    service-url: 
       defaultZone : http://127.0.0.1:8761/eureka,http://127.0.0.1:8762/eureka