package br.com.programmers.animasom_alegria;

import java.io.IOException;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.View;

public class AnimationManager {

	private final long DEFAULT_TIMER_INTERVAL = 100;

	private boolean _running;
	private MediaPlayer _player;
	private Handler _timerHandler;
	private View _image1 = null;
	private View _image2 = null;
	private String _assetName = null;
	private Context _currentContext = null;
	
	/* Constructor */
	public AnimationManager(Context context, View image1, View image2, String assetName) {
		this._currentContext = context;
		this._image1 = image1;
		this._image2 = image2;
		this._assetName = assetName;
		this._running = false;
		
        this._timerHandler = new Handler();
        this._player = new MediaPlayer();
		
    	this.initializeVisibilityState();
    	this.initializeMediaPlayer();
	}
	
	/* Animate methods */
	public boolean getIsRunning() {
		return this._running;
	}
	
    public void stopAnimantion() {
    	// Cancel new events
    	this._timerHandler.removeCallbacks(this._updateUI);
    	
		// Restore initial UI state
		this.initializeVisibilityState();
		
		this._running = false;
    }
    
    public void startAnimation() {
    	this._running = true;

    	// Set update UI timer
    	this._timerHandler.removeCallbacks(this._updateUI);
    	this._timerHandler.postDelayed(this._updateUI, 0);

    	// Play media
    	this._player.start();
    }

    /* Timer callback */
    private Runnable _updateUI = new Runnable() {
    	public void run() {
    		if (_player.isPlaying()) {
    			switchVisibility();
    			_timerHandler.postDelayed(_updateUI, DEFAULT_TIMER_INTERVAL);
    		}
    		else {
    			stopAnimantion();
    		}
    	}
    };
 
    /* Private Helper Methods */
    private void initializeVisibilityState() {
    	this._image1.setVisibility(View.VISIBLE);
    	this._image2.setVisibility(View.GONE);
    }
    
    private void switchVisibility() {
    	int oldVisibility = this._image1.getVisibility();
    	this._image1.setVisibility(this._image2.getVisibility());
    	this._image2.setVisibility(oldVisibility);
    }
    
    private void initializeMediaPlayer() {
		try {
			AssetFileDescriptor descriptor = this._currentContext.getAssets().openFd(this._assetName);
	    	
			this._player.setDataSource(
	    			descriptor.getFileDescriptor(), 
	    			descriptor.getStartOffset(), 
	    			descriptor.getLength());
	    	
	    	descriptor.close();
	    	
	    	this._player.prepare();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
