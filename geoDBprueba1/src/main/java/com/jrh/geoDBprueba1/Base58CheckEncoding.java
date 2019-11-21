/**
 * @file: Base58CheckEncoding.java
 * @author: Jose Redondo Hurtado
 * @brief: Fichero basado en https://rosettacode.org/wiki/Base58Check_encoding#Java
 *         Proporciona la codificación y decodificación de un entero a una string en base58
 */
package com.jrh.geoDBprueba1;

/**
 *  Proporciona la codificación y decodificación de un entero a una string en base58
 */
public class Base58CheckEncoding {
    private static final String ALPHABET = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz";

    /**
     * Convierte un entero a una cadena de caracteres en base58 de longitud determinada.
     *
     * @param base10 Entero en base 10
     * @param len Longitud de la cadena de caracteres en base58
     * @return cadena de caracteres en base58
     */
    public static String convertToBase58(long base10, int len) {
        String stConverted = convertToBase58(base10);
        if (stConverted.length() < len) {
            String one = "1";
            String repeated = new String(new char[len - stConverted.length()]).replace("\0", one);
            return repeated + stConverted;
        } else {
            return stConverted;
        }
    }

    /**
     * Convierte un entero a una cadena de caracteres en base58 sin longitud determinada.
     *
     * @param base10 Entero en base 10
     * @return cadena de caracteres en base58
     */
    public static String convertToBase58(long base10) {

        StringBuilder sb = new StringBuilder();
        while (base10 > 0) {
            int r = (int) (base10 % 58);
            sb.append(ALPHABET.charAt(r));
            base10 = base10 / 58;
        }

        return sb.reverse().toString();
    }

    /**
     * Devuelve un entero de 64-bits a partir de una cadena de caracteres en base58.
     *
     * @param input Cadena de caracteres en base58
     * @return Entero de 64-bits en base 10
     */
    // based in https://rosettacode.org/wiki/Bitcoin/address_validation#Java
    public static long decodeBase58ToLong(String input) {
        long num = 0;
        for (char t : input.toCharArray()) {
            int p = ALPHABET.indexOf(t);
            // ERROR CASE
            // if (p == -1)
            // return null;
            num = (num * 58) + p;
        }
        return num;
    }
}
