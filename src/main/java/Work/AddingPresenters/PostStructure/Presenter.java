package Work.AddingPresenters.PostStructure;

/** The P in MVP */
public interface Presenter<V extends View<?>>{

  void bindView(V view);
}
