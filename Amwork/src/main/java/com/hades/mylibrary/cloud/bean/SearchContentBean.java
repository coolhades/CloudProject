package com.hades.mylibrary.cloud.bean;

import com.hades.mylibrary.base.ui.base.pojo.CodeInfoBean;

import java.util.List;

/**
 * Created by Hades on 2016/11/28.
 */

public class SearchContentBean {

    /**
     * list : [{"codeinfo":{"pushCode":"courseDetial","pushData":"D1B41F50613579CA8FB24B9C85A9C4B7"},"course_name":"猪猪添加课程1479282166","course_album":"http://img1.auto-mooc.com/course/album/F5/F5E5F397FBA94274956701471B5A3E2D.jpg","price_original":"0","price":"10.5","num_class":"88","num_user":"43","teacher_list":[]},{"codeinfo":{"pushCode":"courseDetial","pushData":"F43A339CA4C3488FDE12313BF2D71BC9"},"course_name":"猪猪添加课程1479282165","course_album":"http://img1.auto-mooc.com/course/album/F5/F5E5F397FBA94274956701471B5A3E2D.jpg","price_original":"0","price":"10.5","num_class":"88","num_user":"43","teacher_list":[]},{"codeinfo":{"pushCode":"courseDetial","pushData":"F6A3AA256F566855D8C26B60BD640EF6"},"course_name":"猪猪添加课程1479282165","course_album":"http://img1.auto-mooc.com/course/album/F5/F5E5F397FBA94274956701471B5A3E2D.jpg","price_original":"0","price":"10.5","num_class":"88","num_user":"43","teacher_list":[]},{"codeinfo":{"pushCode":"courseDetial","pushData":"38B0CFD9B4D671D4A076591400997218"},"course_name":"猪猪添加课程1479282164","course_album":"http://img1.auto-mooc.com/course/album/F5/F5E5F397FBA94274956701471B5A3E2D.jpg","price_original":"0","price":"10.5","num_class":"88","num_user":"43","teacher_list":[]},{"codeinfo":{"pushCode":"courseDetial","pushData":"6E4EA45AF29776C52A26BD2BC82E7C0B"},"course_name":"猪猪添加课程1479282164","course_album":"http://img1.auto-mooc.com/course/album/F5/F5E5F397FBA94274956701471B5A3E2D.jpg","price_original":"0","price":"10.5","num_class":"88","num_user":"43","teacher_list":[]},{"codeinfo":{"pushCode":"courseDetial","pushData":"4897AAFF1840A335B1997590B90CC26C"},"course_name":"猪猪添加课程1479282163","course_album":"http://img1.auto-mooc.com/course/album/F5/F5E5F397FBA94274956701471B5A3E2D.jpg","price_original":"0","price":"10.5","num_class":"88","num_user":"43","teacher_list":[]},{"codeinfo":{"pushCode":"courseDetial","pushData":"71EDDECF531090A631D1C006CD26F549"},"course_name":"猪猪添加课程1479282163","course_album":"http://img1.auto-mooc.com/course/album/F5/F5E5F397FBA94274956701471B5A3E2D.jpg","price_original":"0","price":"10.5","num_class":"88","num_user":"43","teacher_list":[]},{"codeinfo":{"pushCode":"courseDetial","pushData":"54251FDEAFF390EA0A45847A9C335DC1"},"course_name":"猪猪添加课程1479282162","course_album":"http://img1.auto-mooc.com/course/album/F5/F5E5F397FBA94274956701471B5A3E2D.jpg","price_original":"0","price":"10.5","num_class":"88","num_user":"43","teacher_list":[]},{"codeinfo":{"pushCode":"courseDetial","pushData":"D2E1A7C545128FB0D64F6A527C31F977"},"course_name":"猪猪添加课程1479282161","course_album":"http://img1.auto-mooc.com/course/album/F5/F5E5F397FBA94274956701471B5A3E2D.jpg","price_original":"0","price":"10.5","num_class":"88","num_user":"43","teacher_list":[]},{"codeinfo":{"pushCode":"courseDetial","pushData":"0538B78EF1B46492FEC684F750CCC12E"},"course_name":"猪猪添加课程1479282153","course_album":"http://img1.auto-mooc.com/course/album/F5/F5E5F397FBA94274956701471B5A3E2D.jpg","price_original":"0","price":"10.5","num_class":"88","num_user":"43","teacher_list":[]}]
     * num : 10
     * page : 1
     * pagesize : 20
     */

    private String num;
    private int page;
    private int pagesize;
    private List<ListBean> list;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * codeinfo : {"pushCode":"courseDetial","pushData":"D1B41F50613579CA8FB24B9C85A9C4B7"}
         * course_name : 猪猪添加课程1479282166
         * course_album : http://img1.auto-mooc.com/course/album/F5/F5E5F397FBA94274956701471B5A3E2D.jpg
         * price_original : 0
         * price : 10.5
         * num_class : 88
         * num_user : 43
         * teacher_list : []
         */

        private CodeInfoBean codeinfo;
        private String course_name;
        private String course_album;
        private String price_original;
        private String price;
        private String num_class;
        private String num_user;
        private List<?> teacher_list;

        public CodeInfoBean getCodeinfo() {
            return codeinfo;
        }

        public void setCodeinfo(CodeInfoBean codeinfo) {
            this.codeinfo = codeinfo;
        }

        public String getCourse_name() {
            return course_name;
        }

        public void setCourse_name(String course_name) {
            this.course_name = course_name;
        }

        public String getCourse_album() {
            return course_album;
        }

        public void setCourse_album(String course_album) {
            this.course_album = course_album;
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

        public String getNum_class() {
            return num_class;
        }

        public void setNum_class(String num_class) {
            this.num_class = num_class;
        }

        public String getNum_user() {
            return num_user;
        }

        public void setNum_user(String num_user) {
            this.num_user = num_user;
        }

        public List<?> getTeacher_list() {
            return teacher_list;
        }

        public void setTeacher_list(List<?> teacher_list) {
            this.teacher_list = teacher_list;
        }

    }
}
