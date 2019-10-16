package com.app.mymvvmsample.viewmodel;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import com.app.mymvvmsample.model.CommonResponseModel;
import com.app.mymvvmsample.model.UserCategoryModel;
import com.app.mymvvmsample.utils.RetrofitApis;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesViewModel extends ViewModel {

    private MutableLiveData<List<UserCategoryModel>> usercategoryList;
    RetrofitApis retrofitApis=RetrofitApis.Factory.create();

    public void getUserCategories()
    {
        Observable<CommonResponseModel> call= retrofitApis.categoryList("40");
        call.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(new Observer<CommonResponseModel>() {
                @Override
                public void onSubscribe(Disposable d) {
                    Log.e("onSubscribe","onSubscribe");
                }

                @Override
                public void onNext(CommonResponseModel value) {
                    Log.e("onNext","onNext");
                    usercategoryList.setValue(value.getUsercategories());
                }

                @Override
                public void onError(Throwable e) {
                    Log.e("onError","onError");
                }

                @Override
                public void onComplete() {
                    Log.e("onComplete","onComplete");
                }
            });
    }

    public LiveData<List<UserCategoryModel>> getUsercategoryList()
    {
        if(usercategoryList==null) {
           usercategoryList=new MutableLiveData<>();
        }
        return usercategoryList;
    }
}
