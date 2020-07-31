package com.lanshiqin.start.core.base;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;

public class ListResultTest {

    @Test
    public void testGetTotalItem() {
        Long totalItem = 100L;
        ListResult<String> listResult = new ListResult<>();
        listResult.setTotalItem(totalItem);
        Assert.assertEquals(listResult.getTotalItem(),totalItem);
    }

    @Test
    public void testSetTotalItem() {
        Long totalItem = 100L;
        ListResult<String> listResult = new ListResult<>();
        listResult.setTotalItem(totalItem);
        Assert.assertEquals(listResult.getTotalItem(),totalItem);
    }

    @Test
    public void testGetTotalPage() {
        Long totalPage = 100L;
        ListResult<String> listResult = new ListResult<>();
        listResult.setTotalPage(totalPage);
        Assert.assertEquals(listResult.getTotalPage(),totalPage);
    }

    @Test
    public void testSetTotalPage() {
        Long totalPage = 100L;
        ListResult<String> listResult = new ListResult<>();
        listResult.setTotalPage(totalPage);
        Assert.assertEquals(listResult.getTotalPage(),totalPage);
    }

    @Test
    public void testGetRecords() {
        Map<Integer, Object> map = new HashMap<>();
        map.put(1,1);
        map.put(2,1L);
        map.put(3,1.1);
        map.put(4,Long.MAX_VALUE);
        map.put(5,Long.MIN_VALUE);
        List<Map<Integer, Object>> list = new ArrayList<>();
        list.add(map);

        ListResult<Map<Integer, Object>> listResult = new ListResult<>();
        listResult.setRecords(list);
        Assert.assertEquals(listResult.getRecords(),list);
        Map<Integer, Object> actualMap = listResult.getRecords().get(0);

        Assert.assertEquals(actualMap.get(1),1);
        Assert.assertEquals(actualMap.get(2),1L);
        Assert.assertEquals(actualMap.get(3),1.1);
        Assert.assertEquals(actualMap.get(4),Long.MAX_VALUE);
        Assert.assertEquals(actualMap.get(5),Long.MIN_VALUE);
    }

    @Test
    public void testSetRecords() {
        Map<Integer, Object> map = new HashMap<>();
        map.put(1,1);
        map.put(2,1L);
        map.put(3,1.1);
        map.put(4,Long.MAX_VALUE);
        map.put(5,Long.MIN_VALUE);
        List<Map<Integer, Object>> list = new ArrayList<>();
        list.add(map);

        ListResult<Map<Integer, Object>> listResult = new ListResult<>();
        listResult.setRecords(list);
        Assert.assertEquals(listResult.getRecords(),list);
        Map<Integer, Object> actualMap = listResult.getRecords().get(0);

        Assert.assertEquals(actualMap.get(1),1);
        Assert.assertEquals(actualMap.get(2),1L);
        Assert.assertEquals(actualMap.get(3),1.1);
        Assert.assertEquals(actualMap.get(4),Long.MAX_VALUE);
        Assert.assertEquals(actualMap.get(5),Long.MIN_VALUE);
    }
}