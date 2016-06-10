package calculation.alex.com.augmentra_test.injection;

import calculation.alex.com.augmentra_test.MainActivity;
import dagger.Component;

/**
 * Created by Alex on 09/06/2016.
 */
    @Component(modules = PresenterModule.class)
    public interface PresenterComponent {

    void inject(MainActivity mainActivity);

}


