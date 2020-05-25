package cat.urv.deim.asm.p3.shared;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import cat.urv.deim.asm.p2.common.R;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.CalendarHolder> {
    // List to store all the contact details
    private ArrayList<CalendarEntry> calendarList;

    // Counstructor for the Class
    public CalendarAdapter(ArrayList<CalendarEntry> calendarList) {
        this.calendarList = calendarList;
    }

    // This method creates views for the RecyclerView by inflating the layout
    // Into the viewHolders which helps to display the items in the RecyclerView
    @Override
    public CalendarAdapter.CalendarHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        // Inflate the layout view you have created for the list rows here
        View view = layoutInflater.inflate(R.layout.row_scheduler_layout, parent, false);
        return new CalendarHolder(view);
    }

    @Override
    public int getItemCount() {
        return calendarList == null? 0: calendarList.size();
    }

    // This method is called when binding the data to the views being created in RecyclerView
    @Override
    public void onBindViewHolder(@NonNull CalendarHolder holder, final int position) {
        final CalendarEntry event = calendarList.get(position);

        // Set the data to the views here
        holder.setTitleName(event.getTitle());
        holder.setSubtitleName(event.getSubtitle());
        holder.setDate(event.getDate());

        // You can set click listners to indvidual items in the viewholder here
        // make sure you pass down the listner or make the Data members of the viewHolder public

    }

    // This is your ViewHolder class that helps to populate data to the view
    public class CalendarHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView subtitle;
        private TextView date;


        public CalendarHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title_scheduler);
            subtitle = itemView.findViewById(R.id.subtitle_scheduler);
            date = itemView.findViewById(R.id.date);
        }

        public void setTitleName(String title) {
            this.title.setText(title);
        }

        public void setSubtitleName(String subtitle) {
            this.subtitle.setText(subtitle);
        }

        public void setDate(String date) { this.date.setText(date.toString());}
    }

}
