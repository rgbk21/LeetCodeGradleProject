package IntervalShooting;

import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Ordering;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static IntervalShooting.Slider.*;

public class LRTimeLapseT1 {


  private final Map<Integer, Map<Slider, Double>> result = new HashMap<>();

  public void changeSetting(Slider sliderName, double fromValue, double toValue, double inStepsOf, int fromImageNumber, int toImageNumber) {
    double numberOfImages = toImageNumber - fromImageNumber + 1;
    int numOfChangesRequired = (int) ((toValue - fromValue) / inStepsOf);
    int makeChangesEveryThisManyImages = (int) Math.round(numberOfImages / Math.abs(numOfChangesRequired));

    double changeValueTo = fromValue;

    for (int i = 0; i < numberOfImages; i++) {
      int imageNumber = fromImageNumber + i;
      result.computeIfAbsent(imageNumber, k -> new HashMap<>());
      Map<Slider, Double> sliderDoubleMap = result.get(imageNumber);
      if (i % makeChangesEveryThisManyImages == 0) {
        changeValueTo = numOfChangesRequired > 0 ? changeValueTo + inStepsOf : changeValueTo - inStepsOf;
      }
      BigDecimal roundedValue = BigDecimal.valueOf(changeValueTo).setScale(2, RoundingMode.HALF_UP);
      sliderDoubleMap.put(sliderName, roundedValue.doubleValue());
    }
  }

  public void readInputs(Map<Slider, List<Double>> inputData, int fromImageNumber, int toImageNumber) {
    for (Map.Entry<Slider, List<Double>> entry : inputData.entrySet()) {
      Slider key = entry.getKey();
      List<Double> value = entry.getValue();
      changeSetting(key, value.get(0), value.get(1), key.getStepChangeValue(), fromImageNumber, toImageNumber);
    }

    ImmutableSortedMap<Integer, Map<Slider, Double>> sortedResults = new ImmutableSortedMap
        .Builder<Integer, Map<Slider, Double>>(Ordering.natural())
        .putAll(result).build();

    for (Map.Entry<Integer, Map<Slider, Double>> entry: sortedResults.entrySet()){
      System.out.println(entry);
    }
  }

  public static void main(String[] args) {
    LRTimeLapseT1 settings = new LRTimeLapseT1();
//    settings.changeSetting(Slider.DEHAZE, 20, 1, 235, 270, 235);

    Map<Slider, List<Double>> inputData = Map.ofEntries(
        Map.entry(EXPOSURE, List.of(/* fromValue*/ 0.30, /* toValue*/ 0.20)),
        Map.entry(CONTRAST, List.of(/* fromValue*/ 30.0, /* toValue*/ 20.0)),
        Map.entry(HIGHLIGHTS, List.of(/* fromValue*/ -35.0, /* toValue*/ -30.0)),
        Map.entry(SHADOWS, List.of(/* fromValue*/ 30.0, /* toValue*/ 20.0)),
        Map.entry(WHITES, List.of(/* fromValue*/ 48.0, /* toValue*/ 33.0)),
        Map.entry(BLACKS, List.of(/* fromValue*/ -15.0, /* toValue*/ -25.0)),
        Map.entry(TEXTURE, List.of(/* fromValue*/ 40.0, /* toValue*/ 30.0)),
        Map.entry(CLARITY, List.of(/* fromValue*/ 25.0, /* toValue*/ 25.0)),
        Map.entry(DEHAZE, List.of(/* fromValue*/ 0.0, /* toValue*/ 20.0)),
        Map.entry(VIBRANCE, List.of(/* fromValue*/ 30.0, /* toValue*/ 20.0)),
        Map.entry(SATURATION, List.of(/* fromValue*/ 0.0, /* toValue*/ 0.0))
    );

    settings.readInputs(inputData, 235, 270);
  }


}
