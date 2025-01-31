package api;

import android.os.AsyncTask;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

import interfaces.LayTruyenVe;

public class ApiLayTruyen extends AsyncTask<Void,Void,Void> {
    String data;
    LayTruyenVe layTruyenVe;

    public ApiLayTruyen(LayTruyenVe layTruyenVe) {
        this.layTruyenVe = layTruyenVe;
        this.layTruyenVe.batDau();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                //.url("https://www.myjsons.com/v/a9983080")
                .url("https://www.myjsons.com/v/d3153083")
                .build();
        data =null;
        try {
            Response response = client.newCall(request).execute();
            ResponseBody body = response.body();
            data = body.string();
        }catch (IOException e){
            data=null;
        }
        return null;
    }
    protected void onPostExecute(Void aVoid) {
        if(data == null){
            this.layTruyenVe.biLoi();
        }else{
            this.layTruyenVe.ketThuc(data);
        }
    }
}
