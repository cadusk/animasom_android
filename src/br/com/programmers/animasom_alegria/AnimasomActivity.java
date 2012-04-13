package br.com.programmers.animasom_alegria;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class AnimasomActivity extends Activity {
	private boolean _flip = false;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);        
    }
    
    public void ClickHandler(View view) {
    	
        View visivel;
        View escondida;

    	if (this._flip)
    	{
    		escondida = (View)this.findViewById(R.id.imageView1);
			visivel = (View)this.findViewById(R.id.imageView2);
    	}
    	else
    	{
    		escondida = (View)this.findViewById(R.id.imageView2);
			visivel = (View)this.findViewById(R.id.imageView1);    		
    	}
    	
    	visivel.setVisibility(View.VISIBLE);
    	escondida.setVisibility(View.GONE);
    	this._flip = !this._flip;
    }
}