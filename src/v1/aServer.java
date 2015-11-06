package v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class aServer extends Thread {
	private String nameClient;
	private BufferedReader socketClientIn;
	private Annuaire annuaire;
	
	private void affTrace(String mess) {
		if (common.TraceActive)
			System.out.println("Serveur local pour "+nameClient+ " " + mess);
	}
	
	private void  traiteDemandeEmission(String srec) throws IOException {
		String[] parts = srec.split(":");
		String nameDistan = parts[3];
		String mess = parts[4];
		PrintWriter versDest = annuaire.getPrintWriter(nameDistan);
		if (versDest == null){
			PrintWriter out = annuaire.getPrintWriter(this.nameClient);
			common.signalErreurToClient(out, "Destinataire Inconnu");
		}
		else{
			versDest.println("Message de "+ this.nameClient +" \"" + mess + '"');
		}
	}

	public aServer(String nameClient, BufferedReader socketClientIn, Annuaire annuaire) {
		super();
		this.nameClient = nameClient;
		this.socketClientIn = socketClientIn;
		this.annuaire = annuaire;
	}
	
	public void run() {
		affTrace("Demarrage d'un serveur pour servir "+ this.nameClient);
		while (true) {
			String srec;
			try {
				srec = socketClientIn.readLine();
				affTrace("Reçu : "+srec);
				if (srec.startsWith(":D:")) {
					traiteDemandeEmission(srec);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
