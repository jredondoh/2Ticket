package com.jrh.geoDBprueba1;

public class _2TicketData implements Comparable<_2TicketData>
{
    public long idTicket;
    public int idEvent;
    public boolean TixValid;

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
        return "idTicket:"+Base58CheckEncoding.convertToBase58(getIdTicket(),10) + 
            " idEvent:"+Base58CheckEncoding.convertToBase58(getIdEvent(),5) + 
            " valid:"+getTixValid();
    }
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