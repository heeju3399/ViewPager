package org.techtown.viewpager;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Vector;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment2 extends Fragment {



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "dd";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragment2() {
        // Required empty public constructor
        
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment2 newInstance(String param1, String param2) {
        BlankFragment2 fragment = new BlankFragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank2, container, false);
        final WebView wb = view.findViewById(R.id.wb);
        wb.setWebViewClient(new WebViewClient());
        final WebSettings webSettings = wb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        final SearchURL url = new SearchURL();
        //btn
        Button[] buttons = new Button[3];
        buttons[0] = view.findViewById(R.id.btndaum);
        buttons[1] = view.findViewById(R.id.btnnaver);
        buttons[2] = view.findViewById(R.id.btngoggle);

        final String[] urlA = new String[3];
        urlA[0] = url.daum();
        urlA[1] = url.naver();
        urlA[2] = url.google();

        for(int i=0; i<buttons.length; i++){
            final int finalI = i;
            buttons[finalI].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    wb.loadUrl(urlA[finalI]);
                }
            });
        }
      return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "블랜크 프래그먼트의 온 액티비티 크래이트");
        super.onActivityCreated(savedInstanceState);
    }
}