package com.rpsolution.rpecommerce.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rpsolution.rpecommerce.R;
import com.rpsolution.rpecommerce.adapter.ListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListActivity extends AppCompatActivity {
    private RecyclerView.LayoutManager mLayoutManager;
    private ListAdapter mAdapter;
    @BindView(R.id.rv_listFrag)
    protected RecyclerView rvListFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);
        initRvListFrag();
    }

    public void initRvListFrag(){
        mLayoutManager = new LinearLayoutManager(this);
        rvListFrag.setLayoutManager(mLayoutManager);
        mAdapter = new ListAdapter();
        rvListFrag.setAdapter(mAdapter);
    }
}
