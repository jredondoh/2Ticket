package com.jrh.geoDBprueba1;
// https://rosettacode.org/wiki/Base58Check_encoding#Java

public class Base58CheckEncoding {
    private static final String ALPHABET = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz";

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

    public static String convertToBase58(long base10) {

        StringBuilder sb = new StringBuilder();
        while (base10 > 0) {
            int r = (int) (base10 % 58);
            sb.append(ALPHABET.charAt(r));
            base10 = base10 / 58;
        }

        return sb.reverse().toString();
    }

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
