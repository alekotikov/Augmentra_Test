package calculation.alex.com.augmentra_test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import calculation.alex.com.augmentra_test.injection.DaggerPresenterComponent;
import calculation.alex.com.augmentra_test.injection.PresenterModule;
import calculation.alex.com.augmentra_test.mvp.IContract;
import calculation.alex.com.augmentra_test.mvp.PresenterImpl;
import calculation.alex.com.augmentra_test.utilities.ToastUtils;

import static com.google.common.base.Preconditions.checkNotNull;

public class MainActivity extends AppCompatActivity implements IContract.IView {


    TextView tvOutput;
    EditText etInput;
    Button btnCal;

    @Inject
    PresenterImpl mPresenter;

    private IContract.IPresenter iPresenter;
    /**
     * Use this method to initialize view components.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.frag_calculation);
        initilaizeViews();

        //  mPresenter=new PresenterImpl(this);
        //Dagger way to inject the presenter
        DaggerPresenterComponent.builder()
                .presenterModule(new PresenterModule(MainActivity.this))
                .build()
                .inject(this);

        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mPresenter.Calculate();
                etInput.setText("");
            }
        });
    }


    public void initilaizeViews() {
        tvOutput=(TextView)findViewById(R.id.tvOutput);
        etInput = (EditText) findViewById(R.id.etInput);
        btnCal=(Button)findViewById(R.id.btnCalculate);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void showError() {
        ToastUtils.showError("Error Calculating", this.getApplicationContext());
    }

    @Override
    public String getEntry() {
        return etInput.getText().toString();
    }


    @Override
    public void setResult(String result) {
        tvOutput.setText(result);
        etInput.setText("");
    }

    @Override
    public void setPresenter(@NotNull IContract.IPresenter presenter) {
        iPresenter = checkNotNull(presenter);
    }
    
}
