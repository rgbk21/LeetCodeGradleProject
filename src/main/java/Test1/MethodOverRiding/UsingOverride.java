package Test1.MethodOverRiding;

import java.util.ArrayList;

public class UsingOverride {
}

interface Addition {
  Number sum(Number num1, Number num2);
}

class AdditionImpl1 implements Addition {
  @Override
  public Number sum(Number num1, Number num2) {
    return 10;
  }
}

class AdditionImpl2 implements Addition {
  @Override
  public Integer sum(Number num1, Number num2) {
    return 10;
  }
}

// Note that this is not overloading the sum method.
// You are getting a name clash error in Intellij
//class AdditionImpl3 implements Addition {
//  @Override
//  public Object sum(Number num1, Number num2) {
//    return 10;
//  }
//}
//
//class AdditionImpl4 implements Addition {
//  @Override
//  public Number sum(Integer num1, Integer num2) {
//    return 10;
//  }
//}
//
//class AdditionImpl5 implements Addition {
//  @Override
//  public Number sum(Object num1, Object num2) {
//    return 10;
//  }
//}
