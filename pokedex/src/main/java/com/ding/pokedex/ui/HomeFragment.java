package com.ding.pokedex.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ding.pokedex.R;
import com.ding.pokedex.adapter.HomeRyAdapter;
import com.ding.pokedex.adapter.NewsAdapter;
import com.ding.pokedex.databinding.FragmentHomeBinding;
import com.ding.pokedex.viewmodel.HomeFragmentViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final String TAG = "PokeDex: ";

    private String mParam1;
    private String mParam2;
    private HomeFragmentViewModel viewModel;
    private FragmentHomeBinding homeBinding;

    public HomeFragment() {
        // Required empty public constructor
    }

    static int count = 0 ;
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        count = 0;
        Log.i(TAG, "onCreate: "+ count+"次数");
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        count++;
        Log.i(TAG, "onCreateView: "+ count+"次数");
        homeBinding = FragmentHomeBinding.inflate(inflater, container, false);
//        return inflater.inflate(R.layout.fragment_home, container, false);
        homeBinding.ryMenu.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        ViewModelProvider viewModelProvider = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new HomeFragmentViewModel();
            }
        });
        viewModel = viewModelProvider.get(HomeFragmentViewModel.class);


        getActivity().getWindow().setStatusBarColor(getResources().getColor(R.color.red));
        return homeBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //menu
        HomeRyAdapter homeRyAdapter = new HomeRyAdapter(viewModel.getData());
        homeBinding.ryMenu.setAdapter(homeRyAdapter);

        //news
        NewsAdapter newsAdapter = new NewsAdapter(viewModel.getNewsData());
        homeBinding.ryViewNews.setAdapter(newsAdapter);

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                NavHostFragment.findNavController(HomeFragment.this).navigate(R.id.action_homeFragment_to_newsDetailFragment);
//                count++;
//                Log.i(TAG, "onActivityCreated: "+ count+"次数");
//            }
//        },2000);

    }
}