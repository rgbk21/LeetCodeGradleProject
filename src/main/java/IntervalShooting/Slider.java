package IntervalShooting;

public enum Slider {
  EXPOSURE, CONTRAST, HIGHLIGHTS, SHADOWS, WHITES, BLACKS, TEXTURE, CLARITY, DEHAZE, VIBRANCE, SATURATION;

  public Double getStepChangeValue() {
    switch (this) {
      case EXPOSURE: return 0.01;
      case CONTRAST: case HIGHLIGHTS: case SHADOWS: case WHITES: case BLACKS: case TEXTURE: case CLARITY: case DEHAZE: case VIBRANCE: case SATURATION:
        return 1.0;
    }
    throw new UnsupportedOperationException("The slider does not exist currently.");
  }
}
