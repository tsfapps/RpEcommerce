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
import com.rpsolution.rpecommerce.model.RvBannerModel;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
public class RvBannerAdapter extends RecyclerView.Adapter<RvBannerAdapter.BannerViewHolder> {

    private Context mContext;
    private List<RvBannerModel> rvBannerModels;
    public RvBannerAdapter(Context mContext, List<RvBannerModel> rvBannerModels) {
        this.mContext = mContext;
        this.rvBannerModels = rvBannerModels;
    }

    @NonNull
    @Override
    public BannerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_banner, viewGroup, false);
        return new BannerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BannerViewHolder bannerViewHolder, int i) {
        RvBannerModel rvBannerModel = rvBannerModels.get(i);

        Glide.with(mContext).load(rvBannerModel.getBanner()).into(bannerViewHolder.ivBanner);
    }
    @Override
    public int getItemCount() {
        return rvBannerModels.size();
    }
    public class BannerViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.iv_banner)
        protected ImageView ivBanner;

        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
