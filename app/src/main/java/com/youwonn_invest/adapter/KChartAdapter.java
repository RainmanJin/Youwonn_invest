package com.youwonn_invest.adapter;

import com.github.tifezh.kchartlib.chart.BaseKChartAdapter;
import com.youwonn_invest.common.KLineEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ShuLin on 2017/11/10.
 * Email linlin.1016@qq.com
 * Company Shanghai Quantpower Information Technology Co.,Ltd.
 */

public class KChartAdapter extends BaseKChartAdapter{
    private List<KLineEntity> datas = new ArrayList<>();

    public KChartAdapter() {

    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public Date getDate(int position) {
        try {
            String s = datas.get(position).Date;
            String[] split = s.split("/");
            Date date = new Date();
            date.setYear(Integer.parseInt(split[0]) - 1900);
            date.setMonth(Integer.parseInt(split[1]) - 1);
            date.setDate(Integer.parseInt(split[2]));
            return date;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 向头部添加数据
     */
    public void addHeaderData(List<KLineEntity> data) {
        if (data != null && !data.isEmpty()) {
            datas.addAll(data);
            notifyDataSetChanged();
        }
    }

    /**
     * 向尾部添加数据
     */
    public void addFooterData(List<KLineEntity> data) {
        if (data != null && !data.isEmpty()) {
            datas.addAll(0, data);
            notifyDataSetChanged();
        }
    }

    /**
     * 改变某个点的值
     * @param position 索引值
     */
    public void changeItem(int position,KLineEntity data)
    {
        datas.set(position,data);
        notifyDataSetChanged();
    }


}
