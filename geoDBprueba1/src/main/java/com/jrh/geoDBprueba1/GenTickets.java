package com.jrh.geoDBprueba1;

import java.util.stream.LongStream;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* import org.javatuples.Triplet; */

public class GenTickets {
	public List<_2TicketData> getTickets(long numTickets) {
		final long maxIdTicket = ((long) Math.pow(58, 10)) - 1;
		final int minTixEvento = 2;
		final int maxTixEvento = 10;
		
		if (numTickets > maxIdTicket){
			System.exit(-1);
		}		
		Random random = new Random();

		/* 
		Los datos en Base58 serán primero manejados en entero para facilitar y optimizar
		su manejo, para luego ser codificados a la hora de presentarlos.
		 */
		/*
		 * Para id de los tickets se ha elegido tipo long int, que puede representar un
		 * número de 10 caracteres expresado en Base58, como un entero con signo
		 * positivo: 2^63 > 58^10 > 2^31 Para el id de los eventos, sí que basta con un
		 * entero del tipo int: 2^31 > 58^5 Para la validez de cada ticket, se ha usado
		 * un booleano que indica si el ticket es válido o no.
		 */

		/*
		 * Hay que fijar el máximo ticket posible ya que el máximo long int no puede ser
		 * representado como 10 caracteres en Base58 y para tener aleatoriedad, vamos a
		 * obtener los valores de tickets como números aleatorios.
		 */


/* 		int iTix = 0;
		long auxLong = 0;
		List<Long> idTicketList = new ArrayList<>();
		while (iTix < numTickets) {
			auxLong = (long) (random.nextFloat() * maxIdTicket);
			// Para asegurar que el id del ticket es único
			if (!(idTicketList.contains(auxLong))) {
				idTicketList.add(auxLong);
				iTix += 1;
			}
		} */

		List<Long> idTicketList =
				LongStream.range(0, numTickets).boxed().collect(Collectors.toCollection(ArrayList::new));
		Collections.shuffle(idTicketList);

		/*
		 * Para el evento, vamos a tener un id secuencial, pero la cantidad de tickets
		 * por evento va a ser aleatoria entre 2 y 10, incluyendo ambos.
		 */
		long iEve = 0;
		int auxInt = 0;

		List<Integer> numTixEvento = new ArrayList<>();
		List<Integer> idEventoList = new ArrayList<>();
		while (iEve < (numTickets - maxTixEvento - 1)) {
			auxInt = minTixEvento + random.nextInt(maxTixEvento - minTixEvento + 1);
			numTixEvento.add(auxInt);
			iEve += auxInt;
		}
		if (iEve < numTickets)
		/*
		 * Los tickets del último evento se fijan por el resto de tickets por repartir.
		 */
		{
			numTixEvento.add((int)(numTickets - iEve));
		}

		/*
		 * Sabiendo el número de tickets por evento, calculamos el número de tickets
		 * válidos, sabiendo que siempre tiene que haber válidos y usados. Para eso
		 * buscamos un número aleatorio entre 1 y el número de tickets del evento - 1,
		 * para que asegurar que  haya de los dos tipos.
		 */
		List<Integer> numTixValid = new ArrayList<>();
		List<Boolean> TixValidList = new ArrayList<>();
		
		int i = 0;
		for (i = 0; i < numTixEvento.size(); i++) {
			auxInt = random.nextInt(numTixEvento.get(i) - 1);
			numTixValid.add(1 + auxInt);
		}

		/* 
		Ahora usamos la lista con los números de tickets por evento y la cantidad de
		válidos por evento, para crear una lista que concuerde con la lista de tickets
		creada al principio.
		 */
		int idEventoIndex = 0;
		int TixValidIndex = 0;
		for (int n = 0; n < numTixEvento.size(); n++) {
			TixValidIndex = numTixValid.get(n);
			for (int nn = 0; nn < numTixEvento.get(n); nn++) {
				idEventoList.add(idEventoIndex);
				/* 
				Si ya se han superado el número de tickets usados, el resto serán
				válidos.
				 */
				TixValidList.add(nn >= TixValidIndex);
			}
			/* 
			El id del evento es secuencial y empieza en el 0, ya que es la decodificación
			de "11111" en Base58.
			*/
			idEventoIndex += 1;
		}

		List<_2TicketData> outList = new ArrayList<>();

		for (int n = 0; n < idTicketList.size(); n++) 
		{
			_2TicketData ticketData = new _2TicketData(
				idTicketList.get(n),
				idEventoList.get(n),
				TixValidList.get(n));
			outList.add(ticketData);
        }
        return outList;
/* 		List<Triplet> outList = new ArrayList<>();

		for (int n = 0; n < idTicketList.size(); n++) {
			Triplet<long, int, boolean> triplet = Triple.with(
				idTicketList.get(n),
				idEventoList.get(n),
				TixValidList.get(n));
			outList.add(Triplet)
		}
 */

/* 		for (int n = 0; n < idEventoList.size(); n++) {
			System.out.print(idEventoList.get(n) + " ");
			System.out.println(TixValidList.get(n));
		}

		/* TixValidList.forEach(System.out::println); */
		/* System.out.println(idTicketList.size());
		System.out.println(idEventoList.size());
		System.out.println(Base58.convertToBase58(maxIdTicket, 10)); */ 
		/* range.forEach((i)->idEventoList.add(Base58.convertToBase58(i,10))); */
	}
}