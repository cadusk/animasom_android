package br.com.programmers.animasom_alegria;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class AnimasomActivity extends Activity {
	AnimationManager _am = null;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        View view1 = this.findViewById(R.id.imageView1);
        View view2 = this.findViewById(R.id.imageView2);
        
        this._am = new AnimationManager(this.getBaseContext(), view1, view2);
    }
    
    public void ClickHandler(View view) {
    	this._am.StartAnimation();
    }
}