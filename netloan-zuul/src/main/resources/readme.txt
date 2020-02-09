@https://www.cnblogs.com/yjmyzz/p/spring-cloud-zuul-demo.html
@https://blog.csdn.net/u013985664/article/details/80737729
Zull: 
   动态路由：动态将请求路由到不同后端集群
   身份认证和安全:识别每一个资源的验证要求 审查和监控
   动态参数修改： 对参数进行补充或者加解密
 zuul提供了fallback机制，我们可以给断路配置一个自定义回退。
    静态响应处理：边缘位置响应，避免转发到内部集群
    负载分配：为不同负载类型分配对应容量
    性能监控：
  