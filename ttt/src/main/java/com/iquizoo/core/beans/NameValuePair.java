package com.iquizoo.core.beans;

/**
 * 名称值对应
 * Created by 卢强 on 2017/1/12.
 */
public class NameValuePair {

    public NameValuePair() {
    }

    public NameValuePair(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    private String name;

    private Object value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

}
