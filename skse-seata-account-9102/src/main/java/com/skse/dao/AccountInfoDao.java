package com.skse.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author jiangyao
 * @Date 2021/1/14 18:03
 **/
@Mapper
public interface AccountInfoDao {

    int create(@Param("id") Integer id, @Param("accountData") String accountData);

    int update(@Param("id") Integer id, @Param("accountData") String accountData);
}
