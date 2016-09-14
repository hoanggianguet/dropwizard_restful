package com.gianghoang.DTO;

import java.util.List;

/**
 * Created by Administrator on 8/18/2016.
 */
public class PageDTO {
    private long totalElements;
    private long totalPage;
    private long size;
    private long pageCurrent;
    private long numberOfElements;
    private List<PersonDTO> personList;

    public List<PersonDTO> getPersonList() {
        return personList;
    }

    public void setPersonList(List<PersonDTO> personList) {
        this.personList = personList;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getPageCurrent() {
        return pageCurrent;
    }

    public void setPageCurrent(long pageCurrent) {
        this.pageCurrent = pageCurrent;
    }

    public long getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(long numberOfElements) {
        this.numberOfElements = numberOfElements;
    }
}
