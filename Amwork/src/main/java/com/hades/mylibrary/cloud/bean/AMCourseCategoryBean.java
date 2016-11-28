package com.hades.mylibrary.cloud.bean;

import java.util.List;

/**
 * Created by Hades on 2016/11/28.
 */

public class AMCourseCategoryBean {

    /**
     * title : 测试Banner题目
     * list : []
     * info : {"codeInfo":{"showCode":"AMCourseCategory","pushCode":"courseDetial","pushData":"F40D515620065E4A7A53915526150468"},"course_album":"","course_name":"猪猪添加课程1479287939-私有云A的","teacher_name":"未知老师","num_hour":"0","date_start":"未设置","date_end":"未设置","price_original":"0","price":"10.5","recommend_type":1,"course_id":"F40D515620065E4A7A53915526150468","num_visit":"0"}
     * page : {"now":"1","size":"10","sum":"30"}
     */

    private String title;
    private InfoBean info;
    private PageBean page;
    private List<?> list;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public PageBean getPage() {
        return page;
    }

    public void setPage(PageBean page) {
        this.page = page;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    public static class InfoBean {
        /**
         * codeInfo : {"showCode":"AMCourseCategory","pushCode":"courseDetial","pushData":"F40D515620065E4A7A53915526150468"}
         * course_album :
         * course_name : 猪猪添加课程1479287939-私有云A的
         * teacher_name : 未知老师
         * num_hour : 0
         * date_start : 未设置
         * date_end : 未设置
         * price_original : 0
         * price : 10.5
         * recommend_type : 1
         * course_id : F40D515620065E4A7A53915526150468
         * num_visit : 0
         */

        private CodeInfoBean codeInfo;
        private String course_album;
        private String course_name;
        private String teacher_name;
        private String num_hour;
        private String date_start;
        private String date_end;
        private String price_original;
        private String price;
        private int recommend_type;
        private String course_id;
        private String num_visit;

        public CodeInfoBean getCodeInfo() {
            return codeInfo;
        }

        public void setCodeInfo(CodeInfoBean codeInfo) {
            this.codeInfo = codeInfo;
        }

        public String getCourse_album() {
            return course_album;
        }

        public void setCourse_album(String course_album) {
            this.course_album = course_album;
        }

        public String getCourse_name() {
            return course_name;
        }

        public void setCourse_name(String course_name) {
            this.course_name = course_name;
        }

        public String getTeacher_name() {
            return teacher_name;
        }

        public void setTeacher_name(String teacher_name) {
            this.teacher_name = teacher_name;
        }

        public String getNum_hour() {
            return num_hour;
        }

        public void setNum_hour(String num_hour) {
            this.num_hour = num_hour;
        }

        public String getDate_start() {
            return date_start;
        }

        public void setDate_start(String date_start) {
            this.date_start = date_start;
        }

        public String getDate_end() {
            return date_end;
        }

        public void setDate_end(String date_end) {
            this.date_end = date_end;
        }

        public String getPrice_original() {
            return price_original;
        }

        public void setPrice_original(String price_original) {
            this.price_original = price_original;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public int getRecommend_type() {
            return recommend_type;
        }

        public void setRecommend_type(int recommend_type) {
            this.recommend_type = recommend_type;
        }

        public String getCourse_id() {
            return course_id;
        }

        public void setCourse_id(String course_id) {
            this.course_id = course_id;
        }

        public String getNum_visit() {
            return num_visit;
        }

        public void setNum_visit(String num_visit) {
            this.num_visit = num_visit;
        }

        public static class CodeInfoBean {
            /**
             * showCode : AMCourseCategory
             * pushCode : courseDetial
             * pushData : F40D515620065E4A7A53915526150468
             */

            private String showCode;
            private String pushCode;
            private String pushData;

            public String getShowCode() {
                return showCode;
            }

            public void setShowCode(String showCode) {
                this.showCode = showCode;
            }

            public String getPushCode() {
                return pushCode;
            }

            public void setPushCode(String pushCode) {
                this.pushCode = pushCode;
            }

            public String getPushData() {
                return pushData;
            }

            public void setPushData(String pushData) {
                this.pushData = pushData;
            }
        }
    }

    public static class PageBean {
        /**
         * now : 1
         * size : 10
         * sum : 30
         */

        private String now;
        private String size;
        private String sum;

        public String getNow() {
            return now;
        }

        public void setNow(String now) {
            this.now = now;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getSum() {
            return sum;
        }

        public void setSum(String sum) {
            this.sum = sum;
        }
    }
}
