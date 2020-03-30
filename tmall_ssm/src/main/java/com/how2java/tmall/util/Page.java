package com.how2java.tmall.util;

/**
 * @author: mingjian
 * @create: 2020-03-11 20:55
 */
public class Page {
    private int start;//开始页数
    private int count;//每页显示个数
    private int total;//总个数
    private String param;//参数
    private static final int defaultCount=5;

    public Page() {
        count=defaultCount;
    }

    public Page(int start, int count) {
        this();
        this.start = start;
        this.count = count;
    }
    public boolean isHasPreviouse(){
        if(start==0)return false;
        return true;
    }
    public boolean isHasNext(){
        if(start==getLast())return false;
        return true;
    }

    public int getTotalPage(){
        int totalPage;
        if(0==total%count)
            totalPage=total/count;
        else totalPage=total/count+1;

        if(0==totalPage)
            totalPage=1;
        return totalPage;
    }
    public int getLast(){
        int last;
        if(0==total%count)
            last=total-count;
        else last=total-total%count;
        return last<0?0:last;
    }
    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    @Override
    public String toString() {
        return "Page{" +
                "start=" + start +
                ", count=" + count +
                ", total=" + total +
                ",getStart()"+getStart()+
                ",getCount()"+getCount()+
                ",isHasPreviouse()"+isHasPreviouse()+
                ",isHasNext()"+isHasNext()+
                ",getTotalPage()"+getTotalPage()+
                ",getLast()"+getLast()+
                ", param='" + param + '\'' +
                '}';
    }
}
