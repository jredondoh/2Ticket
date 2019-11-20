package com.jrh.geoDBprueba1;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

/* import org.javatuples.Triplet; */

public class TicketBlocks {
    public static List<_2TicketData> getBlocks(List<_2TicketData> TixList) {		
        /* 
        El tamaño de la lista se supone expresable en 32bits para esta prueba.
         */
        final double minPercent = 0.50;
        final double maxPercent = 0.75;

        /* 
        Los bloques conocidos por los nodos se suponen no contiguos para buscar
        el peor caso, por lo que se generará una lista de todos los posibles
        tickets, usando su posición en la lista pasada como argumento.
         */
        Random random = new Random();      

        /* 
        La aleatorización del contenido de la lista se realiza con el método
        Collections.shuffle que interiormente usa el algoritmo de Fisher-Yates.
         */
        Collections.shuffle(TixList);        
        List<_2TicketData> returnList = new ArrayList<_2TicketData>(TixList.subList(0, 
            (int)(minPercent*TixList.size()) + random.nextInt(
			(int)((maxPercent - minPercent)*TixList.size()))));
        
        return returnList;
    }
}