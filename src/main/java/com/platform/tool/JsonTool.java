package com.platform.tool;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.platform.base.SysConst;

/**
 * ClassName：JsonTool
 * Description：JSON工具类
 */
public class JsonTool {

    private static ObjectMapper mapper = new ObjectMapper();

    private static final Logger log = LoggerFactory.getLogger(JsonTool.class);

    /**
     * 方法描述：转换对象为JSON字符串
     *
     * @param value
     * @return
     */
    public static String toJsonStr(Object value, String dateFormatStr) {
        try {
            if (StringUtils.isBlank(dateFormatStr)) {
                dateFormatStr = SysConst.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS;
            }
            DateFormat dateFormat = new SimpleDateFormat(dateFormatStr);
            mapper.setDateFormat(dateFormat);
            return mapper.writeValueAsString(value);
        } catch (Exception e) {
            log.error("转换对象为JSON字符串异常", e);
        }
        return "";
    }

    /**
     * 方法描述：转化json字符串为对象
     *
     * @param context
     * @param valueType
     * @return
     */
    public static <T> T readValue(String context, Class<T> valueType) {
        try {
            return mapper.readValue(context, valueType);
        } catch (Exception e) {
            log.error("转化json字符串为对象异常", e);
        }
        return null;
    }

    /**
     * 方法描述：转换JSon对象为制定类对象
     *
     * @param context
     * @param collectionClass
     * @param elementCLasses
     * @return
     */
    public static <T> T readValue(String context, Class<?> collectionClass, Class<?>... elementCLasses) {
        try {
            // return mapper.readValue(context, new
            // TypeReference<SynRst<SynDepartment>>() {});
            return mapper.readValue(context, getCollectionJavaType(collectionClass, elementCLasses));
        } catch (Exception e) {
            log.error("转化json字符串为对象异常", e);
        }
        return null;
    }

    /**
     * 方法描述：根据类对象获得JavaType类型
     *
     * @param collectionClass
     * @param elementCLasses
     * @return
     */
    private static JavaType getCollectionJavaType(Class<?> collectionClass, Class<?>... elementCLasses) {
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementCLasses);
    }
}
