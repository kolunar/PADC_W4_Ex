package com.padc.aml.w4_ex.data.models;

import com.google.gson.reflect.TypeToken;
import com.padc.aml.w4_ex.data.vos.JobVO;
import com.padc.aml.w4_ex.utils.CommonInstances;
import com.padc.aml.w4_ex.utils.JsonUtils;

import org.json.JSONException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 7/2/2016.
 */
public class JobModel {

    private static final String DUMMY_JOB_LIST = "job_list.json";
    private static JobModel objInstance;
    private List<JobVO> jobList;

    private JobModel(){
        jobList = initializeEventList();
    }

    public static JobModel getInstance(){
        if(objInstance == null) {
            objInstance = new JobModel();
        }

        return objInstance;
    }

    private List<JobVO> initializeEventList() {
        List<JobVO> jobList = new ArrayList<>();

        try {
            String dummyJobList = JsonUtils.getInstance().loadDummyData(DUMMY_JOB_LIST);
            Type listType = new TypeToken<List<JobVO>>() {
            }.getType();
            jobList = CommonInstances.getGsonInstance().fromJson(dummyJobList, listType);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jobList;
    }

    public List<JobVO> getJobList() {
        return jobList;
    }
}
