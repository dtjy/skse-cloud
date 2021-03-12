package com.skse.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "stock_mail_task")
public class StockMailTask implements Serializable {

    @ApiModelProperty(value = "id", example = "1")
    @Id
    private Long id;
    @ApiModelProperty(value = "邮件地址", example = "279964527@qq.com")
    @Column(name = "send_mail")
    private String sendMail;

    @ApiModelProperty(value = "股票代码", example = "279964527@qq.com")
    @Column(name = "stock_code")
    private String stockCode;

    @ApiModelProperty(value = "创建时间", example = "前端不需要")
    @Column(name = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "类型", example = "xxx")
    @Column(name = "stock_type")
    private String stockType;

    @ApiModelProperty(value = "数据下标", example = "1,3,5")
    @Column(name = "data_index")
    private String dataIndex;

    @ApiModelProperty(value = "cron表达式", example = "1 1 1 * * ？")
    @Column(name = "cron_express")
    private String cronExpress;

    @ApiModelProperty(value = "作废", example = "作废")
    @Column(name = "check_time")
    private String checkTime;

    @ApiModelProperty(value = "状态", example = "T正常，F删除")
    @Column(name = "task_status")
    private String taskStatus;

    @ApiModelProperty(value = "说明", example = "这是一个说明")
    private String item;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return send_mail
     */
    public String getSendMail() {
        return sendMail;
    }

    /**
     * @param sendMail
     */
    public void setSendMail(String sendMail) {
        this.sendMail = sendMail;
    }

    /**
     * @return stock_code
     */
    public String getStockCode() {
        return stockCode;
    }

    /**
     * @param stockCode
     */
    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return stock_type
     */
    public String getStockType() {
        return stockType;
    }

    /**
     * @param stockType
     */
    public void setStockType(String stockType) {
        this.stockType = stockType;
    }

    /**
     * @return data_index
     */
    public String getDataIndex() {
        return dataIndex;
    }

    /**
     * @param dataIndex
     */
    public void setDataIndex(String dataIndex) {
        this.dataIndex = dataIndex;
    }

    /**
     * @return cron_express
     */
    public String getCronExpress() {
        return cronExpress;
    }

    /**
     * @param cronExpress
     */
    public void setCronExpress(String cronExpress) {
        this.cronExpress = cronExpress;
    }

    /**
     * @return item
     */
    public String getItem() {
        return item;
    }

    /**
     * @param item
     */
    public void setItem(String item) {
        this.item = item;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }
}