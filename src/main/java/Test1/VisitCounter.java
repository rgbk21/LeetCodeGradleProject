package Test1;

import java.math.BigInteger;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class VisitCounter {

    Map<Long, Long> count(Map<String, UserStats>... visits) {


        Predicate<String> isKeyValid = key -> {
            for (int i = 0; i < key.length(); i++) {
                if (!Character.isDigit(key.charAt(i))) {
                    return false;
                }
            }
            return true;
        };


        List<Map<String, UserStats>> collect = Arrays.stream(visits)
                .filter(map -> {
                    for (Map.Entry<String, UserStats> entry : map.entrySet()) {

                        if (entry.getValue() == null) return false;

                        UserStats stats = entry.getValue();
                        if (!stats.getVisitCount().isPresent()) {
                            return false;
                        }

                        String key = entry.getKey();
                        for (int i = 0; i < key.length(); i++) {
                            if (!Character.isDigit(key.charAt(i))) {
                                return false;
                            }
                        }
                        return true;
                    }
                    return true;
                })
                .collect(Collectors.toList());

        Map<Long, Long> result = new HashMap<>();

        for (Map<String, UserStats> map: collect) {
            for (Map.Entry<String, UserStats> entry : map.entrySet()) {
                Long key = Long.parseLong(entry.getKey());
                Long value = entry.getValue().getVisitCount().get();
                if (!result.containsKey(key)) {
                    result.put(key, value);
                } else {
                    Long prevCount = result.get(key);
                    result.put(key, prevCount + value);
                }
            }
        }

        return result;
    }
}



class UserStats {

    Long visitCount;

    public Optional<Long> getVisitCount() {
        return Optional.of(visitCount);
    }

    public void setVisitCount(Long visitCount) {
        this.visitCount = visitCount;
    }
}