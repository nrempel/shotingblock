package ca.tolmieproductions.ShotingBlock;

import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCNode;

/**
 * This class provides scene changing methods to be used when an object requires
 * a target/selector for a callback
 **/

public class SceneManager extends CCNode {

	/** Reference this method to change to the menu scene **/
	public void toMenuScene(Object sender) {
		// Stop all current actions
		CCDirector.sharedDirector().getRunningScene().cleanup();
		// Ensure the current scene isn't replaced while paused
		if(CCDirector.sharedDirector().getIsPaused()){
			CCDirector.sharedDirector().resume();
		}
		// Replace the running scene with the requested scene
		CCDirector.sharedDirector().replaceScene(MenuScene.scene());
	}

	/** Reference this method to change to the options scene **/
	public void toOptionsScene(Object sender) {
		// Stop all current actions
		CCDirector.sharedDirector().getRunningScene().cleanup();
		// Ensure the current scene isn't replaced while paused
		if(CCDirector.sharedDirector().getIsPaused()){
			CCDirector.sharedDirector().resume();
		}
		// Replace the running scene with the requested scene
		CCDirector.sharedDirector().replaceScene(OptionsScene.scene());
	}

	/** Reference this method to change to the help scene **/
	public void toHelpScene(Object sender) {
		// Stop all current actions
		CCDirector.sharedDirector().getRunningScene().cleanup();
		// Ensure the current scene isn't replaced while paused
		if(CCDirector.sharedDirector().getIsPaused()){
			CCDirector.sharedDirector().resume();
		}
		// Replace the running scene with the requested scene
		CCDirector.sharedDirector().replaceScene(HelpScene.scene());
	}

	/** Reference this method to change to the game scene **/
	public void toGameScene(Object sender) {
		// Stop all current actions
		CCDirector.sharedDirector().getRunningScene().cleanup();
		// Ensure the current scene isn't replaced while paused
		if(CCDirector.sharedDirector().getIsPaused()){
			CCDirector.sharedDirector().resume();
		}
		// Replace the running scene with the requested scene
		CCDirector.sharedDirector().replaceScene(GameScene.scene());
	}
}
