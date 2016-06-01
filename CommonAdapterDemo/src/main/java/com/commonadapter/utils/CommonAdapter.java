package com.commonadapter.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.commonadapter.R;

import java.util.List;

/**
 * 通用Adapter抽象类
 */
public abstract class CommonAdapter<T> extends BaseAdapter {

    protected Context context;
    protected List<T> list;
    protected LayoutInflater mInflater;

    public CommonAdapter(Context context, List<T> list) {
        this.context = context;
        this.list = list;

        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public T getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = ViewHolder.get(context, convertView, parent, R.layout.item_list, position);

        convert(viewHolder, (T) getItem(position));

        return viewHolder.getConvertView();
    }

    /**
     * 抽象方法
     *
     * @param viewHolder 一个ViewHolder
     * @param t          一个数据集
     */
    public abstract void convert(ViewHolder viewHolder, T t);
}
