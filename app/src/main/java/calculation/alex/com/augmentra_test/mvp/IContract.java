package calculation.alex.com.augmentra_test.mvp;


public interface IContract {

    interface IView extends BaseView<IPresenter> {

        void showError();
        String getEntry();
        void setResult(String result);

    }

    interface IPresenter extends BasePresenter{
        void Calculate();

    }
}
