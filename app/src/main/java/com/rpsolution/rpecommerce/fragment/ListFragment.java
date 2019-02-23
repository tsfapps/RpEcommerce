package com.rpsolution.rpecommerce.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rpsolution.rpecommerce.R;
import com.rpsolution.rpecommerce.adapter.ListAdapter;

import butterknife.BindView;

public class ListFragment extends Fragment {

    private RecyclerView.LayoutManager mLayoutManager;
    private ListAdapter mAdapter;
    @BindView(R.id.rv_listFrag)
    protected RecyclerView rvListFrag;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_list,container, false);
        initRvListFrag();
        return view;

    }

    public void initRvListFrag(){
        mLayoutManager = new LinearLayoutManager(getContext());
        rvListFrag.setLayoutManager(mLayoutManager);
        mAdapter = new ListAdapter();
        rvListFrag.setAdapter(mAdapter);
    }
}
