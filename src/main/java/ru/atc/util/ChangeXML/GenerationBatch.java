package ru.atc.util.ChangeXML;

import javax.xml.bind.DatatypeConverter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GenerationBatch {
    private static final Random RND = new Random();
    private static final Set<byte[]> names = new HashSet();

    static public synchronized String generate() {
        byte[] value = new byte[16];
        RND.nextBytes(value);

        while(!names.add(value)) {
            RND.nextBytes(value);
        }

        byte[] part1 = Arrays.copyOfRange(value, 0, 4);
        byte[] part2 = Arrays.copyOfRange(value, 4, 6);
        byte[] part3 = Arrays.copyOfRange(value, 6, 8);
        byte[] part4 = Arrays.copyOfRange(value, 8, 10);
        byte[] part5 = Arrays.copyOfRange(value, 10, 16);
        return (DatatypeConverter.printHexBinary(part1) + "-" + DatatypeConverter.printHexBinary(part2) + "-" + DatatypeConverter.printHexBinary(part3) + "-" + DatatypeConverter.printHexBinary(part4) + "-" + DatatypeConverter.printHexBinary(part5)).toLowerCase();
    }
}
