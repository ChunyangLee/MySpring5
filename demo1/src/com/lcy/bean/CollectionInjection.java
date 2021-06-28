package com.lcy.bean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CollectionInjection {
    private String[] strArr;
    private List<Integer> list;
    private Map map;
    private List<Course> courseList;

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "CollectionInjection{" +
                "strArr=" + Arrays.toString(strArr) +
                ", list=" + list +
                ", map=" + map +
                ", courseList=" + courseList +
                '}';
    }

    public String[] getStrArr() {
        return strArr;
    }

    public void setStrArr(String[] strArr) {
        this.strArr = strArr;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
