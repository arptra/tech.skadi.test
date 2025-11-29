package com.xjsd.ai.assistant.protocol.nav;

import com.upuphone.xr.interconnect.entity.PoiResult;
import java.util.List;

public class NaviListData {
    private int currentPage;
    private int pageNumber;
    private List<PoiResult> poiResults;
    private int totalPage;

    public int getCurrentPage() {
        return this.currentPage;
    }

    public int getPageNumber() {
        return this.pageNumber;
    }

    public List<PoiResult> getPoiResults() {
        return this.poiResults;
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public void setPageNumber(int i) {
        this.pageNumber = i;
    }

    public void setPoiResults(List<PoiResult> list) {
        this.poiResults = list;
    }

    public void setTotalPage(int i) {
        this.totalPage = i;
    }
}
