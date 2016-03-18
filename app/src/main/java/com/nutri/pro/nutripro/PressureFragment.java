package com.nutri.pro.nutripro;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PressureFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PressureFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PressureFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_DATE = "DATE";
    private static final String ARG_PULSE = "PULSE";
    private static final String ARG_SYSTOLIC = "SYSTHOLIC";
    private static final String ARG_DIATHOLIC = "DIATHOLIC";
    private static final String TAG = "pressure";

    // TODO: Rename and change types of parameters

    private Date mDate;
    private int mSystolic;
    private int mDiatholic;
    private int mPulse;

    private OnFragmentInteractionListener mListener;

    public PressureFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment PressureFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PressureFragment newInstance(Date date, int systolic, int diatholic, int pulse) {
        PressureFragment fragment = new PressureFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_DATE, date);
        args.putInt(ARG_SYSTOLIC, systolic);
        args.putInt(ARG_DIATHOLIC, diatholic);
        args.putInt(ARG_PULSE, pulse);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mDate = (Date) getArguments().getSerializable(ARG_DATE);
            mSystolic = getArguments().getInt(ARG_SYSTOLIC);
            mDiatholic = getArguments().getInt(ARG_DIATHOLIC);
            mPulse = getArguments().getInt(ARG_PULSE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_pressure, container, false);
        Button saveButton = (Button) fragmentView.findViewById(R.id.buttonSave);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSave(v);
            }
        });

        return fragmentView;
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
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
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

    private void onSave(View v) {
        Log.i(TAG, "A Click button from a fragment");
    }
}
