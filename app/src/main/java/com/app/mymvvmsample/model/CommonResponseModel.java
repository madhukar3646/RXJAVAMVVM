package com.app.mymvvmsample.model;
import android.arch.lifecycle.LiveData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CommonResponseModel {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private List<HashtagsDataModel> data = null;
    @SerializedName("totalCount")
    @Expose
    private Integer totalCount;
    @SerializedName("categories")
    @Expose
    private List<UserCategoryModel> usercategories = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<HashtagsDataModel> getData() {
        return data;
    }

    public void setData(List<HashtagsDataModel> data) {
        this.data = data;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<UserCategoryModel> getUsercategories() {
        return usercategories;
    }

    public void setUsercategories(List<UserCategoryModel> usercategories) {
        this.usercategories = usercategories;
    }
}
