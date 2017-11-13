package com.example.sion10032.hmsystem;


import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sion10032.hmsystem.backend.Medicine;
import com.example.sion10032.hmsystem.backend.User;

import java.util.ArrayList;
import java.util.UUID;

public class EMedBoxPageFragment extends Fragment implements View.OnClickListener {
    FloatingActionButton mFloatingActionButton;
    RecyclerView mRecyclerView;
    LinearLayoutManager mLayoutManager;
    EMedBoxAdapter mEMedBoxAdapter;
    User test;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_emed_box_page, container, false);
        initListener(view);
        initRecyclerView(view);
        return view;
    }

    public void initListener(View view){
        mFloatingActionButton = view.findViewById(R.id.addMedFab);
        mFloatingActionButton.setOnClickListener(this);
    }

    public void initRecyclerView(View view){
        // Get the RecyclerView
        mRecyclerView = view.findViewById(R.id.EMedBox_Recycler_View);

        // Set the LayoutManager of RecyclerView
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // TODO just for test, remember to delete in the future
        test = new User(UUID.fromString("550e8400-e29b-41d4-a716-446655440000"), getContext());
        Medicine med;
        for(int i = 0; i < 30; ++i){
            med = new Medicine(UUID.randomUUID(),
                    "MED #" + i,
                    "MED #" + i + "'s Description.",
                    "",
                    10,
                    false);
            test.addMed(med);
        }

        // Set the Adapter
        mEMedBoxAdapter = new EMedBoxAdapter(test);
        mRecyclerView.setAdapter(mEMedBoxAdapter);
    }

    @Override
    public void onClick(View v) {
        for(Medicine i : test.getAllMed())
            i.setDescription(i.getDescription()+" (Changed) ");

        Medicine med = new Medicine(UUID.randomUUID(),
                "MED #" + test.getAllMed().size(),
                "MED #" + test.getAllMed().size() + "'s Description.",
                "",
                10,
                false);
        test.addMed(med);
        mEMedBoxAdapter.notifyItemChanged(test.getAllMed().size());

    }
}

class EMedBoxAdapter extends RecyclerView.Adapter<EMedBoxAdapter.ViewHolder> {
    public User datas = null;
    public ArrayList<Medicine> Meds;
    public EMedBoxAdapter(User datas) {
        this.datas = datas;
        Meds = datas.getAllMed();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater
                .from(viewGroup.getContext()), R.layout.med_item_layout, viewGroup, false);
        ViewHolder vh = new ViewHolder(binding.getRoot());
        vh.setBinding(binding);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.getBinding().setVariable(com.example.sion10032.hmsystem.BR.Med,
                Meds.get(position));
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return Meds.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;

        public ViewHolder(View view){
            super(view);
        }

        public void setBinding(ViewDataBinding binding) {
            this.binding = binding;
        }

        public ViewDataBinding getBinding() {
            return this.binding;
        }

    }
}
