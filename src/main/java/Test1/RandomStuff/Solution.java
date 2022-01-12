package Test1.RandomStuff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public ArrayList<String> popularNFeatures(int numFeatures,
                                              int topFeatures,
                                              List<String> possibleFeatures,
                                              int numFeatureRequests,
                                              List<String> featureRequests) {



        Map<String, Integer> featureCount = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();

        if (numFeatures == 0 || topFeatures == 0 || numFeatureRequests == 0) {
            return result;
        }

        for (int i = 0; i < possibleFeatures.size(); i++) {
            featureCount.put(possibleFeatures.get(i).toLowerCase(), 0);
        }

        for (int i = 0; i < featureRequests.size(); i++) {
            String currFeatureReq = featureRequests.get(i).toLowerCase();

            for (int j = 0; j < possibleFeatures.size(); j++) {
                String currPossibleFeature = possibleFeatures.get(j).toLowerCase();
                if (currFeatureReq.contains(currPossibleFeature)) {
                    Integer prevCount = featureCount.get(currPossibleFeature);
                    featureCount.put(currPossibleFeature, prevCount + 1);
                }
            }
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(featureCount.entrySet());

        entries.sort((entry1, entry2) -> {

            if (entry1.getValue() > entry2.getValue()) {
                return -1;
            } else if (entry1.getValue() < entry2.getValue()) {
                return 1;
            } else {
                return entry1.getKey().compareTo(entry2.getKey());
            }

        });

        if (topFeatures > numFeatures) {

            for (Map.Entry<String, Integer> entry : entries) {
                if (entry.getValue() > 0) {
                    result.add(entry.getKey());
                }
            }
        } else {
            for (int i = 0; i < topFeatures; i++) {
                result.add(entries.get(i).getKey());
            }
        }

        return result;


    }

}
