package com.epam.pashkov.labs1;

/**
 * Created by Yaroslav on 18.04.2015.
 */
public class Merger {
    public static int[] merge(int[] fst, int[] snd) {
        int[] result = new int[fst.length + snd.length];
        int fstIndex = 0;
        int sndIndex = 0;
        int resIndex = 0;
        while (resIndex < result.length) {
            if (fst[fstIndex] < snd[sndIndex]) {
                result[resIndex++] = fst[fstIndex];
                if(fstIndex+1==fst.length) {
                    System.arraycopy(snd, sndIndex, result, resIndex, snd.length-sndIndex);
                    break;
                }
                fstIndex++;
            } else {
                result[resIndex++] = snd[sndIndex];
                if(sndIndex+1==snd.length)   {
                    System.arraycopy(fst, fstIndex, result, resIndex, fst.length-fstIndex);
                    break;
                }
                sndIndex++;
            }
        }
        return result;
    }
}

