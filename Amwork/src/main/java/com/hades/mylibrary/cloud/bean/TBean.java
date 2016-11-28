package com.hades.mylibrary.cloud.bean;

import java.util.List;

/**
 * Created by Hades on 2016/11/24.
 */

public class TBean {

    /**
     * status : 1
     * message : get home ok
     * data : [{"blockType":"AMBanner","blockTitle":"测试Banner","blockConfig":{"autoScrollTimeInterval":"2s","infiniteLoop":"1","autoScroll":"1","showPageControl":"1","hidesForSinglePage":"1","pageControlAliment":"1","pageControlDotSize":"1.00","currentPageDotColor":"#FFFFFF"},"blockData":{"title":"测试Banner","list":[{"title":"测试数据测试数据aaa","img":"http://img1.auto-mooc.com/page/image/20160926/945E21598E944E498915B8D337F6867B.jpg","codeInfo":{"showCode":"category","pushCode":"searchCategory","pushData":"2B5279B25285446B94C2E4F016A73CAE"}},{"title":"测试数据测试数据bbb","img":"http://img1.auto-mooc.com/page/image/20160926/945E21598E944E498915B8D337F6867B.jpg","codeInfo":{"showCode":"category","pushCode":"searchCategory","pushData":"2B5279B25285446B94C2E4F016A73CAE"}},{"title":"测试数据测试数据ccc","img":"http://img1.auto-mooc.com/page/image/20160926/945E21598E944E498915B8D337F6867B.jpg","codeInfo":{"showCode":"category","pushCode":"searchCategory","pushData":"2B5279B25285446B94C2E4F016A73CAE"}}],"info":{"title":"单体数据在此","img":"http://img1.auto-mooc.com/page/image/20160926/945E21598E944E498915B8D337F6867B.jpg","codeInfo":{"showCode":"category","pushCode":"searchCategory","pushData":"2B5279B25285446B94C2E4F016A73CAE"}},"page":{"now":"1","size":"10","sum":"30"}}}]
     */

    private int status;
    private String message;
    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * blockType : AMBanner
         * blockTitle : 测试Banner
         * blockConfig : {"autoScrollTimeInterval":"2s","infiniteLoop":"1","autoScroll":"1","showPageControl":"1","hidesForSinglePage":"1","pageControlAliment":"1","pageControlDotSize":"1.00","currentPageDotColor":"#FFFFFF"}
         * blockData : {"title":"测试Banner","list":[{"title":"测试数据测试数据aaa","img":"http://img1.auto-mooc.com/page/image/20160926/945E21598E944E498915B8D337F6867B.jpg","codeInfo":{"showCode":"category","pushCode":"searchCategory","pushData":"2B5279B25285446B94C2E4F016A73CAE"}},{"title":"测试数据测试数据bbb","img":"http://img1.auto-mooc.com/page/image/20160926/945E21598E944E498915B8D337F6867B.jpg","codeInfo":{"showCode":"category","pushCode":"searchCategory","pushData":"2B5279B25285446B94C2E4F016A73CAE"}},{"title":"测试数据测试数据ccc","img":"http://img1.auto-mooc.com/page/image/20160926/945E21598E944E498915B8D337F6867B.jpg","codeInfo":{"showCode":"category","pushCode":"searchCategory","pushData":"2B5279B25285446B94C2E4F016A73CAE"}}],"info":{"title":"单体数据在此","img":"http://img1.auto-mooc.com/page/image/20160926/945E21598E944E498915B8D337F6867B.jpg","codeInfo":{"showCode":"category","pushCode":"searchCategory","pushData":"2B5279B25285446B94C2E4F016A73CAE"}},"page":{"now":"1","size":"10","sum":"30"}}
         */

        private String blockType;
        private String blockTitle;
        private BlockConfigBean blockConfig;
        private BlockDataBean blockData;

        public String getBlockType() {
            return blockType;
        }

        public void setBlockType(String blockType) {
            this.blockType = blockType;
        }

        public String getBlockTitle() {
            return blockTitle;
        }

        public void setBlockTitle(String blockTitle) {
            this.blockTitle = blockTitle;
        }

        public BlockConfigBean getBlockConfig() {
            return blockConfig;
        }

        public void setBlockConfig(BlockConfigBean blockConfig) {
            this.blockConfig = blockConfig;
        }

        public BlockDataBean getBlockData() {
            return blockData;
        }

        public void setBlockData(BlockDataBean blockData) {
            this.blockData = blockData;
        }

        public static class BlockConfigBean {
            /**
             * autoScrollTimeInterval : 2s
             * infiniteLoop : 1
             * autoScroll : 1
             * showPageControl : 1
             * hidesForSinglePage : 1
             * pageControlAliment : 1
             * pageControlDotSize : 1.00
             * currentPageDotColor : #FFFFFF
             */

            private String autoScrollTimeInterval;
            private String infiniteLoop;
            private String autoScroll;
            private String showPageControl;
            private String hidesForSinglePage;
            private String pageControlAliment;
            private String pageControlDotSize;
            private String currentPageDotColor;

            public String getAutoScrollTimeInterval() {
                return autoScrollTimeInterval;
            }

            public void setAutoScrollTimeInterval(String autoScrollTimeInterval) {
                this.autoScrollTimeInterval = autoScrollTimeInterval;
            }

            public String getInfiniteLoop() {
                return infiniteLoop;
            }

            public void setInfiniteLoop(String infiniteLoop) {
                this.infiniteLoop = infiniteLoop;
            }

            public String getAutoScroll() {
                return autoScroll;
            }

            public void setAutoScroll(String autoScroll) {
                this.autoScroll = autoScroll;
            }

            public String getShowPageControl() {
                return showPageControl;
            }

            public void setShowPageControl(String showPageControl) {
                this.showPageControl = showPageControl;
            }

            public String getHidesForSinglePage() {
                return hidesForSinglePage;
            }

            public void setHidesForSinglePage(String hidesForSinglePage) {
                this.hidesForSinglePage = hidesForSinglePage;
            }

            public String getPageControlAliment() {
                return pageControlAliment;
            }

            public void setPageControlAliment(String pageControlAliment) {
                this.pageControlAliment = pageControlAliment;
            }

            public String getPageControlDotSize() {
                return pageControlDotSize;
            }

            public void setPageControlDotSize(String pageControlDotSize) {
                this.pageControlDotSize = pageControlDotSize;
            }

            public String getCurrentPageDotColor() {
                return currentPageDotColor;
            }

            public void setCurrentPageDotColor(String currentPageDotColor) {
                this.currentPageDotColor = currentPageDotColor;
            }
        }

        public static class BlockDataBean {
            /**
             * title : 测试Banner
             * list : [{"title":"测试数据测试数据aaa","img":"http://img1.auto-mooc.com/page/image/20160926/945E21598E944E498915B8D337F6867B.jpg","codeInfo":{"showCode":"category","pushCode":"searchCategory","pushData":"2B5279B25285446B94C2E4F016A73CAE"}},{"title":"测试数据测试数据bbb","img":"http://img1.auto-mooc.com/page/image/20160926/945E21598E944E498915B8D337F6867B.jpg","codeInfo":{"showCode":"category","pushCode":"searchCategory","pushData":"2B5279B25285446B94C2E4F016A73CAE"}},{"title":"测试数据测试数据ccc","img":"http://img1.auto-mooc.com/page/image/20160926/945E21598E944E498915B8D337F6867B.jpg","codeInfo":{"showCode":"category","pushCode":"searchCategory","pushData":"2B5279B25285446B94C2E4F016A73CAE"}}]
             * info : {"title":"单体数据在此","img":"http://img1.auto-mooc.com/page/image/20160926/945E21598E944E498915B8D337F6867B.jpg","codeInfo":{"showCode":"category","pushCode":"searchCategory","pushData":"2B5279B25285446B94C2E4F016A73CAE"}}
             * page : {"now":"1","size":"10","sum":"30"}
             */

            private String title;
            private InfoBean info;
            private PageBean page;
            private List<ListBean> list;

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

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class InfoBean {
                /**
                 * title : 单体数据在此
                 * img : http://img1.auto-mooc.com/page/image/20160926/945E21598E944E498915B8D337F6867B.jpg
                 * codeInfo : {"showCode":"category","pushCode":"searchCategory","pushData":"2B5279B25285446B94C2E4F016A73CAE"}
                 */

                private String title;
                private String img;
                private CodeInfoBean codeInfo;

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public CodeInfoBean getCodeInfo() {
                    return codeInfo;
                }

                public void setCodeInfo(CodeInfoBean codeInfo) {
                    this.codeInfo = codeInfo;
                }

                public static class CodeInfoBean {
                    /**
                     * showCode : category
                     * pushCode : searchCategory
                     * pushData : 2B5279B25285446B94C2E4F016A73CAE
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

            public static class ListBean {
                /**
                 * title : 测试数据测试数据aaa
                 * img : http://img1.auto-mooc.com/page/image/20160926/945E21598E944E498915B8D337F6867B.jpg
                 * codeInfo : {"showCode":"category","pushCode":"searchCategory","pushData":"2B5279B25285446B94C2E4F016A73CAE"}
                 */

                private String title;
                private String img;
                private CodeInfoBeanX codeInfo;

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public CodeInfoBeanX getCodeInfo() {
                    return codeInfo;
                }

                public void setCodeInfo(CodeInfoBeanX codeInfo) {
                    this.codeInfo = codeInfo;
                }

                public static class CodeInfoBeanX {
                    /**
                     * showCode : category
                     * pushCode : searchCategory
                     * pushData : 2B5279B25285446B94C2E4F016A73CAE
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
        }
    }
}
