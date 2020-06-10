/*
package com.example.fristdemo.config;

import com.example.fristdemo.doamin.User;
import com.example.fristdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

*/
/**
 * 路由函数,等同于Controller中的mapping方式\
 * java版的se文件
 *//*

//表示配置对象，逐一替代
@Configuration
public class RouterFunctionConfig {

    @Autowired
    private UserRepository userRepository;

    */
/**
     * 定义get请求，返回所有的用户对象 URI为/person/find/all
     * Flux 是0-N个对象集合
     * mono 是0-1个对象集合，单一对象 类似于java8的Optional
     * Reactive 中的Flux与Mono 是异步处理（非阻塞）
     * Flux 或者 Mono都是Publisher
     *//*

    @Bean
    public RouterFunction<ServerResponse> personFindAll(){
        return RouterFunctions.route(RequestPredicates.GET("/person/find/all"),
                request ->{
                    Collection<User> users = userRepository.findAll();
                    Flux<User> userFlux = Flux.fromIterable(users);

                    return ServerResponse.ok().body(userFlux,User.class);
                });

    }
}
*/
