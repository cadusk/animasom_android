package br.com.programmers.animasom_alegria;

import android.content.Context;
import android.view.View;

public class AnimationManager {

	private boolean _flip = false;
	private View _view1, _view2;
	
	public AnimationManager(Context contex, View iv1, View iv2) {
		this._view1 = iv1;
		this._view2 = iv2;
	}

	public void StartAnimation() {
        View visivel;
        View escondida;

    	if (this._flip)
    	{
    		escondida = this._view1;
			visivel = this._view2;
    	}
    	else
    	{
    		visivel = this._view1;
			escondida = this._view2;
    	}
    
    	visivel.setVisibility(View.VISIBLE);
    	escondida.setVisibility(View.GONE);
    	this._flip = !this._flip;
	}

}
