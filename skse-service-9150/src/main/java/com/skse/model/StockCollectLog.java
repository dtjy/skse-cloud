package com.skse.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "stock_collect_log")
public class StockCollectLog {
    @Id
    private Integer id;

    @Column(name = "stock_code")
    private String stockCode;

    @Column(name = "week_date")
    private Integer weekDate;

    @Column(name = "create_date")
    private Date createDate;

    private String item;

    private Double data;

    @Column(name = "data_percentage")
    private Double dataPercentage;
    @Column(name = "increase_decrease")
    private Double increaseDecrease;


    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
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
     * @return week_date
     */
    public Integer getWeekDate() {
        return weekDate;
    }

    /**
     * @param weekDate
     */
    public void setWeekDate(Integer weekDate) {
        this.weekDate = weekDate;
    }

    /**
     * @return create_date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    /**
     * @return data
     */
    public Double getData() {
        return data;
    }

    /**
     * @param data
     */
    public void setData(Double data) {
        this.data = data;
    }

    /**
     * @return data_percentage
     */
    public Double getDataPercentage() {
        return dataPercentage;
    }

    /**
     * @param dataPercentage
     */
    public void setDataPercentage(Double dataPercentage) {
        this.dataPercentage = dataPercentage;
    }

    /**
     * @return increase_decrease
     */
    public Double getIncreaseDecrease() {
        return increaseDecrease;
    }

    /**
     * @param increaseDecrease
     */
    public void setIncreaseDecrease(Double increaseDecrease) {
        this.increaseDecrease = increaseDecrease;
    }
}