package com.padc.aml.w4_ex.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.padc.aml.w4_ex.R;
import com.padc.aml.w4_ex.W4ExApp;
import com.padc.aml.w4_ex.adapters.JobItemAdapter;
import com.padc.aml.w4_ex.data.models.JobModel;
import com.padc.aml.w4_ex.data.vos.JobVO;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link JobSearchFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link JobSearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JobSearchFragment extends Fragment {

    private JobItemAdapter mJobItemAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_INDEX = "index";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private int mIndex;

    private OnFragmentInteractionListener mListener;

    public JobSearchFragment() {
        // Required empty public constructor
    }

    public static JobSearchFragment newInstance(int index) {
        JobSearchFragment fragment = new JobSearchFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_INDEX, index);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment JobSearchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static JobSearchFragment newInstance(String param1, String param2) {
        JobSearchFragment fragment = new JobSearchFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mJobItemAdapter = new JobItemAdapter(JobModel.getInstance().getJobList(), mJobItemController);

        if (getArguments() != null) {
            mIndex = getArguments().getInt(ARG_INDEX);
            //mParam1 = getArguments().getString(ARG_PARAM1);
            //mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_job_search, container, false);

        RecyclerView rvEvent = (RecyclerView) view.findViewById(R.id.rv_events);
        rvEvent.setAdapter(mJobItemAdapter);
        rvEvent.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        final SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 3000);
            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof ControllerJobItem){
            mJobItemController = (ControllerJobItem) context;
        }
        else{
            throw new RuntimeException("Activity is not implementing required controller for JobSearchFragment");
        }
        /*
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
        */
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private ControllerJobItem mJobItemController;
    public interface ControllerJobItem {
        void onTapEvent(JobVO job);
        void onFragmentChange();
    }
}
