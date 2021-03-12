package com.skse.dao;

import com.skse.model.SourceMailInfo;
import com.skse.utils.BaseMapper;

import java.util.List;

public interface SourceMailInfoMapper extends BaseMapper<SourceMailInfo> {

    List<SourceMailInfo> listSourceMailInfo();
}