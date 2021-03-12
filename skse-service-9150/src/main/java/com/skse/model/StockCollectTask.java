package com.skse.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "stock_collect_task")
public class StockCollectTask {
    @Id
    private Integer id;

    @Column(name = "data_url")
    private String dataUrl;

    @Column(name = "stock_code")
    private String stockCode;

    @Column(name = "data_index")
    private String dataIndex;

    private String item;

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
     * @return data_url
     */
    public String getDataUrl() {
        return dataUrl;
    }

    /**
     * @param dataUrl
     */
    public void setDataUrl(String dataUrl) {
        this.dataUrl = dataUrl;
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
}