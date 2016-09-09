package com.example.odialko.vkwallapi;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.odialko.vkwallapi.data.model.MyCard;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Odialko on 05.09.2016.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private ArrayList<MyCard> aList;
    // класс view holder-а с помощью которого мы получаем ссылку на каждый элемент
    // отдельного пункта списка
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // наш пункт состоит только из одного TextView
        public TextView mTextView;
        public ImageView img;
        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.tv_recycler_item);
            img = (ImageView) v.findViewById(R.id.img);
        }
    }

    // Создает новые views (вызывается layout manager-ом)
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        // тут можно программно менять атрибуты лэйаута (size, margins, paddings и др.)
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Заменяет контент отдельного view (вызывается layout manager-ом)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.mTextView.setText(aList.get(position).getMainText());

        Picasso.with(holder.img.getContext())
                        .load(aList.get(position).getUrl2()) //ссылка
                        .resize(640, 480)
                        .into(holder.img);
        }

    // Возвращает размер данных (вызывается layout manager-ом)
    @Override
    public int getItemCount() {
        return aList == null ? 0 : aList.size();
    }

    public void setAList(ArrayList<MyCard> aList){
        this.aList = aList;
        notifyDataSetChanged();
    }
}
