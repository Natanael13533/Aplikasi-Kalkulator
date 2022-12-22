package com.example.aplikasikalkulator;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class KalkulatorAdapter extends RecyclerView.Adapter<KalkulatorAdapter.ViewHolder> {

    public ArrayList<Kalkulator> listKalkulator;
    private Context context;

    public KalkulatorAdapter(ArrayList<Kalkulator> listKalkulator, Context context) {
        this.listKalkulator = listKalkulator;
        this.context = context;
    }

    @NonNull
    @Override
    public KalkulatorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder holder = new ViewHolder(inflater.inflate(R.layout.view_item, parent,false));

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull KalkulatorAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Kalkulator kalkulator = listKalkulator.get(position);
        holder.txtAngka1.setText(kalkulator.getNum1());
        holder.txtAngka2.setText(kalkulator.getNum2());
        holder.txtOperator.setText(kalkulator.getOperator());
        holder.txtHasil.setText(kalkulator.getResult());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(v.getContext())
                        .setTitle("Hapus histori?")
                        .setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                listKalkulator.remove(position);
                                MainActivity.reloadData(v.getContext());
                            }
                        })
                        .setPositiveButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return listKalkulator.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView txtAngka1,txtAngka2,txtOperator,txtHasil;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtAngka1 = (TextView) itemView.findViewById(R.id.txtAngka1);
            txtAngka2 = (TextView) itemView.findViewById(R.id.txtAngka2);
            txtOperator = (TextView) itemView.findViewById(R.id.txtOperator);
            txtHasil = (TextView) itemView.findViewById(R.id.textHasil);
        }
    }
}
