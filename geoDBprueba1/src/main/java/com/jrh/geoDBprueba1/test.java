/**
 * @file: test.java
 * @author: Jose Redondo Hurtado
 * @brief: Fichero con clase principal de los retos 1 y 2 de la prueba técnica 2Ticket de GeoDB
 */
package com.jrh.geoDBprueba1;
import java.util.Collections;
import java.util.List;

/**
 *  Clase principal que ejecuta los retos 1 y 2 de la prueba técnica 2Ticket de GeoDB.
 */
public class test {
	public static void main(String[] args) {
		/* Reto 1 */
		GenTickets genTickets = new GenTickets();
		List<_2TicketData> Reto1List = genTickets.getTickets(100);
		System.out.println("RETO 1");
		Reto1List.forEach((i)->System.out.println(i.toString()));

		/* Reto 2 */
		System.out.println("RETO 2");
		List<_2TicketData> TixList = genTickets.getTickets(1000000);
		List<_2TicketData> b_a_List = TicketBlocks.getBlocks(TixList);
		List<_2TicketData> b_b_List = TicketBlocks.getBlocks(TixList);
		List<_2TicketData> b_c_List = TicketBlocks.getBlocks(TixList);

		/* 
		Primero ordenamos las listas de Tickets, para poder efectuar una
		búsqueda por intervalos (en este caso Binary).
		*/
		Collections.sort(b_a_List);
		Collections.sort(b_b_List);
		Collections.sort(b_c_List);

		/*
		Las variables a continuación son los índices de búsqueda por arriba y por abajo.
		 */
		int b_a_Top = b_a_List.size()-1;
		int b_b_Top = b_b_List.size()-1;
		int b_c_Top = b_c_List.size()-1;
		int b_a_Btm = 0;
		int b_b_Btm = 0;
		int b_c_Btm = 0;

		/*
		Lo primero es calcular el mínimo de los tres nodos empezando por los índices de arriba (los superiores) y
		el máximo empezando por los índices inferiores.
		 */
		_2TicketData indexMin = 
			_2TicketData.min(b_a_List.get(b_a_Top),b_b_List.get(b_b_Top));
		indexMin = _2TicketData.min(indexMin,b_c_List.get(b_c_Top));
		_2TicketData indexMax = 
			_2TicketData.max(b_a_List.get(b_a_Btm),b_b_List.get(b_b_Btm));
		indexMax = _2TicketData.max(indexMax,b_c_List.get(b_c_Btm));

		/*
		Después calculamos para los tres nodos, el valor más cercano para los valores máximo y mínimo.
		 */
		b_a_Btm = BinarySearchEqualOrClose.searchEqualOrBigger (indexMax,b_a_List,b_a_Btm,b_a_Top);
		b_b_Btm = BinarySearchEqualOrClose.searchEqualOrBigger (indexMax,b_b_List,b_b_Btm,b_b_Top);
		b_c_Btm = BinarySearchEqualOrClose.searchEqualOrBigger (indexMax,b_c_List,b_c_Btm,b_c_Top);
		b_a_Top = BinarySearchEqualOrClose.searchEqualOrSmaller (indexMin,b_a_List,b_a_Btm,b_a_Top);
		b_b_Top = BinarySearchEqualOrClose.searchEqualOrSmaller (indexMin,b_b_List,b_b_Btm,b_b_Top);
		b_c_Top = BinarySearchEqualOrClose.searchEqualOrSmaller (indexMin,b_c_List,b_c_Btm,b_c_Top);
		

		int numCommonIds = 0;		
		boolean minCommon = true;
		boolean maxCommon = true;

		/*
		Y repetimos las dos acciones anteriores (calcular el mín/máx y calcular el índice más cercano) en bucle hasta
		que no queden nodos (la búsqueda devolverá -1) o los índices superiores e inferiores se encuentren.
		 */
		while (
			(b_a_Btm >= 0)&&(b_b_Btm >= 0)&&(b_c_Btm >= 0)&&
			(b_a_Top >= 0)&&(b_b_Top >= 0)&&(b_c_Top >= 0)&&
			(b_a_Btm < b_a_Top)&&(b_b_Btm < b_b_Top)&&(b_b_Btm < b_a_Top))
		{			
			if ((b_a_List.get(b_a_Top) == b_b_List.get(b_b_Top))&&
				(b_a_List.get(b_a_Top) == b_c_List.get(b_c_Top)))
			{
				if (maxCommon)
				{
					System.out.println("Máximo común");
					System.out.println(b_a_List.get(b_a_Top));
					maxCommon = false;
				}
				/*
				Cuando se encuentre un máximo común, se pasa al siguiente ticket de la lista.
				 */
				numCommonIds++;
				b_a_Top-=1;
				b_b_Top-=1;
				b_c_Top-=1;
			}
			if ((b_a_List.get(b_a_Btm) == b_b_List.get(b_b_Btm))&&
				(b_a_List.get(b_a_Btm) == b_c_List.get(b_c_Btm)))
			{				
				if (minCommon)
				{
					System.out.println("Mínimo común");
					System.out.println(b_a_List.get(b_a_Btm));
					minCommon = false;
				}
				/*
				Cuando se encuentre un mínimo común, se pasa al siguiente ticket de la lista.
				 */
				numCommonIds++;
				b_a_Btm+=1;
				b_b_Btm+=1;
				b_c_Btm+=1;
			}
			indexMin = 
				_2TicketData.min(b_a_List.get(b_a_Top),b_b_List.get(b_b_Top));
			indexMin = _2TicketData.min(indexMin,b_c_List.get(b_c_Top));
			indexMax = 
				_2TicketData.max(b_a_List.get(b_a_Btm),b_b_List.get(b_b_Btm));
			indexMax = _2TicketData.max(indexMax,b_c_List.get(b_c_Btm));
			b_a_Btm = BinarySearchEqualOrClose.searchEqualOrBigger (indexMax,b_a_List,b_a_Btm,b_a_Top);
			b_b_Btm = BinarySearchEqualOrClose.searchEqualOrBigger (indexMax,b_b_List,b_b_Btm,b_b_Top);
			b_c_Btm = BinarySearchEqualOrClose.searchEqualOrBigger (indexMax,b_c_List,b_c_Btm,b_c_Top);
			b_a_Top = BinarySearchEqualOrClose.searchEqualOrSmaller (indexMin,b_a_List,b_a_Btm,b_a_Top);
			b_b_Top = BinarySearchEqualOrClose.searchEqualOrSmaller (indexMin,b_b_List,b_b_Btm,b_b_Top);
			b_c_Top = BinarySearchEqualOrClose.searchEqualOrSmaller (indexMin,b_c_List,b_c_Btm,b_c_Top);
		}
 		System.out.printf("Num tickets comunes a todos = %d\n", numCommonIds);
	}
}
