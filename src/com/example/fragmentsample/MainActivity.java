package com.example.fragmentsample;

import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends Activity implements
View.OnClickListener
{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment())
					.commit();
		}
	}

	@Override
	public void onClick(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TODO 自動生成されたメソッド・スタブ
		
	}
	
	public static class PageListFragment extends ListFragment {
		boolean mTwoPane;
		int mCurCheckPosition = 0;
	}
	
	public static final String[][] PAGELIST = {
		{"タイトル","河口湖","伊藤左千夫"},
		{"ページ1","段ばしごがギチギチ音がする。まもなくふすまがあく。" +
		"茶盆をふすまの片辺(かたべ)へおいて、すこぶるていねいにおじぎをした女は宿の娘らしい"},
		{"ページ2","富士のすそ野を見るものはだれもおなじであろう、かならずみょうに隔世的夢幻(かくせいてきむげん)の感に" +
		"うたれる。この朝予は吉田の駅をでて、とちゅう畑のあいだの森のかげに絹織の梭(ひ)の音を聞きつつ、"},
		{"ページ3","予はふかくこの夢幻の感じに酔うて、河川湖畔の舟津(ふなづ)へいでた。" +
		"また湖水の深沈(しんちん)としずかなありさまやが、ことごとく夢中の光景としか思えない"},
		{"ページ4","予の口がおもいせいか、娘はますますかたい。予はことばをおしだすようにして、" +
		"夏になればずいぶん東京あたりから人がきますか、"},
		
	};

	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		List<String>alist = new ArrayList<String>();
		for (String[] pagelist : PAGELIST){
			alist.add(pagelist[0]);
		}
		setListAdapter(new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_activated_1, alist));
		
		View datailsFrame = getActivity().findViewById(R.id.details);
			mTwoPane = detaqilsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;
	}
	
	/*
	 @Override
	 public void onSaveInstanceState(Bundle outState){
	 	super.onSaveInstanceState(outState);
	 }
	 */
	
	public void onListItemClick(ListView 1, View v, int position, long id) {
		String contents = PAGELIST[position][1];
		showDetails(contents);
	}
	void showDetails(String contents){
		if(mTwoPane) {
			DetailsActivity.DetailsFragment fragment =
					DetailsActivity.DetailsFragment.newInstance(contents);
			FragmentTransaction ft = getFragmentManager().beginTransaction();
			ft.replace(R.id.details,fragment);
			ft.commit();
		}else{
			Intent intent = new Intent();
			intent.setClass(getActivity(), DetailsActivity.class);
			intent.putExtra("contents",contents);
			startActivity(intent);
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container, false);
			return rootView;
		}
	}

}
