package com.skse.model.req;

import com.skse.model.StockMailTask;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author jiangyao
 * @Date 2020/5/27 16:46
 **/
public class StockMailTaskReqVO extends StockMailTask implements Serializable {

    @ApiModelProperty(value = "旧cron表达式", example = "xxxxxx")
    private String oldCron;

    @ApiModelProperty(value = "旧发送邮箱地址", example = "xxxxxx@xxx.cxx")
    private String oldMail;

    public String getOldCron() {
        return oldCron;
    }

    public void setOldCron(String oldCron) {
        this.oldCron = oldCron;
    }

    public String getOldMail() {
        return oldMail;
    }

    public void setOldMail(String oldMail) {
        this.oldMail = oldMail;
    }
}
