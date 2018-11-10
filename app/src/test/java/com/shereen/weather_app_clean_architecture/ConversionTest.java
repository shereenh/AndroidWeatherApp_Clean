package com.shereen.weather_app_clean_architecture;

import com.shereen.weather_app_clean_architecture.domain.business.ImperialConverter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by shereen on 11/9/18
 */

public class ConversionTest {

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void conversion() {
        double start = 10.880000114440918;
        double end = ImperialConverter.kelvinToCelcius(start);
        assertEquals(-262.27, end,0.001);
    }

    @Test
    public void checkDecimal(){
        double start = 10.880000114440918;
        double end = ImperialConverter.round2(start);
        assertEquals(10.88,end,0.0001);
    }
}
