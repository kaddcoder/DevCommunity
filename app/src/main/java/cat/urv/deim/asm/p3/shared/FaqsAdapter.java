package cat.urv.deim.asm.p3.shared;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import cat.urv.deim.asm.R;
import cat.urv.deim.asm.libraries.commanagerdc.models.CalendarItem;
import cat.urv.deim.asm.libraries.commanagerdc.models.Faq;
import cat.urv.deim.asm.libraries.commanagerdc.models.Faqs;

public class FaqsAdapter extends RecyclerView.Adapter<FaqsAdapter.FaqsHolder> {

    // List to store all the contact details
    private List<Faq> faqsList;
    private Context mContext;

    // Counstructor for the Class
    public FaqsAdapter(List<Faq> faqsList) {
        this.faqsList = faqsList;
    }

    // This method creates views for the RecyclerView by inflating the layout
    // Into the viewHolders which helps to display the items in the RecyclerView
    @Override
    public FaqsAdapter.FaqsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        mContext = parent.getContext();

        // Inflate the layout view you have created for the list rows here
        View view = layoutInflater.inflate(R.layout.expandable_list_item, parent, false);
        return new FaqsAdapter.FaqsHolder(view);
    }

    @Override
    public int getItemCount() {
        return faqsList == null? 0: faqsList.size();
    }

    // This method is called when binding the data to the views being created in RecyclerView
    @Override
    public void onBindViewHolder(@NonNull final FaqsAdapter.FaqsHolder holder, final int position) {
        final Faq faq = faqsList.get(position);
        final Button faqs_btn = holder.itemView.findViewById(R.id.faqs_btn);

        // Set the data to the views here
        holder.setTitleName(faq.getTitle());
        holder.setBody(faq.getBody());
        holder.getExpandableLayout().setVisibility(View.GONE);
        faqs_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View expandable = holder.getExpandableLayout();

                if(expandable.getVisibility() == View.GONE) {
                    expandable.setVisibility(View.VISIBLE);
                    faqs_btn.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_18dp);
                } else {
                    expandable.setVisibility(View.GONE);
                    faqs_btn.setBackgroundResource(R.drawable.ic_keyboard_arrow_right_black_18dp);
                }

            }
        });

    }

    // This is your ViewHolder class that helps to populate data to the view
    public class FaqsHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView body;
        private View expandableLayout;


        public FaqsHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title_faqs);
            body = itemView.findViewById(R.id.body_faqs);
            expandableLayout = itemView.findViewById(R.id.expandable_faqs);
        }

        public void setTitleName(String title) {
            this.title.setText(title);
        }

        public void setBody(String body) {
            this.body.setText(body);
        }

        public View getExpandableLayout() { return expandableLayout; }

    }

}
