package com.lanshiqin.start.core.base;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ListRequestTest {

    @Test
    public void testGetPageNo() {
        Long pageNo = 1L;
        ListRequest listRequest = new ListRequest();
        listRequest.setPageNo(pageNo);
        Assert.assertEquals(listRequest.getPageNo(),pageNo);
    }

    @Test
    public void testSetPageNo() {
        Long pageNo = 1L;
        ListRequest listRequest = new ListRequest();
        listRequest.setPageNo(pageNo);
        Assert.assertEquals(listRequest.getPageNo(),pageNo);
    }

    @Test
    public void testGetPageSize() {
        Long pageSize = 10L;
        ListRequest listRequest = new ListRequest();
        listRequest.setPageSize(pageSize);
        Assert.assertEquals(listRequest.getPageSize(),pageSize);
    }

    @Test
    public void testSetPageSize() {
        Long pageSize = 10L;
        ListRequest listRequest = new ListRequest();
        listRequest.setPageSize(pageSize);
        Assert.assertEquals(listRequest.getPageSize(),pageSize);
    }

    @Test
    public void testGetSortField() {
        String sortField = "field";
        ListRequest listRequest = new ListRequest();
        listRequest.setSortField(sortField);
        Assert.assertEquals(listRequest.getSortField(),sortField);
    }

    @Test
    public void testSetSortField() {
        String sortField = "field";
        ListRequest listRequest = new ListRequest();
        listRequest.setSortField(sortField);
        Assert.assertEquals(listRequest.getSortField(),sortField);
    }

    @Test
    public void testGetSort() {
        String sort = "DESC";
        ListRequest listRequest = new ListRequest();
        listRequest.setSort(sort);
        Assert.assertEquals(listRequest.getSort(),sort);
    }

    @Test
    public void testSetSort() {
        String sort = "DESC";
        ListRequest listRequest = new ListRequest();
        listRequest.setSort(sort);
        Assert.assertEquals(listRequest.getSort(),sort);
    }
}