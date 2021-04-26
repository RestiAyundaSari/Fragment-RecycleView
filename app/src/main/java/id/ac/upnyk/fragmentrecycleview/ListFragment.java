package id.ac.upnyk.fragmentrecycleview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<KontakModel> list=new ArrayList<>();

    public ListFragment(){
        
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rcv);
        recyclerView.setHasFixedSize(true);
        list.addAll(KontakData.getKontakList());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        KontakAdapter kontakAdapter = new KontakAdapter(KontakData.getKontakList(),getActivity());
        recyclerView.setAdapter(kontakAdapter);
    }

    }

