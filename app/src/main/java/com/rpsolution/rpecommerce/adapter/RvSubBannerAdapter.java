package com.rpsolution.rpecommerce.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.rpsolution.rpecommerce.R;
import com.rpsolution.rpecommerce.model.RvSubBannerModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RvSubBannerAdapter extends RecyclerView.Adapter<RvSubBannerAdapter.SubBannerViewHolder> {
    private Context mContext;
    private List<RvSubBannerModel> rvSubBannerModels;

    public RvSubBannerAdapter(Context mContext, List<RvSubBannerModel> rvSubBannerModels) {
        this.mContext = mContext;
        this.rvSubBannerModels = rvSubBannerModels;
    }

    @NonNull
    @Override
    public SubBannerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_sub_banner, viewGroup, false);
        return new SubBannerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubBannerViewHolder subBannerViewHolder, int i) {

        RvSubBannerModel rvSubBannerModel = rvSubBannerModels.get(i);
        Glide.with(mContext).load(rvSubBannerModel.getSubBanner()).into(subBannerViewHolder.ivSubBanner);
    }

    @Override
    public int getItemCount() {
        return rvSubBannerModels.size();
    }

    public class SubBannerViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.iv_sub_banner)
        protected ImageView ivSubBanner;
        public SubBannerViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
