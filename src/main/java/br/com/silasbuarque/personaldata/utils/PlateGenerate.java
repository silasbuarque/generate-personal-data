package br.com.silasbuarque.personaldata.utils;

import java.util.Random;

public class PlateGenerate {

    private static final String[] PLATES = {"BCP5435","FGX4194","QNN6462","EWR8501","QLO5806","JVZ2204","OSW9780",
                                            "EEU9J43","ORP6376","OXI8302","PCL1669","PLQ1J99","FHM5466","GHC3536"};

    public static String generatePlates() {
        Random random = new Random();
        int index = random.nextInt(PLATES.length);
        return PLATES[index];
    }

}
