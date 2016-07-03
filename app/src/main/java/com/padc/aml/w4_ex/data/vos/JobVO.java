package com.padc.aml.w4_ex.data.vos;

import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by user on 7/2/2016.
 */
public class JobVO {

    private static final SimpleDateFormat sdfJobTimeReceive = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
    private static final SimpleDateFormat sdfJobStartTime = new SimpleDateFormat("EEEE, MMM dd, hh:mm aa");
    private static final SimpleDateFormat sdfJobEndTime = new SimpleDateFormat("hh:mm aa");

    @SerializedName("job_title")
    private String jobTitle;

    @SerializedName("stock_photo")
    private String stockPhotoPath;

    @SerializedName("job_desc")
    private String jobDesc;

    @SerializedName("start_time")
    private String startTimeText;

    @SerializedName("end_time")
    private String endTimeText;

    public JobVO(String jobTitle, String stockPhotoPath, String jobDesc, String startTimeText, String endTimeText) {
        this.jobTitle = jobTitle;
        this.stockPhotoPath = stockPhotoPath;
        this.jobDesc = jobDesc;
        this.startTimeText = startTimeText;
        this.endTimeText = endTimeText;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getStockPhotoPath() {
        return stockPhotoPath;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public String getStartTimeText() {
        return startTimeText;
    }

    public String getEndTimeText() {
        return endTimeText;
    }

    public String getJobTime() {
        try {
            Date startDateTime = sdfJobTimeReceive.parse(startTimeText);
            Date endDateTime = sdfJobTimeReceive.parse(endTimeText);

            return sdfJobStartTime.format(startDateTime) + " - " + sdfJobEndTime.format(endDateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
