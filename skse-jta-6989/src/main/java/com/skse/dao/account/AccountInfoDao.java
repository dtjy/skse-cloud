package com.skse.dao.account;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @Author jiangyao
 * @Date 2021/1/14 18:03
 **/
@Mapper
public interface AccountInfoDao {

    @Insert("insert into account_info (account_data) values (#{accountData})")
    int create(@Param("id") Integer id, @Param("accountData") String accountData);

    @Update("update account_info set account_data = #{accountData}  where id=#{id}")
    int update(@Param("id") Integer id, @Param("accountData") String accountData);
}
