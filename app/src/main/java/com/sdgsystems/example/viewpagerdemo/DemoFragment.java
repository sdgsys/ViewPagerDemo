package com.sdgsystems.example.viewpagerdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DemoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DemoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DemoFragment extends Fragment {
    private static final String ARG_DATA = "data";

    private DemoData mData;
    private OnFragmentInteractionListener mListener;

    public DemoFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance(DemoData demoData) {
        Bundle args = new Bundle();
        args.putParcelable(ARG_DATA, demoData);

        Fragment f = new DemoFragment();
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mData = (DemoData) getArguments().getParcelable(ARG_DATA);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_demo, container, false);
        TextView nameView = (TextView) v.findViewById(R.id.demo_fragment_name);
        TextView descView = (TextView) v.findViewById(R.id.demo_fragment_desc);
        TextView valueView = (TextView) v.findViewById(R.id.demo_fragment_value);

        if(mData != null) {
            nameView.setText(mData.name);
            descView.setText(mData.desc);
            valueView.setText("" + mData.weight);

            if(mListener != null) {
                mListener.onFragmentCreated(this);
            }
        }
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        mListener.onFragmentResumed(this);
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

    public DemoData getData() {
        return mData;
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
        void onFragmentInteraction(int currentDataPosition);
        void onFragmentCreated(DemoFragment demoFragment);
        void onFragmentResumed(DemoFragment demoFragment);
    }
}
