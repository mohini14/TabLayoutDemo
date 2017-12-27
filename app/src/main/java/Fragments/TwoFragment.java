package Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.mohini.tablayoutdemo.R;

import adapters.GridViewAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class TwoFragment extends Fragment {


    public TwoFragment() {
        // Required empty public constructor
    }


    private void setGridView(){
        GridView gridView = (GridView) getView().findViewById(R.id.grid_view);

        if(gridView != null)
            gridView.setAdapter(new GridViewAdapter(this.getActivity()));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        setGridView();
    }
}
