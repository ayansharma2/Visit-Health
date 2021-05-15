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
import java.util.Arrays;
import java.util.List;

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
                values.add(new Entry(1, 68));
                values.add(new Entry(2, 68));
                values.add(new Entry(3,66));
                values.add(new Entry(4,67));
                values.add(new Entry(5,66));


                LineDataSet lineDataSet=new LineDataSet(values," ");
                lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
                lineDataSet.setDrawCircles(false);
                lineDataSet.setLineWidth(3);
                lineDataSet.setDrawValues(false);
                lineDataSet.setColor(Color.parseColor("#714fff"));
                dataSets.add(lineDataSet);
                lineDataSet.setValueTextSize(9);




                ArrayList<Entry> values1=new ArrayList<>();

                values1.add(new Entry(5,66));
                values1.add(new Entry(6,65));
                values1.add(new Entry(7,63));
                LineDataSet lineDataSet1=new LineDataSet(values1,"");
                lineDataSet1.enableDashedLine(25,10,0);
                lineDataSet1.setLineWidth(3);
                lineDataSet1.setColor(Color.parseColor("#ff865c"));
                lineDataSet1.setValueTextSize(9);
                lineDataSet1.setDrawValues(false);
                lineDataSet1.setMode(LineDataSet.Mode.CUBIC_BEZIER);
                lineDataSet1.setDrawCircles(false);
                dataSets.add(lineDataSet1);
                mChart.getDescription().setEnabled(false);
                mChart.getLegend().setEnabled(false);
                YAxis yAxisRight = mChart.getAxisRight();
                yAxisRight.setEnabled(false);
                mChart.getAxisLeft().setDrawGridLines(false);
                mChart.getXAxis().setDrawGridLines(false);
                mChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);





                ArrayList<Entry> values2=new ArrayList<>();
                values2.add(new Entry(1,62));
                values2.add(new Entry(2,62));
                values2.add(new Entry(4,62));
                values2.add(new Entry(7,62));
                LineDataSet lineDataSet2=new LineDataSet(values2,"");
                lineDataSet2.enableDashedLine(25,10,0);
                lineDataSet2.setColor(Color.parseColor("#7fb2ff"));
                lineDataSet2.setDrawValues(false);
                lineDataSet2.setDrawCircles(false);
                lineDataSet2.setLineWidth(3);
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
                xAxis.setGranularity(1f);
                xAxis.setTextColor(R.color.gray);
                YAxis yAxis=mChart.getAxisLeft();
                yAxis.setTextColor(R.color.gray);
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