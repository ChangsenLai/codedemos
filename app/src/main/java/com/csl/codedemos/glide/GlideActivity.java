package com.csl.codedemos.glide;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.csl.codedemos.R;
import com.csl.codedemos.activity.BaseActivity;

import butterknife.BindView;
import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * author: laichangsen | create time: 2017/8/4
 */

public class GlideActivity extends BaseActivity {

    private static final String IMG_URL = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1501822591981&di=e278eb83a7241e2b4a1a049ef64e1fca&imgtype=0&src=http%3A%2F%2Fwww.feizl.com%2Fupload2007%2F2013_10%2F1310111640652711.jpg";

    @BindView(R.id.image)
    ImageView image;

    public static void start(Context context) {
        Intent intent = new Intent(context, GlideActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_glide;
    }

    @Override
    protected void init() {
        Glide.with(this)
                .load(IMG_URL)
                .bitmapTransform(new BlurTransformation(this, 25, 2), new RoundedCornersTransformation(this, 30, 0))
                .into(image);

    }

}
