package com.example.pecpec.Students.NavigationAdmissionForm;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pecpec.FullImagerActivity;
import com.example.pecpec.R;
import com.example.pecpec.Staffs.Admission.AdmissionStaffData;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class NavLateralAdapter extends RecyclerView.Adapter<NavLateralAdapter.ViewHolder> {



    private List<AdmissionStaffData> list;
    private Context context;
    private String category;

    public NavLateralAdapter(List<AdmissionStaffData> list, Context context, String category) {
        this.list = list;
        this.context = context;
        this.category = category;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.nav_first_adapter1,parent,false);

        return new NavLateralAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull NavLateralAdapter.ViewHolder holder, int position) {
        AdmissionStaffData item = list.get(position);

        Glide.with(context).load(item.getStudentImage()).into(holder.ApplicantImage);

        holder.ApplicantName.setText(item.getName());
        holder.ApplicantCourse1.setText(item.getCourseSubmitted());

        holder.ApplicantImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FullImagerActivity.class);
                intent.putExtra("image",item.getStudentImage());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        private ImageView ApplicantImage;
        private TextView ApplicantName,ApplicantCourse1;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            //
            ApplicantImage=itemView.findViewById(R.id.ApplicantImage);
            ApplicantName=itemView.findViewById(R.id.ApplicantName);
            ApplicantCourse1=itemView.findViewById(R.id.ApplicantCourse1);
        }
    }
}
