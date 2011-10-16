package ca.tolmieproductions.ShotingBlock;

import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;

/**
 * This class is (attempting to be) a state machine that manages pause requests.
 * If the current scene is allowed to pause, the scene is paused; Otherwise
 * nothing occurs. To enable pause functionality, simply set the scene's tag as
 * PauseManager.PAUSABLE.
 **/

public class PauseManager {

	private static CCScene scene;
	public static final int PAUSABLE = 1;

	/** This is a static method which can be called any time a scene is running. **/
	public static void pause() {
		scene = CCDirector.sharedDirector().getRunningScene();
		// Check if the scene is already paused
		if (CCDirector.sharedDirector().getIsPaused()) {
			runIfPaused();
		} else {
			runIfNotPaused();
		}
	}

	/** This method will be called if the current scene is already paused. **/
	private static void runIfPaused() {
		// Remove the pause menu overlay
		scene.removeChildByTag(PauseLayer.PAUSE_LAYER, false);
		// Resume the scene
		CCDirector.sharedDirector().resume();
	}

	/** This method will be called if the current scene is not already paused. **/
	private static void runIfNotPaused() {
		// If the the scene is pausable, pause it
		if (scene.getTag() == 1) {
			// Pause the scene
			CCDirector.sharedDirector().pause();
			// Add the pause menu overlay
			scene.addChild(PauseLayer.layer());
		}
	}
}
