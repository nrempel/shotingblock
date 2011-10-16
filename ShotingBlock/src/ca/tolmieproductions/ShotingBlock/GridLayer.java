package ca.tolmieproductions.ShotingBlock;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGSize;

/**
 * Always use GridLayer as the parent layer in every scene. This lets us create actions
 * based on a grid instead of pixel coordinates.
 **/

public class GridLayer extends CCLayer{
	
	CGSize _winSize;
	// A 2D array which contains the coordinates
	CGPoint[][] _coordinates;
 
	protected GridLayer() {
		_winSize = CCDirector.sharedDirector().displaySize();
		initializeCoordinates();
		
	}
	
	private void initializeCoordinates(){
		
	}
	
	public static void setIsGridVisible(boolean isVisible){
		CCLayer grid = new GridLayer();
	}
}
