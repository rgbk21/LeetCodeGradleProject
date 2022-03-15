package Wordle;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WordleList {
  private final List<String> allPossibleWords;
  private final List<String> possibleAnswers;

  public WordleList() throws FileNotFoundException {
    allPossibleWords = readWordsFromResourcesFile("AllFiveLetterWords.txt");
    possibleAnswers = readWordsFromResourcesFile("PossibleAnswers.txt");
  }

  private List<String> readWordsFromResourcesFile(String fileName) throws FileNotFoundException {
    List<String> readWords = new ArrayList<>();

    InputStream allPossibleWordsStream = WordleList.class.getClassLoader().getResourceAsStream(fileName);
    if (allPossibleWordsStream == null) {
      throw new FileNotFoundException();
    }

    try (
        InputStreamReader inputStreamReader = new InputStreamReader(allPossibleWordsStream);
        BufferedReader br = new BufferedReader(inputStreamReader);
    ) {
      String word;
      while ((word = br.readLine()) != null) {
        System.out.println(word);
        readWords.add(word);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return readWords;
  }

  /**
   * @param absolutePath is the absolute path of the file, like: C:\Users\rajga\Desktop\Wordle\AllFiveLetterWords.txt
   * @return the list of the words read from the file
   */
  private List<String> readWordsFromFile(String absolutePath) {
    List<String> result = new ArrayList<>();

    File file = new File(absolutePath);
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String word;
      while ((word = br.readLine()) != null) {
        result.add(word);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return result;
  }

  public static void main(String[] args) throws FileNotFoundException {
//    WordleList wordleList = new WordleList();
//    String allPossibleWords = "C:\\Users\\rajga\\Desktop\\Wordle\\AllFiveLetterWords.txt";
//    String possibleAnswers = "C:\\Users\\rajga\\Desktop\\Wordle\\PossibleAnswers.txt";
//    wordleList.readWordsFromFile(allPossibleWords);

    StringBuilder sb = new StringBuilder("^[][][][][]$");
    int insertionIdx = StringUtils.ordinalIndexOf(sb, "]", 1);
    sb.insert(insertionIdx, "a");
    System.out.println(sb);
  }

}
