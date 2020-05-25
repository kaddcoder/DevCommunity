package cat.urv.deim.asm.p2.common.ui.scheduler;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;

import cat.urv.deim.asm.p2.common.R;
import cat.urv.deim.asm.p3.shared.CalendarAdapter;
import cat.urv.deim.asm.p3.shared.CalendarEntry;

public class SchedulerFragment extends Fragment {

    private SchedulerViewModel toolsViewModel;
    private CalendarAdapter listAdapter;
    private ArrayList<CalendarEntry> contactsList = new ArrayList<>();
    private RecyclerView recycler;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        toolsViewModel =
                ViewModelProviders.of(this).get(SchedulerViewModel.class);
        View root = inflater.inflate(R.layout.fragment_scheduler, container, false);
        recycler = root.findViewById(R.id.recycler_scheduler);

        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));

        contactsList.add(new CalendarEntry("WTM Tarragona 2020", "Secondary line text Lorem ipsum dolor sit amet", "Photo1", "Tarragona, 6 Oct 2020"));
        contactsList.add(new CalendarEntry("Col·laboració 3DActivistes", "Secondary line text Lorem ilde", "Photo2", "Reus, 15 Oct 2020"));

        listAdapter = new CalendarAdapter(contactsList);
        recycler.setAdapter(listAdapter);

        return root;
    }
}