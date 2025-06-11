package com.swfinal.login;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
	
	Map<String, Object> selectUserInfo(Map<String, Object> params);
	
}

