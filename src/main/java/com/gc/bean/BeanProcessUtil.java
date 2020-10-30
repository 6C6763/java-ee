package com.gc.bean;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tanhq
 */
public class BeanProcessUtil {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>(16);
        User user = new User();
        user.setDate(new Date());
        user.setId(1);
        user.setAge(26);
        user.setName("gopher");
        user.setReceiveAddress("北京朝阳");
        try {
            map = transBean2Map(user, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(map);
    }



    public static Map<String, Object> transBean2Map(Object obj, Map<String, Object> map) throws Exception {
        //实体类不能为空
        if (obj == null) {
            return map;
        }
        try {
            // 在 Java Bean 上进行内省，了解其所有属性、公开的方法和事件
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            // 获得 beans PropertyDescriptor
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                // 父类FeatureDescriptor的方法，获得此特性的编程名称
                String key = property.getName();
                // 过滤class属性
                if (!key.equals("class")) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    // 调用指定对象的指定方法
                    Object value = getter.invoke(obj);
                    map.put(key, value == null ? "" : value);
                }
            }
        } catch (Exception e) {
            throw new Exception("将实体类转换成Map过程异常");
        }
        return map;
    }
    static class User {
        private Date date;
        private Integer id;
        private Integer age;
        private String name;
        private String receiveAddress;

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getReceiveAddress() {
            return receiveAddress;
        }

        public void setReceiveAddress(String receiveAddress) {
            this.receiveAddress = receiveAddress;
        }
    }
}

