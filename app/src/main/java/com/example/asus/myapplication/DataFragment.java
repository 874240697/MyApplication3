package com.example.asus.myapplication;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("ValidFragment")
class DataFragment extends Fragment {
    public static final String ARGS_PAGE = "args_page";
    private int mPage;
    private TextView textView;

    public static DataFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARGS_PAGE, page);
        DataFragment fragment = new DataFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARGS_PAGE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment, container, false);
        textView = rootView.findViewById(R.id.textView);
        textView.setText("第"+(mPage+1)+"页");
        Toast.makeText(getActivity(),"第"+(mPage+1)+"页",Toast.LENGTH_SHORT).show();
        return rootView;
    }
}
