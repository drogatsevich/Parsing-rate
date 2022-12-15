package by.rates.nbrb.util;

import java.util.zip.CRC32;

/**
 * Класс выполняет оперции с CRC32
 *
 */
public class CrcHelper {
    public static String getCRC32Value(String data){
        CRC32 crc = new CRC32();
        crc.update(data.getBytes());
        return Long.toString(crc.getValue());
    }
}
