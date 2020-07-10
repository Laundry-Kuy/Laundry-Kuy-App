package com.example.laundrykuy.Status;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.laundrykuy.Mencuci.Member;
import com.example.laundrykuy.R;

import java.util.ArrayList;
import java.util.List;

public class StatusMainActivity extends RecyclerView.Adapter<StatusMainActivity.MyViewHolder> {
    private List<Member> LabList;
    private Activity mActivity;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout rl_layout;
        public TextView tv_nama,tv_tanggal,tv_status;

        public MyViewHolder(View view){
            super(view);
            rl_layout = view.findViewById(R.id.status_layout);
            tv_nama = view.findViewById(R.id.tv_nama);
            tv_tanggal = view.findViewById(R.id.tv_tanggal);
            tv_status = view.findViewById(R.id.tv_status);



        }
    }

    public StatusMainActivity(ArrayList<Member> LabList, Activity activity){
        this.mActivity = activity;
        this.LabList = LabList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_status,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Member lab = LabList.get(position);
        holder.tv_nama.setText(lab.getAtas_nama());
        holder.tv_tanggal.setText(lab.getTanggal_laundry());
        holder.tv_status.setText(lab.getStatus_pakaian());



    }

    @Override
    public int getItemCount() {
        return LabList.size();
    }

}

