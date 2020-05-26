package cat.urv.deim.asm.p2.common.ui.scheduler;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Objects;

import cat.urv.deim.asm.R;
import cat.urv.deim.asm.libraries.commanagerdc.models.CalendarItem;
import cat.urv.deim.asm.libraries.commanagerdc.providers.DataProvider;
import cat.urv.deim.asm.p3.shared.CalendarAdapter;

public class SchedulerFragment extends Fragment {

    private SchedulerViewModel toolsViewModel;
    private CalendarAdapter listAdapter;
    private List<CalendarItem> scheduleList;
    private RecyclerView recycler;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        toolsViewModel =
                ViewModelProviders.of(this).get(SchedulerViewModel.class);
        View root = inflater.inflate(R.layout.fragment_scheduler, container, false);
        recycler = root.findViewById(R.id.recycler_scheduler);

        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));


        //Load data from commanagerdc
        DataProvider dataProvider = DataProvider.getInstance(Objects.requireNonNull(getActivity()).getApplicationContext(),R.raw.faqs,R.raw.news,R.raw.articles,R.raw.events,R.raw.calendar);

        scheduleList = dataProvider.getCalendar();

        listAdapter = new CalendarAdapter(scheduleList);
        recycler.setAdapter(listAdapter);

        return root;
    }
}