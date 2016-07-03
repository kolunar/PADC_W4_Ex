package com.padc.aml.w4_ex.views.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.padc.aml.w4_ex.W4ExApp;
import com.padc.aml.w4_ex.data.vos.JobVO;
import com.padc.aml.w4_ex.fragments.JobSearchFragment;

/**
 * Created by user on 7/2/2016.
 */
public class JobItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private JobVO mJob;
    private JobSearchFragment.ControllerJobItem mJobItemController;

    public JobItemViewHolder(View view, JobSearchFragment.ControllerJobItem jobItemController){
        super(view);
        view.setOnClickListener(this);
        mJobItemController = jobItemController;
    }

    public void setData(JobVO job){
        mJob = job;
    }

    @Override
    public void onClick(View view) {
        mJobItemController.onTapEvent(mJob);
        //Toast.makeText(W4ExApp.getContext(), "onTapEvent", Toast.LENGTH_SHORT).show();
    }
}
