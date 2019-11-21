/**
 * @file: BinarySearchEqualOrClose.java
 * @author: Jose Redondo Hurtado
 * @brief: Fichero basado en https://www.geeksforgeeks.org/search-equal-bigger-or-smaller-in-a-sorted-array-in-java/
 *         Ejecuta una busqueda binaria en una lista de objetos _2TicketData.
 */
package com.jrh.geoDBprueba1;
import java.util.List;

/**
 *  Clase que ejecuta una busqueda binaria en una lista de objetos _2TicketData.
 */
public class BinarySearchEqualOrClose {
    enum SC { 
		EQUAL, 
		EQUAL_OR_BIGGER, 
		EQUAL_OR_SMALLER 
	};

	/**
	 * Efectúa una búsqueda binaria
	 *
	 * @param key Objeto a buscar
	 * @param list Lista en la que se efectúa la búsqueda
	 * @param start Límite inferior de la lista en la que se empieza la búsqueda
	 * @param end Límite inferior de la lista en la que se empieza la búsqueda
	 * @param sC Enumerado que indica el tipo de búsqueda
	 * @return Posición en la lista del objeto buscado
	 */
	public static int searchEqualOrClose(
        _2TicketData key, List<_2TicketData> list, int start, int end, SC sC) 
	{ 
		if (list == null || list.size() == 0) { 
			return -1; 
		} 

		if (list.size() == 1) { // just eliminate case of length==1 

			// since algorithm needs min array size==2 
			// to start final evaluations 
			if (list.get(0).compareTo(key) == 0) { 
				return 0; 
			} 
			if (list.get(0).compareTo(key) < 0 && sC == SC.EQUAL_OR_SMALLER) { 
				return 0; 
			} 
			if (list.get(0).compareTo(key) > 0 && sC == SC.EQUAL_OR_BIGGER) { 
				return 0; 
			} 
			return -1; 
        }
        if (start == end)
        {
            return -1;
        } 
		return searchEqualOrClose(list, key, start, end, sC); 
	}
	/**
	 * Efectúa una búsqueda binaria
	 *
	 * @param list Lista en la que se efectúa la búsqueda
	 * @param key Objeto a buscar
	 * @param start Límite inferior de la lista en la que se empieza la búsqueda
	 * @param end Límite inferior de la lista en la que se empieza la búsqueda
	 * @param sC Enumerado que indica el tipo de búsqueda
	 * @return Posición en la lista del objeto buscado
	 */
	private static int searchEqualOrClose(List<_2TicketData> list, _2TicketData key, 
										int start, int end, SC sC) 
	{ 
		int midPos = (start + end) / 2; 
		_2TicketData midVal = list.get(midPos); 
		if (midVal == key) { 
			return midPos; // equal is top priority 
		} 

		if (start >= end - 1) { 
			if (list.get(end) == key) { 
				return end; 
			} 
			if (sC == SC.EQUAL_OR_SMALLER) { 

				// find biggest of smaller element 
				if (list.get(start).compareTo(key) > 0 && start != 0) { 

					// even before if "start" is not a first 
					return start - 1; 
				} 
				if (list.get(end).compareTo(key) < 0) { 
					return end; 
				} 
				if (list.get(start).compareTo(key) < 0) { 
					return start; 
				} 
				return -1; 
			} 
			if (sC == SC.EQUAL_OR_BIGGER) { 

				// find smallest of bigger element 
				if (list.get(end).compareTo(key) < 0 && end != list.size() - 1) { 

					// even after if "end" is not a last 
					return end + 1; 
				} 
				if (list.get(start).compareTo(key) > 0) { 
					return start; 
				} 
				if (list.get(end).compareTo(key) > 0) { 
					return end; 
				} 
				return -1; 
			} 
			return -1; 
		} 
		if (midVal.compareTo(key) > 0) { 
			return searchEqualOrClose(list, key, start, midPos - 1, sC); 
		} 
		return searchEqualOrClose(list, key, midPos + 1, end, sC); 
    }
	/**
	 * Efectúa una búsqueda binaria para encontrar un objeto de mismo valor o el siguiente de valor inferior.
	 *
	 * @param key Objeto a buscar
	 * @param list Lista en la que se efectúa la búsqueda
	 * @param start Límite inferior de la lista en la que se empieza la búsqueda
	 * @param end Límite inferior de la lista en la que se empieza la búsqueda
	 * @return Posición en la lista del objeto buscado
	 */
    public static int searchEqualOrSmaller(_2TicketData key, List<_2TicketData> list, int start, int end)
    {
        return searchEqualOrClose(key, list, start, end, SC.EQUAL_OR_SMALLER);
    }
	/**
	 * Efectúa una búsqueda binaria para encontrar un objeto de mismo valor o el siguiente de valor superior.
	 *
	 * @param key Objeto a buscar
	 * @param list Lista en la que se efectúa la búsqueda
	 * @param start Límite inferior de la lista en la que se empieza la búsqueda
	 * @param end Límite inferior de la lista en la que se empieza la búsqueda
	 * @return Posición en la lista del objeto buscado
	 */
    public static int searchEqualOrBigger(_2TicketData key, List<_2TicketData> list, int start, int end)
    {
        return searchEqualOrClose(key, list, start, end, SC.EQUAL_OR_BIGGER);
    }    
}