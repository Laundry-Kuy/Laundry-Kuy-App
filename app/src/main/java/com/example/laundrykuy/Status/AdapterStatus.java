package com.example.laundrykuy.Status;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.laundrykuy.Mencuci.Member;
import com.example.laundrykuy.R;

import java.util.ArrayList;

public class AdapterStatus extends RecyclerView.Adapter<AdapterStatus.MyViewHolder> {
    Context context;
    ArrayList<Member> member;

    public AdapterStatus(Context c , ArrayList<Member> b) {
        context = c;
        member = b;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_status, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.tv_nama.setText(member.get(position).getAtas_nama());
        holder.tv_tanggal.setText(member.get(position).getTanggal_laundry());
        holder.tv_status.setText(member.get(position).getStatus_pakaian());
        holder.tv_antar.setText(member.get(position).getPaket_pengantaran());
        holder.tv_paket.setText(member.get(position).getPaket_laundry());
        holder.tv_jenis.setText(member.get(position).getJenis_laundry());
        holder.tv_berat.setText(member.get(position).getEstimasi_berat_pakaian());
        holder.tv_harga.setText(member.get(position).getEstimasi_tarif_laundry());
        holder.tv_alamat.setText(member.get(position).getAlamat());
     }

    @Override
    public int getItemCount() {
        return member.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView tv_nama,tv_tanggal,tv_status,tv_antar,tv_paket,tv_jenis,tv_berat,tv_harga,tv_alamat;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_nama = itemView.findViewById(R.id.tv_nama);
            tv_tanggal = itemView.findViewById(R.id.tv_tanggal);
            tv_status = itemView.findViewById(R.id.tv_status);
            tv_antar = itemView.findViewById(R.id.tv_antar);
            tv_paket = itemView.findViewById(R.id.tv_paket);
            tv_jenis = itemView.findViewById(R.id.tv_jenis);
            tv_berat = itemView.findViewById(R.id.tv_berat);
            tv_harga = itemView.findViewById(R.id.tv_harga);
            tv_alamat = itemView.findViewById(R.id.tv_alamat);

        }

    }

}

