# frist-demo
SpringBoot开发常用技术整合

全局异常处理：
@ControllerAdvice @ExceptionHandler(value = Exception.class)

开启定时任务：
FristDemoApplication使用注解@EnableScheduling开启定时任务，会自动扫描
定义@Scheduled作为组件被容器扫描执行（在线cron表达式生成器 https://cron.qqe2.com/）

开启异步任务：
FristDemoApplication使用注解@EnableAsync来开启异步，会自动扫描
定义@Component @Async作为组件被容器扫描执行

整合拦截器：
在类上使用注解@Configuration配置拦截器
继承WebMvcConfigurerAdapter，配置的适配器
重写addInterceptors，需要添加拦截器的地址