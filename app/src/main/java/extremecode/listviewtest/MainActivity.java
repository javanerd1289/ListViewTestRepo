package extremecode.listviewtest;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    //members
    private ListView listView;
    private ArrayList<ListModel> models = new ArrayList<>();
    private MyListAdapter adapter;
    private ImageView visibleImage = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);

        //add model data
        for (int i = 0; i < 250; i++) {
            models.add(new ListModel("item " + i, "" + i));
        }
        adapter = new MyListAdapter(getApplicationContext(), models);
        listView.setAdapter(adapter);

        //listview clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //check if hidden image is not null
                if (visibleImage != null) {
                    //if not null it means its consumed by click
                    //hide it
                    visibleImage.setVisibility(View.INVISIBLE);
                }

                //do for all
                //define an imageview that will be a new one
                //consume it for click
                ImageView hiddenImage = (ImageView) view.findViewById(R.id.arrow);
                hiddenImage.setVisibility(View.VISIBLE);

                //the image view is visible now
                //give hidden image to visible image, so that it gets the hidden image reference
                visibleImage = hiddenImage;
                adapter.notifyDataSetChanged();

            }
        });
    }
}
