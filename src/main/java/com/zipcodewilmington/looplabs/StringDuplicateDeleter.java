package com.zipcodewilmington.looplabs;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {

    public StringDuplicateDeleter(String[] array){
        super(array);
    }
    @Override
    public String[] removeDuplicates(int maxNumberOfDuplications) {
        ArrayList<String> duplicateString = new ArrayList<>();
        Collections.addAll(duplicateString, array);
        int count = 1;
        for (int i = 0; i < duplicateString.size()-1; i++) {
            if(duplicateString.get(i) == duplicateString.get(i+1)){
                count++;
                if(i == duplicateString.size()-2){
                    if (count >= maxNumberOfDuplications){
                        for (int j = 0; j < count; j++) {
                            duplicateString.remove(duplicateString.get(i+2 - count));
                        }
                    }
                }
            }else{
                if (count >= maxNumberOfDuplications){
                    for (int j = 0; j < count; j++) {
                        duplicateString.remove(duplicateString.get(i+1 - count));
                    }
                    i = i- count;
                }
                count = 1;
            }

        }
        String[] result = duplicateString.toArray(new String[duplicateString.size()]);

        return result;
    }

    @Override
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        ArrayList<String> duplicateStrings = new ArrayList<>();
        Collections.addAll(duplicateStrings, array);
        int count = 1;
        for (int i = 0; i < duplicateStrings.size()-1; i++) {
            if(duplicateStrings.get(i) == duplicateStrings.get(i+1)){
                count++;
                if(i == duplicateStrings.size()-2){
                    if (count == exactNumberOfDuplications){
                        for (int j = 0; j < exactNumberOfDuplications; j++) {
                            duplicateStrings.remove(duplicateStrings.get(i+2 - count));
                        }
                    }
                }
            }else{
                if (count == exactNumberOfDuplications){
                    for (int j = 0; j < exactNumberOfDuplications; j++) {
                        duplicateStrings.remove(duplicateStrings.get(i+1 - count));
                    }
                    i = i- count;
                }

                count = 1;
            }

        }
        String[] result = duplicateStrings.toArray(new String[duplicateStrings.size()]);

        return result;
    }
    }
