package CodingTakeHome;

import java.util.ArrayList;
import java.util.List;

public class Parenthesis {

    private static String[] invertParenthesis(String word){
        String[] output=new String[2];
        StringBuilder wordBuilder = new StringBuilder(word);
        int currentPriority=0;
        int maxPriority=0;

        List<Integer> myListIndex = new ArrayList<Integer>();
        List<Integer> myListPriority = new ArrayList<Integer>();

            for (int index = 0; index < word.length(); index++) {
                if (word.charAt(index) == '(') {
                    currentPriority++;
                    myListIndex.add(index);
                    myListPriority.add(currentPriority);
                }
                if (word.charAt(index) == ')') {
                    currentPriority--;
                    myListIndex.add(index);
                    myListPriority.add(currentPriority + 1);
                }
                if (currentPriority > maxPriority) {
                    maxPriority = currentPriority;
                }
            }

            int cont=0;
            List<String> chunksToRevert = new ArrayList<String>();
            for (int index = 0; index < myListIndex.size(); index++) {
                if (myListPriority.get(index) == maxPriority) {
                    wordBuilder.setCharAt(myListIndex.get(index), '%');
                    if (cont % 2 == 0) {
                        chunksToRevert.add(wordBuilder.toString().substring(myListIndex.get(index) + 1, myListIndex.get(index+1)));
                    }
                    cont++;
                }
            }

            String[] wordChunks = wordBuilder.toString().split("%");

            for (int index = 0; index < wordChunks.length; index++) {
                if (chunksToRevert.contains(wordChunks[index])) {
                    wordChunks[index] = revertWord(wordChunks[index]);
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (String chunk : wordChunks) {
                stringBuilder.append(chunk);
            }

            output[0] = stringBuilder.toString();
            output[1] = Integer.toString(maxPriority);

        return output;
    }

    private static String revertWord(String word) {
        String reversedWord = "";
        for (int index = word.length() - 1; index >= 0; index--) {
            reversedWord += word.charAt(index);
        }
        return reversedWord;
    }
    public static String finalLogic(String word){
        if (word.length()<=50){
            String[] result = Parenthesis.invertParenthesis(word);
            while (Integer.parseInt(result[1])!=0) {
                result=Parenthesis.invertParenthesis(result[0]);
            }
            return result[0].toLowerCase();
        }else {
            return null;
        }
    }
}
