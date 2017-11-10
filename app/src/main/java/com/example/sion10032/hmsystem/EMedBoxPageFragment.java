package com.example.sion10032.hmsystem;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class EMedBoxPageFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_emed_box_page, container, false);
        initRecyclerView(view);
        return view;
    }

    public void initRecyclerView(View view){
        // Get the RecyclerView
        RecyclerView mRecyclerView = view.findViewById(R.id.EMedBox_Recycler_View);

        // Set the LayoutManager of RecyclerView
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Set the Adapter
        EMedBoxAdapter mEMedBoxAdapter = new EMedBoxAdapter(getStringText());
        mRecyclerView.setAdapter(mEMedBoxAdapter);
    }

    // Create the test data
    public String[] getStringText(){
        String[] tmp = new String[50];
        for(int i = 0; i < 50; ++i){
            tmp[i] = "Med #" + i +"";
        }
        return tmp;
    }

}

class EMedBoxAdapter extends RecyclerView.Adapter<EMedBoxAdapter.ViewHolder> {
    public String[] datas = null;
    public EMedBoxAdapter(String[] datas) {
        this.datas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.med_item_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(datas[position]);
    }

    @Override
    public int getItemCount() {
        return datas.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public ViewHolder(View view){
            super(view);
            mTextView = view.findViewById(R.id.MedName);
        }
    }
}
