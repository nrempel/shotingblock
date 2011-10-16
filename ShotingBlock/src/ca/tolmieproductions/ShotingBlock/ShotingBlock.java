package ca.tolmieproductions.ShotingBlock;

import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.opengl.CCGLSurfaceView;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;

/**
 * This class initializes anything related to android and hooks key android
 * events into the cocos2d-android engine.
 **/

public class ShotingBlock extends Activity {

	CCGLSurfaceView _glSurfaceView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Set visual style before inflating view
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
				WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		_glSurfaceView = new CCGLSurfaceView(this);
		// Inflate view
		setContentView(_glSurfaceView);
	}

	@Override
	protected void onStart() {
		super.onStart();
		// Set view and frame rate
		CCDirector.sharedDirector().attachInView(_glSurfaceView);
		CCDirector.sharedDirector().setAnimationInterval(1.0f / 60.0f);
		// First scene is the menu scene
		CCScene scene = MenuScene.scene();
		CCDirector.sharedDirector().runWithScene(scene);
	}

	/***************************************************
	 *** Hook android framework into cocos2d-android ***
	 **************************************************/

	@Override
	protected void onPause() {
		super.onStart();
		CCDirector.sharedDirector().pause();
	}

	@Override
	protected void onResume() {
		super.onResume();
		CCDirector.sharedDirector().resume();
	}

	@Override
	protected void onStop() {
		super.onStop();
		CCDirector.sharedDirector().end();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		return CCDirector.sharedDirector().onKeyDown(event);
	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		// If the back or menu key is pressed, a pause attempt is sent to the
		// pause manager
		if (keyCode == KeyEvent.KEYCODE_BACK
				|| keyCode == KeyEvent.KEYCODE_MENU) {
			PauseManager.pause();
		}
		return CCDirector.sharedDirector().onKeyUp(event);
	}
}