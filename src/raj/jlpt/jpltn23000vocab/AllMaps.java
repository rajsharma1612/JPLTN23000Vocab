package raj.jlpt.jpltn23000vocab;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import android.content.Context;

public class AllMaps {
	ArrayList<String> engListaraary = null;
	ArrayList<String> kanjiListaraary = null;
	ArrayList<String> romajiListaraary = null;
	InputStream inputStream = null;
	Scanner scr = null;
	MainActivity mn;
	AllMaps acdp = null;
	Context c;
	boolean loaded=false;
	static public long secs=0l;

	public AllMaps(Context c) {
		this.c = c;

		getKanji();

		getEnglish();
		getRomaji();
		
	}

	public AllMaps() {

	}

	public AllMaps getInstance() {
		return new AllMaps();
	}

	public void getRomaji() {
		// TODO Auto-generated method stub
		ArrayList<String> aa = new ArrayList<String>();

		inputStream = c.getResources().openRawResource(R.raw.romaji);
		scr = new Scanner(inputStream);

		while (scr.hasNext()) {
			String string = scr.nextLine();
			aa.add(string);
			
			
		}
		scr.close();

		romajiListaraary = aa;
		inputStream = null;
	}

	public void getEnglish() {
		// TODO Auto-generated method stub
		ArrayList<String> aa = new ArrayList<String>();

		inputStream = c.getResources().openRawResource(R.raw.english2);
		scr = new Scanner(inputStream);

		while (scr.hasNext()) {
			String string = scr.nextLine();
			aa.add(string);
		
		}
		scr.close();
		loaded=true;

		engListaraary = aa;
		inputStream = null;
		
	}

	public void getKanji() {
		// TODO Auto-generated method stub
		ArrayList<String> aa = new ArrayList<String>();

		inputStream = c.getResources().openRawResource(R.raw.kanji);
		scr = new Scanner(inputStream);

		while (scr.hasNext()) {
			String string = scr.nextLine();
			aa.add(string);
		}
		scr.close();

		kanjiListaraary = aa;
		inputStream = null;

	}

}
