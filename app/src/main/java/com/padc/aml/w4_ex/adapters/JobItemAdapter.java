package com.padc.aml.w4_ex.adapters;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.aml.w4_ex.R;
import com.padc.aml.w4_ex.W4ExApp;
import com.padc.aml.w4_ex.data.vos.JobVO;
import com.padc.aml.w4_ex.fragments.JobSearchFragment;
import com.padc.aml.w4_ex.views.holders.JobItemViewHolder;

import java.util.List;

/**
 * Created by user on 7/2/2016.
 */
public class JobItemAdapter extends RecyclerView.Adapter<JobItemViewHolder>{

    private LayoutInflater inflater;
    private List<JobVO> jobList;
    private JobSearchFragment.ControllerJobItem mJobItemController;

    public JobItemAdapter(List<JobVO> jobList, JobSearchFragment.ControllerJobItem jobItemController){
        inflater = LayoutInflater.from(W4ExApp.getContext());
        this.jobList = jobList;
        mJobItemController = jobItemController;
    }

    @Override
    public JobItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.view_item_job, parent, false);
        final JobItemViewHolder jobVH = new JobItemViewHolder(view, mJobItemController);
        return jobVH;
    }

    @Override
    public void onBindViewHolder(JobItemViewHolder holder, int position) {
        holder.setData(jobList.get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
