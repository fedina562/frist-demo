package com.example.fristdemo.mapper;

import com.example.fristdemo.pojo.SysUser;
import com.example.fristdemo.utils.MyMapper;

import java.util.List;

public interface SysUserMapper extends MyMapper<SysUser> {

    List<SysUser> queryUserSimplyInfoById(String id);
}