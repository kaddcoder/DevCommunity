package cat.urv.deim.asm.p3.shared;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.Objects;

import cat.urv.deim.asm.R;
import cat.urv.deim.asm.libraries.commanagerdc.models.CalendarItem;
import cat.urv.deim.asm.libraries.commanagerdc.providers.DataProvider;

public class CalendarDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_detail);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);

        int position = getIntent().getExtras().getInt("CARD_POS");
        DataProvider dataProvider = DataProvider.getInstance(this,R.raw.faqs,R.raw.news,R.raw.articles,R.raw.events,R.raw.calendar);

        CalendarItem calendarItem = dataProvider.getCalendar().get(position);

        ImageView image = findViewById(R.id.calendar_img);
        TextView name = findViewById(R.id.calendar_name);
        TextView date = findViewById(R.id.calendar_date);
        TextView place = findViewById(R.id.calendar_place);
        TextView description = findViewById(R.id.calendar_description);

        Picasso.get().load(calendarItem.getImageURL()).into(image);
        name.setText(calendarItem.getName());
        date.setText(calendarItem.getDate());
        place.setText(calendarItem.getVenue());
        description.setText(calendarItem.getDescription());
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
