package com.hades.mylibrary.cloud.bean;

import com.hades.mylibrary.base.ui.base.transaction.TransactionBean;

import java.util.List;

/**
 * Created by Hades on 2016/11/14.
 */

public class TeacherList {

    /**
     * lable : teachernamehcshcuahc
     * item : [{"teacher_name":"老师名","introduction":"简介","course_num":"2"},{"teacher_name":"老师名","introduction":"简介","course_num":"2"},{"teacher_name":"老师名","introduction":"简介","course_num":"2"},{"teacher_name":"老师名","introduction":"简介","course_num":"2"}]
     */

    private String lable;
    private List<ItemBean> item;

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public List<ItemBean> getItem() {
        return item;
    }

    public void setItem(List<ItemBean> item) {
        this.item = item;
    }

    public static class ItemBean extends TransactionBean {
        /**
         * teacher_name : 老师名
         * introduction : 简介
         * course_num : 2
         */

        private String teacher_name;
        private String introduction;
        private String course_num;

        public String getTeacher_name() {
            return teacher_name;
        }

        public void setTeacher_name(String teacher_name) {
            this.teacher_name = teacher_name;
        }

        public String getIntroduction() {
            return introduction;
        }

        public void setIntroduction(String introduction) {
            this.introduction = introduction;
        }

        public String getCourse_num() {
            return course_num;
        }

        public void setCourse_num(String course_num) {
            this.course_num = course_num;
        }
    }
}
