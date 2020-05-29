package cat.urv.deim.asm.p3.shared;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;
import java.util.Objects;

import cat.urv.deim.asm.R;
import cat.urv.deim.asm.libraries.commanagerdc.models.Faq;
import cat.urv.deim.asm.libraries.commanagerdc.providers.DataProvider;

public class FaqsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqs);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);

        RecyclerView recycler = findViewById(R.id.recycler_faqs);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        //Load data from commanagerdc
        DataProvider dataProvider = DataProvider.getInstance(Objects.requireNonNull(this).getApplicationContext(),R.raw.faqs,R.raw.news,R.raw.articles,R.raw.events,R.raw.calendar);

        List<Faq> faqsList = dataProvider.getFaqs();

        FaqsAdapter listAdapter = new FaqsAdapter(faqsList);
        recycler.setAdapter(listAdapter);
        recycler.setHasFixedSize(true);

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
