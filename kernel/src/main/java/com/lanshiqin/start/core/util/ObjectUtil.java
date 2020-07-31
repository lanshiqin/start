package com.lanshiqin.start.core.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 对象工具类
 *
 * @author 蓝士钦
 */
public class ObjectUtil {
    /**
     * 将对象驼峰字段转化成非驼峰下划线链接
     * 例：userName -> user_name
     *
     * @param object 对象
     * @return 对象属性map
     */
    public Map<String, Object> fieldConvertUnderline(final Object object) throws IllegalAccessException {
        Map<String, Object> camelCaseObject = new HashMap<>();
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field item : fields) {
            item.setAccessible(true);
            String name = item.getName();
            Object value = item.get(object);
            camelCaseObject.put(camelCaseToUnderline(name), value);
        }
        return camelCaseObject;
    }

    /**
     * 驼峰转下划线
     *
     * @param camelCaseFileName 驼峰字段
     * @return 下划线字段
     */
    public String camelCaseToUnderline(final String camelCaseFileName) {
        Matcher matcher = Pattern.compile("[A-Z]").matcher(camelCaseFileName);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
}
