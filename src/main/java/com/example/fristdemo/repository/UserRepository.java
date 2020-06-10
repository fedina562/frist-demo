package com.example.fristdemo.repository;

import com.example.fristdemo.doamin.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

//Dao
@Repository
//@Repository注解是spring的注解，主动标识当前类要交给spring容器管理（相当于@Component注解）
public class UserRepository {

    private final ConcurrentHashMap<Integer,User> repository = new ConcurrentHashMap<>();
    private final AtomicInteger idGenerator = new AtomicInteger();

    public boolean save(User user) {
        boolean success = false;
        //id从1开始
        Integer id = idGenerator.incrementAndGet();
        user.setId(id);
        //success==null返回成功
        success = repository.put(id,user)==null;

        return success;
    }

    public Collection<User> findAll(){
        return repository.values();
    }
}
