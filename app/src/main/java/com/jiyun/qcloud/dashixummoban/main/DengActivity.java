package com.jiyun.qcloud.dashixummoban.main;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseActivity;
import com.jiyun.qcloud.dashixummoban.widget.GlideCacheUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DengActivity extends BaseActivity {

    @BindView(R.id.qingchu)
    TextView qingchu;
    @BindView(R.id.shoucang)
    RelativeLayout shoucang;
    private AlertDialog.Builder builder;

    @Override
    protected void initData() {
        String cacheSize = GlideCacheUtil.getInstance().getCacheSize(this);
        qingchu.setText(cacheSize);
        builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");
        builder.setMessage("确定清除缓存吗？");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                GlideCacheUtil.getInstance().clearImageMemoryCache(DengActivity.this);
                GlideCacheUtil.getInstance().clearImageAllCache(DengActivity.this);
                dialog.dismiss();
                String cacheSize = GlideCacheUtil.getInstance().getCacheSize(DengActivity.this);
                qingchu.setText(cacheSize);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.dismiss();
            }
        });

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_deng;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({ R.id.shoucang})
    public void onViewClicked(View view) {
        builder.show();
    }
}
