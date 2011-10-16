package ca.tolmieproductions.ShotingBlock;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGSize;

/**
 * This class represents the playable game scene. It will probably be broken
 * into several different scenes in the future.
 **/

public class GameScene extends GridLayer {

	CCSprite _oddBackground;
	CCSprite _evenBackground;
	CGSize _winSize;

	public static CCScene scene() {
		// Create the scene
		CCScene scene = CCScene.node();
		// Create the background layer
		CCLayer layer = new GameScene();
		// Add it to the scene
		scene.addChild(layer);
		// Enable pause functionality
		scene.setTag(PauseManager.PAUSABLE);
		return scene;
	}

	protected GameScene() {
		// Get window size for reference
		_winSize = CCDirector.sharedDirector().displaySize();
		animateBackground();
	}

	/** This method is called to begin animating the background **/
	private void animateBackground() {
		// Create the two background sprites which will alternate
		_oddBackground = CCSprite.sprite("blue_background.png");
		_evenBackground = CCSprite.sprite("blue_background.png");
		// One starts dead centre and one starts exactly one screen height above
		_oddBackground.setPosition(_winSize.width / 2, _winSize.height / 2);
		_evenBackground.setPosition(_winSize.width / 2, _winSize.height
				+ (_winSize.height / 2));
		// Schedule the scrolling action
		schedule("scroll");
		// Add sprites to the layer
		addChild(_oddBackground).addChild(_evenBackground);
	}

	public void scroll(float dt) {
		// move them 100*dt pixels down
		_oddBackground.setPosition(_oddBackground.getPosition().x,
				_oddBackground.getPosition().y - 150 * dt);
		_evenBackground.setPosition(_evenBackground.getPosition().x,
				_evenBackground.getPosition().y - 150 * dt);
		// reset position when they are off from view.
		if (_oddBackground.getPosition().y < -_winSize.height / 2) {
			_oddBackground.setPosition(_winSize.width / 2, _winSize.height / 2);
			_evenBackground.setPosition(_winSize.width / 2, _winSize.height
					+ (_winSize.height / 2));
		}
	}
}
