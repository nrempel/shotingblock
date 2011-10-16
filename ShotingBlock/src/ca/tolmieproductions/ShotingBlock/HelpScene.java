package ca.tolmieproductions.ShotingBlock;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;

import android.view.KeyEvent;

/**
 * This class represents the help scene which users can access from the menu
 * screen.
 **/

public class HelpScene extends GridLayer {

	public static CCScene scene() {
		// Create a new Scene
		CCScene scene = CCScene.node();
		// Create the background layer
		CCLayer background = new HelpScene();
		// Add the background to the scene
		scene.addChild(background);
		return scene;
	}

	protected HelpScene() {
		setIsKeyEnabled(true);
	}	
	
	@Override
	public boolean ccKeyUp(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			CCDirector.sharedDirector().replaceScene(MenuScene.scene());
		}
		return true;
	}
}