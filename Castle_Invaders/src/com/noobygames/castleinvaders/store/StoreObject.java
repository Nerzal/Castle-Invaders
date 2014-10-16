package com.noobygames.castleinvaders.store;

public class StoreObject {
	private int price;
	private int objectLevel;
	private int objectMaxLevel;
	private boolean isAvailable;
	private boolean owned;
	private boolean costCoins;
	private String name;
	private String description;
	
	
	/**standard constructor
	 *@param price Array holding the price for each level
	 *@param level the level the object shall get
	 *@param maxLevel the max skill level
	 *@param available is it buyable right now?
	 *@param owned already bought?
	 *@param description A briefly description of the object
	 *@param name Name of the object **/
	public StoreObject(int price, int level, int maxLevel, boolean available, boolean owned, boolean costCoins , String description, String name){
		this.price = price;
		this.objectLevel = level;
		this.objectMaxLevel = maxLevel;
		this.isAvailable = available;
		this.owned = owned;
		this.setDescription(description);
		this.setName(name);
		this.setCostCoins(costCoins);
		
	}
	
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
	/** Sets price for a specific ObjectLevel
	 * @param price the price to set
	 * @param level The index/objectlevel**/
	public void setSpecificPrice(int price, int level){
		this.price = price;
	}
	/**
	 * @return the objectLevel
	 */
	public int getObjectLevel() {
		return objectLevel;
	}
	/**
	 * @param objectLevel the objectLevel to set
	 */
	public void setObjectLevel(int objectLevel) {
		this.objectLevel = objectLevel;
	}
	/**
	 * @return the objectMaxLevel
	 */
	public int getObjectMaxLevel() {
		return objectMaxLevel;
	}
	/**
	 * @param objectMaxLevel the objectMaxLevel to set
	 */
	public void setObjectMaxLevel(int objectMaxLevel) {
		this.objectMaxLevel = objectMaxLevel;
	}
	/**
	 * @return the isAvailable
	 */
	public boolean isAvailable() {
		return isAvailable;
	}
	/**
	 * @param isAvailable the isAvailable to set
	 */
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	/**
	 * @return the owned
	 */
	public boolean isOwned() {
		return owned;
	}
	/**
	 * @param owned the owned to set
	 */
	public void setOwned(boolean owned) {
		this.owned = owned;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the costCoins
	 */
	public boolean isCostCoins() {
		return costCoins;
	}

	/**
	 * @param costCoins the costCoins to set
	 */
	public void setCostCoins(boolean costCoins) {
		this.costCoins = costCoins;
	}
}
