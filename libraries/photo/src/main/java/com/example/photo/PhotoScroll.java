package com.example.photo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.chahinem.pageindicator.PageIndicator;
import com.example.photo.adapter.ReyclerViewAdapter;


public class PhotoScroll extends RelativeLayout {

    ReyclerViewAdapter adapter;
//    AnyViewIndicator verticalIndicator;
    int[] mData = {R.drawable.images2, R.drawable.image1, R.drawable.images3, R.drawable.images4
                    ,R.drawable.images5, R.drawable.images6, R.drawable.images6};
    int p = 0;
    public PhotoScroll(Context context) {
        super(context);
    }

    public PhotoScroll(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_photo, this, true);
    }

    public PhotoScroll(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        final RecyclerView mRecyclerview;
        mRecyclerview = findViewById(R.id.recyclerView);

        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerview.setLayoutManager(layoutManager);
        adapter = new ReyclerViewAdapter(getContext(), mData);

        mRecyclerview.setAdapter(adapter);

        final PagerSnapHelper pagerSnapHelper  = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(mRecyclerview);
        final PageIndicator pageIndicator = findViewById(R.id.pageIndicator);
        pageIndicator.attachTo(mRecyclerview);
        mRecyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState == RecyclerView.SCROLL_STATE_IDLE) {
                    View centerView = pagerSnapHelper.findSnapView(layoutManager);
                    int pos = layoutManager.getPosition(centerView);
                    Log.d("position", "" + pos);
                    if (pos > p){
                        for(int i=0;i<pos-p;i++){
                            pageIndicator.swipeNext();
                        }
                        p = pos;
                    }else if (pos < p){
                        for(int i=0;i < p-pos;i++){
                            pageIndicator.swipePrevious();
                        }
                        p = pos;
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }
}
