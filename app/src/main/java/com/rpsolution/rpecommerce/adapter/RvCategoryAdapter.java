package com.rpsolution.rpecommerce.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rpsolution.rpecommerce.R;
import com.rpsolution.rpecommerce.activity.ListActivity;
import com.rpsolution.rpecommerce.model.RvCategoryModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RvCategoryAdapter extends RecyclerView.Adapter<RvCategoryAdapter.CategoryViewHolder> {
    private Context mContext;
   private List<RvCategoryModel> rvCategoryModels;

    public RvCategoryAdapter(Context mContext, List<RvCategoryModel> rvCategoryModels) {
        this.mContext = mContext;
        this.rvCategoryModels = rvCategoryModels;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_category, viewGroup, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i) {

        RvCategoryModel rvCategoryModel = rvCategoryModels.get(i);
        categoryViewHolder.tvCategory.setText(rvCategoryModel.getCategoryTitle());
        Glide.with(mContext).load(rvCategoryModel.getCtegoryImg()).into(categoryViewHolder.ivCategory);
        categoryViewHolder.ivCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.startActivity(new Intent(mContext, ListActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return rvCategoryModels.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.iv_cat_img)
        protected ImageView ivCategory;
        @BindView(R.id.tv_category)
        protected TextView tvCategory;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
