package com.skse.dao.storage;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @Author jiangyao
 * @Date 2021/1/14 18:03
 **/
@Mapper
public interface StorageInfoDao {

    @Insert("insert into storage_info (storage_data) values (#{storageData})")
    int create(@Param("id") Integer id, @Param("storageData") String storageData);

    @Update("update storage_info set storage_data = #{storageData} where id=#{id}")
    int update(@Param("id") Integer id, @Param("storageData") String storageData);
}
