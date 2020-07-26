package com.lanshiqin.start.core.base;

import java.util.List;

/**
 * 列表响应结果
 * @author 蓝士钦
 */
public class ListResult<T> {
    private Long totalItem;
    private Long totalPage;
    private List<T> records;

    public Long getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(Long totalItem) {
        this.totalItem = totalItem;
    }

    public Long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
