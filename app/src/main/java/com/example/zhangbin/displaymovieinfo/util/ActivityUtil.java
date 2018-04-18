package com.example.zhangbin.displaymovieinfo.util;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import io.reactivex.annotations.NonNull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by zhangbin on 4/3/2018.
 */

public class ActivityUtil {

    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                             @NonNull Fragment fragment, int containerId){
        checkNotNull(fragment);
        checkNotNull(fragmentManager);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(containerId,fragment);
        fragmentTransaction.commit();
    }
}
