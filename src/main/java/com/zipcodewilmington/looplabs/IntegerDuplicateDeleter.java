package com.zipcodewilmington.looplabs;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by leon on 1/29/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {

    public IntegerDuplicateDeleter(Integer[] array){
        super(array);
    }
    @Override
    public Integer[] removeDuplicates(int maxNumberOfDuplications) {
        ArrayList<Integer> duplicateNumber = new ArrayList<>();
        Collections.addAll(duplicateNumber, array);
        int count = 1;
        for (int i = 0; i < duplicateNumber.size()-1; i++) {
            if(duplicateNumber.get(i) == duplicateNumber.get(i+1)){
                count++;
                if(i == duplicateNumber.size()-2){
                    if (count >= maxNumberOfDuplications){
                        for (int j = 0; j < count; j++) {
                            duplicateNumber.remove(duplicateNumber.get(i+2 - count));
                        }
                    }
                }
            }else{
                if (count >= maxNumberOfDuplications){
                    for (int j = 0; j < count; j++) {
                        duplicateNumber.remove(duplicateNumber.get(i+1 - count));
                    }
                    i = i- count;
                }
                count = 1;
            }

        }
        Integer[] result = duplicateNumber.toArray(new Integer[duplicateNumber.size()]);

        return result;
    }

    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        ArrayList<Integer> duplicateNumbers = new ArrayList<>();
        Collections.addAll(duplicateNumbers, array);
        int count = 1;
        for (int i = 0; i < duplicateNumbers.size()-1; i++) {
            if(duplicateNumbers.get(i) == duplicateNumbers.get(i+1)){
                count++;
                if(i == duplicateNumbers.size()-2){
                    if (count == exactNumberOfDuplications){
                        for (int j = 0; j < exactNumberOfDuplications; j++) {
                            duplicateNumbers.remove(duplicateNumbers.get(i+2 - count));
                        }
                    }
                }
            }else{
                if (count == exactNumberOfDuplications){
                    for (int j = 0; j < exactNumberOfDuplications; j++) {
                        duplicateNumbers.remove(duplicateNumbers.get(i+1 - count));
                    }
                    i = i- count;
                }

                count = 1;
            }

        }
        Integer[] result = duplicateNumbers.toArray(new Integer[duplicateNumbers.size()]);

        return result;
    }
}
