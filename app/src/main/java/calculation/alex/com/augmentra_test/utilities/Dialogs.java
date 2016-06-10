package calculation.alex.com.augmentra_test.utilities;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by Alex on 08/06/2016.
 */
public class Dialogs {

        static ProgressDialog pDialog;

    /**
     * Showing Dialog
     * */

   public  static void showDialog(Context c, String msg){
                pDialog = new ProgressDialog(c);
                pDialog.setMessage(msg);
                pDialog.setIndeterminate(false);
                pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                pDialog.setCancelable(false);
                pDialog.show();

        }

    /**
     * Dismiss Dialog
     * */
    public static void dismissDialog()
    {
        if(pDialog!=null){
            pDialog.dismiss();
        }
    }
}
