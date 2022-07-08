package com.yqp.common;

/**
 * @author yqp
 **/
public class PageInfo {


    /**
     * total : 3
     * page : 0
     * size : 3
     */

    private Long total = 0l;
    private int page;
    private int size;

    public PageInfo() {
        super();
    }

    public PageInfo(int page, int size) {
        super();
        this.page = page;
        this.size = size;
    }

    public PageInfo(int page, int size, Long total) {
        super();
        this.page = page;
        this.size = size;
        this.total = total;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
