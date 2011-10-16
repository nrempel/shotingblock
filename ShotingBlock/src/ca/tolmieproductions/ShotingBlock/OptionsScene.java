package ca.tolmieproductions.ShotingBlock;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;

import android.view.KeyEvent;

/**
 * This class represents the options screen that can be accessed from the title
 * screen or the pause menu.
 **/

public class OptionsScene extends GridLayer {

	public static CCScene scene() {
		// Create new scene
		CCScene scene = CCScene.node();
		// Create background layer
		CCLayer background = new OptionsScene();
		// Add the background layer to the scene
		scene.addChild(background);
		return scene;
	}

	protected OptionsScene() {
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
