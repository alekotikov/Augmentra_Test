package calculation.alex.com.augmentra_test.injection;

import calculation.alex.com.augmentra_test.mvp.IContract;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Alex on 09/06/2016.
 */

    @Module
    public class PresenterModule {

        private final IContract.IView mView;

        public PresenterModule(IContract.IView view) {
            mView = view;
        }

        @Provides
        IContract.IView  provideContractView() {
            return mView;
        }

    }

