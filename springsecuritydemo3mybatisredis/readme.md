springboot+springsecurity+mybatis+JWT
https://blog.csdn.net/zzxzzxhao/article/details/83381876
一、springboot
    1.新建项目
    2.application.yml的配置
    3.写一个小demo

二、druid

三、springsecurity
    1.引入相关依赖
    2.写了几个工具类
        ResultEnum  返回的错误码枚举类
        ResultVO    返回格式
    3.实现springsecurity各个核心接口，处理用户各种状态
        实现AuthenticationEntryPoint接口，处理用户未登录
        实现AccessDeniedHandler接口，处理无权访问的情况
        实现AuthenticationFailureHandler接口，处理用户登录失败
        实现AuthenticationSuccessHandler接口，处理登录成功的情况
        实现LogoutSuccessHandler接口，处理退出成功
        
        实现UserDetails实现自定义对象
    4.权限访问控制
    5.jwt生成token的工具类
        JwtTokenUtil
        JwtAuthenticationTokenFilter extends OncePerRequestFilter   
            jwt拦截器，确保在一次请求只通过一次filter，而不需要重复执行
    6.springsecurity核心处理
        SelfUserDetailsService  继承UserDetailsService，用户认证的业务代码
        相应dao层
        相应mapper.xml
        核心处理类
            SpringSecurityConf extends WebSecurityConfigurerAdapter

使用postman测试接口
http://localhost:8080/demo/login?username=admin&password=123  post 返回token封装在ResultEnum中的……

