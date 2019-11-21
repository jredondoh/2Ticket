/**
 * @file: _2TicketData.java
 * @author: Jose Redondo Hurtado
 * @brief: Fichero con definición de la clase _2TicketData para la prueba técnica 2Ticket de GeoDB
 */
package com.jrh.geoDBprueba1;

/**
 * Definición de la clase _2TicketData
 */
public class _2TicketData implements Comparable<_2TicketData>
{
    public long idTicket;
    public int idEvent;
    public boolean TixValid;

    /**
     * Constructor de la clase _2TicketData
     *
     * @param idTicket Identificador del ticket en formato entero de 64-bits
     * @param idEvent Identificador del evento en formato entero de 32-bits
     * @param TixValid Boolean con la validez del ticket
     */
    public _2TicketData (long idTicket,int idEvent,boolean TixValid)
    {
        this.idTicket = idTicket;
        this.idEvent = idEvent;
        this.TixValid = TixValid;
    }
    /**
     * @return the idTicket
     */
    public long getIdTicket() {
        return idTicket;
    }
     /**
     * @return the idEvent
     */
    public int getIdEvent() {
        return idEvent;
    }
     /**
     * @return the TixValid
     */
    public boolean getTixValid() {
        return TixValid;
    }    
    @Override
    public String toString()
    {
        return "{idTicket: \""+Base58CheckEncoding.convertToBase58(getIdTicket(),10) +
            "\", idEvent: \""+Base58CheckEncoding.convertToBase58(getIdEvent(),5) +
            "\", valid: \""+getTixValid()+"\"}";
    }

    /**
     * Compara el objeto con otro de la misma clase _2TicketData
     *
     * @param compareTix Objeto _2TicketData con el que se compara el objeto
     * @return Resultado de la comparación
     */
    @Override
    public int compareTo(_2TicketData compareTix) {
        if (this.getIdTicket() < compareTix.getIdTicket())
        {
            return -1;
        }
        if (this.getIdTicket() == compareTix.getIdTicket())
        {
            return 0;
        }
        /* if (this.idTicket > compareTix.idTicket) */
        return 1;
    }

    /**
     * Devuelve el mínimo de los dos objetos _2TicketData pasados como parámetros
     *
     * @param a
     * @param b
     * @return mínimo de los dos parámetros
     */
    public static _2TicketData min(_2TicketData a, _2TicketData b)
    {
        if (a.compareTo(b)< 0)
        {
            return a;
        }
        else
        {
            return b;
        }
    }
    /**
     * Devuelve el máximo de los dos objetos _2TicketData pasados como parámetros
     *
     * @param a
     * @param b
     * @return máximo de los dos parámetros
     */
    public static _2TicketData max(_2TicketData a, _2TicketData b)
    {
        if (a.compareTo(b)> 0)
        {
            return a;
        }
        else
        {
            return b;
        }
    }
}
