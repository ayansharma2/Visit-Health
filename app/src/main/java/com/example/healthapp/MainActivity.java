package com.example.healthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.show_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog dialog = new BottomSheetDialog(MainActivity.this,R.style.CustomBottomSheetDialog);
                dialog.setContentView(R.layout.custom_dialog);
                View view=LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_dialog, (ViewGroup) getWindow().getDecorView().getRootView(),false);
                LineChart mChart=dialog.findViewById(R.id.image_view);
                mChart.setTouchEnabled(true);
                mChart.setPinchZoom(true);
                ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
                ArrayList<Entry> values = new ArrayList<>();
                values.add(new Entry(1, 50));
                values.add(new Entry(2, 65));
                values.add(new Entry(3,75));
                values.add(new Entry(4,63));
                values.add(new Entry(5,70));
                values.add(new Entry(6,60));
                values.add(new Entry(7,61));
                LineDataSet lineDataSet=new LineDataSet(values," ");
                lineDataSet.setLineWidth(3);
                lineDataSet.setColor(Color.YELLOW);
                dataSets.add(lineDataSet);
                lineDataSet.setValueTextSize(9);




                ArrayList<Entry> values1=new ArrayList<>();
                values1.add(new Entry(1,60));
                values1.add(new Entry(2,45));
                values1.add(new Entry(3,56));
                values1.add(new Entry(4,60));
                values1.add(new Entry(5,55));
                LineDataSet lineDataSet1=new LineDataSet(values1,"");
                lineDataSet1.enableDashedLine(45,10,0);
                lineDataSet1.setLineWidth(3);
                lineDataSet1.setColor(Color.GREEN);
                lineDataSet1.setValueTextSize(9);
                dataSets.add(lineDataSet1);
                mChart.getDescription().setEnabled(false);
                mChart.getLegend().setEnabled(false);
                YAxis yAxisRight = mChart.getAxisRight();
                yAxisRight.setEnabled(false);
                mChart.getAxisLeft().setDrawGridLines(false);
                mChart.getXAxis().setDrawGridLines(false);
                mChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);





                ArrayList<Entry> values2=new ArrayList<>();
                values2.add(new Entry(1,50));
                values2.add(new Entry(2,50));
                values2.add(new Entry(3,50));
                values2.add(new Entry(4,50));
                values2.add(new Entry(5,50));
                values2.add(new Entry(6,50));
                values2.add(new Entry(7,50));
                LineDataSet lineDataSet2=new LineDataSet(values2,"");
                lineDataSet2.enableDashedLine(50,10,0);
                lineDataSet2.setColor(Color.MAGENTA);
                dataSets.add(lineDataSet2);
                final ArrayList<String> xAxisLabel = new ArrayList<>();
                xAxisLabel.add("");
                xAxisLabel.add("Jan");
                xAxisLabel.add("Feb");
                xAxisLabel.add("Mar");
                xAxisLabel.add("Apr");
                xAxisLabel.add("May");
                xAxisLabel.add("Jun");
                xAxisLabel.add("Jul");
                XAxis xAxis = mChart.getXAxis();

                YAxis yAxis=mChart.getAxisLeft();
                yAxis.setValueFormatter(new ValueFormatter() {
                    @Override
                    public String getFormattedValue(float value) {
                        return String.valueOf((int)value)+"kg";
                    }
                });
                xAxis.setValueFormatter(new ValueFormatter() {
                    @Override
                    public String getFormattedValue(float value) {
                        return xAxisLabel.get((int)value-1);
                    }
                });
                LineData lineData=new LineData(dataSets);
                mChart.setData(lineData);
                //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
    }


}