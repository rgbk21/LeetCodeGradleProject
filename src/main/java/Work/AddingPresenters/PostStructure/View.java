package Work.AddingPresenters.PostStructure;

/** The V in MVP */
public interface View<P extends Presenter<?>>{

  /** @return the presenter for this view */
  P getPresenter();
}
