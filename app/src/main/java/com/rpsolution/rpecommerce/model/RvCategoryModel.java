package com.rpsolution.rpecommerce.model;

public class RvCategoryModel {
    private int ctegoryImg;
    private String categoryTitle;

    public RvCategoryModel(int ctegoryImg, String categoryTitle) {
        this.ctegoryImg = ctegoryImg;
        this.categoryTitle = categoryTitle;
    }

    public int getCtegoryImg() {
        return ctegoryImg;
    }

    public void setCtegoryImg(int ctegoryImg) {
        this.ctegoryImg = ctegoryImg;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }
}
