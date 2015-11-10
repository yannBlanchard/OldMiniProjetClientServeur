package v1;

import java.io.PrintWriter;
import java.util.HashMap;

public class Annuaire {

	private HashMap<String, PrintWriter> tableClient;

	public Annuaire() {
		super();
		this.tableClient = new HashMap<String, PrintWriter>();
	}
	
	public int addName(String name, PrintWriter out){
		if (tableClient.containsKey(name))
			return 0;
		else{
			tableClient.put(name, out);
			return 1;
		}		
	}

	public int removeName(String name){
		if (!tableClient.containsKey(name))
			return 0;
		else{
			tableClient.remove(name);
			return 1;
		}
	}
	
	public PrintWriter getPrintWriter(String name){
		return tableClient.get(name);
	}

}
