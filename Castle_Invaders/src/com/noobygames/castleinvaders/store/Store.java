package com.noobygames.castleinvaders.store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.noobygames.castleinvaders.Player;

/** @author Nerzal **/
public class Store {
	private Array<StoreObject> items;
	protected Player player;
	private Json json = new Json();
	private File file;
	private BufferedWriter out;
	private BufferedReader in;

	public Store(Player player) {
		this.player = player;

		items = new Array<StoreObject>();
		items.add(new StoreObject(10, 1, 15, true, false, true, "kurzer test",
				"Ich bin der erste Json test (:"));
		items.add(new StoreObject(5, 2, 15, true, false, true,
				"längerer Test undso!", "Das ist ein langer Test! :)"));
		
		file = new File("src/storeObjects.txt");
		saveToFile(this.file);
		//loadFromFile();

	}

	/**Writes all StoreObjects into the given File **/
	private boolean saveToFile(File file) {
		try {
			if (!file.exists())
				file.createNewFile();
			out = new BufferedWriter(new FileWriter(file));
			for (StoreObject obj : items) {
				out.write(json.prettyPrint(obj));
				//	out.write(json.toJson(obj));
					//out.newLine();
			}
			out.flush();
			return true;

		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}
	}

	/**Loads all JSon Objects out of a File and adds it onto items
	 * @return true If successfully loaded else false**/
	private boolean loadFromFile() {
		String s;
		try{
			in = new BufferedReader(new FileReader(file));
			
			while((s = in.readLine()) != null){
				json.fromJson(StoreObject.class, s); 
				System.out.println(s);
			}
			
			
			//
		}catch (IOException e){
			e.printStackTrace();
			return false;
		}
		
		return false;

	}

	public boolean buyObject(StoreObject obj){
		if(obj.isCostCoins())
			return buyObjectCoins(obj);
		else 
			return buyObjectGems(obj);
	}
	
	private boolean buyObjectCoins(StoreObject obj) {
		if (player.getCoins() >= obj.getPrice()
				&& obj.getObjectLevel() < obj.getObjectMaxLevel()
				&& obj.isAvailable() && !obj.isOwned()) {
			obj.setObjectLevel(obj.getObjectLevel() + 1);
			player.addCoins(-obj.getPrice());
			return true;

		}
		return false;
	}

	private boolean buyObjectGems(StoreObject obj) {
		if (player.getGems() >= obj.getPrice()
				&& obj.getObjectLevel() < obj.getObjectMaxLevel()
				&& obj.isAvailable() && !obj.isOwned()) {
			obj.setObjectLevel(obj.getObjectLevel() + 1);
			player.addGems(-obj.getPrice());
			return true;
		}
		return false;
	}

	// TODO Alle storeItems adden - wird nun per JavaIO gemacht - danke JSON !
	public void addStoreItem() {
		//items.add(new StoreObject(1, 0, 0, false, false, null, null));
	}
	
	public Array<StoreObject> getItems(){
		return items;
	}

}
