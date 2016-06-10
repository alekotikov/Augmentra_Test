package calculation.alex.com.augmentra_test.mvp;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import calculation.alex.com.augmentra_test.model.Modelfunction;

/**
 * Created by Alex on 08/06/2016.
 */
public class PresenterImpl implements IContract.IPresenter{
    private final IContract.IView mView;

        @Inject
        public PresenterImpl(@NonNull IContract.IView mView){
        this.mView = mView;
    }

    @Override
    public void Calculate() {
        //Asynchrous  Function
        String tvEntry = mView.getEntry();
        if (tvEntry.isEmpty()) {
            mView.showError();
            return;
        }

        if (!tvEntry.matches("\\d+(\\.\\d+)?([\\/\\*\\+-]\\d+(.\\d+)?)+")) {
            mView.showError();
            return;
        }
        String result = Modelfunction.calculateProblem(tvEntry);
        mView.setResult(result);

    }

    @Inject
    public void start() {
        mView.setPresenter(this);

    }
}
