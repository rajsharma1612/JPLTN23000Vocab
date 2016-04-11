package raj.jlpt.jpltn23000vocab;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RomajiActivity extends Activity {
	ListView rom_listView = null;

	AllMaps amp;
	Bundle b;
	Intent i;
	ArrayList<String> romEngLust = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.romaji_layout);
		rom_listView = (ListView) findViewById(R.id.romaji_listView1);
		amp = new AllMaps();
		// TODO Auto-generated method stub
		romEngLust = new ArrayList<String>();
		i = getIntent();
		amp = new AllMaps();
		b = i.getExtras();
		String kanji = b.getString("Kanji");
		String romaji = b.getString("Romaji");
		String english = b.getString("English");

		romEngLust.add(kanji);

		romEngLust.add(romaji);

		romEngLust.add(english);

		ArrayAdapter<String> romaa = new ArrayAdapter<String>(
				getApplicationContext(), android.R.layout.simple_list_item_1,
				romEngLust);
		romaa.notifyDataSetChanged();
		rom_listView.setAdapter(romaa);
		;

	}
}
