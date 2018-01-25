package com.example.irfanfahmiwijaya.fixtubes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import java.util.List;



public class VideoAdapter_modulkajian extends RecyclerView.Adapter<VideoAdapter_modulkajian.VideoViewHolder> {


    List<YoutubeVideo_modulkajian> youtubeVideoModulkajianList;

    public VideoAdapter_modulkajian() {
    }

    public VideoAdapter_modulkajian(List<YoutubeVideo_modulkajian> youtubeVideoModulkajianList) {
        this.youtubeVideoModulkajianList = youtubeVideoModulkajianList;
    }

    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from( parent.getContext()).inflate(R.layout.card_video, parent, false);

        return new VideoViewHolder(view);

    }

    @Override
    public void onBindViewHolder(VideoViewHolder holder, int position) {

        holder.videoWeb.loadData( youtubeVideoModulkajianList.get(position).getVideoUrl(), "text/html" , "utf-8" );

    }

    @Override
    public int getItemCount() {
        return youtubeVideoModulkajianList.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder{

        WebView videoWeb;

        public VideoViewHolder(View itemView) {
            super(itemView);

            videoWeb = (WebView) itemView.findViewById(R.id.webVideoView);

            videoWeb.getSettings().setJavaScriptEnabled(true);
            videoWeb.setWebChromeClient(new WebChromeClient() {


            } );
        }
    }

}
