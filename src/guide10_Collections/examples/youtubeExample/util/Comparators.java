package guide10_Collections.examples.youtubeExample.util;

import guide10_Collections.examples.youtubeExample.Pet;

import java.util.Comparator;

public class Comparators {
    public static Comparator<Pet> orderByNameDesc = new Comparator<Pet>(){
        @Override
        public int compare(Pet o1, Pet o2) {
            return o2.getName().compareTo(o1.getName());
        }
    };
}
