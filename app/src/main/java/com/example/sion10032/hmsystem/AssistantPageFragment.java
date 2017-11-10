package com.example.sion10032.hmsystem;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class AssistantPageFragment extends Fragment {

    LinearLayout mLinearLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_assistant_page, container, false);
        mLinearLayout = view.findViewById(R.id.CardInfo_Layout);

        TextView tmp;
        for(int i = 0; i < 10; ++i) {
            tmp = new TextView(getContext());
            tmp.setText("TextView #" + i + ".");
            addCardInfo(tmp);
        }
        return view;
    }

    public void addCardInfo(View view){
        mLinearLayout.addView(view, 0);
    }
}
