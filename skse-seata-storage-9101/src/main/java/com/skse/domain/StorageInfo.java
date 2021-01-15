package com.skse.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jiangyao
 * @Date 2021/1/14 18:00
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StorageInfo {
    private Integer id;
    private String storageData;
}
