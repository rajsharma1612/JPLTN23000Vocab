package raj.jlpt.jpltn23000vocab;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {
	//Thread t = null;
	//AllMaps ap = null;
	//ArrayList<String> databaseList = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_layout);
		
		new Handler().postDelayed(new Thread() {
			@Override
			public void run() {
				Intent it = new Intent(SplashActivity.this, MainActivity.class);
				startActivity(it);
			finish();
			}
			}, 5000);
		//ap = new AllMaps(getApplicationContext());
		//databaseList = ap.kanjiListaraary;

		//t = new Thread(this);
		//t.start();
	/*synchronized (t) {
			try {
				t.wait();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		*/
		

	}

	/*@Override
	public void run() {
		// TODO Auto-generated method stub

		//KanjiListHandler kj = new KanjiListHandler(getApplicationContext());
		//for (int i = 0; i <10; i++) {
			//kj.AddKanji(databaseList.get(i));
		//}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Intent it = new Intent(SplashActivity.this, MainActivity.class);
		startActivity(it);
		//t.notify();

		finish();

	}
*/
}
