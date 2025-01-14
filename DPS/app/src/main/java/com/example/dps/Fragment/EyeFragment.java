package com.example.dps.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dps.R;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.models.BarModel;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EyeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EyeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EyeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EyeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EyeFragment newInstance(String param1, String param2) {
        EyeFragment fragment = new EyeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    View view;
    BarChart eyechart;
    String user_id;
    String[] time;
    int[] is_sleep;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_eye, container, false);
        Bundle bundle = getArguments();

        if (bundle != null) {
            user_id = bundle.getString("user_id"); //Name 받기.
            time = bundle.getStringArray("time");
            is_sleep = bundle.getIntArray("is_sleep");
            System.out.println("EyeFragment: "+user_id); //확인

            for(int i=0;i<time.length;i++){
                System.out.println( (i + 1) + "time : "+time[i]);
                System.out.println( (i + 1) + "is_sleep" + is_sleep[i]);
            }
        }
        initView(view);
        return view;
    }

    public void initView(View v){
        eyechart = (BarChart) v.findViewById(R.id.eyechart);
        setBarChart();
    }

    // 막대 차트 설정
    private void setBarChart() {

        eyechart.clearChart();

        for(int i=0;i<time.length;i++){
            eyechart.addBar(new BarModel(time[i].substring(11, 16), is_sleep[i], 0xFF56B7F1));
        }

        eyechart.startAnimation();

    }

}