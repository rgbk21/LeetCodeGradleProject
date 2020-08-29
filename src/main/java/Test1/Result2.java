//package Test1;
//
//import java.util.List;
//
//public class Result2 {
//
//    public static long countMoves(List<Integer> numbers) {
//
//
//        long n = numbers.size();
//        int overallSum = 0;
//        int minElmnt = numbers.get(0);
//        long numOfMoves = 0;
//
//        for (int i = 0; i < n; i++) {
//
//            int currNum = numbers.get(i);
//
//            if (currNum < minElmnt){
//                minElmnt = currNum;
//            }
//
//            overallSum = overallSum + currNum;
//        }
//
//        numOfMoves = overallSum - (n * minElmnt);
//
//        return numOfMoves;
//
//
//    }
//
//    public static long countMoves2(List<Integer> numbers) {
//
//
//        long n = numbers.size();
//        int overallSum = 0;
//        int minElmnt = numbers.get(0);
//        long numOfMoves = 0;
//        for (int i = 0; i < numbers.size(); i++) {
//
//            int maxElmntInLoop = findMaxElmntInLoop(numbers);
//
//            int currElmnt = numbers.get(i);
//
//            if (numbers.get(i) != maxElmntInLoop) {
//                numbers.set(i, currElmnt+1);
//            }
//
//
//        }
//
//    }
//
//    private static int findMaxElmntInLoop(List<Integer> numbers) {
//
//        int maxElmnt = numbers.get(0);
//
//        for (int i = 0; i < numbers.size(); i++) {
//
//            if (numbers.get(i) > maxElmnt) {
//                maxElmnt = numbers.get(i);
//            }
//        }
//
//        return maxElmnt;
//
//    }
//
//}
