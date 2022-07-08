package com.yqp.common;

import com.alibaba.druid.support.json.JSONUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName Utils
 * @Description Utils工具类
 * @Author yqp
 * @Version 1.0.0
 **/
public class Utils {


    //写入session
    public static void setSession(HttpServletRequest request, String SessionName, Object SessionValue) {
        String jsonString = JSONObject.valueAsStr(SessionValue);
        HttpSession session = request.getSession();
        session.setAttribute(SessionName,jsonString);
    }

    //取出session
    public static String getSession(HttpServletRequest request, String sessionName) {
        HttpSession session = request.getSession();
        String sessionValue = (String) session.getAttribute(sessionName);
        return sessionValue;
    }

    //清空session
    public static void clearSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
    }

    /**
     * 是否为空
     *
     * @return
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        } else if (obj instanceof String) {
            String instance = (String) obj;
            if (instance.trim().length() <= 0 || "null".equalsIgnoreCase(instance)) {
                return true;
            }
        } else if (obj instanceof Integer) {
            Integer instance = (Integer) obj;
            if (instance < 0) {
                return true;
            }
        } else if (obj instanceof List<?>) {
            List<?> instance = (List<?>) obj;
            if (instance.size() <= 0) {
                return true;
            }
        } else if (obj instanceof Map<?, ?>) {
            Map<?, ?> instance = (Map<?, ?>) obj;
            if (instance.size() <= 0) {
                return true;
            }
        } else if (obj instanceof Object[]) {
            Object[] instance = (Object[]) obj;
            if (instance.length <= 0) {
                return true;
            }
        } else if (obj instanceof Long) {
            Long instance = (Long) obj;
            if (instance < 0) {
                return true;
            }
        }
        return false;
    }

    public static void isEmptyThrow(String... values) throws Exception {
        for (String value : values) {
            boolean b = isEmpty(value);
            if (b) {
                throw new Exception("参数错误");
            }
        }
    }

    /**
     * @Description 首字母小写
     * @Param value
     * @Return String
     * @Author yuan.shuai
     * @Date 2019/8/30
     * @Version 1.0.0
     */
    public static String toLowerCaseFirstOne(String value) {
        if (Objects.nonNull(value) && !Objects.equals(value, "")) {
            char[] chars = value.toCharArray();
            chars[0] += 32;
            return String.valueOf(chars);
        }
        return null;
    }

    public static boolean notEmpty(Object obj) {
        return !isEmpty(obj);
    }

    public static boolean notEmptyAll(Object... objects) {
        for (Object obj : objects) {
            if (isEmpty(obj)) {
                return false;
            }
        }
        return true;
    }

    //存在不为空则返回
    public static boolean existNotEmpty(Object... objects) {
        for (Object object : objects) {
            if (notEmpty(object)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEmptyAll(Object... objects) {
        return !notEmpty(objects);
    }

    /**
     * @Description 判断字符串全是数字
     * @Author yuan.shuai
     * @Date 2021/3/11 11:47
     * @Param
     * @Return
     * @Version 1.0.0
     **/
    public static boolean isNumeric(String str) {
        //Pattern pattern = Pattern.compile("^-?[0-9]+"); //这个也行
        Pattern pattern = Pattern.compile("^-?\\d+(\\.\\d+)?$");//这个也行
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    public static double calculationDivision(int divisor,int dividend) {
        if (dividend == 0 || divisor == 0) {
            return 0;
        }
        return new BigDecimal((float)divisor/dividend).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static double calculationDivision(double divisor,int dividend) {
        if (dividend == 0 || divisor == 0) {
            return 0;
        }
        return new BigDecimal((float)divisor/dividend).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

}
