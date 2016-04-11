package raj.jlpt.jpltn23000vocab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

public class MainActivity extends Activity {
	public AdView adView;
	public AdRequest adRequest;
	ListView listv;
	public AllMaps amp;
	KanjiListHandler kj = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listv = (ListView) findViewById(R.id.listView1);

		adView = (AdView) findViewById(R.id.ad);
		adView.setAdUnitId("ca-app-pub-7895463058195094/3813188762");
		adView.setAdSize(AdSize.BANNER);

		adRequest = new AdRequest.Builder().addTestDevice(
				AdRequest.DEVICE_ID_EMULATOR).build();

		// Load the adView with the ad request.
		adView.loadAd(adRequest);

		amp = new AllMaps(this);
		// Toast.makeText(getApplicationContext(),kj.RetreiveKanji().get(0),
		// Toast.LENGTH_LONG).show();
		// kj=new KanjiListHandler(getApplicationContext());

		// amp = new AllMaps();
		// amp=new AllMaps(this);

		ArrayAdapter<String> aa = new ArrayAdapter<String>(
				getApplicationContext(), android.R.layout.simple_list_item_1,
				amp.kanjiListaraary);
		aa.notifyDataSetChanged();
		listv.setAdapter(aa);

		listv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub

				Intent it = new Intent(MainActivity.this, RomajiActivity.class);
				it.putExtra("Kanji", (amp.kanjiListaraary.get(arg2)));
				// it.putExtra("Index", arg2);
				it.putExtra("Romaji", amp.romajiListaraary.get(arg2));
				it.putExtra("English", amp.engListaraary.get(arg2));
				startActivity(it);
			}
		});

	}

	@Override
	public void onPause() {
		adView.pause();
		super.onPause();
	}

	@Override
	public void onResume() {
		super.onResume();
		adView.resume();
	}

	@Override
	public void onDestroy() {
		adView.destroy();
		super.onDestroy();
	}

}
