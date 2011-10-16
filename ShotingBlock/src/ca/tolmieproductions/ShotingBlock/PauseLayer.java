package ca.tolmieproductions.ShotingBlock;

import org.cocos2d.layers.CCColorLayer;
import org.cocos2d.menus.CCMenu;
import org.cocos2d.menus.CCMenuItem;
import org.cocos2d.menus.CCMenuItemLabel;
import org.cocos2d.nodes.CCLabel;
import org.cocos2d.types.ccColor4B;

/**
 * This class represents the pause overlay that appears when the game is paused.
 * It is used in conjunction with the pause manager to serve the pause overlay
 * to whatever scene is being paused.
 **/

public class PauseLayer extends CCColorLayer {

	public static final int PAUSE_LAYER = 0;

	public static CCColorLayer layer() {
		// Create scene manager object to be used in the menu items
		SceneManager sceneManager = new SceneManager();
		// Create the background layer which should just darken then screen
		CCColorLayer layer = new PauseLayer(ccColor4B.ccc4(0, 0, 0, 100));
		// Create a labels as menu items for the menu
		CCMenuItem paused = CCMenuItemLabel.item(CCLabel.makeLabel("PAUSED",
				"Marker Felt", 70), null, null);
		CCMenuItem options = CCMenuItemLabel.item(CCLabel.makeLabel("Options",
				"Marker Felt", 40), sceneManager, "toOptionsScene");
		CCMenuItem quit = CCMenuItemLabel.item(CCLabel.makeLabel("Quit",
				"Marker Felt", 40), sceneManager, "toMenuScene");
		// Put them in an array for the menu
		CCMenuItem[] items = {paused, options, quit};
		// Add the menu item to the menu
		CCMenu menu = CCMenu.menu(items);
		// Align the menu items vertically
		menu.alignItemsVertically();
		// Add the menu to the layer then return it
		layer.addChild(menu);
		// Give it a tag so we can find it from other scenes
		layer.setTag(PAUSE_LAYER);
		return layer;
	}

	protected PauseLayer(ccColor4B colour) {
		super(colour);
	}
}
