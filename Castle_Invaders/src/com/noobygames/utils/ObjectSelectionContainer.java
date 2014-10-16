package com.noobygames.utils;

import com.badlogic.gdx.utils.Array;

/**ObjectSelection is a container class which accepts whether a generic single object or an generic array of multiple objects as target.
 * So Object Selection is just a container for generic objects
 * @author Nerzal**/
public class ObjectSelectionContainer<T> {

	private T singleTarget;
	private Array<T> multiTarget;
	
	/**false for single target mode
	 * true for multi target mode**/
	private boolean multiTargetSelection;
	

	/**standard getter
	 * @return true if in multi select mode**/
	public boolean getSelectionMode() {
		return multiTargetSelection;
	}

	/**standard setter
	 * @param multiTargetSelection Indicates if multi target select mode is turned on/off**/
	public void setSelectionMode(boolean multiTargetSelection) {
		this.multiTargetSelection = multiTargetSelection;
	}	
	
	/**Constructor
	 * @param singleTarget generic object
	 * @param multiTarget generic array**/
	public ObjectSelectionContainer(T singleTarget, Array<T> multiTarget){
		this.singleTarget = singleTarget;
		this.multiTarget = multiTarget;
	}
	
	
	/**Standard getter (for generic type T)
	 * @return returns the singleTarget object**/
	public T getSingleTarget(){
		return singleTarget;
	}
	
	/**Sets the generic field singleTarget to the given "value"
	 * @param singleTarget **/
	public void setSingleTarget(T singleTarget){
		this.singleTarget = singleTarget;
	}

	/**@return Returns the array or null**/
	public Array<T> getMultiTarget() {
		return multiTarget;
	}
	
	/**Returns the specific element with the given index out of the multiTarget
	 * @param index The index of the element**/
	public T getSingleTarget(int index){
		return multiTarget.get(index);
	}
	
	/**Returns the given object, if its in the array
	 * @param object The object to look for
	 * @return the object if found in the array, else null **/
	public T getSingleTarget(T object){
		for(T obj: multiTarget){
			if(obj.equals(object))
				return obj;
		}
		return null;
	}

	/**Sets the multiTarget array
	 * @param multiTarget The generic array to set**/
	public void setNewMultiTarget(Array<T> multiTarget) {
		this.multiTarget = multiTarget;
	}
	
	/**removes a single object from the selection
	 * @param object the object to remove**/
	public void removeTarget(T object){
		multiTarget.removeValue(object, true);	
		}
	
	
	/**Adds a object to multiTarget
	 * @param object The object to add**/
	public void addTarget(T object){
		multiTarget.add(object);
	}
	
	/**Clears the multi select**/
	public void clearmultiTarget(){
		multiTarget.clear();
	}
	/**Clears the single Target**/
	public void clearSingleTarget(){
		singleTarget = null;
	}
	
	/**Clears all targets, sets mode to single target selection**/
	public void clearAll(){
		singleTarget = null;
		multiTarget = null;
		multiTargetSelection = false;
	}

}
