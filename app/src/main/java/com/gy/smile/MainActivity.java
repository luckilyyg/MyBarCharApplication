package com.gy.smile;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private BarChart mBarChart;
    private BarData mBarData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initBarChart();
    }

    private void initView() {
        mBarChart = findViewById(R.id.mBarChart);
    }

    private void initData() {
        //叠加条形图

        ArrayList<BarEntry> yValues = new ArrayList<>();
        yValues.add(new BarEntry(0, new float[]{10,20,30}));
        yValues.add(new BarEntry(1, new float[]{100,20,80}));
        yValues.add(new BarEntry(2, new float[]{10,80,60}));
        yValues.add(new BarEntry(3, new float[]{170,20,8}));
        yValues.add(new BarEntry(4, new float[]{70,4,30}));
        yValues.add(new BarEntry(5, new float[]{90,20,15}));
        yValues.add(new BarEntry(6, new float[]{30,60,60}));
        yValues.add(new BarEntry(7, new float[]{10,10,30}));
        yValues.add(new BarEntry(8, new float[]{1,2,3}));
        yValues.add(new BarEntry(9, new float[]{10,45,30}));
        yValues.add(new BarEntry(10, new float[]{50,60,30}));
        yValues.add(new BarEntry(11, new float[]{20,20,20}));
//        for (int x = 0; x < 12; x++) {
//            float y = (float) (Math.random() * 30) + 10;
//            float y2 = (float) (Math.random() * 30) + 10;
//            float y3 = (float) (Math.random() * 30) + 10;
//            // 同一个x  不同 y 值。
//            yValues.add(new BarEntry(x, new float[]{y, y2, y3}));
//        }

        // y 轴数据集
        BarDataSet barDataSet = new BarDataSet(yValues, "");
        // 设置 对应数据 颜色
        barDataSet.setColors(Color.RED, Color.GREEN, Color.BLUE);
        barDataSet.setStackLabels(new String[]{""});
        barDataSet.setDrawValues(false);


//        barDataSet.setStackLabels(new String[]{"说明1","说明2","说明3"});
        mBarData = new BarData(barDataSet);


        //普通条形图
//        ArrayList<BarEntry> yValues = new ArrayList<>();
//
//        for (int x = 0; x < 12; x++) {
//            float y = (float) (Math.random() * 30) + 10;
//            // 同一个x  不同 y 值。
//            yValues.add(new BarEntry(x,y));
//        }
//
//        // y 轴数据集
//        BarDataSet barDataSet = new BarDataSet(yValues, "我是Label");
//        // 设置 对应数据 颜色
//        barDataSet.setColors(Color.RED);
//        barDataSet.setStackLabels(new String[]{"说明1"});
//        mBarData = new BarData(barDataSet);
    }

    private void initBarChart() {
        mBarChart.setData(mBarData);
        Legend le = mBarChart.getLegend();
//        le.setFormSize(10f); //图例大小
//        le.setForm(Legend.LegendForm.CIRCLE); //图例形状
//        //设置说明文字的大小和颜色
//        le.setTextSize(12f);
//        le.setTextColor(Color.GRAY);
        le.setEnabled(false);
        // 设置 条形图 简介
        Description description = new Description();
        // 可以自定义 位置
        // description.setPosition(200, 200);
        // 也可以 根据 X 轴，Y 轴进行偏移量设置
//        description.setXOffset(50f);
//        description.setYOffset(10f);
        description.setText("");
//
        mBarChart.setDescription(description);
        // 设置 是否可以缩放
        mBarChart.setScaleEnabled(false);

        // 设置 柱子的宽度
//         mBarData.setBarWidth(2f);

        // 获取 x 轴
        XAxis xAxis = mBarChart.getXAxis();

        // 设置 x 轴显示位置
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        // 取消 垂直 网格线
        xAxis.setDrawGridLines(false);
        // 设置 x 轴 坐标旋转角度
//        xAxis.setLabelRotationAngle(10f);
        // 设置 x 轴 坐标字体大小
        xAxis.setTextSize(10f);
        // 设置 x 坐标轴 颜色
//        xAxis.setAxisLineColor(Color.RED);
        xAxis.setAxisLineColor(Color.TRANSPARENT);
        // 设置 x 坐标轴 宽度
        xAxis.setAxisLineWidth(1f);
        //X轴最小值
        //xAxis.setAxisMinimum(1f);
        xAxis.setGranularity(1f);
        xAxis.setLabelCount(12);  // 设置 x轴 的刻度数量
        // xAxis.setCenterAxisLabels(true);//设置标签居中
        xAxis.setValueFormatter(new IndexAxisValueFormatter(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));


        // 获取 右边 y 轴
        YAxis mRAxis = mBarChart.getAxisRight();
        // 隐藏 右边 Y 轴
        mRAxis.setEnabled(false);

        // 获取 左边 Y轴
        YAxis mLAxis = mBarChart.getAxisLeft();
        mLAxis.setEnabled(false);
        // 取消 左边 Y轴 坐标线
        mLAxis.setDrawAxisLine(false);
        // 取消 横向 网格线
        mLAxis.setDrawGridLines(false);
        // 设置 Y轴 的刻度数量
        mLAxis.setLabelCount(10);
        //Y轴最小值
        mLAxis.setAxisMinimum(0f);
    }
}
