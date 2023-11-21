package com.example.dzmobilneapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BodoviFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BodoviFragment extends DialogFragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private OnCloseListener onCloseListener;
    private static final String ARG_PARAM1 = "bodovi";
    private TextView bodoviView;
    private Button closeButton;
    private int score;
    public BodoviFragment() {
        // Required empty public constructor
    }
    public static BodoviFragment newInstance(int score) {
        BodoviFragment fragment = new BodoviFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, score);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        onCloseListener = (OnCloseListener) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            score = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bodovi, container, false);
        closeButton = view.findViewById(R.id.closeButton);
        bodoviView = view.findViewById(R.id.viewBodovi);

        closeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                notifyOnClose();
                dismiss();

            }
        });

        bodoviView.setText("Bodovi: "+score);

        return view;

    }
    public void notifyOnClose(){
        onCloseListener.onFragmentClose();
    }

    public interface OnCloseListener{
        void onFragmentClose();
    }
}