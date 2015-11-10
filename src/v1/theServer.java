package v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class theServer extends Thread {
	Socket s;
	Annuaire tableClient;
	private static int numMess = 0;
	private static void affTrace(String mess) {
		if (common.TraceActive){
			System.out.println("Serveur Principal : " + (numMess++) + " "+ mess);
		}
	}

	public theServer() {
		tableClient = new Annuaire();
	}

	private void traiteDemandeAbonnement(Socket clientSocket, String srec, BufferedReader clientSocketIn) throws IOException {
		String nameClient = srec.substring(5, srec.length() - 1);
		affTrace("Demande abonnement de -->" + nameClient);
		PrintWriter outClient = new PrintWriter(clientSocket.getOutputStream(), true);

		if (tableClient.addName(nameClient, outClient) == 0){
			affTrace("Erreur sur enregistrement client " + nameClient);
			common.signalErreurToClient(outClient, "Erreur sur enregistrement : nom déjà utilisé");
		}
		else{
			aServer a = new aServer(nameClient, clientSocketIn, tableClient);
			a.start();
		}
	}

	public void run() {
		affTrace("Demarrage Serveur");

		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(common.portNumber);
			while (true) {
				Socket clientSocket = serverSocket.accept();
				BufferedReader clientSocketIn = new BufferedReader(
						new InputStreamReader(clientSocket.getInputStream()));

				String srec = clientSocketIn.readLine();
				affTrace("reçu : " + srec);

				if (srec.startsWith(":S:1:")) {
					traiteDemandeAbonnement(clientSocket, srec, clientSocketIn);
				}
				else {

				}
			}
		} catch (IOException e) {
			affTrace("PB SERVEUR PRINCIPAL");
			e.printStackTrace();
		}

	}
}
