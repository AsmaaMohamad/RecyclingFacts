package com.m.m.asmaa.recyclingfacts;

import android.content.Context;

import java.util.Random;

/**
 * Created by hp on 21/02/2018.
 */

public class RecyclingfactGenerator {
    String facts[];
    //علشان استخدم الgetResourse لازم يكون في داله فهنعرف كونستركتور
    public RecyclingfactGenerator(Context context){
        facts=context.getResources().getStringArray(R.array.facts);

    }
    public String generateFacts(){
        Random random=new Random();
        int count=random.nextInt(facts.length);
        String fact=facts[count];
        return fact;
    }
}
