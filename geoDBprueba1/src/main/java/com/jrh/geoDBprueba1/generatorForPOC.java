/**
 * @file: generatorForPOC.java
 * @author: Jose Redondo Hurtado
 * @brief: Genera los inputs para la POC del reto 4 de la prueba técnica 2Ticket de geoDB
 */
package com.jrh.geoDBprueba1;
import java.util.Collections;
import java.util.List;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;

/**
 * Genera los inputs para la POC del reto 4 de la prueba técnica 2Ticket de geoDB
 */
public class generatorForPOC {
    public static void main(String[] args) {
	GenTickets genTickets = new GenTickets();
	List<_2TicketData> TixList = genTickets.getTickets(30);
	List<_2TicketData> b_a_List = TicketBlocks.getBlocks(TixList);
	List<_2TicketData> b_b_List = TicketBlocks.getBlocks(TixList);
	List<_2TicketData> b_c_List = TicketBlocks.getBlocks(TixList);
	fileWriter2Ticket("nodo1.txt",b_a_List);
	fileWriter2Ticket("nodo2.txt",b_b_List);
	fileWriter2Ticket("nodo3.txt",b_c_List);
    }

	/**
	 * Genera un fichero de texto a partir de una lista de objetos _2TicketData
	 *
	 * @param fileName Nombre del fichero de texto a generar
	 * @param list Lista de objetos _2TicketData
	 */
    public static void fileWriter2Ticket(String fileName, List<_2TicketData> list ) {
	try{
	    File file = new File(fileName);
	    PrintWriter printWriter = new PrintWriter(file);
	    list.forEach((i)->printWriter.println(i.toString()));
	    printWriter.close();
	}catch (IOException e)
	    {
		System.err.println("Filename not possible!");	    
	}
    }
}
