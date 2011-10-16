package ca.tolmieproductions.ShotingBlock;

import org.cocos2d.events.CCTouchDispatcher;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.menus.CCMenu;
import org.cocos2d.menus.CCMenuItem;
import org.cocos2d.menus.CCMenuItemImage;
import org.cocos2d.nodes.CCDirector;

import android.view.KeyEvent;

/** This class represents the scene for the title screen. **/

public class MenuScene extends GridLayer {

	public static CCScene scene() {
		// Create the scene
		CCScene scene = CCScene.node();
		// Create a background layer.
		CCLayer background = new MenuScene();
		// Add the background layer to the scene
		scene.addChild(background);
		return scene;
	}

	protected MenuScene() {
		//Create a scene manager
		SceneManager sceneManager = new SceneManager();
		// Create a menu items.
		CCMenuItem start = CCMenuItemImage.item("start.png", "start.png",
				sceneManager, "toGameScene");
		CCMenuItem options = CCMenuItemImage.item("options.png", "options.png",
				sceneManager, "toOptionsScene");
		CCMenuItem help = CCMenuItemImage.item("help.png", "help.png",
				sceneManager, "toHelpScene");
		// Create array of menu items to add to menu
		CCMenuItem[] items = { start, options, help };
		// Add menu items to menu
		CCMenu menu = CCMenu.menu(items);
		// Align items with 150px adding
		menu.alignItemsVertically(150);
		addChild(menu);
		// Enable touch input
		CCTouchDispatcher.sharedDispatcher().addTargetedDelegate(this, 0, true);
		setIsTouchEnabled(true);
		// Enable key input
		setIsKeyEnabled(true);
	}
	
	@Override
	public boolean ccKeyUp(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			CCDirector.sharedDirector().getActivity().finish();
		}
		return true;
	}
	
}
